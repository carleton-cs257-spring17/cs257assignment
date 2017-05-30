package sample;

/**
 * Created by yanhanlyu on 29/05/2017.
 * Class that specifies the behavior of strong Zombie
 */
public class StrongZombie {
    private int[] position = new int[2];
    private int health;
    private int power;
    private int speed;
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
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;

    }
}
