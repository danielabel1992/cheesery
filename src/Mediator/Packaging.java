package Mediator;

/**
 * Created by danielabel on 04.02.18.
 */
public class Packaging implements ICheesery {

    private IMediator mediator;

    public Packaging(IMediator mediator) {
        this.mediator = mediator;
    }

}
