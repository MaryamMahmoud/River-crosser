package rivercrosser;


import java.util.ArrayList;
import java.util.List;

public interface ICrosserstrategy {
    
    public List<ICrosser> rightBankCrossers = new ArrayList<>();
    public List<ICrosser>  leftBankCrossers = new ArrayList<>();
    public List<ICrosser> boatRiders = new ArrayList<>();
    Carnivorus lion = new Carnivorus(2);
    Carnivorus fox = new Carnivorus(1);
    Herbivorus goat = new Herbivorus(1);
    Herbivorus sheep = new Herbivorus(2);
    Farmer farmer = new Farmer(80,0);
    Farmer farmer1 = new Farmer(90,1);
    Farmer farmer2 = new Farmer(80,1);
    Farmer farmer3 = new Farmer(60,1);
    Farmer farmer4 = new Farmer(40,1);
    Plant plant = new Plant();
    Children child1 = new Children(40);
    Children child2 = new Children(40);

    public boolean isValid(List<ICrosser> rightBankCrossers,
            List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders);

    /**
     * @return the crossers of the left bank initially the right bank has no
     * crossers initially
     */
    public List<ICrosser> getInitialCrossers();

    /**
     * @return return the rules and the instructions of the current strategy, to
     * be shown to the user
     */
    public String[] getInstructions();
}
