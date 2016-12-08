
package slitgui;

import DataModule.UsersDataModel;
import Framework.Managers.UserManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * 
 */
public class LoginController implements Initializable, ControlledScreen {
    
    @FXML
    TextField email;
    @FXML
    PasswordField password;
    @FXML
    Label lblStatus;
   
    ScreensController myController;
    
    UserManager user = new UserManager(); 
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }
    
    @FXML
     private void goToDashBoard(ActionEvent event){
        if(!this.password.getText().isEmpty() && !this.email.getText().isEmpty())
        {            
            UsersDataModel userModule = user.loginUser(this.email.getText(), this.password.getText());
            
            if(userModule.getMail() != null)
            {
                this.lblStatus.setText("Login successfull");

                myController.setScreen(Main.dashBoardID);               
            }
            else 
            {
                lblStatus.setText("Wrong username and/or password");
            }  
        }
        else 
        {
            lblStatus.setText("Password or username cannot be null");
        }
     }
}




    

   

   /** 
    
    @FXML
    private void goToDashBoard(ActionEvent event){
        
        if(userId.getText().equals("user") && password.getText().equals("password")){
            lblStatus.setText("Login Success");
            myController.setScreen(Main.dashBoardID);
        }
            
    else {
    lblStatus.setText("Wrong username and/or password");
        }
    }
    }
    *

**/

    

   
