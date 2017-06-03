package sample;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

/**
 * Created by Lucy on 6/2/17.
 */
public class Star extends Sprite implements Plant{

    private int row;
    private int column;
    private int price = 100;
    private int[] position = new int[2];
    private int health = 500;
    private int power = 0;
    private StackPane s = new StackPane();
    private Group root = new Group();
    private Image plant;
    private ImageView plantView;
    private double osizeX;
    private double osizeY;
    private double sizeX;
    private double sizeY;
    private boolean shrink = false;
    private Player player;
    private AudioClip audioClip;

    public Star(int row, int column, Group root, Player player){
        this.player = player;
        this.row = row;
        this.column = column;
        this.plant = new Image("/res/sunflower.png");
        this.plantView = new ImageView(plant);
        s.getChildren().add(plantView);
        this.root = root;
        root.getChildren().add(s);
        s.setTranslateY((int) (135+(row-1)*110+55)-40);
        s.setTranslateX((int) (60+(column-1)*80+40)-40);
        this.osizeX = 90;
        this.osizeY = 90;
        this.sizeX = 90;
        this.sizeY = 90;
        this.audioClip = new AudioClip(getClass().getResource("/res/ting.wav").toString());
    }


    public void removeImage(){
        this.s.getChildren().remove(this.plantView);
        this.root.getChildren().remove(this.s);
    }

    @Override
    public int getRow() {
        return 0;
    }

    @Override
    public int getColumn() {
        return 0;
    }

    @Override
    public String getName() {
        return "star";
    }


    public void setPosition(int row, int column){
        this.row = row;
        this.column = column;
        position[0] = row;
        position[1] = column;
    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public void setHealth(int health) {

    }

    @Override
    public int getPower() {
        return 0;
    }

    @Override
    public void setPower(int power) {

    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public void setPrice(int price) {

    }

    public int[] getPosition(){
        return position;
    }

    public void setSize(double width, double height) {
        super.setSize(width, height);
        this.plantView.setFitWidth(width);
        this.plantView.setFitHeight(height);
    }

    @Override
    public void makeSound() {
        this.audioClip.play();

    }

    public void clicked(){
        FadeTransition fadeTransition =
                new FadeTransition(Duration.millis(3000), s);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.3f);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);
        TranslateTransition translateTransition =
                new TranslateTransition(Duration.millis(2000), s);
        translateTransition.setFromX(50);
        translateTransition.setToX(350);
        translateTransition.setCycleCount(2);
        translateTransition.setAutoReverse(true);
        RotateTransition rotateTransition =
                new RotateTransition(Duration.millis(3000), s);
        rotateTransition.setByAngle(180f);
        rotateTransition.setCycleCount(4);
        rotateTransition.setAutoReverse(true);
        ScaleTransition scaleTransition =
                new ScaleTransition(Duration.millis(2000), s);
        scaleTransition.setToX(2f);
        scaleTransition.setToY(2f);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);

        ParallelTransition parallelTransition = new ParallelTransition();

        parallelTransition.getChildren().addAll(
                fadeTransition,
                translateTransition,
                rotateTransition,
                scaleTransition
        );
        parallelTransition.setCycleCount(Timeline.INDEFINITE);
        parallelTransition.play();

        makeSound();
    }
}
