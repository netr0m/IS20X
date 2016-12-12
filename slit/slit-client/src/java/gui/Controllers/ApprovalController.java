package gui.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Data.ModuleDeliveryDataModel;
import Framework.Common.AssessmentObject;
import Framework.Common.ModuleDeliveryListObject;
import Framework.Managers.ModuleDeliveryManager;
import Framework.Managers.ModuleManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import gui.Screens.ControlledScreen;
import gui.Screens.Main;
import gui.Screens.ScreensController;

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
    private TableView<ModuleDeliveryListObject> overLookTable;
    @FXML
    private TableColumn<ModuleDeliveryListObject, String> nameCol;
    @FXML
    private TableColumn<ModuleDeliveryListObject, String> moduleCol;
    @FXML
    private TableColumn<ModuleDeliveryListObject, String> dateCol;
    @FXML
    private TableColumn<ModuleDeliveryListObject, String> commentCol;
    @FXML
    private TableColumn<ModuleDeliveryListObject, String> fileNameCol;

    ScreensController myController;
    
    private ModuleDeliveryManager deliveryManager = new ModuleDeliveryManager(); 
    @FXML
    private TextField searchBar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.nameCol.setCellValueFactory(new PropertyValueFactory<ModuleDeliveryListObject, String>("username"));
        this.moduleCol.setCellValueFactory(new PropertyValueFactory<ModuleDeliveryListObject, String>("modulename"));
        this.dateCol.setCellValueFactory(new PropertyValueFactory<ModuleDeliveryListObject, String>("uploadDate"));
        this.commentCol.setCellValueFactory(new PropertyValueFactory<ModuleDeliveryListObject, String>("comment"));
        this.fileNameCol.setCellValueFactory(new PropertyValueFactory<ModuleDeliveryListObject, String>("file"));
        
        ModuleManager manager = new ModuleManager();
        data = FXCollections.observableArrayList();
        
        ObservableList<ModuleDeliveryListObject> items = FXCollections.observableArrayList();
        
        for (ModuleDeliveryDataModel module : this.deliveryManager.getWaitingModuleDeliveries())
        {
            ModuleDeliveryListObject listObject = new ModuleDeliveryListObject();
            listObject.setComment(module.getModuleDelivery());
            listObject.setFile(module.getModuleFile());
            listObject.setModulename(module.getModule().getModuleName());
            listObject.setUploadDate(module.getUploadDate().toString());
            listObject.setUsername(module.getUser().getUsername());
            
            items.add(listObject); 
        }
        
        this.overLookTable.setItems(items);
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    public void goToMain(ActionEvent event){
        myController.setScreen(Main.teacherMainID);
    }

    @FXML
    private void onTableItemClick(MouseEvent event) {
        
        ModuleDeliveryListObject moduleDelivery = this.overLookTable.getSelectionModel().selectedItemProperty().get(); 
        AssessmentObject assessmentObject = new AssessmentObject();
        assessmentObject.setUsername(moduleDelivery.getUsername());
        assessmentObject.setModulename(moduleDelivery.getModulename());
        assessmentObject.setComment(moduleDelivery.getComment());
        assessmentObject.setFile(moduleDelivery.getFile());
        
        myController.setScreen(Main.assessmentID);
        
    }
}