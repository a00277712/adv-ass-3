package orchestration;

import model.*;

import java.util.ArrayList;

public class AssemblyLineRunner {
    public static void main(String[] args) throws InterruptedException {
        final Computer computer = new Computer();

        ArrayList<Part> parts = new ArrayList<Part>();

        parts.add(new CPU());
        parts.add(new Motherboard());
        for(int i = 0; i < 4; i++) {
            parts.add(new RAM());
            parts.add(new SATA());
        }

        parts.forEach((part) -> {
            
            part.AddPart(computer);
        });

        System.out.println(computer.isBuilt());
    }
}
