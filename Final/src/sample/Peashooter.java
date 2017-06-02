package sample;

import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Scale;
import javafx.util.Duration;

/**
 * Created by yanhanlyu on 29/05/2017.
 * Class that specifies the behavior of Peashooter
 */
public class Peashooter extends Sprite implements Plant{
    private int price = 100;
    private int[] position = new int[2];
    private int health = 500;
    private int power = 0;
    private StackPane s = new StackPane();
    private  Group root = new Group();
    private Image plant;
    private  ImageView plantView;
    private double osizeX;
    private double osizeY;
    private double sizeX;
    private double sizeY;
    private boolean shrink = false;
    private Player player;
    private int count = 0;
    private boolean shoot = false;


    public Peashooter(int row, int column, Group root, Player player){
        this.player = player;
        this.position[0] = row;
        this.position[1] = column;
        this.plant = new Image("/res/peashooter.png");
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
    public void setPosition(int x, int y){
        position[0] = x;
        position[1] = y;
    }

    public void setSize(double width, double height) {
        super.setSize(width, height);
        this.plantView.setFitWidth(width);
        this.plantView.setFitHeight(height);
    }



    public int[] getPosition(){
        return position;
    }
    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public int getPower(){
        return power;
    }
    public void setPower(int power){
        this.power = power;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void step(){
        super.step();


        if (this.sizeX > (1.1 * osizeX) || this.sizeY > (1.1 * osizeY)){
            this.shrink = true;
        } else if (this.sizeX < (0.8 * osizeX) || this.sizeY < (0.8 * osizeY)) {
            this.shrink = false;
        }

        if (count >= 100){
            shoot = true;
        } else if (count <= 0){
            shoot = false;
        }

        if (shoot) {
            count --;
            System.out.println("SHOOT");
//            Pea pea = new Pea (this.position[0], this.position[1], this.root);
//            pea.makeSound();
//            this.player.addPlants(pea);
        } else {
            System.out.println("NOT SHOOT");
            count ++;
        }

        if (shrink) {



            this.setSize(1 * this.sizeX, this.sizeY - 0.1);

            this.sizeY = this.sizeY - 0.1;
        } else {
            this.setSize(1 * this.sizeX, this.sizeY + 0.1);
            this.sizeY = this.sizeY + 0.1;
        }
    }

    @Override
    public void makeSound() {

    }
}

