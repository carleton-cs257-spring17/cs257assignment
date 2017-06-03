package sample;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
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

                boolean add = true;

                for (Plant plant : player.getPlants()) {
                    if (plant.getRow() == row && plant.getColumn() == column) {
                        add = false;
                    }
                }

                if (add) {
                    switch (type) {
                        case "peashooter":
                            Peashooter peashooter = new Peashooter(row, column,root, player);
                            player.addPlants(peashooter);
                            player.setMoney(player.getSun() - peashooter.getPrice());

                            break;
                        case "wallnut":
                            WallNut wallnut = new WallNut(row, column,root);
                            player.addPlants(wallnut);
                            player.setSun(player.getSun() - wallnut.getPrice());
                            break;
                        case "sunflower":
                            Sunflower sunflower = new Sunflower(row, column,root,player);
                            player.addPlants(sunflower);
                            player.setSun(player.getSun() - sunflower.getPrice());
                            //player.addPlants(star);
                            break;
                    }
                }
            }
        }
        //System.out.println(player.getPlants().size());
    }

}

