package sample;

import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Iterator;



/**
 * Created by yanhanlyu on 28/05/2017.
 * Class that updates the status of game in general
 */

public class Controller implements EventHandler<KeyEvent> {
    final private double FRAMES_PER_SECOND = 60.0;
    private int difficulty;
    private Player player;
    private Enermy enermy;

    private Timer timer;

    public Controller(int difficulty, Player player, Enermy enermy) {
        this.difficulty = difficulty;
        this.player = player;
        this.enermy = enermy;
    }

    /**
     * initialize timer
     */
    public void initialize() {
        this.startTimer();

    }

    /**
     * run starterTimer
     */
    private void startTimer() {
        this.timer = new java.util.Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        updateAnimation();
                    }
                });
            }
        };

        long frameTimeInMilliseconds = (long)(1);
        this.timer.schedule(timerTask, 0, frameTimeInMilliseconds);
    }

    public Player getPlayer(){
        return player;
    }

    /**
     * Update animation in this method
     */
    private void updateAnimation() {

        ArrayList<Plant> listOfPlants = checkPlants();
        ArrayList<Zombie> listOfZombies = checkZombies();
       // System.out.println(listOfPlants.size());
        runFight(listOfPlants, listOfZombies);
        listOfPlants = checkPlants();
        listOfZombies = checkZombies();

        for (Plant plant : listOfPlants){
            //System.out.println("here?????");
            plant.step();
        }

        for (Zombie zombie : listOfZombies){
            zombie.step();
        }

        for (Iterator<Plant> iterator = player.getPlants().iterator(); iterator.hasNext();){
            Plant plant = iterator.next();
            plant.step();
        }
    }

    private ArrayList<Plant> checkPlants(){
        ArrayList<Plant> listOfPlants = player.getPlants();
        return listOfPlants;
    }

    private ArrayList<Zombie> checkZombies(){
        ArrayList<Zombie> listOfZombies = enermy.getZombies();
        return listOfZombies;
    }

    private void runFight(ArrayList<Plant> plants, ArrayList<Zombie> zombies){
        ArrayList<Integer> dieZombie = new ArrayList<Integer>();
        ArrayList<Integer> diePlant = new ArrayList<Integer>();

        for (Iterator<Plant> iterator = plants.iterator(); iterator.hasNext(); ) {

            Plant plant = iterator.next();

            for (Iterator<Zombie> iterator2 = zombies.iterator(); iterator2.hasNext(); ) {
                Zombie zombie = iterator2.next();
                int plantRow = plant.getRow();
                int plantColumn = plant.getColumn();
                int zombieRow = zombie.getRow();
                int zombieColumn = zombie.getColumn();

                if (plantRow == zombieRow && plantColumn != zombieColumn  ){
                    int zombieHealth = zombie.getHealth();
                    int plantPower = plant.getPower();
                    zombie.setHealth(zombieHealth - plantPower);
                    if (zombie.getHealth() <= 0){
                        iterator2.remove();
                        enermy.removeZombie(zombie);
                        zombie.removeImage();
//                        int index = zombies.indexOf(zombie);
//                        dieZombie.add(index);
                    }
                } else if (plantColumn == zombieColumn && plantRow == zombieRow) {
                    System.out.println("here!!");
                    int plantHealth = plant.getHealth();
                    int zombiePower = zombie.getPower();
                    plant.setHealth(plantHealth-zombiePower);
                    if (plant.getHealth() <= 0) {
                        System.out.println("plant is dying");
                        iterator.remove();
                        player.removePlants(plant);
                        plant.removeImage();
                    }
                    int zombieHealth = zombie.getHealth();
                    int plantPower = plant.getPower();
                    zombie.setHealth(zombieHealth - plantPower);
                    if (zombie.getHealth() <= 0) {
                        iterator2.remove();
                        enermy.removeZombie(zombie);
                        zombie.removeImage();
                    }
                }
            }
        }
    }

    /**
     * handle events
     */
    @Override
    public void handle(KeyEvent keyEvent) {

    }
}