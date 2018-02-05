package Sensor;

import Mediator.Container;
import java.util.ArrayList;

/**
 * Created by danielabel on 04.02.18.
 */
public class SensorTemperature implements ISensor {

    private Container container;
    private ArrayList<ISensorTemperature> listeners;

    public SensorTemperature(Container container) {
        this.listeners = new ArrayList<ISensorTemperature>();
        this.container = container;
    }

    private void temperatureReached() {
        for (ISensorTemperature sensor : listeners) {
            sensor.stopHeatMilk();
        }
    }

    public void addListener(ISensorTemperature listener) {
        listeners.add(listener);
    }

    public void removeListener(ISensorTemperature listener) {
        listeners.remove(listener);
    }


    @Override
    public double scale() {
        if (this.container.getTemperatureInC()>=50.5)
            this.temperatureReached();
        return this.container.getTemperatureInC();
    }
}
