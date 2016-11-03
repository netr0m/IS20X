/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import auth.LoginAuthenticator;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class LoginController implements Initializable, ControlledScreen {
    
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Label errorMessage;
    
    private Main application;
    public boolean teachermode = false;
    public String currentUser;

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
    public void goToMain(ActionEvent event) {
        if (checkLoginAuthentication()
                .authenticate(username.getText(), password.getText())) {
            errorMessage.setText("Velkommen, " + username.getText());
            myController.setScreen(Main.teacherMainID);
            password.setText("");
            username.setText("");
    } else {
            errorMessage.setText("Feil brukernavn/passord");
        }
    }
    public static LoginAuthenticator checkLoginAuthentication() {
        try {
            Context c = new InitialContext();
            return (LoginAuthenticator) c.lookup("java:comp/env/LoginAuthenticatorBean");
        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }
    }
}
