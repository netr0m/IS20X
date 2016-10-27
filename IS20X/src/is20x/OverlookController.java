package is20x;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class OverlookController implements Initializable, ControlledScreen {
    
    LoginController loginCtrl;

    private IS20X application;
    @FXML
    private TableView<User> overLookTable;
    @FXML
    private TableColumn<User, String> columnName;
    @FXML
    private TableColumn<User, String> columnMod1;
    @FXML
    private TableColumn<User, String> columnMod2;
    @FXML
    private TableColumn<User, String> columnMod3;
    @FXML
    private TableColumn<User, String> columnMod4;
    @FXML
    private TableColumn<User, String> columnMod5;
    @FXML
    private TableColumn<User, String> columnMod6;
    @FXML
    private TableColumn<User, String> columnMod7;
    @FXML
    private TableColumn<User, String> columnMod8;
    @FXML
    private TableColumn<User, String> columnMod9;
    @FXML
    private TableColumn<User, String> columnMod10;
    @FXML
    private TableColumn<User, String> columnMod11;
    @FXML
    private TableColumn<User, String> columnMod12;
    @FXML
    private TableColumn<User, String> columnMod13;
    @FXML
    private TableColumn<User, String> columnMod14;
    //Initialize observable list to hold out database data
    private ObservableList<User> data;
    String dbUsername = "root";
    String dbPassword = "root";
    String dbURL = "jdbc:mysql://localhost:3306/uia";

    ScreensController myController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (loginCtrl.teacherMode()) {
            try {
                Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
                data = FXCollections.observableArrayList();
                // Execute query and store result in a resultset
                ResultSet rs = conn.createStatement().executeQuery("SELECT u.name, a.mod1, a.mod2, a.mod3, a.mod4, a.mod5, a.mod6, a.mod7, a.mod8, a.mod9, a.mod10, a.mod11, a.mod12, a.mod13, a.mod14 FROM approvals a INNER JOIN user u ON a.studentID = u.userID;");
                while (rs.next()) {
                    //get string from db,whichever way 
                    data.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15)));
                }

            } catch (SQLException ex) {
                System.err.println("Error"+ex);
            }

            //Set cell value factory to tableview.
            //NB.PropertyValue Factory must be the same with the one set in model class.
            columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
            columnMod1.setCellValueFactory(new PropertyValueFactory<>("mod1"));
            columnMod2.setCellValueFactory(new PropertyValueFactory<>("mod2"));
            columnMod3.setCellValueFactory(new PropertyValueFactory<>("mod3"));
            columnMod4.setCellValueFactory(new PropertyValueFactory<>("mod4"));
            columnMod5.setCellValueFactory(new PropertyValueFactory<>("mod5"));
            columnMod6.setCellValueFactory(new PropertyValueFactory<>("mod6"));
            columnMod7.setCellValueFactory(new PropertyValueFactory<>("mod7"));
            columnMod8.setCellValueFactory(new PropertyValueFactory<>("mod8"));
            columnMod9.setCellValueFactory(new PropertyValueFactory<>("mod9"));
            columnMod10.setCellValueFactory(new PropertyValueFactory<>("mod10"));
            columnMod11.setCellValueFactory(new PropertyValueFactory<>("mod11"));
            columnMod12.setCellValueFactory(new PropertyValueFactory<>("mod12"));
            columnMod13.setCellValueFactory(new PropertyValueFactory<>("mod13"));
            columnMod14.setCellValueFactory(new PropertyValueFactory<>("mod14"));

            overLookTable.setItems(null);
            overLookTable.setItems(data);

        } else {
            try {
                Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
                data = FXCollections.observableArrayList();
                // Execute query and store result in a resultset
                ResultSet rs = conn.createStatement().executeQuery("SELECT u.name, a.mod1, a.mod2, a.mod3, a.mod4, a.mod5, a.mod6, a.mod7, a.mod8, a.mod9, a.mod10, a.mod11, a.mod12, a.mod13, a.mod14 FROM approvals a INNER JOIN user u ON a.studentID = u.userID WHERE u.username = '" + loginCtrl.getUser() + "';");
                while (rs.next()) {
                    //get string from db,whichever way 
                    data.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15)));
                }

            } catch (SQLException ex) {
                System.err.println("Error"+ex);
            }

            //Set cell value factory to tableview.
            //NB.PropertyValue Factory must be the same with the one set in model class.
            columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
            columnMod1.setCellValueFactory(new PropertyValueFactory<>("mod1"));
            columnMod2.setCellValueFactory(new PropertyValueFactory<>("mod2"));
            columnMod3.setCellValueFactory(new PropertyValueFactory<>("mod3"));
            columnMod4.setCellValueFactory(new PropertyValueFactory<>("mod4"));
            columnMod5.setCellValueFactory(new PropertyValueFactory<>("mod5"));
            columnMod6.setCellValueFactory(new PropertyValueFactory<>("mod6"));
            columnMod7.setCellValueFactory(new PropertyValueFactory<>("mod7"));
            columnMod8.setCellValueFactory(new PropertyValueFactory<>("mod8"));
            columnMod9.setCellValueFactory(new PropertyValueFactory<>("mod9"));
            columnMod10.setCellValueFactory(new PropertyValueFactory<>("mod10"));
            columnMod11.setCellValueFactory(new PropertyValueFactory<>("mod11"));
            columnMod12.setCellValueFactory(new PropertyValueFactory<>("mod12"));
            columnMod13.setCellValueFactory(new PropertyValueFactory<>("mod13"));
            columnMod14.setCellValueFactory(new PropertyValueFactory<>("mod14"));

            overLookTable.setItems(null);
            overLookTable.setItems(data);
    }
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    public void goToMain(ActionEvent event){
        myController.setScreen(IS20X.teacherMainID);
    }
    
    @FXML
    private void loadData(ActionEvent event) {
        if (loginCtrl.teacherMode()) {
        try {
            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT u.name, a.mod1, a.mod2, a.mod3, a.mod4, a.mod5, a.mod6, a.mod7, a.mod8, a.mod9, a.mod10, a.mod11, a.mod12, a.mod13, a.mod14 FROM approvals a INNER JOIN user u ON a.studentID = u.userID;");
            while (rs.next()) {
                //get string from db,whichever way 
                data.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15)));
            }

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }

        //Set cell value factory to tableview.
        //NB.PropertyValue Factory must be the same with the one set in model class.
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnMod1.setCellValueFactory(new PropertyValueFactory<>("mod1"));
        columnMod2.setCellValueFactory(new PropertyValueFactory<>("mod2"));
        columnMod3.setCellValueFactory(new PropertyValueFactory<>("mod3"));
        columnMod4.setCellValueFactory(new PropertyValueFactory<>("mod4"));
        columnMod5.setCellValueFactory(new PropertyValueFactory<>("mod5"));
        columnMod6.setCellValueFactory(new PropertyValueFactory<>("mod6"));
        columnMod7.setCellValueFactory(new PropertyValueFactory<>("mod7"));
        columnMod8.setCellValueFactory(new PropertyValueFactory<>("mod8"));
        columnMod9.setCellValueFactory(new PropertyValueFactory<>("mod9"));
        columnMod10.setCellValueFactory(new PropertyValueFactory<>("mod10"));
        columnMod11.setCellValueFactory(new PropertyValueFactory<>("mod11"));
        columnMod12.setCellValueFactory(new PropertyValueFactory<>("mod12"));
        columnMod13.setCellValueFactory(new PropertyValueFactory<>("mod13"));
        columnMod14.setCellValueFactory(new PropertyValueFactory<>("mod14"));

        overLookTable.setItems(null);
        overLookTable.setItems(data);

        } else {
            try {
                Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
                data = FXCollections.observableArrayList();
                // Execute query and store result in a resultset
                ResultSet rs = conn.createStatement().executeQuery("SELECT u.name, a.mod1, a.mod2, a.mod3, a.mod4, a.mod5, a.mod6, a.mod7, a.mod8, a.mod9, a.mod10, a.mod11, a.mod12, a.mod13, a.mod14 FROM approvals a INNER JOIN user u ON a.studentID = u.userID WHERE u.username = '" + loginCtrl.getUser() + "';");
                while (rs.next()) {
                    //get string from db,whichever way 
                    data.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15)));
                }

            } catch (SQLException ex) {
                System.err.println("Error"+ex);
            }

            //Set cell value factory to tableview.
            //NB.PropertyValue Factory must be the same with the one set in model class.
            columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
            columnMod1.setCellValueFactory(new PropertyValueFactory<>("mod1"));
            columnMod2.setCellValueFactory(new PropertyValueFactory<>("mod2"));
            columnMod3.setCellValueFactory(new PropertyValueFactory<>("mod3"));
            columnMod4.setCellValueFactory(new PropertyValueFactory<>("mod4"));
            columnMod5.setCellValueFactory(new PropertyValueFactory<>("mod5"));
            columnMod6.setCellValueFactory(new PropertyValueFactory<>("mod6"));
            columnMod7.setCellValueFactory(new PropertyValueFactory<>("mod7"));
            columnMod8.setCellValueFactory(new PropertyValueFactory<>("mod8"));
            columnMod9.setCellValueFactory(new PropertyValueFactory<>("mod9"));
            columnMod10.setCellValueFactory(new PropertyValueFactory<>("mod10"));
            columnMod11.setCellValueFactory(new PropertyValueFactory<>("mod11"));
            columnMod12.setCellValueFactory(new PropertyValueFactory<>("mod12"));
            columnMod13.setCellValueFactory(new PropertyValueFactory<>("mod13"));
            columnMod14.setCellValueFactory(new PropertyValueFactory<>("mod14"));

            overLookTable.setItems(null);
            overLookTable.setItems(data);
    }
    
}
}