/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is20x;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Morten
 */
public class IS20XController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    public void handleButtonAction(ActionEvent event) {
        System.out.println("Get2ready4rekt");
        label.setText("Got hit by a sandnigger in town today.\nIt was lit as f m8");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
