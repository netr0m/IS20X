/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitgui;

import slitgui.ControlledScreen;
import slitgui.ScreensController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;



public class MainController implements Initializable, ControlledScreen {
 
    private Main application;
    private LoginController loginscreen;

    ScreensController myController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

   // @FXML
   // public void logOut(ActionEvent event) {
   //     myController.setScreen(Main.loginID);
   // }
    
   // @FXML
   // public void login(ActionEvent event){
   //     myController.setScreen(Main.dashBoardID);
    //}
}
   /** 
    @FXML
    public void goToOverlook(ActionEvent event) {
        myController.setScreen(Main.overlookID);
    }
    
    @FXML
    public void goToCreateUser(ActionEvent event) {
        myController.setScreen(Main.newuserID);
    }
    
    @FXML
    public void goToGrading(ActionEvent event) {
        myController.setScreen(Main.gradingID);
    }
    
    //public void userLoggedOut() {
     //   loginscreen.setErrorMessage("");
     //   loginscreen.setTeacherMode(false);
    }
    **/
