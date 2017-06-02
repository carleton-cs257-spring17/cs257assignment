package sample;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * Created by yanhanlyu on 29/05/2017.
 * Class that specifies the behavior of normal Zombie
 */
public class NormalZombie implements Zombie {
    private int price = 100;
    private int[] position = new int[2];
    private int health = 500;
    private int power = 0;
    private StackPane s = new StackPane();
    private Group root = new Group();
    private Image zombie;
    private ImageView zombieView;


    public NormalZombie(int row, int column, Group root){
        this.position[0] = row;
        this.position[1] = column;
        this.zombie = new Image("strongZombie.png");
        this.zombieView = new  ImageView(zombie);
        s.getChildren().add(zombieView);
        root.getChildren().add(s);
        s.setTranslateY((int) (135+(row-1)*110+55)-40);
        s.setTranslateX((int) (60+(column-1)*80+40)-40);
    }

    public void removeImage(){
        this.s.getChildren().remove(this.zombieView);
        this.root.getChildren().remove(this.s);
    }

    // Set the position of Zombie given coordinates
    public void setPosition(int x, int y){
        position[0] = x;
        position[1] = y;
    }

    // Get the position of Zombie
    public int[] getPosition(){
        return position;
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
    public int getSpeed(){
        return 1;//speed;
    }

    // Set the speed value of Zombie
    public void setSpeed(int speed){
//        this.speed = speed;

    }

    public void step(){

    }
}
