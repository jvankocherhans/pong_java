package ch.lidl;

// Dependencies
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ball extends Rectangle{

    public int xVelocity;
    public int yVelocity;
    Random rand;
    private int speed = 1;

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

    public void increaseSpeed() {
        this.yVelocity++;
        this.xVelocity++;
    }

    public void setYDirection(int xDirection) {
        this.yVelocity = xDirection;
    }

    public void setXDirection(int yDirection) {
        this.xVelocity = yDirection;
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    

}