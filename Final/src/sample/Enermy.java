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
<<<<<<< HEAD
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
=======

    // Get the density of attacking enemy
    public int getDensity(){
        return density;
    }
    // Set the density of attacking enemy
    public void setDensity(int density){
        this.density = density;
    }

    // Get the speed of attacking enemy
    public int getSpeed(){
        return speed;
    }
    // Set the speed of attacking enemy
    public void setSpeed(int speed){
        this.speed = speed;
    }

    // Get the list of all Zombies attacking
    public ArrayList<Zombie> getZombies(){
        return zombies;
    }
    // Set the list of all Zombies attacking
>>>>>>> 78f8817b075b07b7ce8154f2419f3749a8e9e0af
    public void addZombies(Zombie zombie){
        zombies.add(zombie);
    }
}
