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
import java.sql.Statement;
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
        String dbURL = "jdbc:mysql://localhost:3306/Overwatch";
        String username = "root";
        String password = "root";
        
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
            
            if (conn != null) {
                System.out.println("Connected to " + dbURL);
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
        String dbUsername = "root";
        String dbPassword = "root";
        String dbURL = "jdbc:mysql://localhost:3306/Overwatch";
        boolean login = false;
        
        try {
            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            Statement statement = (Statement) conn.createStatement();
            String sql = "SELECT username, password FROM users WHERE username='" + userId + "' AND password='" + password + "';";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String user = rs.getString("username");
                String pass = rs.getString("password");
                
                    if ((userId.equals(user)) && (password.equals(password))) {
                        login = true;
            }
            rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return login; 
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
