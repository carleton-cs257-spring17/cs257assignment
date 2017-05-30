package sample;

import java.util.ArrayList;

/**
 * Created by yanhanlyu on 28/05/2017.
 * Class that sets player's status of sun and plants;
 */
public class Player {
    private int sun;
    private ArrayList<Plant> listPlants;

    // Get the sun status
    public int getSun(){
        return sun;
    }

    // Get the plants that the player owns
    public ArrayList<Plant> getPlants(){
        return listPlants;
    }

    // Set the sun status
    public void setSun(int sun){
        this.sun = sun;
    }
    
    // Add the plants that the player bought
    public void addPlants(Plant plant){
        listPlants.add(plant);
    }
}
