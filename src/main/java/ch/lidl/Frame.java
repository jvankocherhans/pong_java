package ch.lidl;

// Dependencies
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame {
    
    public static Frame frame;

    private GamePanel gamePanel;

    private Frame() {
        MenuPanel m = new MenuPanel();

        this.add(PanelContainer.gRestartMenuInstance());
        this.setTitle("Pong");
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static Frame getInstance() {
        if(frame == null) {
            frame = new Frame();
        }
        return frame;
    }

    public static void exit() {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

}
