
package slitgui;

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
public class DashboardController implements Initializable, ControlledScreen {
    
   
   
    ScreensController myController;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }
    
    @FXML
    public void logOut(ActionEvent event){
        myController.setScreen(Main.loginID);
    }
    
   
  
}


    

   
