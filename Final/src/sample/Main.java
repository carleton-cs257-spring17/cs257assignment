package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.web.WebView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import javafx.event.ActionEvent;

/**
 * Main function
 */

public class Main extends Application {
    static Stage welcomeStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        final WebView webView = new WebView();
        VBox root = addContent(webView);
        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setTitle("Welcome!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        welcomeStage = primaryStage;
    }

    /* add the main content */
    private static VBox addContent(WebView webView) {
        VBox box = new VBox();
        Text titleHolder = new Text("Welcome to Zombie's world");
        Button startGameButton = addStartButton(webView);
        Button helpButton = addDifficultyButton();
        box.getChildren().addAll(titleHolder,startGameButton, helpButton);
        return box;
    }
    private static Button addStartButton(WebView webView) {
        Button startGameButton = new StartButton("START", webView);
        startGameButton.setOnAction(event -> {
            GameStage initiateGame = new GameStage();
            try{
                initiateGame.start(initiateGame.initiateStage);
            } catch (Exception e){
                e.printStackTrace();
            }
            welcomeStage.close();
        });
        return startGameButton;
    }

    private static class StartButton extends Button {
        public StartButton(String textOnButton, final WebView webView) {
            setText(textOnButton);
            webView.getEngine().load(textOnButton);
        }
    }
    private static Button addDifficultyButton() {
        Button helpButton = new Button("Set Difficulty");
        return helpButton;
    }

    public static void main(String[] args) {
        launch(args);
    }
}