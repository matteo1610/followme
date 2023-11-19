package it.unicam.cs.followme.model.commands;

import it.unicam.cs.followme.CommandExecutor;
import it.unicam.cs.followme.model.Robot;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a 'Do Forever' iterator. It repeatedly executes a sequence of
 * robot commands indefinitely.
 */
public final class DoForeverIterator extends AbstractIterator {

    @Override
    public void execute(List<Robot> swarm) {
        while (true) {
            this.instructions.forEach(instruction -> CommandExecutor.execute(instruction, swarm,
                    this.timeForInstruction));
        }
    }
}
