package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.WindowEvent;
import java.io.IOException;


/**
 * Yanhan Lyu
 */
public class GameStage extends Application{

    static Stage initiateStage = new Stage();

    @Override
    public void start(Stage primaryStage) throws IOException {
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
        root.setOnKeyPressed(controller);
        root.setId("gameView");
        Scene scene = new Scene(root, 2048, 1024);
        primaryStage.setScene(scene);
        primaryStage.show();
        initiateStage = primaryStage;
    }

    public Stage getInitiateStage() {
        return initiateStage;
    }

    /* adding the root panel */
    private VBox addPanel() {
        VBox panel = new VBox();
        panel.setSpacing(30);
        Button start = new Button("Start");
        start.setId("startButton");
        return panel;
    }

    public static void main(String[] args) {launch(args);}
}
