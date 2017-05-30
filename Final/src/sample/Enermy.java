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
    public void addZombies(Zombie zombie){
        zombies.add(zombie);
    }
}
