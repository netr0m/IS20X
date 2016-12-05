/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit;


import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Me
 */
public class LoginController implements Initializable, ControlledScreen {
    
@FXML
Button loginButton;
    
@FXML
private TextField login;

@FXML
private PasswordField userPassword;
     


ScreensController myController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       String dbURL = "jdbc:mysql://localhost:3306/sampledb";
       String username = "root";
       String password = "root";
 
try {
 
    Connection conn = DriverManager.getConnection(dbURL, username, password);
 
    if (conn != null) {
        System.out.println("Connected");
    }
} catch (SQLException ex) {
    ex.printStackTrace();
}
    }
    
    public String getLogin() {
        
        return login.getText();
    }
    
    public String getPassword() {
        
        return userPassword.getText();
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        myController.setScreen(Slit.mainScreenID);
    

    }
    
}
    
   
