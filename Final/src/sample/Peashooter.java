package sample;

/**
 * Created by yanhanlyu on 29/05/2017.
 * Class that specifies the behavior of Peashooter
 */
public class Peashooter implements Plant {
    private int price;
    private int[] position = new int[2];
    private int health;
    private int power;
    public void setPosition(int x, int y){
        position[0] = x;
        position[1] = y;
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
}

