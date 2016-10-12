/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.Client;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Morten
 */
public class SLIT extends Application {
    
    public static String loginID = "login";
    public static String loginFile = "Login.fxml";
    public static String mainID = "main";
    public static String mainFile = "Main.fxml";
    public static String overlookID = "overlook";
    public static String overlookFile = "Overlook.fxml";
    public static String gradingID = "grading";
    public static String gradingFile = "Grading.fxml";
    public static String newuserID = "newuser";
    public static String newuserFile = "NewUser.fxml";
    private User loggedUser;
    
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("UiA Overwatch");
        primaryStage.setResizable(false);
        
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(SLIT.loginID, SLIT.loginFile);
        mainContainer.loadScreen(SLIT.mainID, SLIT.mainFile);
        mainContainer.loadScreen(SLIT.overlookID, SLIT.overlookFile);
        mainContainer.loadScreen(SLIT.gradingID, SLIT.gradingFile);
        mainContainer.loadScreen(SLIT.newuserID, SLIT.newuserFile);
        
        mainContainer.setScreen(SLIT.loginID);
        
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
    
    public User getLoggedUser() {
        return loggedUser;
    }
    
    void userLogout(){
        loggedUser = null;
    }
}