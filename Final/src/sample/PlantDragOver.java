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


public class PlantDragOver implements EventHandler<DragEvent> {

    public PlantDragOver(){

    }

    @Override
    public void handle(DragEvent event) {
        System.out.println("onDragOver");

        /* accept it only if it is  not dragged from the same node
        * and if it has a string data */
//        if (event.getGestureSource() != target &&
//                event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        //}

        event.consume();

    }

}