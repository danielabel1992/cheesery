package Sensor;

import Mediator.Container;

import java.util.ArrayList;

/**
 * Created by danielabel on 04.02.18.
 */
public class SensorMicrobialRennet implements ISensor {

    private Container container;
    private ArrayList<ISensorMicrobialRennet> listeners;

    public SensorMicrobialRennet(Container container) {
        this.listeners = new ArrayList<ISensorMicrobialRennet>();
        this.container = container;
    }

    private void microbialRennetIsUsed() {
        for (ISensorMicrobialRennet sensor : listeners) {
            sensor.microbialRennetUsed();
        }
    }

    public void addListener(ISensorMicrobialRennet listener) {
        listeners.add(listener);
    }

    public void removeListener(ISensorTemperature listener) {
        listeners.remove(listener);
    }


    @Override
    public double scale() {
        if (this.container.getMicrobialRennet()==0)
            this.microbialRennetIsUsed();
        return this.container.getMicrobialRennet();
    }
}
