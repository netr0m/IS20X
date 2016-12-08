package gui.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Data.UsersDataModel;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import slitclient.ControlledScreen;
import slitclient.Main;
import slitclient.ScreensController;
import slitclient.UserType;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class NewUserController implements Initializable, ControlledScreen {
    
    @FXML
    TextField nameField;
    @FXML
    TextField usernameField;
    @FXML
    TextField emailField;
    @FXML
    ComboBox rolePicker;
    @FXML
    Label errorLabel;

    private Main application;

    ScreensController myController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    public void goToMain(ActionEvent event){
        myController.setScreen(Main.teacherMainID);
        System.out.println(UserType.username);
    }
    
    @FXML
    public void submitUser(ActionEvent event) {        
        try {
            
            errorLabel.setText("Bruker " + usernameField.getText() + " opprettet");
        } catch (Exception e) {
            System.out.println(e);
        }
        myController.setScreen(Main.teacherMainID);
        nameField.setText("");
        usernameField.setText("");
        emailField.setText("");
        rolePicker.setValue("");
        errorLabel.setText("");
    }
}