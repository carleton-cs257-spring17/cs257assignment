/**
 * Lyuy.java
 * Yanhan Lyu
 *
 * A sample subclass of Sprite for CS257.
 */
package sprites;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.transform.Rotate;

public class Lyuy extends Sprite {
    private AudioClip audioClip;
    private ImageView imageView;
    /**
     * default constructor is for my little husky
     */
    public Lyuy() {
        Image image = new Image(getClass().getResourceAsStream("/res/husky1.png"));
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

    public void setImage(String pictureName){
        this.getChildren().remove(this.imageView);
        Image image;
        image = new Image(getClass().getResourceAsStream(pictureName));
        this.imageView.setImage(image);
        this.getChildren().add(this.imageView);
    }

    @Override
    public void step() {
        // I change the size in controller in SpriteWord.java
        double width = this.getScene().getWidth();
        double x1 = width * 0.4;
        double x2 = width * 0.6;
        double distance1 = Math.abs(2*this.getVelocity().getX())+1;
        this.setSound("/res/bomb.wav");
        // can not solve the rotate and transform stuff until I see the code from Martin Choffman. Credit to and thanks to him.
        // if in the expected rotation position, make the bomb sound
        if (this.getPosition().getX() > x1 && this.getPosition().getX() < x1 + distance1
                && this.getVelocity().getX() > 0) {
            this.getTransforms().add(new Rotate(180, this.getSize().getX() / 2.0, this.getSize().getY() / 2.0));
            this.makeSound();
        } else if (this.getPosition().getX() < x2 && this.getPosition().getX() > x2 - distance1
                && this.getVelocity().getX() < 0) {
            this.getTransforms().add(new Rotate(180, this.getSize().getX() / 2.0, this.getSize().getY() / 2.0));
            this.makeSound();
        }
        // change images for different velocity
        double velovityX = this.getVelocity().getX();
        double velovityY = this.getVelocity().getY();
        if (velovityX >= 0 && velovityY >= 0) {
            this.setImage("/res/husky2.png");
        } else if (velovityX >= 0 && velovityY < 0){
            this.setImage("/res/husky3.png");
        } else if (velovityX < 0 && velovityY < 0){
            this.setImage("/res/husky4.png");
        } else {
            this.setImage("/res/husky1.png");
        }
        this.setSound("/res/husky.wav");
        super.step();
    }

    /*
    * set sound according to the file name
    * */
    public void setSound(String nameSound){
        this.audioClip = new AudioClip(getClass().getResource(nameSound).toString());
    }
    @Override
    public void makeSound() {
        this.audioClip.play();
    }
}

