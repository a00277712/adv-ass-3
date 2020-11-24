package model;

import java.util.concurrent.TimeUnit;

public class SATA implements Part {

    public SATA() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("SATA built");
    }

    public boolean AddPart(Computer computer) {
        return computer.addSata(this);
    }
}
