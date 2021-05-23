/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Level2 implements ICrosserstrategy {
    
    String errorMsg;

    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
        boolean g = true;
        if (boatRiders.contains(goat) && boatRiders.size()==1){
            errorMsg = "Only farmer can raft";
            g = false;
        }
        if (boatRiders.size()==2){
        if (boatRiders.get(0).getweight() + boatRiders.get(1).getweight() > 100){
            errorMsg = "boat cannot bear a load heavier than 100 kg";
            g = false;
        }
        }
        return g;
    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        leftBankCrossers.clear();
        leftBankCrossers.add(farmer1);
        leftBankCrossers.add(farmer2);
        leftBankCrossers.add(farmer3);
        leftBankCrossers.add(farmer4);
        leftBankCrossers.add(goat);
        return leftBankCrossers;    
    }

    @Override
    public String[] getInstructions() {
        String[] instructions = new String[5];
        instructions[0] = "Four farmers and their animal need to cross a river in a small boat\n";
        instructions[1] = "The weights of the farmers  are 90 kg, 80 kg,60 kg and 40 kg respectively, and the weight of the animal is 20 kg.\n";
        instructions[2] = " ​The boat cannot bear a load heavier than 100 kg.\n";
        instructions[3] = " ​All farmers can raft, while the animal cannot.\n";
        instructions[4] = errorMsg;

        return instructions;    
    }
    
}
