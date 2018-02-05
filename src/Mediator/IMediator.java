package Mediator;

import Controlcenter.Controlcenter;

/**
 * Created by danielabel on 04.02.18.
 */
public interface IMediator {

    public void registerCheesePress(Cheesepress cheesepress);
    public void registerContainer(Container container);
    public void registerPackaging(Packaging packaging);
    public void registerSaltBath(Saltbath saltbath);
    public Controlcenter getControlcenter();
}
