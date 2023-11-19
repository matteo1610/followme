package it.unicam.cs.followme.model;

import static org.junit.jupiter.api.Assertions.*;

import it.unicam.cs.followme.model.Signal;
import org.junit.jupiter.api.Test;

class SignalTest {

    @Test
    void createSignalWithValidLabel() {
        Signal signal = new Signal("lbl-123-valid");
        assertEquals("lbl-123-valid", signal.label());
    }

    @Test
    void createSignalWithEmptyLabel() {
        assertThrows(NullPointerException.class, () -> new Signal(""));
        assertThrows(NullPointerException.class, () -> new Signal(null));
    }

    @Test
    void createSignalWithInvalidLabel() {
        assertThrows(IllegalArgumentException.class, () -> new Signal("lbl_invalid"));
        assertThrows(IllegalArgumentException.class, () -> new Signal("label with spaces"));
        assertThrows(IllegalArgumentException.class, () -> new Signal("label-invalid-$@"));
    }

    @Test
    void toStringTest() {
        Signal signal = new Signal("label");
        assertEquals("Signal [label=label]", signal.toString());
    }
}
