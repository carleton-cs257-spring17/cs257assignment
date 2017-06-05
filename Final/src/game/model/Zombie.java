package game.model;

/**
 * Created by yanhanlyu on 28/05/2017.
 * Interface that lists the general characters and behaviors of a Zombie
 */
public interface Zombie {

    public void setImagePosition(double x, double y);

    public double getImagePositionX();

    /**
     * set the position of the zombie
     */
    public void setPosition(int x, int y);

    /**
     * get the row of the zombie
     */
    public int getRow();

    /**
     * get the row of the zombie
     */
    public int getColumn();

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
     * get the initial speed value of the zombie
     */
    public double getISpeed();

    /**
     * set the speed value of the zombie
     */
    public void setSpeed(double speed);

    public void setColumn (int column);

    public void step();

    public void removeImage();




}
