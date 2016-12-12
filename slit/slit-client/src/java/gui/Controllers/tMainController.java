/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Controllers;

import gui.Screens.ScreensController;
import gui.Screens.Main;
import gui.Screens.ControlledScreen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class tMainController implements Initializable, ControlledScreen {
 
    private Main application;
    private LoginController loginscreen;
    private GradingController grading;

    ScreensController myController;
    @FXML
    private Button goEvaluate;
    @FXML
    private Button goApprove;
    @FXML
    private Button goOverlook;
    @FXML
    private Button logout;
    @FXML
    private Button createUser;
    @FXML
    private Button createModule;
    @FXML
    private Button studentListButton;
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

    /**
     * De følgende metodene valgte vi å beholde på klient-siden av programmet,
     * da disse kun utfører navigasjon mellom ulike deler av programmet.
    */
    @FXML
    public void logOut(ActionEvent event) {
        myController.setScreen(Main.loginID);
    }
    
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
    
    public void goToDelivery(ActionEvent event) {
        myController.setScreen(Main.deliveryID);
    }
    
    @FXML
    public void goToApproval(ActionEvent event) {
        myController.setScreen(Main.approvalID);
    }
    
    @FXML
    public void goToCreateModule(ActionEvent event) {
        myController.setScreen(Main.newmoduleID);
    }

    @FXML
    private void goToStudentList(ActionEvent event) {
        myController.setScreen(Main.studentlistID);
    }
}
