/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Morten
 */
public class Main extends Application {
    
    // This variable defines that the file "login.java" is reachable by "loginID".
    public static String loginID = "login";
    // This variable defines that the file "Login.fxml" is reachable as "loginFile".
    public static String loginFile = "Login.fxml";
    public static String studentMainID = "sMain";
    public static String studentMainFile = "Student.fxml";
    public static String teacherMainID = "tMain";
    public static String teacherMainFile = "Teacher.fxml";
    public static String overlookID = "overlook";
    public static String overlookFile = "Overlook.fxml";
    public static String gradingID = "grading";
    public static String gradingFile = "Grading.fxml";
    public static String newuserID = "newuser";
    public static String newuserFile = "NewUser.fxml";
    public static String deliveryID = "delivery";
    public static String deliveryFile = "Delivery.fxml";
    
    
    @Override
    public void start(Stage primaryStage) {
        // This sets the title of the window displayed
        primaryStage.setTitle("SLIT | UiA");
        
        // Make window NOT resizable.
        primaryStage.setResizable(false);
        
        /* Creates an object of the class ScreensController,
           and calls this object "mainContainer" */
        ScreensController mainContainer = new ScreensController();
        /* The variables defined at the top are connected to each other here
           by adding them to the HashMap in ScreensController.java.
           This way, it loads a Java file with it's coherent FXML file.*/
        mainContainer.loadScreen(Main.loginID, Main.loginFile);
        mainContainer.loadScreen(Main.studentMainID, Main.studentMainFile);
        mainContainer.loadScreen(Main.teacherMainID, Main.teacherMainFile);
        mainContainer.loadScreen(Main.overlookID, Main.overlookFile);
        mainContainer.loadScreen(Main.gradingID, Main.gradingFile);
        mainContainer.loadScreen(Main.newuserID, Main.newuserFile);
        mainContainer.loadScreen(Main.deliveryID, Main.deliveryFile);
        
        // Finally, we set a screen for the window once it opens up
        mainContainer.setScreen(Main.loginID);
        
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
