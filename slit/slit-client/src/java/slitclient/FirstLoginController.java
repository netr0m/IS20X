/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import Data.UsersDataModel;
import Server.UsersModelSessionRemote;
import Framework.Managers.UserManager;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 * FXML Controller class
 *
 * @author Morten
 */
public class FirstLoginController implements Initializable, ControlledScreen {
    
    @FXML
    PasswordField password1;
    @FXML
    PasswordField password2;
    @FXML
    Label errorMessage;
    @FXML
    Button login;
    
    UserManager user = new UserManager();
    static UsersDataModel obj;
    
    private Main application;

    ScreensController myController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
    @FXML
    public void goToMain() {
        if (checkMatchingPasswords()) {
            errorMessage.setText("Nytt passord lagret!");
            lookupUserBeanRemote().updatePassword(obj, password1.getText());
            /*if (obj.getIsTeacher() == 1) {
                myController.setScreen(Main.teacherMainID);
            } else {
                myController.setScreen(Main.studentMainID);
            }*/
        } else {
            this.errorMessage.setTextFill(Color.web("#da0d0d"));
            errorMessage.setText("Begge passordene må være like, og bestå av minimum 5 tegn.");
        }
    }
    
    private boolean checkMatchingPasswords() {
        if (password1.getText().equals(password2.getText()) && password1.getText().length() >= 5) {
            return true;
        } else {
            return false;
        }
    }
    
    private UsersModelSessionRemote lookupUserBeanRemote() {
        try {
            Context c = new InitialContext();
            return (UsersModelSessionRemote) c.lookup("java:global/slit-ejb/UserModuleSession");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
