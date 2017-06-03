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
public class Sunflower extends Sprite implements Plant {
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



    public Sunflower(int row, int column, Group root, Player player){
        this.player = player;
        this.row = row;
        this.column = column;
        this.plant = new Image("/res/sunflower.png");
        this.plantView = new  ImageView(plant);
        s.getChildren().add(plantView);
        this.root = root;
        root.getChildren().add(s);
        s.setTranslateY((int) (135+(row-1)*110+55)-40);
        s.setTranslateX((int) (60+(column-1)*80+40)-40);
        this.osizeX = 90;
        this.osizeY = 90;
        this.sizeX = 90;
        this.sizeY = 90;
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

    public void setSize(double width, double height) {
        super.setSize(width, height);
        this.plantView.setFitWidth(width);
        this.plantView.setFitHeight(height);
    }

    public void step(){
        super.step();

        if (this.sizeX > (1.1 * osizeX) || this.sizeY > (1.1 * osizeY)){
            this.shrink = true;
        } else if (this.sizeX < (0.8 * osizeX) || this.sizeY < (0.8 * osizeY)) {
            this.shrink = false;
        }

        if (shrink) {
            this.setSize(1 * this.sizeX - 0.1, this.sizeY - 0.1);

            this.sizeX = this.sizeX - 0.1;
            this.sizeY = this.sizeY - 0.1;
        } else {
            this.setSize(1 * this.sizeX + 0.1, this.sizeY + 0.1);
            this.sizeX = this.sizeX + 0.1;
            this.sizeY = this.sizeY + 0.1;
        }
    }

    @Override
    public void makeSound() {

    }

    public String getName(){
        return "sunflower";
    }

}
