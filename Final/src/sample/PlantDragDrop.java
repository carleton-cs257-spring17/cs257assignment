package sample;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;

public class PlantDragDrop implements EventHandler<DragEvent> {

    //private Sun sun;

    public PlantDragDrop() {
        //this.sun = sun;
    }
    @Override
    public void handle(DragEvent event) {
        System.out.println(event.getX());
    }

}

