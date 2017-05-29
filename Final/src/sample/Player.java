package sample;

import java.util.ArrayList;

/**
 * Created by yanhanlyu on 28/05/2017.
 */
public class Player {
    private int sun;
    private ArrayList<Plant> listPlants;

    public int getSun(){
        return sun;
    }
    public ArrayList<Plant> getPlants(){
        return listPlants;
    }

    public void setSun(int sun){
        this.sun = sun;
    }
    public void addPlants(Plant plant){
        listPlants.add(plant);
    }
}
