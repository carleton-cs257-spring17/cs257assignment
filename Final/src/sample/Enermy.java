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
    private int speed;
    private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    Group root = new Group();
    Random rand = new Random();

    public Enermy(Group root){
        this.root = root;
        zombies = generateZombies(100);
    }

    public ArrayList<Zombie> generateZombies(int density){
        ArrayList<Zombie> zombies = new ArrayList<Zombie>();
        for (int i = 0; i < 1; i++){
            //NormalZombie normalZombie1 = new NormalZombie(rand.nextInt(5)  + 6, rand.nextInt(5)  + 6, root);
            NormalZombie normalZombie1 = new NormalZombie(2, 2, root);
            //NormalZombie normalZombie1 = new NormalZombie(rand.nextInt(5)  + 1,rand.nextInt(100)  + 9, root);
            //StrongZombie strongZombie1 = new StrongZombie(rand.nextInt(5)  + 1,rand.nextInt(100)  + 9, root);
            zombies.add(normalZombie1);
            //zombies.add(strongZombie1);
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
