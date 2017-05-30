package sample;

import java.util.ArrayList;

/**
 * Created by yanhanlyu on 28/05/2017.
 * Class that lists the general behavior of the Zombies
 */
public class Enermy{
    private int density;
    private int speed;
    private ArrayList<Zombie> zombies;
    public int getDensity(){
        return density;
    }
    public void setDensity(int density){
        this.density = density;
    }
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public ArrayList<Zombie> getZombies(){
        return zombies;
    }
    public void addZombies(Zombie zombie){
        zombies.add(zombie);
    }
}
