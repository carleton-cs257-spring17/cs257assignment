package sample;

/**
 * Created by yanhanlyu on 28/05/2017.
 * Interface that lists the general characters and behaviors of a Zombie
 */
public interface Zombie {
    /**
     * set the position of the zombie
     */
    public void setPosition(int x, int y);
    /**
     * get the position of the zombie
     */
    public int[] getPosition();
    /**
     * get the health value of the zombie
     */
    public int getHealth();
    /**
     * set the health value of the zombie
     */
    public void setHealth(int health);
    /**
     * get the power value of the zombie
     */
    public int getPower();
    /**
     * set the power value of the zombie
     */
    public void setPower(int power);
    /**
     * get the speed value of the zombie
     */
    public int getSpeed();
    /**
     * set the speed value of the zombie
     */
    public void setSpeed(int speed);

    public void step();


}
