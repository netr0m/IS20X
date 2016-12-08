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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import database.Overlook;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class OverlookController implements Initializable, ControlledScreen {
    
    LoginController loginCtrl;

    private Main application;
        @FXML
    private TableView<Overlook> overLookTable;
    @FXML
    private TableColumn<Overlook, String> columnName;
    @FXML
    private TableColumn<Overlook, String> columnMod1;
    @FXML
    private TableColumn<Overlook, String> columnMod2;
    @FXML
    private TableColumn<Overlook, String> columnMod3;
    @FXML
    private TableColumn<Overlook, String> columnMod4;
    @FXML
    private TableColumn<Overlook, String> columnMod5;
    @FXML
    private TableColumn<Overlook, String> columnMod6;
    @FXML
    private TableColumn<Overlook, String> columnMod7;
    @FXML
    private TableColumn<Overlook, String> columnMod8;
    @FXML
    private TableColumn<Overlook, String> columnMod9;
    @FXML
    private TableColumn<Overlook, String> columnMod10;
    @FXML
    private TableColumn<Overlook, String> columnMod11;
    @FXML
    private TableColumn<Overlook, String> columnMod12;
    @FXML
    private TableColumn<Overlook, String> columnMod13;
    @FXML
    private TableColumn<Overlook, String> columnMod14;
    
    private ObservableList<Overlook> data;

    ScreensController myController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserManager manager = new UserManager();
        
        data = FXCollections.observableArrayList();
        
        //ObservableList<String> items = FXCollections.observableArrayList();
        
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
        if (UserType.userrole == 1 | UserType.userrole == 2 | UserType.userrole == 3) {
            myController.setScreen(Main.teacherMainID);
        } else if (UserType.userrole == 4) {
            myController.setScreen(Main.studentMainID);
        }
    }
}