package ch.lidl;

// Dependencies
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score {
    private static int GAME_WIDTH;
    private static int GAME_HEIGHT;
    public int playerscore;

    public Score(int GAME_WIDTH, int GAME_HEIGHT) {
        this.GAME_WIDTH = GAME_WIDTH;
        this.GAME_HEIGHT = GAME_HEIGHT;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.PLAIN, 30));
        g.drawString(String.valueOf("Score: " + this.playerscore), GAME_WIDTH -180, 50);
    }
}