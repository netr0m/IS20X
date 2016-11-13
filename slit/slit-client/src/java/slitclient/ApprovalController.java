package slitclient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Data.ModuleDeliveryDataModel;
import Data.UsersDataModel;
import Framework.Managers.ModuleManager;
import Framework.Managers.UserManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class ApprovalController implements Initializable, ControlledScreen {
    
    LoginController loginCtrl;

    private Main application;
    @FXML
    private TableView<String> approvalView;
    @FXML
    private TableColumn<String, String> nameCol;
    @FXML
    private TableColumn<String, String> moduleCol;
    @FXML
    private TableColumn<String, String> dateCol;
    @FXML
    private TableColumn<String, String> commentCol;
    @FXML
    private TableColumn<String, String> fileNameCol;

    ScreensController myController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ModuleManager manager = new ModuleManager();
        
        ObservableList<String> approvals = FXCollections.observableArrayList();
        
        for (ModuleDeliveryDataModel delivery : manager.getAllUsers()) {
            approvals.add(user.getUsername());
        }
        
        this.nameCol.setItems(approvals, "hi");
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    public void goToMain(ActionEvent event){
        myController.setScreen(Main.teacherMainID);
    }
}