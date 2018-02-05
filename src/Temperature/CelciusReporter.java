package Temperature;

/**
 * Created by danielabel on 04.02.18.
 */
public class CelciusReporter {

    double temperatureInC;

    public CelciusReporter() {

    }

    protected double getTemperature() {
        return temperatureInC;
    }

    protected void setTemperature(double temperatureInC){
        this.temperatureInC = temperatureInC;
    }

}
