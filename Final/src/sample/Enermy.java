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
    /**
     * return the density of the group of zombies
     */
    public int getDensity(){
        return density;
    }
    /**
     * set the density of the group of zombies
     */
    public void setDensity(int density){
        this.density = density;
    }
    /**
     * get the speed of the group of zombies
     */
    public int getSpeed(){
        return speed;
    }
    /**
     * set the speed of the group of zombies
     */
    public void setSpeed(int speed){
        this.speed = speed;
    }
    /**
     * return a list of current zombies on the map
     */
    public ArrayList<Zombie> getZombies(){
        return zombies;
    }
    /**
     * add zombies into zombie list
     */
    public void addZombies(Zombie zombie){
        zombies.add(zombie);
    }

    public void removeZombie(Zombie zombie){
        zombies.remove(zombie);
    }

}
