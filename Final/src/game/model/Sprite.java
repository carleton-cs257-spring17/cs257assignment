package game.model;

/**
 * Created by Lucy on 6/1/17.
 */
import javafx.scene.Group;

public abstract class Sprite extends Group {
    public void step() {

    }

    abstract public void makeSound();
}

