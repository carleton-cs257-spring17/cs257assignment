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
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


/**
 * Yanhan Lyu
 */
public class GameStage extends Application{
    private Group root;
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
        primaryStage.setTitle( "Plants VS Zombies" );
        this.root = new Group();
        Scene theScene = new Scene(root,900,800);
        //set image
        Image background = new Image("wallp.png");
        ImageView iv1 = new ImageView();
        iv1.setImage(background);
        iv1.setTranslateY(100);
        Label sunPrice =new Label("how much now?????");
        //sunPrice.setPrefWidth(10);
        sunPrice.setFont(new Font(20));
        // img peashooter
        StackPane i1 = new StackPane();
        Image peashooter = new Image("peashooter.png");
        ImageView peashooter1 = new  ImageView(peashooter);
        i1.getChildren().add(peashooter1);
        i1.setMaxSize(90, 160);
        i1.setTranslateX(-170);
        // img sunflower
        StackPane i2 = new StackPane();
        Image sunflower = new Image("sunflower.png");
        ImageView sunflower1 = new  ImageView(sunflower);
        i2.getChildren().add(sunflower1);
        i2.setMaxSize(90, 160);
        i2.setTranslateX(-75);
        // img wallnut
        StackPane i3 = new StackPane();
        Image wallnut = new Image("wallnut.png");
        ImageView wallnut1 = new  ImageView(wallnut);
        i3.getChildren().add(wallnut1);
        i3.setMaxSize(90, 160);
        i3.setTranslateX(20);
        Label cent= new Label("100");
        Label fifty_1 = new Label("50");
        Label fifty = new Label("50");
        root.getChildren().add(iv1);
        Image down = new Image("getcard.png");
        ImageView iv2 = new ImageView();
        iv2.setImage(down);
        StackPane drag = new StackPane();
        BorderPane sun = new BorderPane();
        root.getChildren().add(drag);
        drag.getChildren().add(sun);
        drag.getChildren().add(iv2);
        drag.getChildren().add(i1);
        i1.getChildren().add(cent);
        cent.setTranslateY(50);
        cent.setTextFill(Color.WHITE);
        drag.getChildren().add(i2);
        i2.getChildren().add(fifty_1);
        fifty_1.setTranslateY(50);
        fifty_1.setTextFill(Color.WHITE);
        drag.getChildren().add(i3);
        i3.getChildren().add(fifty);
        fifty.setTranslateY(50);
        fifty.setTextFill(Color.WHITE);
        sun.setTop(sunPrice);
        i1.setId("peashooter");
        i2.setId("sunflower");
        i3.setId("wallnut");
        sunPrice.setTranslateX(90);
        sunPrice.setTranslateY(110);
        primaryStage.setScene( theScene );
        primaryStage.setResizable(false);
        primaryStage.show();
        initiateStage = primaryStage;
    }

    public Stage getInitiateStage() {
        return initiateStage;
    }
    

    public static void main(String[] args) {launch(args);}
}
