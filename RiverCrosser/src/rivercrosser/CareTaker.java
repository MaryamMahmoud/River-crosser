package rivercrosser;


import java.util.ArrayList;

public class CareTaker {

    private ArrayList<ScoreSaving> mementos = new ArrayList<>();

    
    public void addMemento(ScoreSaving k) {
        mementos.add(k);
    }

    public ScoreSaving getMemento() {
        return mementos.get(1);
    }
}
