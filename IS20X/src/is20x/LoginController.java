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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class LoginController implements Initializable, ControlledScreen {
    
    @FXML
    TextField userId;
    @FXML
    PasswordField password;
    @FXML
    Label errorMessage;
    
    private IS20X application;
    private User loggedUser;

    ScreensController myController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Nope
    }    
    
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
    
    @FXML
    private void goToMain(ActionEvent event) {
        if (userLogging(userId.getText(), password.getText())) {
            errorMessage.setText("Velkommen, " + userId.getText());
            myController.setScreen(IS20X.mainID);
            password.setText("");
            userId.setText("");
        } else {
            errorMessage.setText("Incorrect Username/Password");
        }
    }
    public boolean userLogging(String userId, String password){
        if (Authenticator.validate(userId, password)) {
            loggedUser = User.of(userId);
            return true;
        } else {
            return false;
        }
    }
    
    public User getLoggedUser() {
        return loggedUser;
    }
    
    void userLogout(){
        loggedUser = null;
    }
    /*@FXML
    * private void goToNextScreen(ActionEvent event) {
    *     myController.setScreen(IS20X.nextID);
    * }
    */
}
