package sample;
import java.util.ArrayList;
/**
 * Created by yanhanlyu on 28/05/2017.
 * Interface for the characters of Plant
 */
public interface Plant {
<<<<<<< HEAD
    /**
     * set the position of the plant
     */
    public void setPosition(int x, int y);
    /**
     * return the position of the plant
     */
    public int[] getPosition();
    /**
     * return the health of the plant
     */
    public int getHealth();
    /**
     * set the health of the plant
     */
    public void setHealth(int health);
    /**
     * return the power of the plant
     */
    public int getPower();
    /**
     * set the power of the plant
     */
    public void setPower(int power);
    /**
     * get the price of the plant
     */
    public int getPrice();
    /**
     * set the price of the plant
     */
=======
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
>>>>>>> 78f8817b075b07b7ce8154f2419f3749a8e9e0af
    public void setPrice(int price);
}
