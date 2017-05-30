package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yanhanlyu on 28/05/2017.
 * Class that updates the status of game in general
 */

public class Controller implements EventHandler<KeyEvent> {
    final private double FRAMES_PER_SECOND = 60.0;

    private Timer timer;

    public Controller() {

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

        long frameTimeInMilliseconds = (long)(1000.0 / FRAMES_PER_SECOND);
        this.timer.schedule(timerTask, 0, frameTimeInMilliseconds);
    }

    /**
     * Update animation in this method
     */
    private void updateAnimation() {
    }

    /**
     * handle events
     */
    @Override
    public void handle(KeyEvent keyEvent) {

    }
    public void onMenuButton(ActionEvent actionEvent) {

    }
    /* Facilitates buying towers feature
     * updates money
     * Lets user place tower
     */
    public void onBuyTowerButton(ActionEvent actionEvent) {

    }
    /* Triggers waves of enemies
     * Determines number of enemies in each wave
     * Checks to make sure previous wave is over
     */
    public void onWaveButton(ActionEvent actionEvent) {

    }
}