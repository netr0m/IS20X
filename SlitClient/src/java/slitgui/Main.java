

package slitgui;

import slitgui.ScreensController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.stage.Stage;


public class Main extends Application {
    
    public static String loginID = "login";
    public static String loginFile = "Login.fxml";
    public static String dashBoardID = "dashBoard";
    public static String dashBoardFile = "Dashboard.fxml";
    public static String testID = "test";
    public static String testFile = "test.fxml";
    

    @Override
    public void start(Stage primaryStage) {
        
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(Main.loginID, Main.loginFile);
        mainContainer.loadScreen(Main.dashBoardID, Main.dashBoardFile);
        
        mainContainer.setScreen(Main.loginID);
        
       
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Main.class.getResource("login.css").toExternalForm());
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
