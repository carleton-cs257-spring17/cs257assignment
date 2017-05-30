package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Main function
 */

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = (Parent)loader.load();
        Controller controller = loader.getController();

        // Set up a KeyEvent handler so we can respond to keyboard activity.
        root.setOnKeyPressed(controller);
        root.setId("gameView");

        Scene scene = new Scene(root, 2048, 1024);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}