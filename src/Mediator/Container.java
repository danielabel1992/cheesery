package Mediator;


import Delay.Delay;
import Sensor.SensorMicrobialRennet;
import Sensor.SensorTemperature;
import Temperature.TemperatureClassReporter;

import java.util.Random;

/**
 * Created by danielabel on 04.02.18.
 */
public class Container implements ICheesery {

    private IMediator mediator;
    private int length;
    private int width;
    private int height;
    private String content;
    private TemperatureClassReporter temperature;
    private SensorTemperature sensorTemperature;
    private SensorMicrobialRennet sensorMicrobialRennet;
    private int microbialRennet;

    public Container(IMediator mediator){
        this.mediator = mediator;
        content = "";
        length = 200;
        width = 100;
        height = 100;
        temperature = new TemperatureClassReporter();
        temperature.setTemperatureInF(42.8);
        sensorTemperature = new SensorTemperature(this);
        sensorTemperature.addListener(this.mediator.getControlcenter());
        sensorMicrobialRennet = new SensorMicrobialRennet(this);
        sensorMicrobialRennet.addListener(this.mediator.getControlcenter());
        microbialRennet = 0;
    }

    public boolean fillMilk() {
        content = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 200000; i++) {
            sb.append("MMMMMMMMMM");
        }
        content = sb.toString();
        Delay.wait(3);
        System.out.println(this.contentToString());

        return true;
    }

    public double heatMilk() {
        Delay.wait(1);
        temperature.setTemperatureInC(temperature.getTemperatureInC()+4.45);
        this.sensorTemperature.scale();
        return temperature.getTemperatureInC();
    }

    public double getTemperatureInC() {
        return this.temperature.getTemperatureInC();
    }

    public int getMicrobialRennet() {
        return this.microbialRennet;
    }

    public void fillMlR() {
        microbialRennet = 200;
        simCvRToCAndW();
    }

    public void simCvRToCAndW() {
        int MaxSizeOfMToChange = 200; // Für Testzwecke, da mein Rechner nur 4GB Ram hat
        Delay.wait(1);
        System.out.println("R wird umgewandelt in C und W. Es sind noch " + microbialRennet + " Resteinheiten an R vorhanden.");
        Random randomGenerator = new Random();
        int countC = 0;
        int maxCountC = MaxSizeOfMToChange/100*15;
        while (countC < maxCountC) {
            int pos = randomGenerator.nextInt(content.length());
            if (content.charAt(pos)=='M') {
                content = content.substring(0,pos-1)+'C'+content.substring(pos);
                countC++;
            }
        }

        int countW = 0;
        int maxCountW = MaxSizeOfMToChange/100*85;
        while (countW < maxCountW) {
            int pos = randomGenerator.nextInt(content.length());
            if (content.charAt(pos) == 'M') {
                content = content.substring(0, pos - 1) + 'W' + content.substring(pos);
                countW++;
            }
        }
        this.microbialRennet-=10;
        System.out.println(this.contentToString());
        this.sensorMicrobialRennet.scale();
    }

    public void removeW() {
        this.content = content.replace("W","");
        Delay.wait(1);
    }

    public String contentToString() {
        int countM = content.length() - content.replace("M", "").length();
        int countW = content.length() - content.replace("W", "").length();
        int countC = content.length() - content.replace("C", "").length();
        return "Inhalt dieses Behaelters: M: " + countM + "; W: " + countW + "; C: " + countC + "; Gesamt: " + (countM+countC+countW);
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
