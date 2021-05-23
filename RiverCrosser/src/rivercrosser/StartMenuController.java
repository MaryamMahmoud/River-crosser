/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class StartMenuController implements Initializable {

    @FXML
    private Button exitBtn;
    @FXML
    private Button story1Btn;
    @FXML
    private Button loadBtn;
    @FXML
    private Button story2Btn;
    @FXML
    private Button story3Btn;
    @FXML
    private Button story4Btn;

    /**
     * Initializes the controller class.
     */
    
    int flag=0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void newgame (){
        if (flag == 0){ 
        story1Btn.setDisable(false);
        story2Btn.setDisable(false);
        story3Btn.setDisable(false);
        //story4Btn.setDisable(false);
        loadBtn.setDisable(true);
        flag++;
        }
        else {
            story1Btn.setDisable(true);
            story2Btn.setDisable(true);
            story3Btn.setDisable(true);
            story4Btn.setDisable(true);
            loadBtn.setDisable(false);
            flag=0;
    }
    }
    
    public void exit(){
        Platform.exit();
    }
    
    public void story1(ActionEvent event) throws IOException{
        Parent rivercrosser = FXMLLoader.load(getClass().getResource("Story1.fxml"));
        Scene rivercrosser_scene = new Scene (rivercrosser);
        Stage App_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App_stage.setScene(rivercrosser_scene);
        App_stage.show();
    }
    
     public void story2(ActionEvent event) throws IOException{
        Parent rivercrosser = FXMLLoader.load(getClass().getResource("Story2.fxml"));
        Scene rivercrosser_scene = new Scene (rivercrosser);
        Stage App_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App_stage.setScene(rivercrosser_scene);
        App_stage.show();
    }
     
      public void story3(ActionEvent event) throws IOException{
        Parent rivercrosser = FXMLLoader.load(getClass().getResource("Story3.fxml"));
        Scene rivercrosser_scene = new Scene (rivercrosser);
        Stage App_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App_stage.setScene(rivercrosser_scene);
        App_stage.show();
    }
      
       public void story4(ActionEvent event) throws IOException{
        Parent rivercrosser = FXMLLoader.load(getClass().getResource("Story4.fxml"));
        Scene rivercrosser_scene = new Scene (rivercrosser);
        Stage App_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App_stage.setScene(rivercrosser_scene);
        App_stage.show();
    }
 
}
