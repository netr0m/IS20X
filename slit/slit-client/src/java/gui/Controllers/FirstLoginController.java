/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Controllers;

import gui.Screens.ScreensController;
import gui.Screens.Main;
import gui.Screens.ControlledScreen;
import Data.UsersDataModel;
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
import Server.UserSessionBeanRemote;
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
            this.errorMessage.setTextFill(Color.web("#13c113"));
            errorMessage.setText("Nytt passord lagret!");
            System.out.println(UserType.userrole);
            //lookupUserBeanRemote().updatePassword(obj, password1.getText());
            if (UserType.userrole == 1 || UserType.userrole == 2 || UserType.userrole == 3) {
                myController.setScreen(Main.teacherMainID);
                password1.setText("");
                password2.setText("");
            } else if (UserType.userrole == 4) {
                password1.setText("");
                password2.setText("");
                myController.setScreen(Main.studentMainID);
            }
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
    
    private UserSessionBeanRemote lookupUserBeanRemote() {
        try {
            Context c = new InitialContext();
            return (UserSessionBeanRemote) c.lookup("java:global/slit-ejb/UserModuleSession");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
