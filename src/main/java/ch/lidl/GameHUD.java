package ch.lidl;

// Dependencies
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameHUD {
    private static int GAME_WIDTH;
    private static int GAME_HEIGHT;
    public int playerscore;
    private String playerName;

    public GameHUD(int GAME_WIDTH, int GAME_HEIGHT, String playerName) {
        this.GAME_WIDTH = GAME_WIDTH;
        this.GAME_HEIGHT = GAME_HEIGHT;
        this.playerName = playerName;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.PLAIN, 25));
        g.drawString(String.valueOf("Score: " + this.playerscore), GAME_WIDTH -160, 50);
        g.drawString(String.valueOf("user: " + this.playerName), 20, 50);
    }
}