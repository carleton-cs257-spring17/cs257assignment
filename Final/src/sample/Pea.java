package sample;

/**
 * Created by yanhanlyu on 01/06/2017.
 */
import javafx.scene.shape.Circle;

public class Pea extends Circle {
    private double velocityX;
    private double velocityY;

    public Pea() {
    }

    public void step() {
//        this.setCenterX(this.getCenterX() + this.velocityX);
//        this.setCenterY(this.getCenterY() + this.velocityY);
    }

    public double getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }
}