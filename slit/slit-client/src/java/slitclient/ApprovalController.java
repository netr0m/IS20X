package slitclient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Data.ModuleDataModel;
import Framework.Managers.ModuleManager;
import database.Module;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class ApprovalController implements Initializable, ControlledScreen {
    
    LoginController loginCtrl;
    private ObservableList<String> data;

    private Main application;
    @FXML
    private TableView<String> overLookTable;
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
        data = FXCollections.observableArrayList();
        
        ObservableList<String> items = FXCollections.observableArrayList();
        
        for (ModuleDataModel module : manager.getModules()) {
            data.add(module.getModuleName());
            //items.add(user.getUsername());
        }
        this.overLookTable.setItems(items);
        
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        moduleCol.setCellValueFactory(new PropertyValueFactory<>("module"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        commentCol.setCellValueFactory(new PropertyValueFactory<>("comment"));
        fileNameCol.setCellValueFactory(new PropertyValueFactory<>("file"));
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    public void goToMain(ActionEvent event){
        myController.setScreen(Main.teacherMainID);
    }
}