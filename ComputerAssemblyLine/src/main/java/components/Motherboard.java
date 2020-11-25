package components;

import java.util.concurrent.TimeUnit;

public class Motherboard implements IComponent {

    public Motherboard() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
    }

    @Override
    public boolean addComponent(Computer computer) {
        return computer.addMotherboard(this);
    }
}
