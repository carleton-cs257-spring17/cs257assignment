package sample;
import java.util.ArrayList;

/**
 * Created by yanhanlyu on 29/05/2017.
 * Class that specifies the behavior of Sunflower
 */
<<<<<<< HEAD
public class Sunflower extends Sprite implements Plant {
    private int price;
=======
public class Sunflower implements Plant {
    private int price = 50;
>>>>>>> bbd18a413f0d24b1adcd7b2c19631409d0f97f1e
    private int[] position = new int[2];
    private int health = 100;
    private int power = 0;

    /** Set the position of Sunflower given coordinates*/
    public void setPosition(int x, int y){
        position[0] = x;
        position[1] = y;
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

    @Override
    public void makeSound() {

    }
}
