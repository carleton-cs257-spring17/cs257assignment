package sample;
import java.util.ArrayList;
/**
 * Created by yanhanlyu on 28/05/2017.
 * Interface for the characters of Plant
 */
public interface Plant {
    // Set the position of a plant given coordinates
    public void setPosition(int x, int y);
    // Get the position of a plant
    public int[] getPosition();

    // Get the health status of a plant
    public int getHealth();
    // Set the health status of a plant
    public void setHealth(int health);

    // Get the power value of a plant
    public int getPower();
    // Set the power value of a plant
    public void setPower(int power);

    // Get the price of a plant
    public int getPrice();
    // Set the price of a plant
    public void setPrice(int price);
}
