package sample;

/**
 * Created by yanhanlyu on 29/05/2017.
 * Class that specifies the behavior of Peashooter
 */
<<<<<<< HEAD
public class Peashooter extends Sprite implements Plant{
    private int price;
=======
public class Peashooter implements Plant {
    private int price = 100;
>>>>>>> bbd18a413f0d24b1adcd7b2c19631409d0f97f1e
    private int[] position = new int[2];
    private int health = 100;
    private int power = 20;
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
    public void step(){}

    @Override
    public void makeSound() {

    }
}

