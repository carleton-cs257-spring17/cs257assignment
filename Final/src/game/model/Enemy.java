package game.model;

import java.util.ArrayList;

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

        for (int i = 0; i < difficulty; i++){

            for (int j = 0; j < norm; j++){
                NormalZombie normalZombie =  new NormalZombie(rand.nextInt(5)  + 1, rand.nextInt(9)  + 9, root);
                zombies.add(normalZombie);
            }

            for (int k = 0; k < strong; k++){
                StrongZombie strongZombie = new StrongZombie(rand.nextInt(5)  + 1,rand.nextInt(9)  + 9, root);
                zombies.add(strongZombie);
            }
        }


        return zombies;
    }

    public ArrayList<Zombie> getZombies(){
        return zombies;
    }


}
