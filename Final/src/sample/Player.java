package sample;

import java.util.ArrayList;

/**
 * Created by yanhanlyu on 28/05/2017.
 * Class that sets player's status of sun and plants;
 */
public class Player {
    private int sun = 200;
    private int money = 200;
    private ArrayList<Plant> listPlants = new ArrayList<Plant>();
    private ArrayList<Pea> listPeas = new ArrayList<Pea>();

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money){
        this.money = money;
    }

    /**
     * Get the sun status
     */
    public int getSun(){
        return this.sun;
    }


    /**
     *Get the plants that the player owns
     */
    public ArrayList<Plant> getPlants(){
        return listPlants;
    }

    public ArrayList<Pea> getPeas(){
        return listPeas;
    }

    /**
     * set the sun status
     */
    public void setSun(int sun){
        this.sun = sun;
    }

    /**
     * add the plant that the player bought
     */
    public void addPlants(Plant plant){
        listPlants.add(plant);
    }

    public void addPea(Pea pea){
        listPeas.add(pea);

    }

    public void removePlants(Plant plant){
        listPlants.remove(plant);
    }
}
