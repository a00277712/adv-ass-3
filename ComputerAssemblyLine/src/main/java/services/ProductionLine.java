package services;

import components.Computer;
import components.IComponent;

import java.util.ArrayList;
import java.util.logging.Logger;

public class ProductionLine {
    private static ProductionLine instance;

    private static ArrayList<Computer> computers = new ArrayList<>();
    private static ArrayList<Computer> builtComputers = new ArrayList<>();
    
    private ProductionLine(){}

    public static synchronized ProductionLine getInstance() {
        if(instance == null){
            instance = new ProductionLine();
        }
        return instance;
    }

    /**
     * Attempt to install component on a computer
     * @param component to install
     */
    public synchronized void installComponent(IComponent component){
        Computer computer;
        int i = 0;
        // loop through incomplete computers trying to add component if it doesn't fit move onto next computer
        do{
            // if computer i doesn't exist start a new computer
            if(computers.size() <= i){
                computers.add(new Computer());
            }
            computer = computers.get(i);
            i++;
        }while (!component.addComponent(computer));

        if(computer.isBuilt()){
            builtComputers.add(computer);
            computers.remove(computer);

            Logger logger = Logger.getLogger(ProductionLine.class.getName());

            String incompleteCount = "number of Computers incomplete: " +  computers.size();
            String completeCount = "number of Computers complete: " + builtComputers.size();

            logger.info(incompleteCount);
            logger.info(completeCount);
        }
    }
}
