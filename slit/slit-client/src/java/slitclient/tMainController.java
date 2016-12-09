/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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
    
    @FXML
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
}
