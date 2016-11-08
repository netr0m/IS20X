/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import Data.UsersDataModel;
import Framework.Managers.UserManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
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
    
    UserManager user = new UserManager();
    
    private Main application;
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
        if(!this.password.getText().isEmpty() && !this.username.getText().isEmpty())
        {            
            UsersDataModel userModule = user.loginUser(this.username.getText(), this.password.getText());
            
            if(userModule.getUsername() != null)
            {
                this.errorMessage.setText("Velkommen, " + username.getText());
                
                try 
                {
                    if (userModule.getIsTeacher()) {
                        myController.setScreen(Main.teacherMainID);
                    }
                }
                catch(Exception e) 
                {
                     this.errorMessage.setText(e.getMessage()); 
                }
                
            }
            else 
            {
                this.errorMessage.setText("Feil brukernavn/passord.");
            }
            
        }
        else 
        {
            this.errorMessage.setText("Begge feltene m� fylles ut.");
        }
    }
/*    @FXML
    public static LoginAuthenticator checkLoginAuthentication() {
        try {
            Context c = new InitialContext();
            //return (LoginAuthenticator) c.lookup("java:comp/env/LoginAuthenticatorBean");
            return (LoginAuthenticator) c.lookup("java:global/slit-ear/slit-ejb/LoginAuthenticatorBean");
        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }
    }*/
}