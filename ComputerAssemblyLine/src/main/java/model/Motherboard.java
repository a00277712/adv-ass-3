package model;

import java.util.concurrent.TimeUnit;

public class Motherboard implements Part {

    public Motherboard() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Motherboard built");
    }

    public boolean AddPart(Computer computer) {
        return computer.addMotherboard(this);
    }
}
