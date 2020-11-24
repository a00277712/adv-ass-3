package model;

import java.util.concurrent.TimeUnit;

public class RAM implements Part {

    public RAM() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("RAM built");
    }

    public boolean AddPart(Computer computer) {
        return computer.addRam(this);
    }
}
