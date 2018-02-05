package Mediator;

import Delay.Delay;
import Sensor.SensorSaltBath;

import java.util.ArrayList;

/**
 * Created by danielabel on 04.02.18.
 */
public class Saltbath implements ICheesery {

    private IMediator mediator;
    private static double conzentration = 80.0;
    private ArrayList<Container> cheese;
    private SensorSaltBath sensorSaltBath;

    public Saltbath(IMediator mediator) {
        this.mediator = mediator;
        this.sensorSaltBath = new SensorSaltBath(this);
        this.sensorSaltBath.addListener(this.mediator.getControlcenter());
    }

    public void addCheeseToSaltBath(ArrayList<Container> cheese) {
        System.out.println("Der Käse liegt jetzt im Salzbad");
        this.cheese = cheese;
    }

    public void batheInSalt() {
        this.conzentration = (conzentration*0.999975);
        System.out.println("Nach dem Baden liegt die Konzentration bei " + conzentration);
        this.sensorSaltBath.scale();
        Delay.wait(1);
    }

    public void resetConzentration() {
        System.out.println("Konzentration im Saltzbad wird zurückgesetzt.");
        this.conzentration = 80;
    }

    public double getConzentration() {
        return this.conzentration;
    }

}
