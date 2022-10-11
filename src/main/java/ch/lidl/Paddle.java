package ch.lidl;

// Dependencies
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle {

    private int id;
    private int yVelocity;
    private int speed = 2;

    public Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }

    public void keyPressed(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(-speed);
                    move();
                }

                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(speed);
                    move();
                }
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(0);
                    move();
                }

                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(0);
                    move();
                }
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