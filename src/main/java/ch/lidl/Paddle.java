package ch.lidl;

// Dependencies
import java.awt.*;
import net.java.games.input.Component;

public class Paddle extends Rectangle {

    // Membervariablen
    private int id;
    private int yVelocity;
    private int speed = 2;

    /**
     * Konstruktor der Paddle-Klasse
     * @param x
     * @param y
     * @param PADDLE_WIDTH
     * @param PADDLE_HEIGHT
     * @param id
     */
    public Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }

    /**
     * ControllerInput wird abgefangen und dann umgsetzt.
     * @param identifier
     * @param data
     */
    public void controllerInput(Component.Identifier identifier, float data) {
        if (identifier == Component.Identifier.Button._0 && data >= 0.5) {
            setYDirection(-speed);
            move();
        } else if (identifier == Component.Identifier.Button._0){
            setYDirection(0);
            move(); 
        }

        if(identifier == Component.Identifier.Button._2 && data >= 0.5) {
            setYDirection(speed);
            move();
        } else if (identifier == Component.Identifier.Button._2) {
            setYDirection(0);
            move();
        }
    }

    /**
     * Die Y-Kraft wird neu initialisiert
     * @param yDirection
     */
    public void setYDirection(int yDirection) {
        this.yVelocity = yDirection;
    }

    /**
     * Die Move-Methode aktualisiert die neue Y-Position
     */
    public void move() {
        this.y = y + yVelocity;
    }

    /**
     * Grafiken des Paddles werden gezeichnet
     * @param g
     */
    public void draw(Graphics g) {
        if (this.id == 1) {
            g.setColor(Color.WHITE);
        }
        g.fillRect(x, y, width, height);
    }

}