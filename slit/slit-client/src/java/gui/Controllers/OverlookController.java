package gui.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import database.Moduledelivery;
import gui.Screens.ScreensController;
import gui.Screens.Main;
import gui.Screens.ControlledScreen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class OverlookController implements Initializable, ControlledScreen {
    
    LoginController loginCtrl;

    private Main application;

    private EntityManager em;

    ScreensController myController;
    @FXML
    private TextField searchBar;
    @FXML
    private TableView<Moduledelivery> overLookTable;
    @FXML
    private TableColumn<Moduledelivery, String> columnName;
    @FXML
    private TableColumn<Moduledelivery, String> columnMod1;
    @FXML
    private TableColumn<Moduledelivery, String> columnMod2;
    @FXML
    private TableColumn<Moduledelivery, String> columnMod3;
    @FXML
    private TableColumn<Moduledelivery, String> columnMod4;
    @FXML
    private TableColumn<Moduledelivery, String> columnMod5;
    @FXML
    private TableColumn<Moduledelivery, String> columnMod6;
    @FXML
    private TableColumn<Moduledelivery, String> columnMod7;
    @FXML
    private TableColumn<Moduledelivery, String> columnMod8;
    @FXML
    private TableColumn<Moduledelivery, String> columnMod9;
    @FXML
    private TableColumn<Moduledelivery, String> columnMod10;
    @FXML
    private TableColumn<Moduledelivery, String> columnMod11;
    @FXML
    private TableColumn<Moduledelivery, String> columnMod12;
    @FXML
    private TableColumn<Moduledelivery, String> columnMod13;
    @FXML
    private TableColumn<Moduledelivery, String> columnMod14;
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
        if (UserType.userrole == 1 | UserType.userrole == 2 | UserType.userrole == 3) {
            myController.setScreen(Main.teacherMainID);
        } else if (UserType.userrole == 4) {
            myController.setScreen(Main.studentMainID);
        }
    }
}