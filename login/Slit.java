/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Morten
 */
public class Slit extends Application {
    
    public static String loginID = "login";
    public static String loginFile = "Login.fxml";
    public static String mainScreenID = "mainScreen";
    public static String mainScreenFile = "MainScreen.fxml";
    ;
    
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Slit");
        primaryStage.setResizable(false);
        
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(Slit.loginID, Slit.loginFile);
        mainContainer.loadScreen(Slit.mainScreenID, Slit.mainScreenFile);
    
        
        mainContainer.setScreen(Slit.loginID);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
 
}