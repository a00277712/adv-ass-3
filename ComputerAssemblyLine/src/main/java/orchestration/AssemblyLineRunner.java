package orchestration;

import services.ProductionLine;
import components.*;

import java.util.ArrayList;
import java.util.concurrent.*;

public class AssemblyLineRunner {
    public static final Semaphore semaphore = new Semaphore(3);
    public static final ProductionLine computerHolder = ProductionLine.getInstance();

    public static void main(String[] args) {

        ArrayList<Thread> threads = new ArrayList<>();

        threads.add(getCpuThread());
        threads.add(getMotherboardThread());
        threads.add(getRamThread());
        threads.add(getSataThread());

        threads.forEach(Thread::start);
    }

    private static Thread getCpuThread() {
        Runnable cpuR = () -> {
            while (true) {
                try {
                    semaphore.acquire();
                    CPU cpu = new CPU();
                    computerHolder.installComponent(cpu);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    semaphore.release();
                }
            }
        };
        return new Thread(cpuR);
    }

    private static Thread getMotherboardThread() {
        Runnable motherboardR = () -> {
            while (true) {
                try {
                    semaphore.acquire();
                    Motherboard motherboard = new Motherboard();
                    computerHolder.installComponent(motherboard);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    semaphore.release();
                }
            }
        };
        return new Thread(motherboardR);
    }

    private static Thread getRamThread() {
        Runnable ramR = () -> {
            while (true) {
                try {
                    semaphore.acquire();
                    RAM ram = new RAM();
                    computerHolder.installComponent(ram);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    semaphore.release();
                }
            }
        };
        return new Thread(ramR);
    }

    private static Thread getSataThread() {
        Runnable sataR = () -> {
            while (true) {
                try {
                    semaphore.acquire();
                    SATA sata = new SATA();
                    computerHolder.installComponent(sata);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    semaphore.release();
                }
            }
        };
        return new Thread(sataR);
    }
}
