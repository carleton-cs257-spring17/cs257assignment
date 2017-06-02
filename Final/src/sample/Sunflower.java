package sample;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.input.MouseEvent;

import javafx.event.EventHandler;


/**
 * Created by yanhanlyu on 29/05/2017.
 * Class that specifies the behavior of Sunflower
 */
public class Sunflower implements Plant {
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
    private Player player;


    public Sunflower(int row, int column, Group root){
        this.player = player;
        this.row = row;
        this.column = column;
        this.plant = new Image("sunflower.png");
        this.plantView = new  ImageView(plant);
        s.getChildren().add(plantView);
        root.getChildren().add(s);
        s.setTranslateY((int) (135+(row-1)*110+55)-40);
        s.setTranslateX((int) (60+(column-1)*80+40)-40);
    }

    public void removeImage(){
        this.s.getChildren().remove(this.plantView);
        this.root.getChildren().remove(this.s);
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.column;
    }

    /** Set the position of Sunflower given coordinates*/
    public void setPosition(int row, int column){
        this.row = row;
        this.column = column;
    }

     /** Get the position of Sunflower*/
    public int[] getPosition(){
        return position;
    }

     /** Get the health value of Sunflower*/
    public int getHealth(){
        return health;
    }

     /** Set the health value of Sunflower*/
    public void setHealth(int health){
        this.health = health;
    }

     /** Get the power value of Sunflower*/
    public int getPower(){
        return power;
    }

     /** Set the power value of Sunflower*/
    public void setPower(int power){
        this.power = power;
    }

     /** Get the price value of Sunflower*/
    public int getPrice(){
        return price;
    }

     /** Set the price value of Sunflower*/
    public void setPrice(int price){
        this.price = price;
    }
    public void step(){}


}
