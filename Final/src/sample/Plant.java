package sample;
import java.util.ArrayList;
/**
 * Created by yanhanlyu on 28/05/2017.
 * Interface for the characters of Plant
 */
public interface Plant {
    public void setPosition(int x, int y);
    public int[] getPosition();
    public int getHealth();
    public void setHealth(int health);
    public int getPower();
    public void setPower(int power);
    public int getPrice();
    public void setPrice(int price);
}
