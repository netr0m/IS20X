/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Controllers;

import Data.UsersDataModel;
import Framework.Managers.UserManager;
import gui.Screens.ScreensController;
import gui.Screens.Main;
import gui.Screens.ControlledScreen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class StudentListController implements Initializable, ControlledScreen {
 
    private Main application;

    ScreensController myController;
    @FXML
    private ListView<String> studentListView;
    @FXML
    private Button backButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserManager manager = new UserManager();
              
        ObservableList<String> items =FXCollections.observableArrayList (); 
        
        for(UsersDataModel user : manager.getAllUsers())
        {
            items.add(user.getUsername()); 
        }
        
        this.studentListView.setItems(items);
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private void goToMain(ActionEvent event) {
        myController.setScreen(Main.teacherMainID);
    }
}
