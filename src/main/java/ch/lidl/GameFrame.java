package ch.lidl;

// Dependencies
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameFrame extends JFrame {
    
    private GamePanel gamePanel;

    public GameFrame() {
        gamePanel = new GamePanel();

        this.add(gamePanel);
        this.setTitle("Pong");
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocation(null);
    }
}
