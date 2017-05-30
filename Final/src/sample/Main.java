package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.web.WebView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.scene.text.Font;

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
        scene.getStylesheets().add(Main.class.getResource("welcome.css").toExternalForm());
        primaryStage.setTitle("Welcome!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        welcomeStage = primaryStage;
    }

    private static VBox addContent(WebView webView) {
        VBox box = new VBox();
        box.prefWidth(600);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(50);
        Text title= new Text("Plants vs. Zombies");
        Button startGameButton = addStartButton(webView);
        Button helpButton = addDifficultyButton();
        title.setFont(Font.font ("Verdana", 50));
        title.setId("fancytext");
        box.getChildren().addAll(title,startGameButton, helpButton);
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