package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.DragEvent;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


/**
 * Yanhan Lyu
 */
public class GameStage extends Application{
    private Group root;
    static Stage initiateStage = new Stage();
    final private double SCENE_WIDTH = 500;
    final private double SCENE_HEIGHT = 400;
    final private double FRAMES_PER_SECOND = 20.0;
    Player player = new Player();
    Enermy enermy = new Enermy();
    private Controller controller = new Controller(1,player, enermy);

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
        ImageView backgroundView = new ImageView();
        backgroundView.setImage(background);
        backgroundView.setTranslateY(100);
        // Set up a KeyEvent handler so we can respond to keyboard activity.
        // img peashooter
        StackPane s1 = new StackPane();
        Image peashooter = new Image("peashooter.png");
        ImageView peashooter1 = new  ImageView(peashooter);
        s1.getChildren().add(peashooter1);
        s1.setMaxSize(90, 160);
        s1.setTranslateX(-170);
        // img sunflower
        StackPane s2 = new StackPane();
        Image sunflower = new Image("sunflower.png");
        ImageView sunflower1 = new  ImageView(sunflower);
        s2.getChildren().add(sunflower1);
        s2.setMaxSize(90, 160);
        s2.setTranslateX(-75);
        // img wallnut
        StackPane s3 = new StackPane();
        Image wallnut = new Image("wallnut.png");
        ImageView wallnut1 = new  ImageView(wallnut);
        s3.getChildren().add(wallnut1);
        s3.setMaxSize(90, 160);
        s3.setTranslateX(20);
        // img potato mine
        StackPane s4 = new StackPane();
        Image potatoMine = new Image("potatoMine.png");
        ImageView potatoMine1 = new  ImageView(potatoMine);
        s4.getChildren().add(potatoMine1);
        s4.setMaxSize(90, 160);
        s4.setTranslateX(115);


        Label sunPrice =new Label("how much now?????");
        sunPrice.setFont(Font.font("Cambria", 32));
        Label cent= new Label("100");
        cent.setFont(Font.font("Cambria", 20));
        Label fifty_1 = new Label("50");
        fifty_1.setFont(Font.font("Cambria", 20));
        Label fifty = new Label("50");
        fifty.setFont(Font.font("Cambria", 20));
        Label twoHundred= new Label("200");
        twoHundred.setFont(Font.font("Cambria", 20));

        root.getChildren().add(backgroundView);
        Image down = new Image("bar.png");
        ImageView barView = new ImageView();
        barView.setImage(down);
        StackPane drag = new StackPane();
        BorderPane sun = new BorderPane();
        root.getChildren().add(drag);
        drag.getChildren().add(sun);
        drag.getChildren().add(barView);
        drag.getChildren().add(s1);
        s1.getChildren().add(cent);
        cent.setTranslateY(50);
        cent.setTextFill(Color.WHITE);
        drag.getChildren().add(s2);
        s2.getChildren().add(fifty_1);
        fifty_1.setTranslateY(50);
        fifty_1.setTextFill(Color.WHITE);
        drag.getChildren().add(s3);
        s3.getChildren().add(fifty);
        fifty.setTranslateY(50);
        fifty.setTextFill(Color.WHITE);

        drag.getChildren().add(s4);
        s4.getChildren().add(twoHundred);
        twoHundred.setTranslateY(50);
        twoHundred.setTextFill(Color.WHITE);
        //sun.setTop(sunPrice);
        s1.setId("peashooter");
        s2.setId("sunflower");
        s3.setId("wallnut");
        s4.setId("potatoMine");
        sunPrice.setTranslateX(90);
        sunPrice.setTranslateY(110);
        primaryStage.setScene( theScene );
        primaryStage.setResizable(false);
        primaryStage.show();
        //buy stuff???????? solved from google
        s1.setOnDragDetected(new PlantDrag(s1, peashooter));
        s2.setOnDragDetected(new PlantDrag(s2, sunflower));
        s3.setOnDragDetected(new PlantDrag(s3, wallnut));
        s4.setOnDragDetected(new PlantDrag(s4, potatoMine));
        theScene.setOnDragOver(new PlantDragOver());
        //drop
<<<<<<< HEAD
        Player player = new Player();
        Enermy enermy = new Enermy();
        theScene.setOnDragDropped(new PlantDragDrop(root, player));
=======
        theScene.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {

            }
        });
>>>>>>> 052c7ff00c910e02d45789ff9f0a8b12db4608a5
        initiateStage = primaryStage;
        controller.initialize();

    }

    public Stage getInitiateStage() {
        return initiateStage;
    }


    

    public static void main(String[] args) {launch(args);}
}
