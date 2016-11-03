/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import auth.LoginAuthenticator;
import javafx.scene.control.Button;
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
    @FXML
    Button login;
    
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
    public void goToMain() {
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
    @FXML
    public static LoginAuthenticator checkLoginAuthentication() {
        try {
            Context c = new InitialContext();
            //return (LoginAuthenticator) c.lookup("java:comp/env/LoginAuthenticatorBean");
            return (LoginAuthenticator) c.lookup("java:global/slit-ear/slit-ejb/LoginAuthenticatorBean");
        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }
    }
}
