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

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class Story1Controller implements Initializable {

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
    private ImageView fox;
    @FXML
    private ImageView goat;
    @FXML
    private ImageView farmer;
    @FXML
    private ImageView lion;
    @FXML
    private ImageView sheep;
    @FXML
    private ImageView plant;
    @FXML
    private ImageView fox2;
    @FXML
    private ImageView goat2;
    @FXML
    private ImageView farmer2;
    @FXML
    private ImageView lion2;
    @FXML
    private ImageView sheep2;
    @FXML
    private ImageView plant2;
    @FXML
    private Label scorelbl;
    @FXML
    private Label message;

    /**
     * Initializes the controller class.
     */
    
    strategyoflevel1 strategy;
    List<ICrosser> tempList = new ArrayList<>();
    static int onBoat =0;
    boolean isRightEmpty = true;
    boolean isLeftEmpty = true;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        create();
        instructions();
        random();
        load_images();
        canUndoRedo();
    }    
    
    public void Mainmenu(ActionEvent event) throws IOException{
        Parent rivercrosser = FXMLLoader.load(getClass().getResource("StartMenu.fxml"));
                Scene rivercrosser_scene = new Scene (rivercrosser);
                Stage App_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App_stage.setScene(rivercrosser_scene);
                App_stage.show();
    }
    
    public void moveFarmer() {
        if (strategy.isBoatOnTheLeftBank()){
        if (farmer.getLayoutY() == boat.getLayoutY())
        {
            farmer.setLayoutX(397);
            farmer.setLayoutY(511);
            onBoat--;
            if(tempList.indexOf(strategy.strategy.farmer)==0)
            isLeftEmpty = true;
            else isRightEmpty=true;
            tempList.remove(strategy.strategy.farmer);
        }
        else {
            if (onBoat<2){
            if (isLeftEmpty){
            farmer.setLayoutX(boat.getLayoutX()+20);
            farmer.setLayoutY(boat.getLayoutY());
            }
            else {
                farmer.setLayoutX(boat.getLayoutX()+170);
                farmer.setLayoutY(boat.getLayoutY());
            }
            onBoat++;
            tempList.add(strategy.strategy.farmer);
            if(tempList.indexOf(strategy.strategy.farmer)==0)
            isLeftEmpty = false;
            else isRightEmpty=false;
        }
        else boatFull();
        }
        }
        else {
              if (farmer2.getLayoutY() == boat.getLayoutY())
        {
            farmer2.setLayoutX(397);
            farmer2.setLayoutY(61);
            onBoat--;
            if(tempList.indexOf(strategy.strategy.farmer)==0)
            isLeftEmpty = true;
            else isRightEmpty=true;
            tempList.remove(strategy.strategy.farmer);
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
            tempList.add(strategy.strategy.farmer);
            if(tempList.indexOf(strategy.strategy.farmer)==0)
            isLeftEmpty = false;
            else isRightEmpty=false;
        }  
                else boatFull();
        }
                }
    }   
    public void moveLion() {
        if (strategy.isBoatOnTheLeftBank()){
         if (lion.getLayoutY() == boat.getLayoutY()+5)
        {
            lion.setLayoutX(497);
            lion.setLayoutY(532);
            onBoat--;
            if(tempList.indexOf(strategy.strategy.lion)==0)
            isLeftEmpty = true;
            else isRightEmpty=true;
            tempList.remove(strategy.strategy.lion);
        }
        else{
             if (onBoat<2){
                 if (isLeftEmpty){
                lion.setLayoutX(boat.getLayoutX()-50);
                lion.setLayoutY(boat.getLayoutY()+5);
                 }
                 else{
                     lion.setLayoutX(boat.getLayoutX()+70);
                lion.setLayoutY(boat.getLayoutY()+5);
                 }
                onBoat++;
                tempList.add(strategy.strategy.lion);
                if(tempList.indexOf(strategy.strategy.lion)==0)
                isLeftEmpty = false;
                else isRightEmpty=false;
            }
         else boatFull();
         }
        }
        else{
            if (lion2.getLayoutY() == boat.getLayoutY()+5)
        {
            lion2.setLayoutX(497);
            lion2.setLayoutY(82);
            onBoat--;
            if(tempList.indexOf(strategy.strategy.lion)==0)
            isLeftEmpty = true;
            else isRightEmpty=true;
            tempList.remove(strategy.strategy.lion);
        }
        else{
             if (onBoat<2){
                 if (isLeftEmpty){
                lion2.setLayoutX(boat.getLayoutX()-50);
                lion2.setLayoutY(boat.getLayoutY()+5);
                 }
                 else{
                     lion2.setLayoutX(boat.getLayoutX()+70);
                lion2.setLayoutY(boat.getLayoutY()+5);
                 }
                onBoat++;
                tempList.add(strategy.strategy.lion);
                if(tempList.indexOf(strategy.strategy.lion)==0)
                isLeftEmpty = false;
                else isRightEmpty=false;
            }
         else boatFull();
         }
        }
    }    
    public void moveFox() { 
         if (strategy.isBoatOnTheLeftBank()){
        if (fox.getLayoutY() == boat.getLayoutY()+25)
        {
            fox.setLayoutX(662);
            fox.setLayoutY(532);
            onBoat--;
            if(tempList.indexOf(strategy.strategy.fox)==0)
            isLeftEmpty = true;
            else isRightEmpty=true;
            tempList.remove(strategy.strategy.fox);
        }
        else{
            if (onBoat<2){
                if (isLeftEmpty){
            fox.setLayoutX(boat.getLayoutX()+10);
            fox.setLayoutY(boat.getLayoutY()+25);
                }
                else{
                    fox.setLayoutX(boat.getLayoutX()+120);
            fox.setLayoutY(boat.getLayoutY()+25);
                }
            onBoat++;
            tempList.add(strategy.strategy.fox);
            if(tempList.indexOf(strategy.strategy.fox)==0)
            isLeftEmpty = false;
            else isRightEmpty=false;
         }
             else boatFull();
        }
        }
        else {
                if (fox2.getLayoutY() == boat.getLayoutY()+25)
        {
            fox2.setLayoutX(662);
            fox2.setLayoutY(82);
            onBoat--;
            if(tempList.indexOf(strategy.strategy.fox)==0)
            isLeftEmpty = true;
            else isRightEmpty=true;
            tempList.remove(strategy.strategy.fox);
        }
        else{
            if (onBoat<2){
                if (isLeftEmpty){
            fox2.setLayoutX(boat.getLayoutX()+10);
            fox2.setLayoutY(boat.getLayoutY()+25);
                }
                else{
                    fox2.setLayoutX(boat.getLayoutX()+120);
            fox2.setLayoutY(boat.getLayoutY()+25);
                }
            onBoat++;
            tempList.add(strategy.strategy.fox);
            if(tempList.indexOf(strategy.strategy.fox)==0)
            isLeftEmpty = false;
            else isRightEmpty=false;
         }
         else boatFull();
        }
    }
    }
    
    public void moveGoat() {
        if (strategy.isBoatOnTheLeftBank()){
         if (goat.getLayoutY() == boat.getLayoutY()+25)
        {
            goat.setLayoutX(198);
            goat.setLayoutY(552);
            onBoat--;
            if(tempList.indexOf(strategy.strategy.goat)==0)
            isLeftEmpty = true;
            else isRightEmpty=true;
            tempList.remove(strategy.strategy.goat);
        }
        else{
             if (onBoat<2){
                 if (isLeftEmpty){
            goat.setLayoutX(boat.getLayoutX()+10);
            goat.setLayoutY(boat.getLayoutY()+25);
                 }
                 else{
                     goat.setLayoutX(boat.getLayoutX()+170);
            goat.setLayoutY(boat.getLayoutY()+25);
                 }
            onBoat++;
            tempList.add(strategy.strategy.goat);
            if(tempList.indexOf(strategy.strategy.goat)==0)
            isLeftEmpty = false;
            else isRightEmpty=false;
        }
         else boatFull();
         }
        }
        else {
            if (goat2.getLayoutY() == boat.getLayoutY()+25)
        {
            goat2.setLayoutX(198);
            goat2.setLayoutY(102);
            onBoat--;
            if(tempList.indexOf(strategy.strategy.goat)==0)
            isLeftEmpty = true;
            else isRightEmpty=true;
            tempList.remove(strategy.strategy.goat);
        }
        else{
             if (onBoat<2){
                 if (isLeftEmpty){
            goat2.setLayoutX(boat.getLayoutX()+10);
            goat2.setLayoutY(boat.getLayoutY()+25);
                 }
                 else{
                     goat2.setLayoutX(boat.getLayoutX()+170);
            goat2.setLayoutY(boat.getLayoutY()+25);
                 }
            onBoat++;
            tempList.add(strategy.strategy.goat);
            if(tempList.indexOf(strategy.strategy.goat)==0)
            isLeftEmpty = false;
            else isRightEmpty=false;
        }
         else boatFull();
         }
        }
    }
    public void moveSheep() { 
        if (strategy.isBoatOnTheLeftBank()){
        if (sheep.getLayoutY() == boat.getLayoutY()+25)
        {
            sheep.setLayoutX(288);
            sheep.setLayoutY(562);
            onBoat--;
            if(tempList.indexOf(strategy.strategy.sheep)==0)
            isLeftEmpty = true;
            else isRightEmpty=true;
            tempList.remove(strategy.strategy.sheep);
        }
        else{
            if (onBoat<2){
            if (isLeftEmpty){
                sheep.setLayoutX(boat.getLayoutX()+10);
            sheep.setLayoutY(boat.getLayoutY()+25);
            }
            else{
                sheep.setLayoutX(boat.getLayoutX()+170);
            sheep.setLayoutY(boat.getLayoutY()+25);
            }
            onBoat++;
            tempList.add(strategy.strategy.sheep);
            if(tempList.indexOf(strategy.strategy.sheep)==0)
            isLeftEmpty = false;
            else isRightEmpty=false;
         }
         else boatFull();
        }
        }
        else {
            if (sheep2.getLayoutY() == boat.getLayoutY()+25)
        {
            sheep2.setLayoutX(288);
            sheep2.setLayoutY(112);
            onBoat--;
            if(tempList.indexOf(strategy.strategy.sheep)==0)
            isLeftEmpty = true;
            else isRightEmpty=true;
            tempList.remove(strategy.strategy.sheep);
        }
        else{
            if (onBoat<2){
            if (isLeftEmpty){
                sheep2.setLayoutX(boat.getLayoutX()+10);
            sheep2.setLayoutY(boat.getLayoutY()+25);
            }
            else{
                sheep2.setLayoutX(boat.getLayoutX()+170);
            sheep2.setLayoutY(boat.getLayoutY()+25);
            }
            onBoat++;
            tempList.add(strategy.strategy.sheep);
            if(tempList.indexOf(strategy.strategy.sheep)==0)
            isLeftEmpty = false;
            else isRightEmpty=false;
         }
         else boatFull();
        }
        }
    }    
    public void movePlant() {
        if (strategy.isBoatOnTheLeftBank()){
        if (plant.getLayoutY() == boat.getLayoutY()+25)
        {
            plant.setLayoutX(484);
            plant.setLayoutY(573);
            onBoat--;
            if(tempList.indexOf(strategy.strategy.plant)==0)
            isLeftEmpty = true;
            else isRightEmpty=true;
            tempList.remove(strategy.strategy.plant);
        }
        else { 
        if (onBoat<2){
            if (isLeftEmpty){
            plant.setLayoutX(boat.getLayoutX()+20);
            plant.setLayoutY(boat.getLayoutY()+25);
            }
            else{
            plant.setLayoutX(boat.getLayoutX()+170);
            plant.setLayoutY(boat.getLayoutY()+25);
            }
            onBoat++;
            tempList.add(strategy.strategy.plant);
            if(tempList.indexOf(strategy.strategy.plant)==0)
            isLeftEmpty = false;
            else isRightEmpty=false;
        }
         else boatFull();
        }
        }
        else {
            if (plant2.getLayoutY() == boat.getLayoutY()+25)
        {
            plant2.setLayoutX(484);
            plant2.setLayoutY(123);
            onBoat--;
            if(tempList.indexOf(strategy.strategy.plant)==0)
            isLeftEmpty = true;
            else isRightEmpty=true;
            tempList.remove(strategy.strategy.plant);
        }
        else { 
        if (onBoat<2){
            if (isLeftEmpty){
            plant2.setLayoutX(boat.getLayoutX()+20);
            plant2.setLayoutY(boat.getLayoutY()+25);
            }
            else{
            plant2.setLayoutX(boat.getLayoutX()+170);
            plant2.setLayoutY(boat.getLayoutY()+25);
            }
            onBoat++;
            tempList.add(strategy.strategy.plant);
            if(tempList.indexOf(strategy.strategy.plant)==0)
            isLeftEmpty = false;
            else isRightEmpty=false;
        }
         else boatFull();
        }
        }
    }
    
    public void harbivoruslabel(){
        Herbivorus  c = new Herbivorus(1);
        c.setLabeltobeshown();
        message.setText(c.getLabelToBeShown());
    }
    
    public void carnivoruslabel(){
        Carnivorus  c = new Carnivorus(1);
        c.setLabeltobeshown();
        message.setText(c.getLabelToBeShown());
    }
    
    public void farmerlabel(){
        Farmer  c = new Farmer(80,0);
        c.setLabeltobeshown();
        message.setText(c.getLabelToBeShown());
    }
    
    public void plantlabel(){
        Plant c = new Plant();
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
                alert.setContentText(str[3]);
                alert.show();
    }
    
    public void create(){
        strategyoflevel1 s = new strategyoflevel1();
        level1 l = new level1();
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
            farmer.setLayoutX(397);
            farmer.setLayoutY(511);
            lion.setLayoutX(497);
            lion.setLayoutY(532);
            fox.setLayoutX(662);
            fox.setLayoutY(532);
            plant.setLayoutX(484);
            plant.setLayoutY(573);
            sheep.setLayoutX(288);
            sheep.setLayoutY(562);
            goat.setLayoutX(198);
            goat.setLayoutY(552);
            isLeftEmpty = true;
            isRightEmpty = true;
            tempList.clear();
            onBoat=0;
    }
    
    public void initialize2(){
            farmer2.setLayoutX(397);
            farmer2.setLayoutY(61);
            lion2.setLayoutX(497);
            lion2.setLayoutY(82);
            fox2.setLayoutX(662);
            fox2.setLayoutY(82);
            plant2.setLayoutX(484);
            plant2.setLayoutY(123);
            sheep2.setLayoutX(288);
            sheep2.setLayoutY(112);
            goat2.setLayoutX(198);
            goat2.setLayoutY(102);
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
        if (temp.contains(strategy.strategy.lion))
                {
                    lion.setVisible(false);
                    lion2.setVisible(true);
                }
        if (temp.contains(strategy.strategy.fox))
                {
                    fox.setVisible(false);
                    fox2.setVisible(true);
                }
        if (temp.contains(strategy.strategy.farmer))
                {
                    farmer.setVisible(false);
                    farmer2.setVisible(true);
                }
        if (temp.contains(strategy.strategy.sheep))
                {
                    sheep.setVisible(false);
                    sheep2.setVisible(true);
                }
        if (temp.contains(strategy.strategy.goat))
                {
                    goat.setVisible(false);
                    goat2.setVisible(true);
                }
        if (temp.contains(strategy.strategy.plant))
                {
                    plant.setVisible(false);
                    plant2.setVisible(true);
                }
    }
    
    void uncross(){
        List<ICrosser> temp = strategy.getCrossersOnLeftBank();
        if (temp.contains(strategy.strategy.lion))
                {
                    lion2.setVisible(false);
                    lion.setVisible(true);
                }
        if (temp.contains(strategy.strategy.fox))
                {
                    fox2.setVisible(false);
                    fox.setVisible(true);
                }
        if (temp.contains(strategy.strategy.farmer))
                {
                    farmer2.setVisible(false);
                    farmer.setVisible(true);
                }
        if (temp.contains(strategy.strategy.sheep))
                {
                    sheep2.setVisible(false);
                    sheep.setVisible(true);
                }
        if (temp.contains(strategy.strategy.goat))
                {
                    goat2.setVisible(false);
                    goat.setVisible(true);
                }
        if (temp.contains(strategy.strategy.plant))
                {
                    plant2.setVisible(false);
                    plant.setVisible(true);
                }
    }
    
    void random(){
        fox.setVisible(false);
        lion.setVisible(false);
        sheep.setVisible(false);
        goat.setVisible(false);
        List<ICrosser> temp = new ArrayList<>();
        temp = strategy.strategy.getInitialCrossers();
        if (temp.contains(strategy.strategy.fox))
            fox.setVisible(true);
        if (temp.contains(strategy.strategy.lion))
            lion.setVisible(true);
        if (temp.contains(strategy.strategy.goat))
            goat.setVisible(true);
        if (temp.contains(strategy.strategy.sheep))
            sheep.setVisible(true);
    }
    
    public void solve(){
        List<List<ICrosser>> temp = strategy.solveGame();
        List<ICrosser> step =temp.get(0);
         try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
        moveFarmer();
        if (step.contains(strategy.strategy.goat))
            moveGoat();
        else if (step.contains(strategy.strategy.sheep))
            moveSheep();
        try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
        moveBoatUp();
        try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
        moveFarmer();
        try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
        moveBoatDown();
    }
    
    void load_images(){
        BufferedImage [] buffer =  strategy.strategy.farmer.getImages();
        Image image = SwingFXUtils.toFXImage(buffer[0], null);
        farmer.setImage(image);
        image = SwingFXUtils.toFXImage(buffer[1], null);
        farmer2.setImage(image);
        
        buffer =  strategy.strategy.fox.getImages();
        image = SwingFXUtils.toFXImage(buffer[0], null);
        fox.setImage(image);
        image = SwingFXUtils.toFXImage(buffer[1], null);
        fox2.setImage(image);
        
        buffer =  strategy.strategy.lion.getImages();
        image = SwingFXUtils.toFXImage(buffer[0], null);
        lion.setImage(image);
        image = SwingFXUtils.toFXImage(buffer[1], null);
        lion2.setImage(image);
        
        buffer =  strategy.strategy.goat.getImages();
        image = SwingFXUtils.toFXImage(buffer[0], null);
        goat.setImage(image);
        image = SwingFXUtils.toFXImage(buffer[1], null);
        goat2.setImage(image);
        
        buffer =  strategy.strategy.sheep.getImages();
        image = SwingFXUtils.toFXImage(buffer[0], null);
        sheep.setImage(image);
        image = SwingFXUtils.toFXImage(buffer[1], null);
        sheep2.setImage(image);
        
        buffer =  strategy.strategy.plant.getImages();
        image = SwingFXUtils.toFXImage(buffer[0], null);
        plant.setImage(image);
        image = SwingFXUtils.toFXImage(buffer[1], null);
        plant2.setImage(image);
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
