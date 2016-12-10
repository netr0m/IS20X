package gui.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Data.UsersDataModel;
import Framework.Managers.UserManager;
import java.net.URL;
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

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class NewUserController implements Initializable, ControlledScreen {
    
    @FXML
    TextField fNameField;
    @FXML
    TextField lNameField;
    @FXML
    TextField usernameField;
    @FXML
    TextField emailField;
    @FXML
    ComboBox rolePicker;
    @FXML
    Label errorLabel;
    private int userrole;

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
        fNameField.setText("");
        lNameField.setText("");
        usernameField.setText("");
        emailField.setText("");
        rolePicker.setValue("");
        myController.setScreen(Main.teacherMainID);
    }
    
    @FXML
    public void submitUser(ActionEvent event) {
        if (rolePicker.getValue().equals("ADMIN")) {
            userrole = 1;
        } else if (rolePicker.getValue().equals("TEACHER")) {
            userrole = 2;
        } else if (rolePicker.getValue().equals("ASSISTANT")) {
            userrole = 3;
        } else if (rolePicker.getValue().equals("STUDENT")) {
            userrole = 4;
        }
        try {
            UsersDataModel userModel = new UsersDataModel(fNameField.getText(), lNameField.getText(), usernameField.getText(), usernameField.getText(), emailField.getText(), userrole);
            
            UserManager userManager = new UserManager();
            
            userManager.storeUser(userModel); 
            
            errorLabel.setText("Bruker " + usernameField.getText() + " opprettet");
        } catch (Exception e) {
            System.out.println(e);
        }
        myController.setScreen(Main.teacherMainID);
        fNameField.setText("");
        lNameField.setText("");
        usernameField.setText("");
        emailField.setText("");
        rolePicker.setValue("");
        errorLabel.setText("");
    }
}