package sample;

/**
 * Created by yanhanlyu on 01/06/2017.
 */
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Circle;

public class Pea extends Sprite implements Plant{
    private int velocityX = 1;
    private int velocityY = 1;
    private double[] position = new double[2];
    private Image plant;
    private  ImageView plantView;
    private AudioClip audioClip;
    private  Group root = new Group();
    private StackPane s = new StackPane();

    public Pea(double x, double y, Group root) {
        this.position[0] = x;
        this.position[1] = y;
        this.plant = new Image("/res/pea.png");
        this.plantView = new ImageView(plant);
        s.getChildren().add(plantView);
        this.root = root;
        root.getChildren().add(s);
        s.setTranslateY((int) (135+(x-1)*110+55)-40);
        s.setTranslateX((int) (60+(y-1)*80+40)-40 + 90);
        this.audioClip = new AudioClip(getClass().getResource("/res/shoot.wav").toString());
    }

    @Override
    public void makeSound() {
        this.audioClip.play();
    }

    @Override
    public void setPosition(int x, int y) {

    }

    public int[] getPosition() {
        return new int[0];
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

    public void step() {
        this.setPosition(0,0);
    }

    @Override
    public void removeImage() {

    }

    @Override
    public int getRow() {
        return 0;
    }

    @Override
    public int getColumn() {
        return 0;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }
}