package sample;

import java.util.ArrayList;

/**
 * Created by yanhanlyu on 28/05/2017.
 */
public interface EnermyInterface {
    int getDensity();
    void setDensity(int density);
    int getSpeed();
    void setSpeed(int speed);
    ArrayList getPlants();
    void addPlants(Zombie zombie);

}
