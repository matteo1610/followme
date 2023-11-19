package it.unicam.cs.followme.model.commands;

import it.unicam.cs.followme.model.Point;
import it.unicam.cs.followme.model.Robot;
import it.unicam.cs.followme.model.Signal;
import it.unicam.cs.followme.util.*;

import java.util.List;

/**
 * A class representing a command for robots to follow a signal within a specified distance and speed.
 *
 * Each robot moves at a speed (in m/s) toward a direction that is the average of the positions of the robots satisfying
 * the signal condition and located within a distance less than or equal to 'dist'. If no robots satisfy the condition,
 * a random direction within the range [-dist, dist]x[-dist, dist] is chosen.
 */
public final class FollowCommand implements RobotCommand {

    private final Signal signal;
    private final double distance;
    private final double speed;

    /**
     * Constructs a FollowCommand with the specified signal label, follow distance, and speed.
     *
     * @param label    The label of the signal to follow.
     * @param distance The maximum distance within which robots should follow the signal.
     * @param speed    The speed at which to move the robots.
     */
    public FollowCommand(String label, double distance, double speed) {
        this.signal = new Signal(label);
        this.distance = distance;
        this.speed = speed;
    }

    @Override
    public void execute(List<Robot> swarm) {
        if (swarm.isEmpty())
            throw new NullPointerException("Attempting to run a command without specifying the robot.");
        List<Point> targets = this.getTargets(swarm);
        swarm.parallelStream().forEach(robot -> robot.move(DirectionCalculator
                    .calculateDirection(robot.getActualPosition(), targets.get(swarm.indexOf(robot))), this.speed));
    }

    /**
     * Retrieves the signal that the robots should follow.
     *
     * @return The {@link Signal} to follow.
     */
    public Signal getSignal() {
        return signal;
    }

    /**
     * Retrieves the maximum distance within which robots should follow the signal.
     *
     * @return The maximum following distance.
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Retrieves the speed of movement specified by this command.
     *
     * @return The speed of movement.
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Retrieves the target points for the robots to follow based on the signal and distance criteria.
     *
     * @param swarm The list of robots in the swarm.
     * @return A list of target points for the robots to follow.
     */
    private List<Point> getTargets(List<Robot> swarm) {
        return swarm.parallelStream()
                .map(robot -> this.getTargetPoint(this.getRobotsSatisfyConditions(swarm, robot)))
                .toList();
    }

    /**
     * Filters the robots that satisfy the conditions of containing the signal and being within the specified distance.
     *
     * @param swarm The list of robots in the swarm.
     * @param robot The robot for which to find satisfying robots.
     * @return A list of robots satisfying the conditions.
     */
    private List<Robot> getRobotsSatisfyConditions(List<Robot> swarm, Robot robot) {
        return swarm.parallelStream()
                .filter(r -> r.containSignal(this.signal) && DistanceCalculator
                        .calculateDistance(robot.getActualPosition(), r.getActualPosition()) <= this.distance)
                .toList();
    }


    /**
     * Calculates the average position of the robots in the list or generates a random point within the specified range
     * if the list is empty.
     *
     * @param robots The list of robots for which to calculate the target point.
     * @return The target point for the robots to follow.
     */
    private Point getTargetPoint(List<Robot> robots) {
        return robots.parallelStream()
                .map(Robot::getActualPosition)
                .reduce((p1, p2) -> new Point(p1.x() + p2.x(), p1.y() + p2.y()))
                .map(p -> new Point(p.x() / robots.size(), p.y() / robots.size()))
                .orElse(RandomPointGenerator.generatePoint(
                        new Point(-this.distance, this.distance), new Point(-this.distance, this.distance)));
    }
}
