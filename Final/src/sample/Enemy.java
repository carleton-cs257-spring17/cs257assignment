package sample;

import java.util.ArrayList;

import com.sun.tools.internal.xjc.generator.bean.field.NoExtendedContentField;
import javafx.scene.Group;
import java.util.*;
/**
 * Created by yanhanlyu on 28/05/2017.
 * Class that lists the general behavior of the Zombies
 */
public class Enemy{
    private int difficulty;
    private double speed;
    private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    Group root = new Group();
    Random rand = new Random();

    public Enemy(Group root, int difficulty){
        this.root = root;
        this.difficulty = difficulty;
        zombies = generateZombies(difficulty);
    }

    public ArrayList<Zombie> generateZombies(int difficulty){
        System.out.println("difficulty"+this.difficulty);
        int norm = (int) Math.round(difficulty * 0.6);
        int strong = difficulty - norm;

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
     * return the difficulty of the group of zombies
     */
    public int getdifficulty(){
        return difficulty;
    }
    /**
     * set the difficulty of the group of zombies
     */
    public void setdifficulty(int difficulty){
        this.difficulty = difficulty;
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
