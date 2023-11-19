package it.unicam.cs.followme.model;

import java.util.HashSet;
import java.util.Set;

/**
 * A class representing a robot in the space with movement capabilities.
 */
public class Robot {

    private Point actualPosition;
    private Direction direction;
    private double speed;
    private Set<Signal> signals;
    private boolean isStopped;

    /**
     * Constructs a Robot instance with the given initial position.
     *
     * @param actualPosition The initial position of the robot.
     * @throws NullPointerException If the actual position is null.
     */
    public Robot(Point actualPosition) {
        if (actualPosition == null)
            throw new NullPointerException("The actualPosition parameter cannot be null.");
        this.actualPosition = actualPosition;
        this.direction = new Direction(0,0);
        this.speed = 0;
        this.signals = new HashSet<>();
        this.isStopped = false;
    }

    /**
     * Retrieves the actual position of the robot.
     *
     * @return The actual position of the robot.
     */
    public Point getActualPosition() {
        return actualPosition;
    }

    /**
     * Retrieves the current direction of the robot's movement.
     *
     * @return The current direction of the robot.
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Retrieves the current speed of the robot's movement.
     *
     * @return The current speed of the robot.
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Checks if the robot is currently stopped.
     *
     * @return True if the robot is stopped, false otherwise.
     */
    public boolean isStopped() {
        return isStopped;
    }

    /**
     * Moves the robot in the specified direction with the given speed.
     *
     * @param direction The direction to move the robot.
     * @param newSpeed  The speed at which to move the robot.
     * @throws IllegalArgumentException If the speed is less than 1.
     */
    public void move(Direction direction, double newSpeed) {
        if (this.isStopped) return;
        if (newSpeed < 1)
            throw new IllegalArgumentException("In order to move, the robot must have at least a speed of 1.");
        this.direction = direction;
        this.speed = newSpeed;
        this.actualPosition = new Point( this.direction.x() * this.speed + this.actualPosition.x(),
                 this.direction.y() * this.speed + this.actualPosition.y());
    }

    /**
     * Moves the robot in its current direction and speed. It is assumed that if the robot has not set a speed it is
     * set by default to 1.
     */
    public void move() {
        if (this.speed == 0) this.speed = 1;
        this.move(this.direction, this.speed);
    }

    /**
     * Adds a signal to the robot's signal set.
     *
     * @param signal The signal to add.
     * @throws IllegalArgumentException If the signal already exists in the robot's signals.
     */
    public void addSignal(Signal signal) {
        if (!this.signals.add(signal))
            throw new IllegalArgumentException("Attempt to add a signal that already exists in this robot.");
    }

    /**
     * Checks if the robot contains a specific signal.
     *
     * @param signal The signal to check for.
     * @return True if the robot contains the signal, false otherwise.
     */
    public boolean containSignal(Signal signal) {
        return this.signals.contains(signal);
    }

    /**
     * Removes a signal from the robot's signal set.
     *
     * @param signal The signal to remove.
     * @throws IllegalArgumentException If the signal doesn't exist in the robot's signals.
     */
    public void removeSignal (Signal signal) {
        if (!this.signals.remove(signal))
            throw new IllegalArgumentException("Attempt to remove a signal that doesn't exist in this robot");
    }

    /**
     * Stops the robot, setting its direction and speed to zero.
     */
    public void stop() {
        this.direction = new Direction(0,0);
        this.speed = 0;
        this.isStopped = true;
    }

    @Override
    public String toString() {
        return "Robot {" +
                "actualPosition=" + actualPosition +
                ", direction=" + direction +
                ", speed=" + speed +
                ", signals=" + signals +
                ", isStopped=" + isStopped +
                '}';
    }
}
