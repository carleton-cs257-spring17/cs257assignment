package sample;

import java.util.ArrayList;

/**
 * Created by yanhanlyu on 28/05/2017.
 * Class that sets player's status of sun and plants;
 */
public class Player {
    private int sun;
    private ArrayList<Plant> listPlants;

    /**
     * Get the sun status
     */
    public int getSun(){
        return sun;
    }


    /**
     *Get the plants that the player owns
     */
    public ArrayList<Plant> getPlants(){
        return listPlants;
    }

    /**
     * set the sun status
     */
    public void setSun(int sun){
        this.sun = sun;
    }

<<<<<<< HEAD
    /**
     * add the plant that the player bought
     */
=======
    // Add the plants that the player bought
>>>>>>> 78f8817b075b07b7ce8154f2419f3749a8e9e0af
    public void addPlants(Plant plant){
        listPlants.add(plant);
    }
}
