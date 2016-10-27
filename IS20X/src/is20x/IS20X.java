/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is20x;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Morten
 */
public class IS20X extends Application {
    
    public static String loginID = "login";
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
    private User loggedUser;
    
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("UiA Overwatch");
        primaryStage.setResizable(false);
        
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(IS20X.loginID, IS20X.loginFile);
        mainContainer.loadScreen(IS20X.studentMainID, IS20X.studentMainFile);
        mainContainer.loadScreen(IS20X.teacherMainID, IS20X.teacherMainFile);
        mainContainer.loadScreen(IS20X.overlookID, IS20X.overlookFile);
        mainContainer.loadScreen(IS20X.gradingID, IS20X.gradingFile);
        mainContainer.loadScreen(IS20X.newuserID, IS20X.newuserFile);
        mainContainer.loadScreen(IS20X.deliveryID, IS20X.deliveryFile);
        
        mainContainer.setScreen(IS20X.loginID);
        
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
