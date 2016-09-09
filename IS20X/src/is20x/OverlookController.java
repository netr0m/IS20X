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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class OverlookController implements Initializable, ControlledScreen {

    private IS20X application;

    ScreensController myController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String dbUsername = "root";
        String dbPassword = "root";
        String dbURL = "jdbc:mysql://localhost:3306/uia";
        
        try {
            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            Statement statement = (Statement) conn.createStatement();
            String sql = "SELECT * FROM approval;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String approved = rs.getString("approved");
                String studentID = rs.getString("studentID");
                String approverID = rs.getString("approverID");
                String moduleID = rs.getString("moduleID");
                String approvalDate = rs.getString("approvalDate");
                System.out.println(approved + " " + studentID + " " + approverID + " " + moduleID + " " + approvalDate);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    public void goToMain(ActionEvent event){
        myController.setScreen(IS20X.mainID);
    }
}