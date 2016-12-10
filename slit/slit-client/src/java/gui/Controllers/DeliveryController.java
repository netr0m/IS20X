package gui.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Data.ModuleDeliveryDataModel;
import Framework.Managers.ModuleDeliveryManager;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import slitclient.ControlledScreen;
import slitclient.Main;
import slitclient.ScreensController;
import slitclient.UserType;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class DeliveryController implements Initializable, ControlledScreen {
    
    @FXML
    ComboBox modulePicker;
    @FXML
    TextArea commentField;
    @FXML
    TextField fileName;
    @FXML
    ToggleButton fileButton;
    @FXML
    Label errorLabel;
    private Desktop desktop = Desktop.getDesktop();
    private int moduleID;


    private Main application;

    ScreensController myController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TO-DO
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    public void goToMain(ActionEvent event){
        commentField.setText("");
        fileName.setText("");
        modulePicker.setValue("");
        myController.setScreen(Main.studentMainID);
    }
    
    @FXML
    public void deliverModule(ActionEvent event) {   
        System.out.println(modulePicker.getValue() + " " + commentField.getText() + " " + fileName.getText() + " av " + UserType.username + " AKA UserID " + UserType.userID);
        try {
            String module = (String) modulePicker.getValue();
            /*if (modulePicker.getValue().equals("Modul 1")) {
                
            }*/
            String intString = module.replaceAll("[^0-9]", ""); // returns 123
            int moduleID = Integer.parseInt(String.valueOf(intString));
            System.out.println(moduleID);
            
            //ModuleDeliveryDataModel moduleDeliveryModel = new ModuleDeliveryDataModel(UserType.userID, moduleID, commentField.getText(), fileName.getText());
            ModuleDeliveryDataModel moduleDeliveryModel = new ModuleDeliveryDataModel(3, 3, "Hestkuk å sånn sit", "bitchassnigger.mp4");
            ModuleDeliveryManager moduleDeliveryManager = new ModuleDeliveryManager();
            
            moduleDeliveryManager.storeModuleDelivery(moduleDeliveryModel); 
            
            errorLabel.setText(modulePicker.getValue() + " opprettet");
        } catch (Exception e) {
            System.out.println(e);
        }
        modulePicker.setValue("");
        commentField.setText("");
        fileName.setText("");
        
        myController.setScreen(Main.studentMainID);
        //myController.setScreen(Main.overlookID);
    }
    
    public void getPickerData() {
        
    }
    
    public void chooseFile() throws IOException {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Velg en modulvideo (zippet)");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("ZIP", "*.zip"),
                new FileChooser.ExtensionFilter("RAR", "*.rar"),
                new FileChooser.ExtensionFilter("MP4", "*.mp4")
            );
        
        File file = fileChooser.showOpenDialog(stage);
                    if (file != null) {
                        String filepath = file.toString();
                        fileName.setText(filepath);
                    }
    }
    
    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(DeliveryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}