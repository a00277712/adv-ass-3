package model;

public class Computer {
    private CPU cpu;
    private RAM[] ramSticks = new RAM[4];
    private Motherboard motherboard;
    private SATA[] sataCables = new SATA[4];

    public boolean addCpu(CPU cpu) {
        if(this.cpu == null){
            this.cpu = cpu;
            return true;
        }else{
            return false;
        }
    }

    public boolean addMotherboard(Motherboard motherboard) {
        if(this.motherboard == null){
            this.motherboard = motherboard;
            return true;
        }else{
            return false;
        }
    }

    public boolean addRam(RAM ram){
        if(ramSticks.length >= 4){
            return false;
        }else{
            ramSticks[ramSticks.length] = ram;
            return true;
        }
    }

    public boolean addSata(SATA sata){
        if(sataCables.length >= 4){
            return false;
        }else{
            sataCables[sataCables.length] = sata;
            return true;
        }
    }

    public boolean isBuilt(){
        return cpu != null && ramSticks.length == 4 && motherboard != null && sataCables.length == 4;
    }
}
