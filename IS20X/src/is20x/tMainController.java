/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is20x;

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
 
    private IS20X application;
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

    @FXML
    public void logOut(ActionEvent event) {
        myController.setScreen(IS20X.loginID);
    }
    
    @FXML
    public void goToOverlook(ActionEvent event) {
        myController.setScreen(IS20X.overlookID);
    }
    
    @FXML
    public void goToCreateUser(ActionEvent event) {
        myController.setScreen(IS20X.newuserID);
    }
    
    @FXML
    public void goToGrading(ActionEvent event) {
        myController.setScreen(IS20X.gradingID);
    }
    
    @FXML
    public void goToDelivery(ActionEvent event) {
        myController.setScreen(IS20X.deliveryID);
    }
    
    public void userLoggedOut() {
        loginscreen.setErrorMessage("");
        loginscreen.setTeacherMode(false);
    }
}
