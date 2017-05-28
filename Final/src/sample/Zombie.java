package sample;

/**
 * Created by yanhanlyu on 28/05/2017.
 */
public interface Zombie {
    void setPosition(int x, int y);
    int[] getPosition();
    int getHealth();
    void setHealth(int health);
    int getPower();
    void setPower(int power);
    int getSpeed();
    void setSpeed(int speed);
}
