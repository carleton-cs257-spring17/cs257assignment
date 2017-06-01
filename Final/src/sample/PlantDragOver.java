package sample;
import javafx.scene.Group;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;


public class PlantDragOver implements EventHandler<DragEvent> {

    public PlantDragOver(){

    }

    public void handle(DragEvent event) {
        System.out.println("x: "+event.getX());
        System.out.println("y: "+event.getY());
        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        event.consume();

    }

}