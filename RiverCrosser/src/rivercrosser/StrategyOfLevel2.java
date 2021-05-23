package rivercrosser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javafx.scene.control.Alert;

public class StrategyOfLevel2 implements IRiverController {

    ICrosserstrategy strategy2;
    int numberofsail;
    Stack undostack = new Stack();
    Stack redostack = new Stack();
    int i=0;
    int j=0;
    int undo = 0;
    int redo =0;

    @Override
    public void newGame(ICrosserstrategy gameStrategy) {
        strategy2 = gameStrategy;
        strategy2.getInitialCrossers();
        resetGame();
    }

    @Override
    public void resetGame() {
        strategy2.rightBankCrossers.clear();
        strategy2.leftBankCrossers.clear();
        strategy2.boatRiders.clear();
        numberofsail = 0;
    }

    @Override
    public String[] getInstructions() {
        return strategy2.getInstructions();
    }

    @Override
    public List<ICrosser> getCrossersOnRightBank() {
        return strategy2.rightBankCrossers;
    }

    @Override
    public List<ICrosser> getCrossersOnLeftBank() {
        return strategy2.leftBankCrossers;
    }

    @Override
    public boolean isBoatOnTheLeftBank() {
        if (numberofsail % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getNumberOfSails() {
        return numberofsail;
    }

    @Override
    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
 boolean b;
        if (fromLeftToRightBank) {
            strategy2.rightBankCrossers.add(crossers.get(0));
            strategy2.leftBankCrossers.remove(crossers.get(0));
            if (crossers.size() == 2) {
                strategy2.rightBankCrossers.add(crossers.get(1));
                strategy2.leftBankCrossers.remove(crossers.get(1));
            }
            List<ICrosser> right = getCrossersOnRightBank();
            List<ICrosser> left = getCrossersOnLeftBank();
            b = strategy2.isValid(right, left, crossers);
            strategy2.rightBankCrossers.remove(crossers.get(0));
            strategy2.leftBankCrossers.add(crossers.get(0));
            if (crossers.size() == 2) {
                strategy2.leftBankCrossers.add(crossers.get(1));
                strategy2.rightBankCrossers.remove(crossers.get(1));
            }
        } else {
            strategy2.rightBankCrossers.remove(crossers.get(0));
            strategy2.leftBankCrossers.add(crossers.get(0));
            if (crossers.size() == 2) {
                strategy2.rightBankCrossers.remove(crossers.get(1));
                strategy2.leftBankCrossers.add(crossers.get(1));
            }
            List<ICrosser> right = getCrossersOnRightBank();
            List<ICrosser> left = getCrossersOnLeftBank();
            b = strategy2.isValid(right, left, crossers);
            strategy2.rightBankCrossers.add(crossers.get(0));
            strategy2.leftBankCrossers.remove(crossers.get(0));
            if (crossers.size() == 2) {
                strategy2.leftBankCrossers.remove(crossers.get(1));
                strategy2.rightBankCrossers.add(crossers.get(1));
            }
        }
        return b;    
    }

    @Override
    public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
boolean b;
        if (fromLeftToRightBank) {
            strategy2.rightBankCrossers.add(crossers.get(0));
            strategy2.leftBankCrossers.remove(crossers.get(0));
            numberofsail++;
            if (crossers.size() == 2) {
                strategy2.rightBankCrossers.add(crossers.get(1));
                strategy2.leftBankCrossers.remove(crossers.get(1));
            undostack.push(2);
            }
            else undostack.push(1);
            i++;
            j=i-1;
            undo++;
            }
        else {
            strategy2.rightBankCrossers.remove(crossers.get(0));
            strategy2.leftBankCrossers.add(crossers.get(0));
            numberofsail++;
            if (crossers.size() == 2) {
                strategy2.rightBankCrossers.remove(crossers.get(1));
                strategy2.leftBankCrossers.add(crossers.get(1));
            undostack.push(2);
            }
            else undostack.push(1);
            i++;
            j=i-1;
            undo++;
            }
        if (strategy2.rightBankCrossers.size() == 5) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Congratulations");
            alert.setContentText("YOU HAVE WON\n Your score: " + numberofsail + "  !!");
            alert.show();
        }    }

    @Override
	public boolean canUndo() {
		if(undo>0)
		return true;
                else return false;
	}

	@Override
	public boolean canRedo() {
		if(redo>0)
		return true;
                else return false;
	}

	@Override
	public void undo() {
            List<ICrosser> temp = new ArrayList<>();
            int size=0;
            int k;
		if(!isBoatOnTheLeftBank())
		{
                    int x =(int) undostack.pop();
                    redostack.push(x);
                    for (k=0;k<x;k++){
                    size = strategy2.rightBankCrossers.size();
                    temp.add(strategy2.rightBankCrossers.get(size-1));
                    strategy2.rightBankCrossers.remove(size-1);
                    strategy2.leftBankCrossers.add(temp.get(k));
                    }
                        numberofsail--;
                        temp.clear();
                        j--;
                        undo--;
                        redo++;
		}
		else
		{
                    int x =(int) undostack.pop();
                    redostack.push(x);
			for (k=0;k<x;k++){
                    size = strategy2.leftBankCrossers.size();
                    temp.add(strategy2.leftBankCrossers.get(size-1));
                    strategy2.leftBankCrossers.remove(size-1);
                    strategy2.rightBankCrossers.add(temp.get(k));
                    }
                        numberofsail--;
                        temp.clear();
                        j--;
                        undo--;
                        redo++;
		}
	}

	@Override
	public void redo() {
            List<ICrosser> temp = new ArrayList<>();
            int size=0;
            int k;
		if(!isBoatOnTheLeftBank())
		{
                    int x =(int) redostack.pop();
                    undostack.push(x);
                    for (k=0;k<x;k++){
                    size = strategy2.rightBankCrossers.size();
                    temp.add(strategy2.rightBankCrossers.get(size-1));
                    strategy2.rightBankCrossers.remove(size-1);
                    strategy2.leftBankCrossers.add(temp.get(k));
                    }
                        numberofsail++;
                        temp.clear();
                        j++;
                        undo++;
                        redo--;
		}
		else
		{
                    int x =(int) redostack.pop();
                    undostack.push(x);
			for (k=0;k<x;k++){
                    size = strategy2.leftBankCrossers.size();
                    temp.add(strategy2.leftBankCrossers.get(size-1));
                    strategy2.leftBankCrossers.remove(size-1);
                    strategy2.rightBankCrossers.add(temp.get(k));
                    }
                        numberofsail++;
                        temp.clear();
                        j++;
                        undo++;
                        redo--;
		}
	}

    @Override
    public void saveGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<List<ICrosser>> solveGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
