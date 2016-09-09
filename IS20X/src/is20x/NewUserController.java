package is20x;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class NewUserController implements Initializable, ControlledScreen {
    
    /*@FXML
    TextField nameField;
    @FXML
    TextField usernameField;
    @FXML
    TextField emailField;
    @FXML
    TextField rolePicker;*/

    private IS20X application;

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
    public void goToMain(ActionEvent event){
        myController.setScreen(IS20X.mainID);
    }
    
    @FXML
    public void submitUser(ActionEvent event) {
        String dbUsername = "root";
        String dbPassword = "root";
        String dbURL = "jdbc:mysql://localhost:3306/uia";
        
        try {
            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            Statement statement = (Statement) conn.createStatement();
            /*String sql = "INSERT INTO user (name, username, email, userrole) VALUES ('" + nameField + "', '" + usernameField + "', '" + emailField + "', '" + rolePicker + "');";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();*/
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}