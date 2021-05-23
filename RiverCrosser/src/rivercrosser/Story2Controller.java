/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import static rivercrosser.Story1Controller.onBoat;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class Story2Controller implements Initializable {

    @FXML
    private Rectangle boat;
    @FXML
    private Button sailupBtn;
    @FXML
    private Button undoBtn;
    @FXML
    private Button redoBtn;
    @FXML
    private Button saildownBtn;
    @FXML
    private Label scorelbl;
    @FXML
    private ImageView goat;
    @FXML
    private ImageView farmer1;
    @FXML
    private ImageView farmer4;
    @FXML
    private ImageView farmer2;
    @FXML
    private ImageView farmer3;
    @FXML
    private ImageView farmer11;
    @FXML
    private ImageView farmer22;
    @FXML
    private ImageView farmer33;
    @FXML
    private ImageView farmer44;
    @FXML
    private ImageView goat2;
    @FXML
    private Label message;

    /**
     * Initializes the controller class.
     */
    StrategyOfLevel2 strategy2;
    List<ICrosser> tempList = new ArrayList<>();
    static int onBoat = 0;
    boolean isRightEmpty = true;
    boolean isLeftEmpty = true;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        create();
        instructions();
        load_images();
    }

    public void Mainmenu(ActionEvent event) throws IOException {
        Parent rivercrosser = FXMLLoader.load(getClass().getResource("StartMenu.fxml"));
        Scene rivercrosser_scene = new Scene(rivercrosser);
        Stage App_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App_stage.setScene(rivercrosser_scene);
        App_stage.show();
    }

    public void instructions() {
        String s = " ";
        int i;
        String[] str = strategy2.getInstructions();
        for (i = 0; i < str.length - 1; i++) {
            s += str[i];
            s += "\n";
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Instructions");
        alert.setContentText(s);
        alert.show();
    }

    public void create() {
        StrategyOfLevel2 s = new StrategyOfLevel2();
        Level2 two = new Level2();
        s.newGame(two);
        strategy2 = s;
    }

    public void Reset() {
        strategy2.resetGame();
    }

    void incScore() {
         int score = strategy2.getNumberOfSails();
        String s = Integer.toString(score);
        scorelbl.setText(s);
    }

    public void moveBoatUp() {
        if (onBoat == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("No one on the boat!!");
            alert.show();
        } else if (strategy2.canMove(tempList, true)) {
            boat.setLayoutY(225);
            strategy2.doMove(tempList, true);
            saildownBtn.setDisable(false);
            sailupBtn.setDisable(true);
            incScore();
            cross();
            initialize();
            canUndoRedo();
        } else {
            cannotsail();
        }
    }

    public void moveBoatDown() {
        if (onBoat == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("No one on the boat!!");
            alert.show();
        } else if (strategy2.canMove(tempList, false)) {
            boat.setLayoutY(356);
            strategy2.doMove(tempList, false);
            sailupBtn.setDisable(false);
            saildownBtn.setDisable(true);
            incScore();
            uncross();
            initialize2();
            canUndoRedo();
        } else {
            cannotsail();
        }
    }

    public void boatFull() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("boat is already full");
        alert.show();
    }

    public void cannotsail() {
        String[] str = strategy2.getInstructions();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(str[4]);
        alert.show();
    }

    public void initialize() {
        farmer1.setLayoutX(357);
        farmer1.setLayoutY(521);
        farmer2.setLayoutX(447);
        farmer2.setLayoutY(531);
        farmer3.setLayoutX(537);
        farmer3.setLayoutY(553);
        farmer4.setLayoutX(613);
        farmer4.setLayoutY(561);
        goat.setLayoutX(268);
        goat.setLayoutY(567);
        isLeftEmpty = true;
        isRightEmpty = true;
        tempList.clear();
        onBoat = 0;
    }

    public void initialize2() {
        farmer11.setLayoutX(357);
        farmer11.setLayoutY(71);
        farmer22.setLayoutX(447);
        farmer22.setLayoutY(81);
        farmer33.setLayoutX(537);
        farmer33.setLayoutY(103);
        farmer44.setLayoutX(613);
        farmer44.setLayoutY(111);
        goat2.setLayoutX(268);
        goat2.setLayoutY(117);
        isLeftEmpty = true;
        isRightEmpty = true;
        tempList.clear();
        onBoat = 0;
    }

    public void moveFarmer1() {
        if (strategy2.isBoatOnTheLeftBank()) {
            if (farmer1.getLayoutY() == boat.getLayoutY()) {
                farmer1.setLayoutX(357);
                farmer1.setLayoutY(521);
                onBoat--;
                if (tempList.indexOf(strategy2.strategy2.farmer1) == 0) {
                    isLeftEmpty = true;
                } else {
                    isRightEmpty = true;
                }
                tempList.remove(strategy2.strategy2.farmer1);
            } else {
                if (onBoat < 2) {
                    if (isLeftEmpty) {
                        farmer1.setLayoutX(boat.getLayoutX() + 20);
                        farmer1.setLayoutY(boat.getLayoutY());
                    } else {
                        farmer1.setLayoutX(boat.getLayoutX() + 170);
                        farmer1.setLayoutY(boat.getLayoutY());
                    }
                    onBoat++;
                    tempList.add(strategy2.strategy2.farmer1);
                    if (tempList.indexOf(strategy2.strategy2.farmer1) == 0) {
                        isLeftEmpty = false;
                    } else {
                        isRightEmpty = false;
                    }
                } else {
                    boatFull();
                }
            }
        } else {
            if (farmer11.getLayoutY() == boat.getLayoutY()) {
                farmer11.setLayoutX(357);
                farmer11.setLayoutY(71);
                onBoat--;
                if (tempList.indexOf(strategy2.strategy2.farmer1) == 0) {
                    isLeftEmpty = true;
                } else {
                    isRightEmpty = true;
                }
                tempList.remove(strategy2.strategy2.farmer1);
            } else {
                if (onBoat < 2) {
                    if (isLeftEmpty) {
                        farmer11.setLayoutX(boat.getLayoutX() + 20);
                        farmer11.setLayoutY(boat.getLayoutY());
                    } else {
                        farmer11.setLayoutX(boat.getLayoutX() + 170);
                        farmer11.setLayoutY(boat.getLayoutY());
                    }
                    onBoat++;
                    tempList.add(strategy2.strategy2.farmer1);
                    if (tempList.indexOf(strategy2.strategy2.farmer1) == 0) {
                        isLeftEmpty = false;
                    } else {
                        isRightEmpty = false;
                    }
                } else {
                    boatFull();
                }
            }
        }
    }

    public void moveFramer2() {
        if (strategy2.isBoatOnTheLeftBank()) {
            if (farmer2.getLayoutY() == boat.getLayoutY() + 5) {
                farmer2.setLayoutX(447);
                farmer2.setLayoutY(531);
                onBoat--;
                if (tempList.indexOf(strategy2.strategy2.farmer2) == 0) {
                    isLeftEmpty = true;
                } else {
                    isRightEmpty = true;
                }
                tempList.remove(strategy2.strategy2.farmer2);
            } else {
                if (onBoat < 2) {
                    if (isLeftEmpty) {
                        farmer2.setLayoutX(boat.getLayoutX() + 10);
                        farmer2.setLayoutY(boat.getLayoutY() + 5);
                    } else {
                        farmer2.setLayoutX(boat.getLayoutX() + 170);
                        farmer2.setLayoutY(boat.getLayoutY() + 5);
                    }
                    onBoat++;
                    tempList.add(strategy2.strategy2.farmer2);
                    if (tempList.indexOf(strategy2.strategy2.farmer2) == 0) {
                        isLeftEmpty = false;
                    } else {
                        isRightEmpty = false;
                    }
                } else {
                    boatFull();
                }
            }
        } else {
            if (farmer22.getLayoutY() == boat.getLayoutY() + 5) {
                farmer22.setLayoutX(447);
                farmer22.setLayoutY(81);
                onBoat--;
                if (tempList.indexOf(strategy2.strategy2.farmer2) == 0) {
                    isLeftEmpty = true;
                } else {
                    isRightEmpty = true;
                }
                tempList.remove(strategy2.strategy2.farmer2);
            } else {
                if (onBoat < 2) {
                    if (isLeftEmpty) {
                        farmer22.setLayoutX(boat.getLayoutX() + 10);
                        farmer22.setLayoutY(boat.getLayoutY() + 5);
                    } else {
                        farmer22.setLayoutX(boat.getLayoutX() + 170);
                        farmer22.setLayoutY(boat.getLayoutY() + 5);
                    }
                    onBoat++;
                    tempList.add(strategy2.strategy2.farmer2);
                    if (tempList.indexOf(strategy2.strategy2.farmer2) == 0) {
                        isLeftEmpty = false;
                    } else {
                        isRightEmpty = false;
                    }
                } else {
                    boatFull();
                }
            }
        }
    }

    public void moveFarmer3() {
        if (strategy2.isBoatOnTheLeftBank()) {
            if (farmer3.getLayoutY() == boat.getLayoutY() + 25) {
                farmer3.setLayoutX(537);
                farmer3.setLayoutY(553);
                onBoat--;
                if (tempList.indexOf(strategy2.strategy2.farmer3) == 0) {
                    isLeftEmpty = true;
                } else {
                    isRightEmpty = true;
                }
                tempList.remove(strategy2.strategy2.farmer3);
            } else {
                if (onBoat < 2) {
                    if (isLeftEmpty) {
                        farmer3.setLayoutX(boat.getLayoutX() + 10);
                        farmer3.setLayoutY(boat.getLayoutY() + 25);
                    } else {
                        farmer3.setLayoutX(boat.getLayoutX() + 170);
                        farmer3.setLayoutY(boat.getLayoutY() + 25);
                    }
                    onBoat++;
                    tempList.add(strategy2.strategy2.farmer3);
                    if (tempList.indexOf(strategy2.strategy2.farmer3) == 0) {
                        isLeftEmpty = false;
                    } else {
                        isRightEmpty = false;
                    }
                } else {
                    boatFull();
                }
            }
        } else {
            if (farmer33.getLayoutY() == boat.getLayoutY() + 25) {
                farmer33.setLayoutX(537);
                farmer33.setLayoutY(103);
                onBoat--;
                if (tempList.indexOf(strategy2.strategy2.farmer3) == 0) {
                    isLeftEmpty = true;
                } else {
                    isRightEmpty = true;
                }
                tempList.remove(strategy2.strategy2.farmer3);
            } else {
                if (onBoat < 2) {
                    if (isLeftEmpty) {
                        farmer33.setLayoutX(boat.getLayoutX() + 10);
                        farmer33.setLayoutY(boat.getLayoutY() + 25);
                    } else {
                        farmer33.setLayoutX(boat.getLayoutX() + 170);
                        farmer33.setLayoutY(boat.getLayoutY() + 25);
                    }
                    onBoat++;
                    tempList.add(strategy2.strategy2.farmer3);
                    if (tempList.indexOf(strategy2.strategy2.farmer3) == 0) {
                        isLeftEmpty = false;
                    } else {
                        isRightEmpty = false;
                    }
                } else {
                    boatFull();
                }
            }
        }
    }

    public void moveGoat() {
        if (strategy2.isBoatOnTheLeftBank()) {
            if (goat.getLayoutY() == boat.getLayoutY() + 25) {
                goat.setLayoutX(268);
                goat.setLayoutY(567);
                onBoat--;
                if (tempList.indexOf(strategy2.strategy2.goat) == 0) {
                    isLeftEmpty = true;
                } else {
                    isRightEmpty = true;
                }
                tempList.remove(strategy2.strategy2.goat);
            } else {
                if (onBoat < 2) {
                    if (isLeftEmpty) {
                        goat.setLayoutX(boat.getLayoutX() + 10);
                        goat.setLayoutY(boat.getLayoutY() + 25);
                    } else {
                        goat.setLayoutX(boat.getLayoutX() + 170);
                        goat.setLayoutY(boat.getLayoutY() + 25);
                    }
                    onBoat++;
                    tempList.add(strategy2.strategy2.goat);
                    if (tempList.indexOf(strategy2.strategy2.goat) == 0) {
                        isLeftEmpty = false;
                    } else {
                        isRightEmpty = false;
                    }
                } else {
                    boatFull();
                }
            }
        } else {
            if (goat2.getLayoutY() == boat.getLayoutY() + 25) {
                goat2.setLayoutX(268);
                goat2.setLayoutY(567);
                onBoat--;
                if (tempList.indexOf(strategy2.strategy2.goat) == 0) {
                    isLeftEmpty = true;
                } else {
                    isRightEmpty = true;
                }
                tempList.remove(strategy2.strategy2.goat);
            } else {
                if (onBoat < 2) {
                    if (isLeftEmpty) {
                        goat2.setLayoutX(boat.getLayoutX() + 10);
                        goat2.setLayoutY(boat.getLayoutY() + 25);
                    } else {
                        goat2.setLayoutX(boat.getLayoutX() + 170);
                        goat2.setLayoutY(boat.getLayoutY() + 25);
                    }
                    onBoat++;
                    tempList.add(strategy2.strategy2.goat);
                    if (tempList.indexOf(strategy2.strategy2.goat) == 0) {
                        isLeftEmpty = false;
                    } else {
                        isRightEmpty = false;
                    }
                } else {
                    boatFull();
                }
            }
        }
    }

    public void moveFarmer4() {
        if (strategy2.isBoatOnTheLeftBank()) {
            if (farmer4.getLayoutY() == boat.getLayoutY() + 25) {
                farmer4.setLayoutX(613);
                farmer4.setLayoutY(561);
                onBoat--;
                if (tempList.indexOf(strategy2.strategy2.farmer4) == 0) {
                    isLeftEmpty = true;
                } else {
                    isRightEmpty = true;
                }
                tempList.remove(strategy2.strategy2.farmer4);
            } else {
                if (onBoat < 2) {
                    if (isLeftEmpty) {
                        farmer4.setLayoutX(boat.getLayoutX() + 10);
                        farmer4.setLayoutY(boat.getLayoutY() + 25);
                    } else {
                        farmer4.setLayoutX(boat.getLayoutX() + 170);
                        farmer4.setLayoutY(boat.getLayoutY() + 25);
                    }
                    onBoat++;
                    tempList.add(strategy2.strategy2.farmer4);
                    if (tempList.indexOf(strategy2.strategy2.farmer4) == 0) {
                        isLeftEmpty = false;
                    } else {
                        isRightEmpty = false;
                    }
                } else {
                    boatFull();
                }
            }
        } else {
            if (farmer44.getLayoutY() == boat.getLayoutY() + 25) {
                farmer44.setLayoutX(631);
                farmer44.setLayoutY(111);
                onBoat--;
                if (tempList.indexOf(strategy2.strategy2.farmer4) == 0) {
                    isLeftEmpty = true;
                } else {
                    isRightEmpty = true;
                }
                tempList.remove(strategy2.strategy2.farmer4);
            } else {
                if (onBoat < 2) {
                    if (isLeftEmpty) {
                        farmer44.setLayoutX(boat.getLayoutX() + 10);
                        farmer44.setLayoutY(boat.getLayoutY() + 25);
                    } else {
                        farmer44.setLayoutX(boat.getLayoutX() + 170);
                        farmer44.setLayoutY(boat.getLayoutY() + 25);
                    }
                    onBoat++;
                    tempList.add(strategy2.strategy2.farmer4);
                    if (tempList.indexOf(strategy2.strategy2.farmer4) == 0) {
                        isLeftEmpty = false;
                    } else {
                        isRightEmpty = false;
                    }
                } else {
                    boatFull();
                }
            }
        }
    }

    void cross() {
        List<ICrosser> temp = strategy2.getCrossersOnRightBank();
        if (temp.contains(strategy2.strategy2.farmer1)) {
            farmer1.setVisible(false);
            farmer11.setVisible(true);
        }
        if (temp.contains(strategy2.strategy2.farmer2)) {
            farmer2.setVisible(false);
            farmer22.setVisible(true);
        }
        if (temp.contains(strategy2.strategy2.farmer3)) {
            farmer3.setVisible(false);
            farmer33.setVisible(true);
        }
        if (temp.contains(strategy2.strategy2.farmer4)) {
            farmer4.setVisible(false);
            farmer44.setVisible(true);
        }
        if (temp.contains(strategy2.strategy2.goat)) {
            goat.setVisible(false);
            goat2.setVisible(true);
        }
    }

    void uncross() {
        List<ICrosser> temp = strategy2.getCrossersOnLeftBank();
        if (temp.contains(strategy2.strategy2.farmer1)) {
            farmer11.setVisible(false);
            farmer1.setVisible(true);
        }
        if (temp.contains(strategy2.strategy2.farmer2)) {
            farmer22.setVisible(false);
            farmer2.setVisible(true);
        }
        if (temp.contains(strategy2.strategy2.farmer3)) {
            farmer33.setVisible(false);
            farmer3.setVisible(true);
        }
        if (temp.contains(strategy2.strategy2.farmer4)) {
            farmer44.setVisible(false);
            farmer4.setVisible(true);
        }
        if (temp.contains(strategy2.strategy2.goat)) {
            goat2.setVisible(false);
            goat.setVisible(true);
        }
    }
    
    public void farmer1label(){
        message.setText("farmer can raft & have weight of 90 Kg");
    }
    
    public void farmer2label(){
        message.setText("farmer can raft & have weight of 80 Kg");
    }
    
    public void farmer3label(){
        message.setText("farmer can raft & have weight of 60 Kg");
    }
    
    public void farmer4label(){
        message.setText("farmer can raft & have weight of 40 Kg");
    }
    
    public void goatlabel(){
        message.setText("goat cannot raft & have weight of 20 Kg");
    }
    
    public void unsetlabel(){
        message.setText(" ");
    }
    
    void load_images(){
        BufferedImage [] buffer =  strategy2.strategy2.farmer.getImages();
        Image image = SwingFXUtils.toFXImage(buffer[0], null);
        farmer1.setImage(image);
        farmer2.setImage(image);
        farmer3.setImage(image);
        farmer4.setImage(image);
        image = SwingFXUtils.toFXImage(buffer[1], null);
        farmer11.setImage(image);
        farmer22.setImage(image);
        farmer33.setImage(image);
        farmer44.setImage(image);
        
        buffer =  strategy2.strategy2.goat.getImages();
        image = SwingFXUtils.toFXImage(buffer[0], null);
        goat.setImage(image);
        image = SwingFXUtils.toFXImage(buffer[1], null);
        goat2.setImage(image);
    }
    
    void canUndoRedo(){
        if(strategy2.canUndo())
            undoBtn.setDisable(false);
        else undoBtn.setDisable(true);
        if(strategy2.canRedo())
            redoBtn.setDisable(false);
        else redoBtn.setDisable(true);
    }
    
    public void redo(){
        strategy2.redo();
        incScore();
        cross();
        uncross();
        if (strategy2.isBoatOnTheLeftBank()){
            boat.setLayoutY(356);
            saildownBtn.setDisable(true);
            sailupBtn.setDisable(false);
        }
        else{
            boat.setLayoutY(225);
            saildownBtn.setDisable(false);
            sailupBtn.setDisable(true);
        }
        canUndoRedo();
    }
    
    public void undo(){
        strategy2.undo();
        incScore();
        cross();
        uncross();
        if (strategy2.isBoatOnTheLeftBank()){
            boat.setLayoutY(356);
            saildownBtn.setDisable(true);
            sailupBtn.setDisable(false);
        }
        else {
            boat.setLayoutY(225);
            saildownBtn.setDisable(false);
            sailupBtn.setDisable(true);
        }
        canUndoRedo();
    }
    
    public void Reset(ActionEvent event) throws IOException{
        Parent rivercrosser = FXMLLoader.load(getClass().getResource("Story2.fxml"));
        Scene rivercrosser_scene = new Scene (rivercrosser);
        Stage App_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App_stage.setScene(rivercrosser_scene);
        App_stage.show();
        strategy2.resetGame();
    }
}
