/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is20x;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    ScreensController myController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String dbURL = "jdbc:mysql://localhost:3306/Overwatch";
        String username = "root";
        String password = "root";
        
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            
            if (conn != null) {
                System.out.println("Connected to " + dbURL);
                //insertUser(conn);
                //deleteUser(conn);
                //listUsers(conn);
                //updateUser(conn);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
