package sample;
import java.util.ArrayList;
/**
 * Created by yanhanlyu on 28/05/2017.
 * Interface for the characters of Plant
 */
public interface Plant {
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
    public void setPrice(int price);
}
