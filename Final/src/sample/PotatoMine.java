package sample;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

/**
 * Created by yanhanlyu on 29/05/2017.
 * Class that specifies the character of potato mine.
 */
public class PotatoMine extends Sprite implements Plant{
    private int row;
    private int column;
    private int price = 100;
    private int[] position = new int[2];
    private int health = 500;
    private int power = 0;
    private StackPane s = new StackPane();
    private  Group root = new Group();
    private Image plant;
    private  ImageView plantView;


    public PotatoMine(int row, int column, Group root){
        this.position[0] = row;
        this.position[1] = column;
        this.plant = new Image("/res/potatoMine.png");
        this.plantView = new  ImageView(plant);
        s.getChildren().add(plantView);
        this.root = root;
        root.getChildren().add(s);
        s.setTranslateY((int) (135+(row-1)*110+55)-40);
        s.setTranslateX((int) (60+(column-1)*80+40)-40);
    }

    public void removeImage(){
        this.s.getChildren().remove(this.plantView);
        this.root.getChildren().remove(this.s);
    }
    /** Set the position of Wallnut given coordinates*/
    public void setPosition(int x, int y){
        position[0] = x;
        position[1] = y;
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.column;
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
    public void step(){
        super.step();
    }

    @Override
    public void makeSound() {

    }

    public String getName(){
        return "potatoMine";
    }

    public void removeStar(){

    }
}
