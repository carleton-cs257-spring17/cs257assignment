package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.scene.web.WebView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.scene.text.Font;

import java.util.Optional;

/**
 * Main function
 */

public class Main extends Application {
    static Stage welcomeStage;
    int difficulty = 5;

    @Override
    public void start(Stage primaryStage) throws Exception{
        WebView webView = new WebView();
        VBox root = addContent(webView);
        Scene scene = new Scene(root, 900, 800);
        scene.getStylesheets().add(Main.class.getResource("welcome.css").toExternalForm());
        primaryStage.setTitle("Welcome!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        welcomeStage = primaryStage;
    }

    private VBox addContent(WebView webView) {
        VBox box = new VBox();
        box.prefWidth(500);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(50);
        Text title= new Text("Plants vs. Zombies");
        Button startGameButton = addStartButton(webView);
        Button helpButton = addHelpButton();
        Button difficultyButton = addDifficultyButton();
        title.setFont(Font.font ("Verdana", 50));
        title.setId("fancytext");
        box.getChildren().addAll(title,startGameButton, difficultyButton, helpButton);
        return box;
    }
    private Button addStartButton(WebView webView) {
        Button startGameButton = new StartButton("START", webView);
        startGameButton.setOnAction(event -> {
            GameStage game = new GameStage(difficulty);
            try{

                game.start(game.getInitiateStage());
            } catch (Exception e){
                e.printStackTrace();
                System.err.println("Can not initiate game");
            }
            welcomeStage.close();
        });
        return startGameButton;
    }

    private class StartButton extends Button {
        public StartButton(String textOnButton, WebView webView) {
            setText(textOnButton);
            webView.getEngine().load(textOnButton);
        }
    }
    private Button addHelpButton() {
        Button helpButton = new Button("How to Play");
        helpButton.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Plants vs. Zombies");
            alert.setHeaderText("How to Play");
            alert.setContentText("In this game you will fight against zombies by plant different plants on your plant.\n" +
                    "Each plant has their own special skill:\n" +
                    "-Peashooter: attacks zombies by continuously shoot out peas once you put it down\n" +
                    "-Sunflower: produce one star at intervals. You can click on the plant to collect the stars. Each star worth 50 value, which you would use to buy more plants.\n" +
                    "-Wallnut: put it on the ground to slow down zombie's movement.\n" +
                    "Good luck and have fun!");

            alert.showAndWait();
        });

        return helpButton;
    }


        private Button addDifficultyButton() {
        Button difficultyButton = new Button("Set Difficulty");
        difficultyButton.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog with Custom Actions");
            alert.setHeaderText("Look, a Confirmation Dialog with Custom Actions");
            alert.setContentText("Choose your option.");

            ButtonType buttonTypeOne = new ButtonType("Easy");
            ButtonType buttonTypeTwo = new ButtonType("Medium");
            ButtonType buttonTypeThree = new ButtonType("Hard");
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOne){
                difficulty = 5;
            } else if (result.get() == buttonTypeTwo) {
                difficulty = 10;
            } else if (result.get() == buttonTypeThree) {
                difficulty = 20;
            } else {
            }
        });

        return difficultyButton;
    }


    public static void main(String[] args) {
        launch(args);
    }
}