package components;

import java.util.concurrent.TimeUnit;

public class RAM implements IComponent {

    public RAM() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
    }

    @Override
    public boolean addComponent(Computer computer) {
        return computer.addRam(this);
    }
}
