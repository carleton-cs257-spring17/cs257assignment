package sample;

import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import sun.security.provider.Sun;
import javafx.stage.Stage;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Iterator;
import java.util.ConcurrentModificationException;



/**
 * Created by yanhanlyu on 28/05/2017.
 * Class that updates the status of game in general
 */

public class Controller implements EventHandler<KeyEvent> {
    final private double FRAMES_PER_SECOND = 60.0;
    private int difficulty;
    private Player player;
    private Enermy enermy;
    private boolean win = false;
    private Stage stage;


    private Timer timer;

    public Controller(int difficulty, Player player, Enermy enermy, Stage initStage) {
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

    public boolean getWin(){
        return win;
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
        //System.out.println(this.player.getSun());
        ArrayList<Plant> listOfPlants = checkPlants();
        ArrayList<Zombie> listOfZombies = checkZombies();
        ArrayList<Pea> listOfPeas = checkPeas();
        // System.out.println(listOfPlants.size());
<<<<<<< HEAD
        try{
            for (Iterator<Pea> iterator3 = player.getPeas().iterator(); iterator3.hasNext(); ) {
                Pea pea = iterator3.next();
                if (pea.getImagePositionX()>1000){
                    player.getPeas().remove(pea);
                }
                pea.step();
=======

        // Update pea animation and remove the peas that are out of the screen
        for (Iterator<Pea> iterator3 = player.getPeas().iterator(); iterator3.hasNext(); ) {
            Pea pea = iterator3.next();
            if (pea.getImagePositionX()>1000){
                player.getPeas().remove(pea);
>>>>>>> 39af6dcce2491fbeab076a6a2c3915fcb6820074
            }
        } catch (ConcurrentModificationException e){

        }

<<<<<<< HEAD

=======
        // Update plant animation
>>>>>>> 39af6dcce2491fbeab076a6a2c3915fcb6820074
        for (Plant plant : listOfPlants){
            plant.step();
        }

        // Update Zombie animation
        for (Zombie zombie : enermy.getZombies()){
            zombie.step();
        }

        listOfPlants = checkPlants();
        listOfZombies = checkZombies();
        listOfPeas = checkPeas();

        runFight(listOfPlants, listOfZombies, listOfPeas);


//
//        for (Zombie zombie : listOfZombies){
//            zombie.step();
//        }
//
////        for (Iterator<Plant> iterator = player.getPlants().iterator(); iterator.hasNext();){
////            Plant plant = iterator.next();
////            plant.step();
////        }
    }

    // Get list of plants
    private ArrayList<Plant> checkPlants(){
        ArrayList<Plant> listOfPlants = player.getPlants();
        return listOfPlants;
    }

    // Get list of peas
    private ArrayList<Pea> checkPeas(){
        ArrayList<Pea> listOfPeas = player.getPeas();
        return listOfPeas;
    }

    // Get list of zombies
    private ArrayList<Zombie> checkZombies(){
        ArrayList<Zombie> listOfZombies = enermy.getZombies();
        return listOfZombies;
    }

    // Simulate the fight between plants and zombies and update animation accordingly
    private void runFight(ArrayList<Plant> plants, ArrayList<Zombie> zombies, ArrayList<Pea> peas){
        ArrayList<Integer> dieZombie = new ArrayList<Integer>();
        ArrayList<Integer> diePlant = new ArrayList<Integer>();
        boolean plantDie = false;

        ArrayList<Zombie> blockZombie = new  ArrayList<Zombie>();
        for (Iterator<Zombie> iterator2 = zombies.iterator(); iterator2.hasNext(); ) {
            Zombie zombie = iterator2.next();
            for (Iterator<Plant> iterator = plants.iterator(); iterator.hasNext(); ) {
                //System.out.println("here!!!!");
                Plant plant = iterator.next();

                int plantRow = plant.getRow();
                int plantColumn = plant.getColumn();
                int zombieRow = zombie.getRow();
                int zombieColumn = (int) Math.round(zombie.getImagePositionX());
                int zombieCol = 0;

                // Convert zombie image position to colomn
                if (zombie.getImagePositionX() >= 60 && zombie.getImagePositionX() <= 140){
                    zombieCol = 1;
                } else if (zombie.getImagePositionX()<=211) {
                    zombieCol = 2;
                } else if (zombie.getImagePositionX()<=300) {
                    zombieCol = 3;
                }else if (zombie.getImagePositionX()<=380){
                    zombieCol = 4;
                } else if (zombie.getImagePositionX()<=460) {
                    zombieCol = 5;
                } else if (zombie.getImagePositionX()<=540) {
                    zombieCol = 6;
                } else if (zombie.getImagePositionX()<=620) {
                    zombieCol = 7;
                } else if (zombie.getImagePositionX()<=700) {
                    zombieCol = 8;
                }else if (zombie.getImagePositionX()<=780) {
                    zombieCol = 9;
                }
//                System.out.println("plant row: "+plantRow);
//                System.out.println("plant col: "+plantColumn);
                if (plant.getName().equals("peashooter")) {
                    for (Iterator<Pea> iterator3 = peas.iterator(); iterator3.hasNext(); ) {
                        Pea pea = iterator3.next();

                        int peaRow = pea.getRow();
                        int peaColumn = (int) Math.round(pea.getImagePositionX());

                        // If pea hit the zombie, reduce zombie's health value and remove the pea
                        if (plantRow == peaRow && peaRow == zombieRow && peaColumn == zombieColumn) {
                            pea.removeImage();
                            int zombieHealth = zombie.getHealth();
                            int plantPower = plant.getPower();
                            zombie.setHealth(zombieHealth - plantPower);
                            iterator3.remove();
                            if (zombie.getHealth() <= 0) {
                                zombie.removeImage();
                                iterator2.remove();
                            }
                        }
                    }
                }

//                System.out.println("ZOMBIE row: "+zombieRow);
//                System.out.println("ZOMBIE col: "+zombieCol);


<<<<<<< HEAD
                if (plantRow == zombieRow && plantColumn == zombieCol) {
=======
//                System.out.println("PLANT ROW: " + plantRow);
//                System.out.println("PLANT COL: " + plantColumn);
//                System.out.println("ZOMBIE ROW: " + zombieRow);
//                System.out.println("ZOMBIE COL: " + zombieCol);

                // If zombie arrives at a block where a plant is located
                // zombie starts to consume plant's health value
                if (plantRow == zombieRow && plantColumn == zombieCol) {
//                    System.out.println("here!!");

                    // Make the zombie stop when it meets a plant
>>>>>>> 39af6dcce2491fbeab076a6a2c3915fcb6820074
                    zombie.setSpeed(0);
                    blockZombie.add(zombie);
                    int plantHealth = plant.getHealth();
                    int zombiePower = zombie.getPower();
                    plant.setHealth(plantHealth-zombiePower);
<<<<<<< HEAD
                    System.out.println(plant.getHealth());
                    if (plant.getHealth() < 50) {
                        if (plant.getHealth() <= 0){
                            plantDie = true;
=======
                    if (plant.getHealth() <= 0) {
                        System.out.println("plant is dying");
                        iterator.remove();
                        int count = 0;

                        // If the plant is consumed, zombie move again
                        zombie.setSpeed(zombie.getISpeed());
                        System.out.println("ZERO SPEED ZOMBIE COUNT: " + count);

                        player.removePlants(plant);
                        plant.removeImage();
                        if (plant.getName().equals("sunflower")){
                            plant.removeStar();
>>>>>>> 39af6dcce2491fbeab076a6a2c3915fcb6820074
                        }
                        zombie.setSpeed(zombie.getISpeed());
                    }
                }
                if (plantDie == true){
                    plant.removeImage();
                    if (plant.getName().equals("sunflower")){
                        plant.removeStar();
                    }
                    iterator.remove();
                }
                plantDie = false;

            }

//            if (plantDie == true){
//                for (Zombie zombie1: blockZombie){
//                    zombie1.setSpeed(zombie1.getISpeed());
//                }
//                blockZombie.clear();
//            }
//            plantDie=false;

        }

        // If player has killed all zombie in the list, show message that player has won.
        if (enermy.getZombies().isEmpty()){
            Main game = new Main();
            try{
                //this.stage.close();
                game.start(game.welcomeStage);
            } catch (Exception e){

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