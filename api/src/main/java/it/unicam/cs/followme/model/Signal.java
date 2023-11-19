package it.unicam.cs.followme.model;

/**
 * A record representing a signal with a label. Signals are identified by their labels.
 */
public record Signal(String label) {

    /**
     * Creates a new {@code Signal} instance with the specified label.
     *
     * @param label The label of the signal.
     * @throws NullPointerException if the provided label is empty.
     * @throws IllegalArgumentException if the provided label contains invalid characters (only alphanumeric characters
     * and the '-' symbol are allowed).
     */
    public Signal {
        if (label.isEmpty())
            throw new NullPointerException("Attempt to create a signal with a null label");
        if (!this.checkLabel(label))
            throw new IllegalArgumentException("Attempt to create a signal with invalid characters (only " +
                    "alphanumeric characters and the '-' symbol can be present).");
    }

    private boolean checkLabel(String label) {
        return label.chars().allMatch(c -> Character.isLetterOrDigit(c) || c == '-');
    }

    @Override
    public String toString() {
        return "Signal [label=" + this.label + "]";
    }
}
