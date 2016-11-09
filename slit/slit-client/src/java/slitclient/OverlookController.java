package slitclient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import database.Users;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class OverlookController implements Initializable, ControlledScreen {
    
    LoginController loginCtrl;

    private Main application;
    @FXML
    private TableView<Users> overLookTable;
    @FXML
    private TableColumn<Users, String> columnName;
    @FXML
    private TableColumn<Users, String> columnMod1;
    @FXML
    private TableColumn<Users, String> columnMod2;
    @FXML
    private TableColumn<Users, String> columnMod3;
    @FXML
    private TableColumn<Users, String> columnMod4;
    @FXML
    private TableColumn<Users, String> columnMod5;
    @FXML
    private TableColumn<Users, String> columnMod6;
    @FXML
    private TableColumn<Users, String> columnMod7;
    @FXML
    private TableColumn<Users, String> columnMod8;
    @FXML
    private TableColumn<Users, String> columnMod9;
    @FXML
    private TableColumn<Users, String> columnMod10;
    @FXML
    private TableColumn<Users, String> columnMod11;
    @FXML
    private TableColumn<Users, String> columnMod12;
    @FXML
    private TableColumn<Users, String> columnMod13;
    @FXML
    private TableColumn<Users, String> columnMod14;
    //Initialize observable list to hold out database data
    private ObservableList<Users> data;
    String dbUsername = "root";
    String dbPassword = "root";
    String dbURL = "jdbc:mysql://localhost:3306/uia";

    ScreensController myController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    public void goToMain(ActionEvent event){
        myController.setScreen(Main.teacherMainID);
    }
    
    @FXML
    private void loadData(ActionEvent event) {
        System.out.println("Have a jolly good time");

    }
}