package sample;

import java.util.ArrayList;

import com.sun.tools.internal.xjc.generator.bean.field.NoExtendedContentField;
import javafx.scene.Group;
import java.util.*;
/**
 * Created by yanhanlyu on 28/05/2017.
 * Class that lists the general behavior of the Zombies
 */
public class Enermy{
    private int density;
    private double speed;
    private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    Group root = new Group();
    Random rand = new Random();

    public Enermy(Group root, int density){
        this.root = root;
        this.density = density;
        zombies = generateZombies(density);
    }

    public ArrayList<Zombie> generateZombies(int density){
        System.out.println("DENSITY" + density);
        int norm = (int) Math.round(density * 0.6);
        int strong = density - norm;

        for (int i = 0; i < 1; i++){

            for (int j = 0; j < norm; j++){
                NormalZombie normalZombie =  new NormalZombie(rand.nextInt(5)  + 1, 10 + rand.nextDouble(), root);
                zombies.add(normalZombie);
            }

            for (int k = 0; k < strong; k++){
                StrongZombie strongZombie = new StrongZombie(rand.nextInt(5)  + 1,10 + rand.nextDouble(), root);
                zombies.add(strongZombie);
            }
        }


        return zombies;
    }
    /**
     *
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
    public double getSpeed(){
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
