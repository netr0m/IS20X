package gui.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import gui.Screens.ScreensController;
import gui.Screens.Main;
import gui.Screens.ControlledScreen;
import Server.ModuleDelivery;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class OverlookController implements Initializable, ControlledScreen {
    
    LoginController loginCtrl;

    private Main application;
        @FXML
    private TableView<ModuleDelivery> overLookTable;
    @FXML
    private TableColumn<ModuleDelivery, String> columnName;
    @FXML
    private TableColumn<ModuleDelivery, String> columnMod1;
    @FXML
    private TableColumn<ModuleDelivery, String> columnMod2;
    @FXML
    private TableColumn<ModuleDelivery, String> columnMod3;
    @FXML
    private TableColumn<ModuleDelivery, String> columnMod4;
    @FXML
    private TableColumn<ModuleDelivery, String> columnMod5;
    @FXML
    private TableColumn<ModuleDelivery, String> columnMod6;
    @FXML
    private TableColumn<ModuleDelivery, String> columnMod7;
    @FXML
    private TableColumn<ModuleDelivery, String> columnMod8;
    @FXML
    private TableColumn<ModuleDelivery, String> columnMod9;
    @FXML
    private TableColumn<ModuleDelivery, String> columnMod10;
    @FXML
    private TableColumn<ModuleDelivery, String> columnMod11;
    @FXML
    private TableColumn<ModuleDelivery, String> columnMod12;
    @FXML
    private TableColumn<ModuleDelivery, String> columnMod13;
    @FXML
    private TableColumn<ModuleDelivery, String> columnMod14;
    private EntityManager em;
    private ObservableList<ModuleDelivery> data;

    ScreensController myController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        List<ModuleDelivery> moduleDeliveryList =
            em.createQuery("SELECT o FROM Overlook o").getResultList();
        
        data = FXCollections.observableArrayList(moduleDeliveryList);
        overLookTable.setItems((ObservableList<ModuleDelivery>) moduleDeliveryList);
        
        //ObservableList<String> items = FXCollections.observableArrayList();
        
        /*for (ModuleDeliveryDataModel moduleDeliveryz : manager.getAllUsers()) {
            
            //data.add(new ModuleDelivery(username, moduleName, uploadDate, moduleDelivery);
        }
        
        this.MainListView.setItems(items);*/
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