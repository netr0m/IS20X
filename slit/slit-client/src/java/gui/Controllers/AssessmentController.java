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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    private TextField usernameField;
    @FXML
    private TextField modulenameField;
    @FXML
    private TextArea moduleTextField;
    @FXML
    private Hyperlink moduleFileField;
    @FXML
    private CheckBox approvedBox;
    @FXML
    private Button cancel;
    @FXML
    private Button confirm;
    @FXML
    private TextArea assessmentCommentField;
    
    private int status;
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
        assessmentCommentField.setText("");
        approvedBox.setSelected(false);
        myController.setScreen(Main.approvalID);
    }

    @FXML
    private void submitApproval(ActionEvent event) {
        if (approvedBox.isSelected()) {
            status = 1;
        } else {
                status = 2;
                }
        System.out.println("Tilbakemelding: " + assessmentCommentField.getText() + ", Status: " + status);
        myController.setScreen(Main.approvalID);
        approvedBox.setSelected(false);
        assessmentCommentField.setText("");
    }
    
    @FXML
    public void setData(ActionEvent event) {
        usernameField.setText(AssessmentObject.username);
        modulenameField.setText(AssessmentObject.modulename);
        moduleTextField.setText(AssessmentObject.comment);
        moduleFileField.setText(AssessmentObject.file);
    }
}