package rivercrosser;


import java.util.List;
import java.util.Random;

public class level1 implements ICrosserstrategy {

 
    String errorMsg;
    

    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,List<ICrosser> boatRiders) {
        boolean g = true;
        if (((rightBankCrossers.contains(lion)||rightBankCrossers.contains(fox)) && (rightBankCrossers.contains(goat)||rightBankCrossers.contains(sheep)) && !rightBankCrossers.contains(farmer))
                || ((leftBankCrossers.contains(lion)||leftBankCrossers.contains(fox)) && (leftBankCrossers.contains(goat)||leftBankCrossers.contains(sheep)) && !leftBankCrossers.contains(farmer))){
            g = false;
            errorMsg = "Carnivore will eat Herbivorus!!";
        }
        
        if (((rightBankCrossers.contains(goat)||rightBankCrossers.contains(sheep))&&rightBankCrossers.contains(plant)&&!rightBankCrossers.contains(farmer)) || 
                ((leftBankCrossers.contains(goat)||leftBankCrossers.contains(sheep))&&leftBankCrossers.contains(plant)&&!leftBankCrossers.contains(farmer))) {
            g = false;
            errorMsg = "Herbivorue will eat plant!!";
        }

        if(!boatRiders.contains(farmer)){
            g = false;
            errorMsg = "No one can sail!!";
        }
        return g;
    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        leftBankCrossers.clear();
        Random rand = new Random();
        int rand_int1 = rand.nextInt(2); 
        int rand_int2 = rand.nextInt(2); 
        leftBankCrossers.add(farmer);
        leftBankCrossers.add(plant);
        if (rand_int1 == 0)
        leftBankCrossers.add(lion);
        else if (rand_int1 == 1)
        leftBankCrossers.add(fox);
        if (rand_int2 == 0)
        leftBankCrossers.add(sheep);
        else if (rand_int2 == 1)
        leftBankCrossers.add(goat);
        return leftBankCrossers;
    }

    @Override
    public String[] getInstructions() {
        // TODO Auto-generated method stub
        String[] instructions = new String[4];
        instructions[0] = "A farmer wants to cross the river and take with him wolf,goat and cabbage\n";
        instructions[1] = "The farmer is the only one who can sail the boat\n";
        instructions[2] = "You can not leave any 2 crossers on the same bank if they can harm each other";
        instructions[3] = errorMsg;

        return instructions;
    }

}
