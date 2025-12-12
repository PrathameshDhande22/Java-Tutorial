package proxy.state;

import java.io.Serializable;

// Create the State Interface which will be implemented by new upcoming state.
// Making these as a Serializable
public interface State extends Serializable {
    void insertQuarter();

    void ejectQuarter();

    void dispense();

    void turncrank();
}
