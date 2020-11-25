package components;

import java.util.ArrayList;

public class Computer {
    private CPU cpu;
    private ArrayList<RAM> ramSticks = new ArrayList<>();
    private Motherboard motherboard;
    private ArrayList<SATA> sataCables = new ArrayList<>();

    /**
     * Attempt to add CPU to computer
     * @param cpu component to add
     * @return false if already have a CPU
     */
    public boolean addCpu(CPU cpu) {
        if(this.cpu == null){
            this.cpu = cpu;
            return true;
        }else{
            return false;
        }
    }

    /**
     * Attempt to add Motherboard to computer
     * @param motherboard component to add
     * @return false if already have a Motherboard
     */
    public boolean addMotherboard(Motherboard motherboard) {
        if(this.motherboard == null){
            this.motherboard = motherboard;
            return true;
        }else{
            return false;
        }
    }

    /**
     * Attempt to add RAM to computer
     * @param ram component to add
     * @return false if already have 4 sticks of ram
     */
    public boolean addRam(RAM ram){
        if(ramSticks.size() >= 4){
            return false;
        }else{
            ramSticks.add(ram);
            return true;
        }
    }

    /**
     * Attempt to add SATA cable to computer
     * @param sata component to add
     * @return false if already have 4 SATA cables
     */
    public boolean addSata(SATA sata){
        if(sataCables.size() >= 4){
            return false;
        }else{
            sataCables.add(sata);
            return true;
        }
    }

    /**
     * Attempt to add SATA cable to computer
     * @return if the computer has all it's parts
     */
    public boolean isBuilt(){
        return cpu != null && ramSticks.size() == 4 && motherboard != null && sataCables.size() == 4;
    }
}
