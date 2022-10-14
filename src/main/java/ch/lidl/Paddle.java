package ch.lidl;

// Dependencies
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.java.games.input.Component;

public class Paddle extends Rectangle {

    private int id;
    private int yVelocity;
    private int speed = 2;

    public Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }

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

    public void setYDirection(int yDirection) {
        this.yVelocity = yDirection;
    }

    public void move() {
        this.y = y + yVelocity;
    }

    public void draw(Graphics g) {
        if (this.id == 1) {
            g.setColor(Color.WHITE);
        }
        g.fillRect(x, y, width, height);
    }

}