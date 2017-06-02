package sample;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * Created by yanhanlyu on 29/05/2017.
 * Class that specifies the character of Wallnut
 */
public class WallNut extends Sprite implements Plant {
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


    public WallNut(int row, int column, Group root){
        this.row = row;
        this.column = column;
        this.plant = new Image("wallNut.png");
        this.plantView = new  ImageView(plant);
        s.getChildren().add(plantView);
        root.getChildren().add(s);
        s.setTranslateY((int) (135+(row-1)*110+55)-40);
        s.setTranslateX((int) (60+(column-1)*80+40)-40);
    }
    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.column;
    }

    public void removeImage(){
        this.s.getChildren().remove(this.plantView);
        this.root.getChildren().remove(this.s);
    }
    public void setPosition(int row, int column){
        this.row = row;
        this.column = column;
    }

    /** Get the position of Wallnut*/
    public int[] getPosition(){
        return position;
    }

    /** Get the health value of Wallnut*/
    public int getHealth(){
        return health;
    }

    /** Set the health value of Wallnut*/
    public void setHealth(int health){
        this.health = health;
    }

     /** Get the power value of Wallnut*/
    public int getPower(){
        return power;
    }

     /** Set the power value of Wallnut*/
    public void setPower(int power){
        this.power = power;
    }

     /** Get the price value of Wallnut*/
    public int getPrice(){
        return price;
    }

     /** Set the price value of Wallnut*/
    public void setPrice(int price){
        this.price = price;
    }
    public void step(){}

    @Override
    public void makeSound() {

    }
}
