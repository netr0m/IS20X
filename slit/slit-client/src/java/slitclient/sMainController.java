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
public class sMainController implements Initializable, ControlledScreen {
 
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

    @FXML
    public void logOut(ActionEvent event) {
        myController.setScreen(Main.loginID);
    }
    
    @FXML
    public void goToOverlook(ActionEvent event) {
        myController.setScreen(Main.overlookID);
    }
    
    @FXML
    public void goToDelivery(ActionEvent event) {
        myController.setScreen(Main.deliveryID);
    }
}
