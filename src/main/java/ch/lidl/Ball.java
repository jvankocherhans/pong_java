package ch.lidl;

// Dependencies
import java.util.*;
import java.awt.*;

public class Ball extends Rectangle{

    public int xVelocity;
    public int yVelocity;
    private Random rand;
    private int speed = 1;

    /**
     * Konstruktor der Klasse Ball
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Ball(int x, int y, int width, int height) {
        super(x, y, width, height);
        rand = new Random();
        
        setXDirection(-1 * speed);

        if(rand.nextInt(2) == 0) {
            setYDirection(-1 * speed);   
        } else {
            setYDirection(1 * speed);
        }
    }

    /**
     * Methode ist für die Beschleunigung des Balls zuständig.
     */
    public void increaseSpeed() {
        if(yVelocity < 0) {
            this.yVelocity--;
        } else {
            this.yVelocity++;
        }
        this.xVelocity++;
    }

    /**
     * Aktualisiert die neue Y-Position des Balls 
     * @param yDirection
     */
    public void setYDirection(int yDirection) {
        this.yVelocity = yDirection;
    }

    /**
     * Aktualisiert die neue X-Position des Balls 
     * @param xDirection
     */
    public void setXDirection(int xDirection) {
        this.xVelocity = xDirection;
    }

    /**
     * Die Geschwindigkeit von den Kräften wird auf die X und Y Koordinate übertragen.
     */
    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    /**
     * Die Grafik des Balls wird gezeichnet.
     * @param g
     */
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    

}