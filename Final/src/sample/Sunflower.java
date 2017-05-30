package sample;
import java.util.ArrayList;

/**
 * Created by yanhanlyu on 29/05/2017.
 * Class that specifies the behavior of Sunflower
 */
public class Sunflower implements Plant {
    private int price;
    private int[] position = new int[2];
    private int health;
    private int power;

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
}
