package sample;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 * Created by Lucy on 6/2/17.
 */
public class StarClick implements EventHandler<MouseEvent> {
    private StackPane stackPane;
    private Star star;

    public StarClick(StackPane stackPane, Star star) {
        this.stackPane = stackPane;
        this.star = star;
    }

    @Override
    public void handle(MouseEvent event) {
        this.star.clicked();
    }
}
