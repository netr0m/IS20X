package gui.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class GradingController implements Initializable, ControlledScreen {
    
    @FXML
    ComboBox studentPicker;
    @FXML
    DatePicker datePicker;
    @FXML
    ComboBox modulePicker;
    @FXML
    ComboBox teacherPicker;
    @FXML
    Label errorLabel;

    private Main application;
    String approverID;
    private ObservableList<Users> data;
    private ObservableList<Users> datax;

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
        studentPicker.setValue("");
        teacherPicker.setValue("");
        modulePicker.setValue("");
        datePicker.setValue(null);
        myController.setScreen(Main.teacherMainID);
    }
    
    @FXML
    public void submitGrade(ActionEvent event) {
        myController.setScreen(Main.overlookID);
    }
}