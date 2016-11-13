package slitclient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Data.UsersDataModel;
import Framework.Managers.UserManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class OverlookController implements Initializable, ControlledScreen {
    
    LoginController loginCtrl;

    private Main application;
    @FXML
    private ListView<String> MainListView;
    @FXML
    private TableView<String> tableView;

    ScreensController myController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserManager manager = new UserManager();
        
        ObservableList<String> items = FXCollections.observableArrayList();
        
        for (UsersDataModel user : manager.getAllUsers()) {
            items.add(user.getUsername());
        }
        
        this.MainListView.setItems(items);
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    public void goToMain(ActionEvent event){
        // FIX ME PLS
        myController.setScreen(Main.teacherMainID);
    }
}