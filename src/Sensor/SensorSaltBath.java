package Sensor;

import Mediator.Saltbath;

import java.util.ArrayList;

/**
 * Created by danielabel on 05.02.18.
 */
public class SensorSaltBath implements ISensor {

    private Saltbath saltbath;
    private ArrayList<ISensorSaltBath> listeners;

    public SensorSaltBath(Saltbath saltbath) {
        this.saltbath = saltbath;
        this.listeners = new ArrayList<ISensorSaltBath>();
    }

    private void minimumIsReached() {
        for (ISensorSaltBath listener : listeners) {
            listener.addSalt();
        }
    }

    @Override
    public double scale() {
        if (saltbath.getConzentration()<=79.5)
            this.minimumIsReached();
        return saltbath.getConzentration();
    }

    public void addListener(ISensorSaltBath listener) {
        this.listeners.add(listener);
    }

    public void removeListener(ISensorSaltBath listener) {
        this.listeners.remove(listener);
    }

}
