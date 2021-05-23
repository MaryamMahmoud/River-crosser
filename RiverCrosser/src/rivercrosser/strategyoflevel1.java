package rivercrosser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;


public class strategyoflevel1 implements IRiverController  {
            
            ICrosserstrategy strategy;
            int numberofsail;
            Stack undostack = new Stack();
            Stack redostack = new Stack();
            int i=0;
            int j=0;
            int undo = 0;
            int redo =0;
    
    @Override
	public void newGame(ICrosserstrategy gameStrategy) {
                    strategy = gameStrategy;
                    strategy.getInitialCrossers();
                    resetGame();
	}

	@Override
	public void resetGame(){
                strategy.rightBankCrossers.clear();
                strategy.leftBankCrossers.clear();
                strategy.boatRiders.clear();
                numberofsail = 0;
        }

	@Override
	public String[] getInstructions() {
            return strategy.getInstructions();
	}

	@Override
	public List<ICrosser> getCrossersOnRightBank(){
		
		return strategy.rightBankCrossers;
	}

	@Override
	public List<ICrosser> getCrossersOnLeftBank() {
		return strategy.leftBankCrossers;
	}

	@Override
	public boolean isBoatOnTheLeftBank() {
            if (numberofsail % 2 == 0)
            return true;
            else return false;
	}

	@Override
	public int getNumberOfSails() {
		return numberofsail;
	}

	@Override
	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
            boolean b;
            if (fromLeftToRightBank){
            strategy.rightBankCrossers.add(crossers.get(0));
            strategy.leftBankCrossers.remove(crossers.get(0));
            if(crossers.size() == 2){
            strategy.rightBankCrossers.add(crossers.get(1));
            strategy.leftBankCrossers.remove(crossers.get(1));
            }
            List<ICrosser> right = getCrossersOnRightBank();
            List<ICrosser> left =getCrossersOnLeftBank();        
            b = strategy.isValid(right, left, crossers);
            strategy.rightBankCrossers.remove(crossers.get(0));
            strategy.leftBankCrossers.add(crossers.get(0));
            if(crossers.size() == 2){
            strategy.leftBankCrossers.add(crossers.get(1));
            strategy.rightBankCrossers.remove(crossers.get(1));
            }
            }
            else {
                strategy.rightBankCrossers.remove(crossers.get(0));
            strategy.leftBankCrossers.add(crossers.get(0));
            if(crossers.size() == 2){
            strategy.rightBankCrossers.remove(crossers.get(1));
            strategy.leftBankCrossers.add(crossers.get(1));
            }
            List<ICrosser> right = getCrossersOnRightBank();
            List<ICrosser> left =getCrossersOnLeftBank();        
            b = strategy.isValid(right, left, crossers);
            strategy.rightBankCrossers.add(crossers.get(0));
            strategy.leftBankCrossers.remove(crossers.get(0));
            if(crossers.size() == 2){
            strategy.leftBankCrossers.remove(crossers.get(1));
            strategy.rightBankCrossers.add(crossers.get(1));
            }
            }
            return b;
	}

	@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
            boolean b;
            if (fromLeftToRightBank){
            strategy.rightBankCrossers.add(crossers.get(0));
            strategy.leftBankCrossers.remove(crossers.get(0));
            numberofsail++;
            if(crossers.size() == 2){
            strategy.rightBankCrossers.add(crossers.get(1));
            strategy.leftBankCrossers.remove(crossers.get(1));
            undostack.push(2);
            }
            else undostack.push(1);
            i++;
            j=i-1;
            undo++;
            }
            else {
                strategy.rightBankCrossers.remove(crossers.get(0));
                strategy.leftBankCrossers.add(crossers.get(0));
                numberofsail++;
            if(crossers.size() == 2){
            strategy.rightBankCrossers.remove(crossers.get(1));
            strategy.leftBankCrossers.add(crossers.get(1));
            undostack.push(2);
            }
            else undostack.push(1);
            i++;
            j=i-1;
            undo++;
            }
            if (strategy.rightBankCrossers.size()==4)
            {
                Alert alert = new Alert (Alert.AlertType.INFORMATION);
                alert.setHeaderText("Congratulations");
                alert.setContentText("YOU HAVE WON\n Your score: " + numberofsail + "  !!");
                alert.show();
            }
	}

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
                    size = strategy.rightBankCrossers.size();
                    temp.add(strategy.rightBankCrossers.get(size-1));
                    strategy.rightBankCrossers.remove(size-1);
                    strategy.leftBankCrossers.add(temp.get(k));
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
                    size = strategy.leftBankCrossers.size();
                    temp.add(strategy.leftBankCrossers.get(size-1));
                    strategy.leftBankCrossers.remove(size-1);
                    strategy.rightBankCrossers.add(temp.get(k));
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
                    size = strategy.rightBankCrossers.size();
                    temp.add(strategy.rightBankCrossers.get(size-1));
                    strategy.rightBankCrossers.remove(size-1);
                    strategy.leftBankCrossers.add(temp.get(k));
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
                    size = strategy.leftBankCrossers.size();
                    temp.add(strategy.leftBankCrossers.get(size-1));
                    strategy.leftBankCrossers.remove(size-1);
                    strategy.rightBankCrossers.add(temp.get(k));
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<List<ICrosser>> solveGame() {
	List<List<ICrosser>> temp = new ArrayList<>();
        List<ICrosser> initial = strategy.getInitialCrossers();
        List<ICrosser> step = new ArrayList<>();
		step.add(initial.get(0));
                step.add(initial.get(3));
                temp.add(step);
                step.clear();
                step.add(initial.get(0));
                temp.add(step);
                step.clear();
                step.add(initial.get(0));
                step.add(initial.get(2));
                temp.add(step);
                step.clear();
                step.add(initial.get(0));
                step.add(initial.get(3));
                temp.add(step);
                step.clear();
                step.add(initial.get(0));
                step.add(initial.get(1));
                temp.add(step);
                step.clear();
                step.add(initial.get(0));
                temp.add(step);
                step.clear();
                step.add(initial.get(0));
                step.add(initial.get(3));
                temp.add(step);
		return temp;
	}

}