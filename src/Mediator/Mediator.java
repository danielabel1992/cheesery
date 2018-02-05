package Mediator;

import Controlcenter.Controlcenter;

/**
 * Created by danielabel on 04.02.18.
 */
public class Mediator implements IMediator {

    private Cheesepress cheesepress;
    private Container container;
    private Packaging packaging;
    private Saltbath saltbath;
    private Controlcenter controlcenter;

    public Mediator(Controlcenter controlcenter) {
        this.controlcenter = controlcenter;
    }

    @Override
    public Controlcenter getControlcenter() {
        return this.controlcenter;
    }

    @Override
    public void registerCheesePress(Cheesepress cheesepress) {
        this.cheesepress = cheesepress;
    }

    @Override
    public void registerContainer(Container container) {
        this.container = container;
    }

    @Override
    public void registerPackaging(Packaging packaging) {
        this.packaging = packaging;
    }

    @Override
    public void registerSaltBath(Saltbath saltbath) {
        this.saltbath = saltbath;
    }

    public boolean fillMilk() {
        System.out.println("Milch wird voll gemacht");
        return this.container.fillMilk();
    }

    public double heatMilk() {
        double temperature = this.container.heatMilk();
        System.out.println("Milch wird erhitzt und ist jetzt bei " + temperature);
        return temperature;
    }

    public void stopHeatMilk() {
        System.out.println("Milch ist nun warm genug");
    }

    public void fillMlR() {
        this.container.fillMlR();
    }

    public void simCvRToCAndW() {
        this.container.simCvRToCAndW();
    }

    public void removeW() {
        this.container.removeW();
    }

    public void fillC() {
        this.cheesepress.fillC(this.container);
    }

    public void press() {
        this.cheesepress.press();
    }

    public void removeCWheel() {
        this.saltbath.addCheeseToSaltBath(this.cheesepress.getCheeseContainer());
    }

    public void batheInSalt() {
        this.saltbath.batheInSalt();
    }

    public void addSalt() {
        this.saltbath.resetConzentration();
    }

}
