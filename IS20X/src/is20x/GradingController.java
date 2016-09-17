package is20x;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class GradingController implements Initializable, ControlledScreen {
    
    @FXML
    ComboBox studentPicker;
    @FXML
    DatePicker datePicker;
    @FXML
    ComboBox modulePicker;
    @FXML
    ComboBox teacherPicker;
    @FXML
    Label errorLabel;

    private IS20X application;
    String approverID;
    private ObservableList<User> data;
    private ObservableList<User> datax;

    ScreensController myController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getPickerData();
        //getTeacherPicker();
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    public void goToMain(ActionEvent event){
        studentPicker.setValue("");
        teacherPicker.setValue("");
        modulePicker.setValue("");
        myController.setScreen(IS20X.mainID);
    }
    
    @FXML
    public void submitGrade(ActionEvent event) {
        String dbUsername = "root";
        String dbPassword = "0verwatch1.0";
        String dbURL = "jdbc:mysql://localhost:33306/uia";
        
        try {
            String approverID = getApproverID();
            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            Statement statement = (Statement) conn.createStatement();
            String sql = "SELECT userID FROM user WHERE username='" + studentPicker.getValue() + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String userID = rs.getString("userID");
                if (modulePicker.getValue().equals("Modul 1")) {
                    statement.execute("UPDATE approvals SET mod1='" + datePicker.getValue() + "', mod1Approver='" + approverID + "' WHERE studentID='" + userID + "';");
                } else if (modulePicker.getValue().equals("Modul 2")) {
                    statement.execute("UPDATE approvals SET mod2='" + datePicker.getValue() + "', mod2Approver='" + approverID + "' WHERE studentID='" + userID + "';");
                } else if (modulePicker.getValue().equals("Modul 3")) {
                    statement.execute("UPDATE approvals SET mod3='" + datePicker.getValue() + "', mod3Approver='" + approverID + "' WHERE studentID='" + userID + "';");
                } else if (modulePicker.getValue().equals("Modul 4")) {
                    statement.execute("UPDATE approvals SET mod4='" + datePicker.getValue() + "', mod4Approver='" + approverID + "' WHERE studentID='" + userID + "';");
                } else if (modulePicker.getValue().equals("Modul 5")) {
                    statement.execute("UPDATE approvals SET mod5='" + datePicker.getValue() + "', mod5Approver='" + approverID + "' WHERE studentID='" + userID + "';");
                } else if (modulePicker.getValue().equals("Modul 6")) {
                    statement.execute("UPDATE approvals SET mod6='" + datePicker.getValue() + "', mod6Approver='" + approverID + "' WHERE studentID='" + userID + "';");
                } else if (modulePicker.getValue().equals("Modul 7")) {
                    statement.execute("UPDATE approvals SET mod7='" + datePicker.getValue() + "', mod7Approver='" + approverID + "' WHERE studentID='" + userID + "';");
                } else if (modulePicker.getValue().equals("Modul 8")) {
                    statement.execute("UPDATE approvals SET mod8='" + datePicker.getValue() + "', mod8Approver='" + approverID + "' WHERE studentID='" + userID + "';");
                } else if (modulePicker.getValue().equals("Modul 9")) {
                    statement.execute("UPDATE approvals SET mod9='" + datePicker.getValue() + "', mod9Approver='" + approverID + "' WHERE studentID='" + userID + "';");
                } else if (modulePicker.getValue().equals("Modul 10")) {
                    statement.execute("UPDATE approvals SET mod10='" + datePicker.getValue() + "', mod10Approver='" + approverID + "' WHERE studentID='" + userID + "';");
                } else if (modulePicker.getValue().equals("Modul 11")) {
                    statement.execute("UPDATE approvals SET mod11='" + datePicker.getValue() + "', mod11Approver='" + approverID + "' WHERE studentID='" + userID + "';");
                } else if (modulePicker.getValue().equals("Modul 12")) {
                    statement.execute("UPDATE approvals SET mod12='" + datePicker.getValue() + "', mod12Approver='" + approverID + "' WHERE studentID='" + userID + "';");
                } else if (modulePicker.getValue().equals("Modul 13")) {
                    statement.execute("UPDATE approvals SET mod13='" + datePicker.getValue() + "', mod13Approver='" + approverID + "' WHERE studentID='" + userID + "';");
                } else if (modulePicker.getValue().equals("Modul 14")) {
                    statement.execute("UPDATE approvals SET mod14='" + datePicker.getValue() + "', mod14Approver='" + approverID + "' WHERE studentID='" + userID + "';");
                }
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        myController.setScreen(IS20X.overlookID);
    }
    
    public String getApproverID() {
        String dbUsername = "root";
        String dbPassword = "0verwatch1.0";
        String dbURL = "jdbc:mysql://localhost:33306/uia";
        try {
            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            Statement stm = (Statement) conn.createStatement();
            String ssql = "SELECT userID FROM user WHERE username='" + teacherPicker.getValue() + "'";
            PreparedStatement pps = conn.prepareStatement(ssql);
            ResultSet rss = pps.executeQuery();
            while (rss.next()) {
                approverID = rss.getString("userID");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return approverID;
    }
    
    public void getPickerData() {
        String dbUsername = "root";
        String dbPassword = "0verwatch1.0";
        String dbURL = "jdbc:mysql://localhost:33306/uia";
        ObservableList<Object> comboString = FXCollections.observableArrayList();
        try {
            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT username FROM user WHERE userrole='STUDENT';");
            while (rs.next()) {
                //get string from db,whichever way 
                comboString.add(rs.getString("username"));
                //data.add(new User(rs.getString("username")).getUsername());
            }

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
        
        studentPicker.setItems(null);
        studentPicker.setItems(comboString);
        
        ObservableList<Object> comboxString = FXCollections.observableArrayList();
        try {
            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            datax = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rss = conn.createStatement().executeQuery("SELECT username FROM user WHERE userrole='TEACHER' OR userrole='ASSISTANT';");
            while (rss.next()) {
                //get string from db,whichever way 
                comboxString.add(rss.getString("username"));
                //data.add(new User(rs.getString("username")).getUsername());
            }

        } catch (SQLException exx) {
            System.err.println("Error"+exx);
        }
        
        teacherPicker.setItems(null);
        teacherPicker.setItems(comboxString);
    }
    
    /*public void getTeacherPicker() {
        String dbUsername = "root";
        String dbPassword = "0verwatch1.0";
        String dbURL = "jdbc:mysql://localhost:33306/uia";
        ObservableList<Object> comboxString = FXCollections.observableArrayList();
        try {
            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            datax = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rss = conn.createStatement().executeQuery("SELECT username FROM user WHERE userrole='TEACHER' OR userrole='ASSISTANT';");
            while (rss.next()) {
                //get string from db,whichever way 
                comboxString.add(rss.getString("username"));
                //data.add(new User(rs.getString("username")).getUsername());
            }

        } catch (SQLException exx) {
            System.err.println("Error"+exx);
        }
        
        teacherPicker.setItems(null);
        teacherPicker.setItems(comboxString);
    }*/
}