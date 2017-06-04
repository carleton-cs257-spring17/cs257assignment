package sample;

/**
 * Created by Lucy on 6/1/17.
 */
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Sprite extends Group {
    public void step() {

    }

    abstract public void makeSound();
}

