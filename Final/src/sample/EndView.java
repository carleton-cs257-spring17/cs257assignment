package sample;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.Group;

import java.time.Duration;
import java.util.*;

/**
 * Created by cheny2 on 3/3/17.
 */
public class EndView extends Application {

    String result = "";
    public static Stage endStage = new Stage();
    int difficulty = 5;


    public EndView(String s){
        this.result = s;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        WebView webView = new WebView();
        VBox root = addContent(webView);
        Scene scene = new Scene(root, 900, 800);
        scene.getStylesheets().add(EndView.class.getResource("welcome.css").toExternalForm());
        primaryStage.setTitle("END!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        endStage = primaryStage;
    }

    private VBox addContent(WebView webView) {
        VBox box = new VBox();
        box.prefWidth(500);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(50);
        Text title= new Text(this.result);
        Button startGameButton = addStartButton(webView);
        Button helpButton = addHelpButton();
        Button difficultyButton = addDifficultyButton();
        title.setFont(Font.font ("Verdana", 50));
        title.setId("fancytext");
        box.getChildren().addAll(title,startGameButton, difficultyButton, helpButton);
        return box;
    }
    private Button addStartButton(WebView webView) {
        Button startGameButton = new EndView.StartButton("START", webView);
        startGameButton.setOnAction(event -> {
            GameStage game = new GameStage(difficulty);
            try{

                game.start(game.getInitiateStage());
            } catch (Exception e){
                e.printStackTrace();
                System.err.println("Can not initiate game");
            }
            endStage.close();
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
        Button helpButton = new Button("HOW TO PLAY");
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
        Button difficultyButton = new Button("SET DIFFICULTY");
        difficultyButton.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            DialogPane dialogPane = alert.getDialogPane();
            alert.setTitle("SET DIFFICULTY");


            ButtonType buttonTypeOne = new ButtonType("Easy");
            ButtonType buttonTypeTwo = new ButtonType("Medium");
            ButtonType buttonTypeThree = new ButtonType("Hard");
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOne){
                difficulty = 3;
            } else if (result.get() == buttonTypeTwo) {
                difficulty = 5;
            } else if (result.get() == buttonTypeThree) {
                difficulty = 7;
            } else {
            }
        });

        return difficultyButton;
    }

    public Stage getEndStage() {
        return endStage;
    }

    public static void EndView(String[] args) {
        launch(args);
    }
}
