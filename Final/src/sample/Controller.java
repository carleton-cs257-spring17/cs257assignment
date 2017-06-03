package sample;

import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import sun.security.provider.Sun;

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
    private boolean win = false;

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
        System.out.println(this.player.getSun());
        ArrayList<Plant> listOfPlants = checkPlants();
        ArrayList<Zombie> listOfZombies = checkZombies();
        ArrayList<Pea> listOfPeas = checkPeas();
        // System.out.println(listOfPlants.size());

        for (Iterator<Pea> iterator3 = player.getPeas().iterator(); iterator3.hasNext(); ) {
            Pea pea = iterator3.next();
            if (pea.getImagePositionX()>1000){
                player.getPeas().remove(pea);
            }
            pea.step();
        }

        for (Plant plant : listOfPlants){
            plant.step();
        }

        for (Zombie zombie : enermy.getZombies()){
            zombie.step();
        }

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

    private ArrayList<Plant> checkPlants(){
        ArrayList<Plant> listOfPlants = player.getPlants();
        return listOfPlants;
    }

    private ArrayList<Pea> checkPeas(){
        ArrayList<Pea> listOfPeas = player.getPeas();
        return listOfPeas;
    }

    private ArrayList<Zombie> checkZombies(){
        ArrayList<Zombie> listOfZombies = enermy.getZombies();
        return listOfZombies;
    }

    private void runFight(ArrayList<Plant> plants, ArrayList<Zombie> zombies, ArrayList<Pea> peas){
        ArrayList<Integer> dieZombie = new ArrayList<Integer>();
        ArrayList<Integer> diePlant = new ArrayList<Integer>();


        for (Iterator<Zombie> iterator2 = zombies.iterator(); iterator2.hasNext(); ) {
            Zombie zombie = iterator2.next();
            //System.out.println("bullet"+this.player.getPeas().size());

            for (Iterator<Plant> iterator = plants.iterator(); iterator.hasNext(); ) {
                Plant plant = iterator.next();

                int plantRow = plant.getRow();
                int plantColumn = plant.getColumn();
                int zombieRow = zombie.getRow();
                int zombieColumn = (int) Math.round(zombie.getImagePositionX());
                int zombieCol = 0;

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

                if (plant.getName().equals("peashooter")) {
                    for (Iterator<Pea> iterator3 = peas.iterator(); iterator3.hasNext(); ) {
                        Pea pea = iterator3.next();

                        int peaRow = pea.getRow();
                        int peaColumn = (int) Math.round(pea.getImagePositionX());

                        if (plantRow == peaRow && peaRow == zombieRow && peaColumn == zombieColumn) {
                            pea.removeImage();
                            int zombieHealth = zombie.getHealth();
                            int plantPower = plant.getPower();
                            zombie.setHealth(zombieHealth - plantPower);

                            player.getPeas().remove(pea);

                            System.out.println("ZOMBIE HEALTH: " + zombieHealth);

                            if (zombie.getHealth() <= 0) {
                                //iterator2.remove();
                                enermy.removeZombie(zombie);
                                zombie.removeImage();

//                        int index = zombies.indexOf(zombie);
//                        dieZombie.add(index);
                            }
                        }
                    }
                }



//                System.out.println("PLANT ROW: " + plantRow);
//                System.out.println("PLANT COL: " + plantColumn);
//                System.out.println("ZOMBIE ROW: " + zombieRow);
//                System.out.println("ZOMBIE COL: " + zombieCol);

                if (plantRow == zombieRow && plantColumn == zombieCol) {
//                    System.out.println("here!!");
                    zombie.setSpeed(0);
//                    System.out.println("ZOMBIE SPEED" + zombie.getSpeed());
                    int plantHealth = plant.getHealth();
                    int zombiePower = zombie.getPower();
                    plant.setHealth(plantHealth-zombiePower);
                    if (plant.getHealth() <= 0) {
                        System.out.println("plant is dying");
                        iterator.remove();
                        int count = 0;

                        zombie.setSpeed(zombie.getISpeed());
                        System.out.println("ZERO SPEED ZOMBIE COUNT: " + count);

                        player.removePlants(plant);
                        plant.removeImage();
                        if (plant.getName().equals("sunflower")){
                            plant.removeStar();
                        }
                    }
                }

            }

        }

        if (enermy.getZombies().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Plants vs Zombies");
            alert.setContentText("YOU WIN!");

            alert.showAndWait();
        }
    }

    /**
     * handle events
     */
    @Override
    public void handle(KeyEvent keyEvent) {

    }
}