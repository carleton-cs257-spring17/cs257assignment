package sample;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * Created by yanhanlyu on 29/05/2017.
 * Class that specifies the behavior of strong Zombie
 */
public class StrongZombie implements Zombie{
    private int price = 100;
    private int row;
    private int column;
    private double x_position;
    private int[] position = new int[2];
    private int health = 500;
    private int power = 1;
    private StackPane s = new StackPane();
    private Group root = new Group();
    private Image zombie;
    private ImageView zombieView;
    private double imageY;
    private double imageX;
    private double speed = -0.02;
    private double ispeed = -0.02;


    public StrongZombie(int row, double column, Group root){
        this.row = row;
        this.x_position = column;
        this.zombie = new Image("/res/strongZombie.png");
        this.zombieView = new  ImageView(zombie);
        s.getChildren().add(zombieView);
        root.getChildren().add(s);
        s.setTranslateY((int) (135+(row-1)*110+55)-40+1);
        s.setTranslateX((int) (60+(column-1)*80+40)-40);
        this.imageX = 60+(column-1)*80+40+40;
        this.imageY = 135+(row-1)*110+55-40;
    }

    public void removeImage(){
        this.s.getChildren().remove(this.zombieView);
        this.root.getChildren().remove(this.s);
    }

    @Override
    public void setImagePosition(double x, double y){
        this.imageX = x;
        this.imageY = y;
    }

    @Override
    public double getImagePositionX(){
        return this.imageX;
    }

    public void setPosition(int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.column;
    }

    // Get the health value of Zombie
    public int getHealth(){
        return health;
    }

    // Get the health value of Zombie
    public void setHealth(int health){
        this.health = health;

    }

    // Get the power value of Zombie
    public int getPower(){
        return power;
    }

    // Set the power value of Zombie
    public void setPower(int power){
        this.power = power;
    }

    // Get the speed value of Zombie
    public double getSpeed(){
        return speed;
    }

    public double getISpeed(){
        return ispeed;
    }

    // Set the speed value of Zombie
    public void setSpeed(double speed){
        System.out.println("SET SPEED - STRONG" + speed);
        this.speed = speed;

    }

    // Set the speed value of Zombie
    public void setISpeed(double speed){
        System.out.println("SET ISPEED");
        this.ispeed = speed;

    }

    public void step(){
        double imageX = getImagePositionX()+this.speed;
        setImagePosition(imageX, imageY);
        s.setTranslateY(this.imageY);
        s.setTranslateX(imageX);
    }
}
