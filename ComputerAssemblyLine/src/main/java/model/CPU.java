package model;

import java.util.concurrent.TimeUnit;

public class CPU implements Part {

    public CPU() throws InterruptedException {
        TimeUnit.SECONDS.sleep(7);
        System.out.println("CPU built");
    }

    public boolean AddPart(Computer computer) {
        return computer.addCpu(this);
    }
}
