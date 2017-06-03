package sample;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

import java.util.Stack;

/**
 * Created by Lucy on 6/2/17.
 */
public class Star extends Sprite{
    StackPane s = new StackPane();
    private Image star;
    private ImageView starView;


    public Star( int row, int column, Group root){
        this.star= new Image("/res/peashooter.png");
        this.starView = new  ImageView(star);
        s.getChildren().add(starView);
        s.setTranslateY((int) (135+(row-1)*110+55)-40+1);
        s.setTranslateX((int) (60+(column-1)*80+40)-40-20);
        root.getChildren().add(s);

    }

    public StackPane getStack(){
        System.out.println("!!!!!");
        return this.s;
    }

    @Override
    public void makeSound(){

    }


}
