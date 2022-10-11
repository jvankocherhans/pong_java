package ch.lidl;

// Dependencies
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ball extends Rectangle{

    public int xVelocity;
    public int yVelocity;
    public int speed = 2;

    public Ball(int x, int y, int width, int height) {
        super(x, y, width, height);
        setXDirection(1 * speed);
        setYDirection(-1 * speed);
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