package Mediator;

import java.util.ArrayList;

import Delay.Delay;
import Mediator.*;

/**
 * Created by danielabel on 04.02.18.
 */
public class Cheesepress implements ICheesery {

    private IMediator mediator;
    private ArrayList<Container> container;

    public Cheesepress(IMediator mediator) {
        this.mediator = mediator;
        this.container = new ArrayList<Container>();
        for (int i = 0; i < 20; i++) {
            this.container.add(new Container(this.mediator));
        }
    }

    public void fillC(Container c) {
        c.setContent(c.getContent().replace("C",""));
        for (int i = 0; i < 20; i++) {
            StringBuilder sb = new StringBuilder("");
            for (int j = 0; j < 15000; j++) {
                sb.append("C");
            }
            this.container.get(i).setContent(sb.toString());
        }
        Delay.wait(1);
    }

    public void press() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 20; j++) {
                Container c = this.container.get(j);
                int sizeC = c.getContent().length();
                c.setContent("");
                sizeC = sizeC/100*95;
                StringBuilder sb = new StringBuilder("");
                for (int k = 0; k < sizeC; k++) {
                    sb.append("C");
                }
                c.setContent(sb.toString());
            }
            Delay.wait(1);
        }
        System.out.println("Pressen ist fertig.");
        System.out.println(this.container.get(0).contentToString());
    }

    public ArrayList<Container> getCheeseContainer() {
        return this.container;
    }

}
