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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class NewUserController implements Initializable, ControlledScreen {
    
    @FXML
    TextField nameField;
    @FXML
    TextField usernameField;
    @FXML
    TextField emailField;
    @FXML
    ComboBox rolePicker;
    @FXML
    Label errorLabel;

    private IS20X application;

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
        myController.setScreen(IS20X.mainID);
    }
    
    @FXML
    public void submitUser(ActionEvent event) {
        String dbUsername = "root";
        String dbPassword = "0verwatch1.0";
        String dbURL = "jdbc:mysql://localhost:33306/uia";
        
        try {
            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            Statement statement = (Statement) conn.createStatement();
            statement.execute("INSERT INTO user (name, username, password, email, userrole) VALUES ('" + nameField.getText() + "', '" + usernameField.getText() + "', '" + usernameField.getText() + "', '" + emailField.getText() + "', '" + rolePicker.getValue() + "');");
            String sql = "SELECT userID FROM user WHERE username='" + usernameField.getText() + "';";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String userID = rs.getString("userID");
                statement.execute("INSERT INTO approvals (studentID) VALUES ('" + userID + "')");
            }
            errorLabel.setText("Bruker " + usernameField.getText() + " opprettet");
        } catch (SQLException e) {
            System.out.println(e);
        }
        myController.setScreen(IS20X.mainID);
    }
}