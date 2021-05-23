/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javafx.scene.control.Alert;

/**
 *
 * @author LENOVO
 */
public class StrategyOfLevel3 implements IRiverController {

    ICrosserstrategy strategy3;
    int numberofsail;
    Stack undostack = new Stack();
    Stack redostack = new Stack();
    int i = 0;
    int j = 0;
    int undo = 0;
    int redo = 0;

    @Override
    public void newGame(ICrosserstrategy gameStrategy) {
        strategy3 = gameStrategy;
        strategy3.getInitialCrossers();
        resetGame();
    }

    @Override
    public void resetGame() {
        strategy3.rightBankCrossers.clear();
        strategy3.leftBankCrossers.clear();
        strategy3.boatRiders.clear();
        numberofsail = 0;
    }

    @Override
    public String[] getInstructions() {
        return strategy3.getInstructions();
    }

    @Override
    public List<ICrosser> getCrossersOnRightBank() {
        return strategy3.rightBankCrossers;
    }

    @Override
    public List<ICrosser> getCrossersOnLeftBank() {
        return strategy3.leftBankCrossers;
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
            strategy3.rightBankCrossers.add(crossers.get(0));
            strategy3.leftBankCrossers.remove(crossers.get(0));
            if (crossers.size() == 2) {
                strategy3.rightBankCrossers.add(crossers.get(1));
                strategy3.leftBankCrossers.remove(crossers.get(1));
            }
            List<ICrosser> right = getCrossersOnRightBank();
            List<ICrosser> left = getCrossersOnLeftBank();
            b = strategy3.isValid(right, left, crossers);
            strategy3.rightBankCrossers.remove(crossers.get(0));
            strategy3.leftBankCrossers.add(crossers.get(0));
            if (crossers.size() == 2) {
                strategy3.leftBankCrossers.add(crossers.get(1));
                strategy3.rightBankCrossers.remove(crossers.get(1));
            }
        } else {
            strategy3.rightBankCrossers.remove(crossers.get(0));
            strategy3.leftBankCrossers.add(crossers.get(0));
            if (crossers.size() == 2) {
                strategy3.rightBankCrossers.remove(crossers.get(1));
                strategy3.leftBankCrossers.add(crossers.get(1));
            }
            List<ICrosser> right = getCrossersOnRightBank();
            List<ICrosser> left = getCrossersOnLeftBank();
            b = strategy3.isValid(right, left, crossers);
            strategy3.rightBankCrossers.add(crossers.get(0));
            strategy3.leftBankCrossers.remove(crossers.get(0));
            if (crossers.size() == 2) {
                strategy3.leftBankCrossers.remove(crossers.get(1));
                strategy3.rightBankCrossers.add(crossers.get(1));
            }
        }
        return b;
    }

    @Override
    public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
        boolean b;
        if (fromLeftToRightBank) {
            strategy3.rightBankCrossers.add(crossers.get(0));
            strategy3.leftBankCrossers.remove(crossers.get(0));
            numberofsail++;
            if (crossers.size() == 2) {
                strategy3.rightBankCrossers.add(crossers.get(1));
                strategy3.leftBankCrossers.remove(crossers.get(1));
                undostack.push(2);
            } else {
                undostack.push(1);
            }
            i++;
            j = i - 1;
            undo++;
        } else {
            strategy3.rightBankCrossers.remove(crossers.get(0));
            strategy3.leftBankCrossers.add(crossers.get(0));
            numberofsail++;
            if (crossers.size() == 2) {
                strategy3.rightBankCrossers.remove(crossers.get(1));
                strategy3.leftBankCrossers.add(crossers.get(1));
                undostack.push(2);
            } else {
                undostack.push(1);
            }
            i++;
            j = i - 1;
            undo++;
        }
        if (strategy3.rightBankCrossers.size() == 4) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Congratulations");
            alert.setContentText("YOU HAVE WON\n Your score: " + numberofsail + "  !!");
            alert.show();
        }
    }

    @Override
    public boolean canUndo() {
        if (undo > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canRedo() {
        if (redo > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void undo() {
        List<ICrosser> temp = new ArrayList<>();
        int size = 0;
        int k;
        if (!isBoatOnTheLeftBank()) {
            int x = (int) undostack.pop();
            redostack.push(x);
            for (k = 0; k < x; k++) {
                size = strategy3.rightBankCrossers.size();
                temp.add(strategy3.rightBankCrossers.get(size - 1));
                strategy3.rightBankCrossers.remove(size - 1);
                strategy3.leftBankCrossers.add(temp.get(k));
            }
            numberofsail--;
            temp.clear();
            j--;
            undo--;
            redo++;
        } else {
            int x = (int) undostack.pop();
            redostack.push(x);
            for (k = 0; k < x; k++) {
                size = strategy3.leftBankCrossers.size();
                temp.add(strategy3.leftBankCrossers.get(size - 1));
                strategy3.leftBankCrossers.remove(size - 1);
                strategy3.rightBankCrossers.add(temp.get(k));
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
        int size = 0;
        int k;
        if (!isBoatOnTheLeftBank()) {
            int x = (int) redostack.pop();
            undostack.push(x);
            for (k = 0; k < x; k++) {
                size = strategy3.rightBankCrossers.size();
                temp.add(strategy3.rightBankCrossers.get(size - 1));
                strategy3.rightBankCrossers.remove(size - 1);
                strategy3.leftBankCrossers.add(temp.get(k));
            }
            numberofsail++;
            temp.clear();
            j++;
            undo++;
            redo--;
        } else {
            int x = (int) redostack.pop();
            undostack.push(x);
            for (k = 0; k < x; k++) {
                size = strategy3.leftBankCrossers.size();
                temp.add(strategy3.leftBankCrossers.get(size - 1));
                strategy3.leftBankCrossers.remove(size - 1);
                strategy3.rightBankCrossers.add(temp.get(k));
            }
            numberofsail++;
            temp.clear();
            j++;
            undo++;
            redo--;
        }    }

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
