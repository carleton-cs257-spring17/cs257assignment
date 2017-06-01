package sample;

/**
 * Created by yanhanlyu on 29/05/2017.
 * Class that specifies the character of potato mine.
 */
<<<<<<< HEAD
public class PotatoMine implements Plant{
=======
public class PotatoMine extends Sprite implements Plant{
    /** Set the position of potato mine given coordinates*/
    public void setPosition(int x, int y){}
>>>>>>> 052c7ff00c910e02d45789ff9f0a8b12db4608a5

    private int price = 100;
    private int[] position = new int[2];
    private int health = 500;
    private int power = 0;

    public PotatoMine(int x, int y){
        this.position[0] = x;
        this.position[1] = y;
    }
    /** Set the position of Wallnut given coordinates*/
    public void setPosition(int x, int y){
        position[0] = x;
        position[1] = y;
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
