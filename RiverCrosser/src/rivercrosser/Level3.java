package rivercrosser;

import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Level3 implements ICrosserstrategy {

    String errorMsg;

    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
        boolean g = true;
        if(boatRiders.size()==1)
            g = true;
        if (boatRiders.size()==2){
        if ((boatRiders.contains(farmer1)|| boatRiders.contains(farmer2)) && (boatRiders.contains(child1) || boatRiders.contains(child2))){
            errorMsg = "The boat can hold a maximum of one worker or two children";
            g = false;
        }
        }
        return g;    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        leftBankCrossers.clear();
        leftBankCrossers.add(farmer1);
        leftBankCrossers.add(farmer2);
        leftBankCrossers.add(child1);
        leftBankCrossers.add(child2);
        return leftBankCrossers;
    }

    @Override
    public String[] getInstructions() {
        String[] instructions = new String[5];
        instructions[0] = "Two workers and two children want to cross a river.\n";
        instructions[1] = "Rules : \n";
        instructions[2] = "The boat can hold a maximum of one worker or two children\n";
        instructions[3] = "Everyone can row.\n";
        instructions[4] = errorMsg;
        return instructions;

    }
}
