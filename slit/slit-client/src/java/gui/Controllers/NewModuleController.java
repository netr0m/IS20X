package gui.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Data.ModuleDataModel;
import Framework.Managers.ModuleManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import gui.Screens.ControlledScreen;
import gui.Screens.Main;
import gui.Screens.ScreensController;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class NewModuleController implements Initializable, ControlledScreen {
    
    @FXML
    TextArea moduleNameField;
    @FXML
    TextArea moduleSummaryField;
    @FXML
    TextArea moduleDescField;
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
    }
    
    @FXML
    public void submitModule(ActionEvent event) {
        try {
            ModuleDataModel moduleModel = new ModuleDataModel(moduleNameField.getText(), moduleSummaryField.getText(), moduleDescField.getText());
            
            ModuleManager moduleManager = new ModuleManager();
            
            moduleManager.storeModule(moduleModel); 
            
            errorLabel.setText("Ny " + moduleNameField.getText() + " opprettet");
        } catch (Exception e) {
            System.out.println(e);
        }
        myController.setScreen(Main.teacherMainID);
        moduleNameField.setText("");
        moduleSummaryField.setText("");
        moduleDescField.setText("");
        errorLabel.setText("");
    }
}