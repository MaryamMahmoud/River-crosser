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
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class Story3Controller implements Initializable {

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
    private ImageView farmer2;
    @FXML
    private Label scorelbl;
    @FXML
    private Label message;
    @FXML
    private ImageView farmer1;
    @FXML
    private ImageView kid1;
    @FXML
    private ImageView kid2;
    @FXML
    private ImageView farmer22;
    @FXML
    private ImageView farmer11;
    @FXML
    private ImageView kid11;
    @FXML
    private ImageView kid22;

    /**
     * Initializes the controller class.
     */
    
    StrategyOfLevel3 strategy;
    List<ICrosser> tempList = new ArrayList<>();
    static int onBoat =0;
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

     public void moveFarmer2() {
        if (strategy.isBoatOnTheLeftBank()){
        if (farmer2.getLayoutY() == boat.getLayoutY())
        {
            farmer2.setLayoutX(397);
            farmer2.setLayoutY(511);
            onBoat--;
            if(tempList.indexOf(strategy.strategy3.farmer2)==0)
            isLeftEmpty = true;
            else isRightEmpty=true;
            tempList.remove(strategy.strategy3.farmer2);
        }
        else {
            if (onBoat<2){
            if (isLeftEmpty){
            farmer2.setLayoutX(boat.getLayoutX()+20);
            farmer2.setLayoutY(boat.getLayoutY());
            }
            else {
                farmer2.setLayoutX(boat.getLayoutX()+170);
                farmer2.setLayoutY(boat.getLayoutY());
            }
            onBoat++;
            tempList.add(strategy.strategy3.farmer2);
            if(tempList.indexOf(strategy.strategy3.farmer2)==0)
            isLeftEmpty = false;
            else isRightEmpty=false;
        }
        else boatFull();
        }
        }
        else {
              if (farmer22.getLayoutY() == boat.getLayoutY())
        {
            farmer22.setLayoutX(397);
            farmer22.setLayoutY(71);
            onBoat--;
            if(tempList.indexOf(strategy.strategy3.farmer2)==0)
            isLeftEmpty = true;
            else isRightEmpty=true;
            tempList.remove(strategy.strategy3.farmer2);
        }
        else {
            if (onBoat<2){
            if (isLeftEmpty){
            farmer22.setLayoutX(boat.getLayoutX()+20);
            farmer22.setLayoutY(boat.getLayoutY());
            }
            else {
                farmer22.setLayoutX(boat.getLayoutX()+170);
                farmer22.setLayoutY(boat.getLayoutY());
            }
            onBoat++;
            tempList.add(strategy.strategy3.farmer2);
            if(tempList.indexOf(strategy.strategy3.farmer2)==0)
            isLeftEmpty = false;
            else isRightEmpty=false;
        }  
                else boatFull();
        }
                }
}
     
     public void moveFarmer1() {
        if (strategy.isBoatOnTheLeftBank()){
        if (farmer1.getLayoutY() == boat.getLayoutY())
        {
            farmer1.setLayoutX(317);
            farmer1.setLayoutY(511);
            onBoat--;
            if(tempList.indexOf(strategy.strategy3.farmer1)==0)
            isLeftEmpty = true;
            else isRightEmpty=true;
            tempList.remove(strategy.strategy3.farmer1);
        }
        else {
            if (onBoat<2){
            if (isLeftEmpty){
            farmer1.setLayoutX(boat.getLayoutX()+20);
            farmer1.setLayoutY(boat.getLayoutY());
            }
            else {
                farmer1.setLayoutX(boat.getLayoutX()+170);
                farmer1.setLayoutY(boat.getLayoutY());
            }
            onBoat++;
            tempList.add(strategy.strategy3.farmer1);
            if(tempList.indexOf(strategy.strategy3.farmer1)==0)
            isLeftEmpty = false;
            else isRightEmpty=false;
        }
        else boatFull();
        }
        }
        else {
              if (farmer11.getLayoutY() == boat.getLayoutY())
        {
            farmer11.setLayoutX(317);
            farmer11.setLayoutY(71);
            onBoat--;
            if(tempList.indexOf(strategy.strategy3.farmer1)==0)
            isLeftEmpty = true;
            else isRightEmpty=true;
            tempList.remove(strategy.strategy3.farmer1);
        }
        else {
            if (onBoat<2){
            if (isLeftEmpty){
            farmer11.setLayoutX(boat.getLayoutX()+20);
            farmer11.setLayoutY(boat.getLayoutY());
            }
            else {
                farmer11.setLayoutX(boat.getLayoutX()+170);
                farmer11.setLayoutY(boat.getLayoutY());
            }
            onBoat++;
            tempList.add(strategy.strategy3.farmer1);
            if(tempList.indexOf(strategy.strategy3.farmer1)==0)
            isLeftEmpty = false;
            else isRightEmpty=false;
        }  
                else boatFull();
        }
                }
}
     
     public void moveChild1() {
        if (strategy.isBoatOnTheLeftBank()){
        if (kid1.getLayoutY() == boat.getLayoutY())
        {
            kid1.setLayoutX(575);
            kid1.setLayoutY(540);
            onBoat--;
            if(tempList.indexOf(strategy.strategy3.child1)==0)
            isLeftEmpty = true;
            else isRightEmpty=true;
            tempList.remove(strategy.strategy3.child1);
        }
        else {
            if (onBoat<2){
            if (isLeftEmpty){
            kid1.setLayoutX(boat.getLayoutX()+20);
            kid1.setLayoutY(boat.getLayoutY());
            }
            else {
                kid1.setLayoutX(boat.getLayoutX()+170);
                kid1.setLayoutY(boat.getLayoutY());
            }
            onBoat++;
            tempList.add(strategy.strategy3.child1);
            if(tempList.indexOf(strategy.strategy3.child1)==0)
            isLeftEmpty = false;
            else isRightEmpty=false;
        }
        else boatFull();
        }
        }
        else {
              if (kid11.getLayoutY() == boat.getLayoutY())
        {
            kid11.setLayoutX(575);
            kid11.setLayoutY(100);
            onBoat--;
            if(tempList.indexOf(strategy.strategy3.child1)==0)
            isLeftEmpty = true;
            else isRightEmpty=true;
            tempList.remove(strategy.strategy3.child1);
        }
        else {
            if (onBoat<2){
            if (isLeftEmpty){
            kid11.setLayoutX(boat.getLayoutX()+20);
            kid11.setLayoutY(boat.getLayoutY());
            }
            else {
                kid11.setLayoutX(boat.getLayoutX()+170);
                kid11.setLayoutY(boat.getLayoutY());
            }
            onBoat++;
            tempList.add(strategy.strategy3.child1);
            if(tempList.indexOf(strategy.strategy3.child1)==0)
            isLeftEmpty = false;
            else isRightEmpty=false;
        }  
                else boatFull();
        }
                }
}
     
      public void moveChild2() {
        if (strategy.isBoatOnTheLeftBank()){
        if (kid2.getLayoutY() == boat.getLayoutY())
        {
            kid2.setLayoutX(657);
            kid2.setLayoutY(540);
            onBoat--;
            if(tempList.indexOf(strategy.strategy3.child2)==0)
            isLeftEmpty = true;
            else isRightEmpty=true;
            tempList.remove(strategy.strategy3.child2);
        }
        else {
            if (onBoat<2){
            if (isLeftEmpty){
            kid2.setLayoutX(boat.getLayoutX()+20);
            kid2.setLayoutY(boat.getLayoutY());
            }
            else {
                kid2.setLayoutX(boat.getLayoutX()+170);
                kid2.setLayoutY(boat.getLayoutY());
            }
            onBoat++;
            tempList.add(strategy.strategy3.child2);
            if(tempList.indexOf(strategy.strategy3.child2)==0)
            isLeftEmpty = false;
            else isRightEmpty=false;
        }
        else boatFull();
        }
        }
        else {
              if (kid22.getLayoutY() == boat.getLayoutY())
        {
            kid22.setLayoutX(657);
            kid22.setLayoutY(100);
            onBoat--;
            if(tempList.indexOf(strategy.strategy3.child2)==0)
            isLeftEmpty = true;
            else isRightEmpty=true;
            tempList.remove(strategy.strategy3.child2);
        }
        else {
            if (onBoat<2){
            if (isLeftEmpty){
            kid22.setLayoutX(boat.getLayoutX()+20);
            kid22.setLayoutY(boat.getLayoutY());
            }
            else {
                kid22.setLayoutX(boat.getLayoutX()+170);
                kid22.setLayoutY(boat.getLayoutY());
            }
            onBoat++;
            tempList.add(strategy.strategy3.child2);
            if(tempList.indexOf(strategy.strategy3.child2)==0)
            isLeftEmpty = false;
            else isRightEmpty=false;
        }  
                else boatFull();
        }
                }
}
     
     public void farmerlabel(){
        Farmer  c = new Farmer(80,0);
        c.setLabeltobeshown();
        message.setText(c.getLabelToBeShown());
    }
     
    public void childlabel(){
        Children  c = new Children(50);
        c.setLabeltobeshown();
        message.setText(c.getLabelToBeShown());
    }
     
    public void unsetlabel(){
        message.setText(" ");
    }
    
    public void instructions(){
        String s = " ";
        int i;
        String [] str = strategy.getInstructions();
        for (i=0;i<str.length-1;i++)
        {
            s += str[i];
            s += "\n";
        }
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
                alert.setHeaderText("Instructions");
                alert.setContentText(s);
                alert.show();
    }
    public void moveBoatUp(){
        if (onBoat ==0){
            Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("No one on the boat!!");
                alert.show();
        }
        else if (strategy.canMove(tempList, true)){
        boat.setLayoutY(225);
        strategy.doMove(tempList, true);
        saildownBtn.setDisable(false);
        sailupBtn.setDisable(true);
        incScore();
        cross();
        initialize();
        canUndoRedo();
        }
        else cannotsail();
    }
    public void moveBoatDown(){
         if (onBoat ==0){
            Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("No one on the boat!!");
                alert.show();
        }
        else if (strategy.canMove(tempList,false)){
        boat.setLayoutY(356);
        strategy.doMove(tempList,false);
        sailupBtn.setDisable(false);
        saildownBtn.setDisable(true);
        incScore();
        uncross();
        initialize2();
        canUndoRedo();
         } else cannotsail();
    }
    
    public void boatFull(){
        Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("boat is already full");
                alert.show();
    }
    
    public void cannotsail(){
        String [] str = strategy.getInstructions();
        Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText(str[4]);
                alert.show();
    }
    
    public void create(){
        StrategyOfLevel3 s = new StrategyOfLevel3();
        Level3 l = new Level3();
                s.newGame(l);
                strategy = s; 
    }
    
    public void Reset(ActionEvent event) throws IOException{
        Parent rivercrosser = FXMLLoader.load(getClass().getResource("Story1.fxml"));
        Scene rivercrosser_scene = new Scene (rivercrosser);
        Stage App_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App_stage.setScene(rivercrosser_scene);
        App_stage.show();
        strategy.resetGame();
    }
    
    public void initialize(){
            farmer1.setLayoutX(317);
            farmer1.setLayoutY(511);
            farmer2.setLayoutX(397);
            farmer2.setLayoutY(511);
            kid1.setLayoutX(575);
            kid1.setLayoutY(540);
            kid2.setLayoutX(657);
            kid2.setLayoutY(540);
            isLeftEmpty = true;
            isRightEmpty = true;
            tempList.clear();
            onBoat=0;
    }
    
    public void initialize2(){
            farmer11.setLayoutX(317);
            farmer11.setLayoutY(71);
            farmer22.setLayoutX(397);
            farmer22.setLayoutY(71);
            kid11.setLayoutX(575);
            kid11.setLayoutY(100);
            kid22.setLayoutX(657);
            kid22.setLayoutY(100);
            isLeftEmpty = true;
            isRightEmpty = true;
            tempList.clear();
            onBoat=0;
    }
    
    void incScore(){
        int score = strategy.getNumberOfSails();
        String s = Integer.toString(score);
        scorelbl.setText(s);
    }
    
    void cross(){
        List<ICrosser> temp = strategy.getCrossersOnRightBank();
        if (temp.contains(strategy.strategy3.farmer1))
                {
                    farmer1.setVisible(false);
                    farmer11.setVisible(true);
                }
        if (temp.contains(strategy.strategy3.farmer2))
                {
                    farmer2.setVisible(false);
                    farmer22.setVisible(true);
                }
        if (temp.contains(strategy.strategy3.child1))
                {
                    kid1.setVisible(false);
                    kid11.setVisible(true);
                }
        if (temp.contains(strategy.strategy3.child2))
                {
                    kid2.setVisible(false);
                    kid22.setVisible(true);
                }
    }
    
    void uncross(){
        List<ICrosser> temp = strategy.getCrossersOnLeftBank();
        if (temp.contains(strategy.strategy3.farmer1))
                {
                    farmer1.setVisible(true);
                    farmer11.setVisible(false);
                }
        if (temp.contains(strategy.strategy3.farmer2))
                {
                    farmer2.setVisible(true);
                    farmer22.setVisible(false);
                }
        if (temp.contains(strategy.strategy3.child1))
                {
                    kid1.setVisible(true);
                    kid11.setVisible(false);
                }
        if (temp.contains(strategy.strategy3.child2))
                {
                    kid2.setVisible(true);
                    kid22.setVisible(false);
                }
    }
    
    void load_images(){
        BufferedImage [] buffer =  strategy.strategy3.farmer.getImages();
        Image image = SwingFXUtils.toFXImage(buffer[0], null);
        farmer1.setImage(image);
        farmer2.setImage(image);
        image = SwingFXUtils.toFXImage(buffer[1], null);
        farmer11.setImage(image);
        farmer22.setImage(image);
        
        buffer =  strategy.strategy3.child1.getImages();
        image = SwingFXUtils.toFXImage(buffer[0], null);
        kid1.setImage(image);
        kid2.setImage(image);
        image = SwingFXUtils.toFXImage(buffer[1], null);
        kid11.setImage(image);
        kid22.setImage(image);
        
    }
    
    void canUndoRedo(){
        if(strategy.canUndo())
            undoBtn.setDisable(false);
        else undoBtn.setDisable(true);
        if(strategy.canRedo())
            redoBtn.setDisable(false);
        else redoBtn.setDisable(true);
    }
    
    public void redo(){
        strategy.redo();
        incScore();
        cross();
        uncross();
        if (strategy.isBoatOnTheLeftBank()){
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
        strategy.undo();
        incScore();
        cross();
        uncross();
        if (strategy.isBoatOnTheLeftBank()){
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
}
