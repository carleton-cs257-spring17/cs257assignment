package sample;

/**
 * Created by yanhanlyu on 29/05/2017.
 * Class that specifies the behavior of normal Zombie
 */
public class NormalZombie implements Zombie {
    private int[] position = new int[2];
    private int health;
    private int power;
    private int speed;

    // Set the position of Zombie given coordinates
    public void setPosition(int x, int y){
        position[0] = x;
        position[1] = y;
    }

    // Get the position of Zombie
    public int[] getPosition(){
        return position;
    }

    // Get the health value of Zombie
    public int getHealth(){
        return health;
    }

    // Get the health value of Zombie
    public void setHealth(int health){
        this.health = health;

    }

    // Get the power value of Zombie
    public int getPower(){
        return power;
    }

    // Set the power value of Zombie
    public void setPower(int power){
        this.power = power;
    }

    // Get the speed value of Zombie
    public int getSpeed(){
        return speed;
    }

    // Set the speed value of Zombie
    public void setSpeed(int speed){
        this.speed = speed;

    }
}
