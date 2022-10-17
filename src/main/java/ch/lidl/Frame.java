package ch.lidl;

// Dependencies
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Designpattern: Singleton
 */
public class Frame extends JFrame {
    
    // Member Variablen
    public static Frame frame;

    /**
     * Konstruktor der Frame-Klasse.
     */
    private Frame() {
        this.add(PanelContainer.getMenuPanelInstance());
        this.setTitle("Pong");
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    /**
     * Gibt die INstanz der eignen Klasse zurück
     * @return frame
     */
    public static Frame getInstance() {
        if(frame == null) {
            frame = new Frame();
        }
        return frame;
    }

    /**
     * Methode, welche das Fenster/Frame schliesst
     */
    public static void exit() {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

}
