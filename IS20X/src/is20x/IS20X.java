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
    public static String mainID = "main";
    public static String mainFile = "Main.fxml";
    public static String overlookID = "overlook";
    public static String overlookFile = "Overlook.fxml";
    public static String gradingID = "grading";
    public static String gradingFile = "Grading.fxml";
    private User loggedUser;
    
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("UiA Overwatch");
        primaryStage.setResizable(false);
        
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(IS20X.loginID, IS20X.loginFile);
        mainContainer.loadScreen(IS20X.mainID, IS20X.mainFile);
        mainContainer.loadScreen(IS20X.overlookID, IS20X.overlookFile);
        mainContainer.loadScreen(IS20X.gradingID, IS20X.gradingFile);
        
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
    public boolean userLogging(String userId, String password){
        if (Authenticator.validate(userId, password)) {
            loggedUser = User.of(userId);
            return true;
        } else {
            return false;
        }
    }
    
    void userLogout(){
        loggedUser = null;
    }
}
