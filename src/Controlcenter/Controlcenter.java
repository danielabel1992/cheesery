package Controlcenter;

import Mediator.*;
import Sensor.ISensorMicrobialRennet;
import Sensor.ISensorSaltBath;
import Sensor.ISensorTemperature;
import com.sun.deploy.util.StringUtils;

/**
 * Created by danielabel on 04.02.18.
 */
public class Controlcenter implements ISensorTemperature, ISensorMicrobialRennet, ISensorSaltBath {

    boolean temperatureReached;
    boolean rIsUsed;
    boolean addSalt;

    public void startWork() {
        for (int countCheese = 0; countCheese < 10; countCheese ++) {
            Mediator mediator = new Mediator(this);

            Cheesepress cheesepress = new Cheesepress(mediator);
            Container container = new Container(mediator);
            Packaging packaging = new Packaging(mediator);
            Saltbath saltbath = new Saltbath(mediator);

            mediator.registerCheesePress(cheesepress);
            mediator.registerContainer(container);
            mediator.registerPackaging(packaging);
            mediator.registerSaltBath(saltbath);

            mediator.fillMilk();

            temperatureReached = false;
            while (temperatureReached == false) {
                mediator.heatMilk();
            }

            mediator.fillMlR();
            rIsUsed = false;
            while(rIsUsed==false) {
                mediator.simCvRToCAndW();
            }

            mediator.removeW();
            mediator.fillC();
            mediator.press();

            mediator.removeCWheel();

            addSalt = false;

            for (int i = 0; i < 10; i++) {
                if (addSalt==true) {
                    mediator.addSalt();
                    addSalt = false;
                }
                mediator.batheInSalt();
            }
        }


        System.out.println("Fertig ist der Käse");


    }

    @Override
    public void stopHeatMilk() {
        this.temperatureReached = true;
    }

    @Override
    public void microbialRennetUsed() {
        rIsUsed=true;
    }

    @Override
    public void addSalt() {
        this.addSalt=true;
    }
}
