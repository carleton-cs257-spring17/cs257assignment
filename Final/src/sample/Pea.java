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
    private double velocityRow = 0;
    private double velocityColumn = 1;
    private int price = 100;
    private double row;
    private double column;
    private int health = 500;
    private int power = 1;
    private Image plant;
    private  ImageView plantView;
    private double osizeX;
    private double osizeY;
    private double sizeX;
    private double sizeY;
    private boolean shrink = false;
    private Player player;
    private int shoot_count = 0;
    private AudioClip audioClip;
    private  Group root = new Group();
    private StackPane s = new StackPane();

    public Pea(int row, int column, Group root, Player player) {
        this.player = player;
        this.row = row;
        this.column = column;
        this.plant = new Image("/res/pea.png");
        this.plantView = new  ImageView(plant);
        s.getChildren().add(plantView);
        this.root = root;
        root.getChildren().add(s);
        s.setTranslateY((int) (135+(row-1)*110+55)-40);
        s.setTranslateX((int) (60+(column-1)*80+40)+40);
        this.osizeX = 90;
        this.osizeY = 90;
        this.sizeX = 90;
        this.sizeY = 90;
        this.audioClip = new AudioClip(getClass().getResource("/res/shoot.wav").toString());
    }


    public void setPosition(double row, double column){
        this.row = row;
        this.column = column;
    }

    @Override
    public void makeSound() {
        this.audioClip.play();
    }

//    public void setPosition(double row, double column){
//        this.row = row;
//        this.column = column;
//    }

    public int getRow(){

        return (int)this.row;
    }

    public void setPosition(int x, int y){

    }

    public int getColumn(){
        return (int)this.column;
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
        //System.out.println("PEASHOOTER STEP");
        //System.out.println("velocity x: " + velocityX);
        //System.out.println(this.getPosition());
        //System.out.println("END PEASHOOTER STEP");
        this.setPosition(this.getRow(), this.getColumn()+this.velocityColumn);
//        System.out.println(this.column+velocityColumn);
//        System.out.println(this.getColumn());
        s.setTranslateY((int) (135+(this.row-1)*110+55)-40);
        s.setTranslateX((int) (60+(this.column-1)*80+40)+40);
    }

    @Override
    public void removeImage() {

    }

    public double getVelocityRow() {
        return velocityRow;
    }

    public void setVelocityColumn(int velocityColumn) {
        this.velocityColumn = velocityColumn;
    }

    public double getVelocityColumn() {
        return velocityColumn;
    }

    public void setVelocityRow(int velocityRow) {
        this.velocityRow = velocityRow;
    }
}