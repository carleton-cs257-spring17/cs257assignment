package sample;

/**
 * Created by yanhanlyu on 28/05/2017.
 */
public interface Zombie {
    public void setPosition(int x, int y);
    public int[] getPosition();
    public int getHealth();
    public void setHealth(int health);
    public int getPower();
    public void setPower(int power);
    public int getSpeed();
    public void setSpeed(int speed);
}
