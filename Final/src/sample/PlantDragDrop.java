package sample;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import sun.security.provider.Sun;

public class PlantDragDrop implements EventHandler<DragEvent> {
    Group root;
    Player player;
    //private Sun sun;

    public PlantDragDrop(Group root, Player player){
        this.root = root;
        this.player = player;
    }
    @Override
    public void handle(DragEvent event) {
<<<<<<< HEAD
        int row=1;
        int column=(int)event.getX()-40;
        String type = event.getDragboard().getString();
        StackPane s1 = new StackPane();

        if (event.getX()>=60 && event.getX() <= 780) {
            if (event.getY() >= 135 && event.getY() <= 685) {
                if (event.getY() >= 135 && event.getY() <= 245){
                    row=1;
                } else if (event.getY() < 355) {
                    row=2;
                } else if (event.getY() < 465) {
                    row=3;
                } else if ( event.getY() < 575){
                    row=4;
                } else if (event.getY() < 685) {
                    row=5;
                }

                if (event.getX() >= 60 && event.getX() <= 140){
                    column = 1;
                } else if (event.getX()<=211) {
                    column = 2;
                } else if (event.getX()<=300) {
                    column = 3;
                }else if (event.getX()<=380){
                    column = 4;
                } else if (event.getX()<=460) {
                    column = 5;
                } else if (event.getX()<=540) {
                    column = 6;
                } else if (event.getX()<=620) {
                    column = 7;
                } else if (event.getX()<=700) {
                    column = 8;
                }else if (event.getX()<=780) {
                    column = 9;
                }
                Image plant = null;
                ImageView plant1 = null;

                switch (type) {
                    case "peashooter":
                        plant = new Image("peashooter.png");
                        plant1 = new  ImageView(plant);
                        Peashooter peashooter = new Peashooter(row, column);
                        break;
                    case "wallnut":
                        plant = new Image("wallnut.png");
                        plant1 = new  ImageView(plant);
                        WallNut wallnut = new WallNut(row, column);
                        break;
                    case "sunflower":
                        plant = new Image("sunflower.png");
                        plant1 = new  ImageView(plant);
                        Sunflower sunflower = new Sunflower(row, column);
                        break;
                    case "potatoMine":
                        plant = new Image("potatoMine.png");
                        plant1 = new  ImageView(plant);
                        PotatoMine potatoMine = new PotatoMine(row, column);
                        break;
                }

                s1.getChildren().add(plant1);
                s1.setMaxSize(90, 160);
                s1.setTranslateY((int) (135+(row-1)*110+55)-40);
                s1.setTranslateX((int) (60+(column-1)*80+40)-40);
                root.getChildren().add(s1);
            }
        }
=======
        //System.out.println(event.getX());
>>>>>>> 052c7ff00c910e02d45789ff9f0a8b12db4608a5
    }

}

