package gui.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Framework.Common.AssessmentObject;
import Framework.Common.ModuleDeliveryListObject;
import gui.Screens.ScreensController;
import gui.Screens.Main;
import gui.Screens.ControlledScreen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import database.Users;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class AssessmentController implements Initializable, ControlledScreen {
    
    Label errorLabel;

    private Main application;

    ScreensController myController;
    @FXML
    private static TextField usernameField;
    @FXML
    private static TextField modulenameField;
    @FXML
    private static TextArea moduleTextField;
    @FXML
    private static Hyperlink moduleFileField;
    @FXML
    private static CheckBox approvedBox;
    @FXML
    private Button cancel;
    @FXML
    private Button confirm;
    @FXML
    private TextArea assessmentCommentField;
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
    private void goToApproval(ActionEvent event) {
        myController.setScreen(Main.approvalID);
    }

    @FXML
    private void submitApproval(ActionEvent event) {
        myController.setScreen(Main.approvalID);
    }
    
    public void setData() {
        usernameField.setText(AssessmentObject.getUsername());
        modulenameField.setText(AssessmentObject.getModulename());
        moduleTextField.setText(AssessmentObject.getDeliveryText());
        moduleFileField.setText(AssessmentObject.getModuleFile());        
    }
}