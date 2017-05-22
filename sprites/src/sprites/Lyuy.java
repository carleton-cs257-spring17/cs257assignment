package sprites;

/**
 * Created by yanhanlyu on 21/05/2017.
 */
/**
 * SpinningMoose.java
 * Jeff Ondich, 16 May 2017
 *
 * A sample subclass of Sprite for CS257.
 */

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.transform.Rotate;
public class Lyuy extends Sprite {
    private AudioClip audioClip;
    private ImageView imageView;

    public Lyuy() {
        Image image = new Image(getClass().getResourceAsStream("/res/husky.png"));
        this.imageView = new ImageView();
        this.imageView.setImage(image);
        this.getChildren().add(this.imageView);

        this.audioClip = new AudioClip(getClass().getResource("/res/husky.wav").toString());
    }

    public void setSize(double width, double height) {
        super.setSize(width, height);
        this.imageView.setFitWidth(width);
        this.imageView.setFitHeight(height);
    }

    @Override
    public void step() {
        super.step();
        this.getTransforms().add(new Rotate(2, this.getSize().getX() / 2.0,this.getSize().getY() / 2.0));
    }

    @Override
    public void makeSound() {
        this.audioClip.play();
    }
}

