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

//        ArrayList<Plant> listOfPlants = checkPlants();
//        ArrayList<Zombie> listOfZombies = checkZombies();
//        runFight(listOfPlants, listOfZombies);
//        listOfPlants = checkPlants();
//        listOfZombies = checkZombies();
//
//        for (Plant plant : listOfPlants){
//            //System.out.println("here?????");
//            plant.step();
//        }
//
//        for (Zombie zombie : listOfZombies){
//            zombie.step();
//        }
//        ArrayList<Plant> listOfPlants = checkPlants();
//        ArrayList<Zombie> listOfZombies = checkZombies();
//        runFight(listOfPlants, listOfZombies);
//        listOfPlants = checkPlants();
//        listOfZombies = checkZombies();
//
//        for (Plant plant : listOfPlants){
//            //System.out.println("here?????");
//            plant.step();
//        }
//
//        for (Zombie zombie : listOfZombies){
//            zombie.step();
//        }

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
//        for (Plant plant : plants){
//            for (Zombie zombie: zombies){
//                int[] plantPosition = plant.getPosition();
//                int plantY = plantPosition[2];
//                int[] zombiePosition = zombie.getPosition();
//                int zombieY = zombiePosition[1];
//
//                int plantX = plantPosition[2];
//                int zombieX = zombiePosition[0];

//                if (plantY == zombieY && plantX != zombieX ){
////                    if plant is Peashooer{
////                        initialize a pea and add it into listPea
////                        set the position of Pea as the position of this peashooter
////                        pea.step();
////                        if pea position == zombie position{
////                            int zombieHealth = zombie.getHealth();
////                            int plantPower = plant.getPower();
////                            zombie.setHealth(zombieHealth - plantPower);
////                            if (zombie.getHealth() <= 0){
////                                enermy.removeZombie(zombie);
////                            }
////                        }
//                    }
//
//                } else if (plantY == zombieY && plantX == zombieX ){
//                    int plantHealth = plant.getHealth();
//                    int zombiePower = zombie.getPower();
//                    plant.setHealth(plantHealth-zombiePower);
//                    if (plant.getHealth() <= 0){
//                        player.removePlants(plant);
//                    }
//                }
//            }
//        }
    }

    /**
     * handle events
     */
    @Override
    public void handle(KeyEvent keyEvent) {

    }
}