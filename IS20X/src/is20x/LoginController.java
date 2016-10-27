/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is20x;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

/**
 * FXML Controller class
 *
 * @author Morten
 */
public class LoginController implements Initializable, ControlledScreen {
    
    @FXML
    TextField userId;
    @FXML
    PasswordField password;
    @FXML
    Label errorMessage;
    
    private IS20X application;
    private User loggedUser;
    public boolean teachermode = false;
    public String currentUser;

    ScreensController myController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String dbURL = "jdbc:mysql://localhost:3306/uia";
        String dbUsername = "root";
        String dbPassword = "root";
        
        try (Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword)) {
            
            if (conn != null) {
                System.out.println("Connected to " + dbURL);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }    
    
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
    
    @FXML
    private void goToMain(ActionEvent event) {
        if (userLogging(userId.getText(), password.getText())) {
            if (userId.getText().equals(password.getText())) {
                createNewPasswordDialog();
            }
            errorMessage.setText("Velkommen, " + userId.getText());
            if (teachermode == true) {
                myController.setScreen(IS20X.teacherMainID);
            }
            else {
                myController.setScreen(IS20X.studentMainID);
            }
            password.setText("");
            userId.setText("");
        } else {
            errorMessage.setText("Feil brukernavn/passord");
        }
    }
    public boolean userLogging(String userId, String password){
        String dbUsername = "root";
        String dbPassword = "root";
        String dbURL = "jdbc:mysql://localhost:3306/uia";
        boolean login = false;
        
        try {
            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            String sql = "SELECT username, password, userrole FROM user WHERE username='" + userId + "' AND password='" + password + "';";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String user = rs.getString("username");
                currentUser = user;
                String pass = rs.getString("password");
                String role = rs.getString("userrole");
                
                    if ((userId.equals(user)) && (password.equals(pass))) {
                        login = true;
                        if (role.equals(("TEACHER"))) {
                            teachermode = true;
                        } else if (role.equals(("ASSISTANT"))) {
                            teachermode = true;
                        } else if (role.equals(("ADMIN"))) {
                            teachermode = true;
                        } else {
                            teachermode = false;
                        }
                        System.out.println(role+"MODE");
            }
            rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return login; 
    }
    
    public User getLoggedUser() {
        return loggedUser;
    }
    
    void userLogout(){
        errorMessage.setText("");
        teachermode = false;
    }
    
    public boolean teacherMode() {
        return teachermode;
    }
    
    public void setTeacherMode(boolean mode) {
        this.teachermode = mode;
    }
    
    public void setErrorMessage(String text) {
        errorMessage.setText(text);
    }
    
    public void changePassword(String newPassword) {
        String dbUsername = "root";
        String dbPassword = "root";
        String dbURL = "jdbc:mysql://localhost:3306/uia";
        try {
            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            Statement statement = (Statement) conn.createStatement();
            statement.execute("UPDATE user SET password='" + newPassword + "' WHERE username='" + userId.getText() + "';");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    protected Dialog createNewPasswordDialog() {
        TextInputDialog updatePass = new TextInputDialog("");
        updatePass.setTitle("Vennligst skriv inn et nytt passord");
        updatePass.getDialogPane().setContentText("Nytt Passord:");
        updatePass.setHeaderText("Vennligst bytt ditt passord");
        updatePass.showAndWait()
                .ifPresent(new Consumer<String>() {
            @Override
            public void accept(String response) {
                if (response.isEmpty()) {
                    System.out.println("Passord ble ikke endret");
                } else {
                    System.out.println("Det nye passordet er: " + response);
                    changePassword(response);
                }
            }
        });
        return updatePass;
    }
}
