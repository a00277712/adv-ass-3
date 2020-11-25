package components;

import java.util.concurrent.TimeUnit;

public class CPU implements IComponent {

    public CPU() throws InterruptedException {
        TimeUnit.SECONDS.sleep(7);
    }

    @Override
    public boolean addComponent(Computer computer) {
        return computer.addCpu(this);
    }
}
