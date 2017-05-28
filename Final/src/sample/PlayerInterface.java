package sample;
import java.util.ArrayList;

/**
 * Created by yanhanlyu on 28/05/2017.
 */
public interface PlayerInterface{
    int getMoney();
    int getScore();
    ArrayList getPlants();
    void setScore(int score);
    void setMoney(int money);
    void addPlants(Plant plant);
}