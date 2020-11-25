package components;

import java.util.concurrent.TimeUnit;

public class SATA implements IComponent {

    public SATA() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }

    @Override
    public boolean addComponent(Computer computer) {
        return computer.addSata(this);
    }
}
