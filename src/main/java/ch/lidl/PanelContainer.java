package ch.lidl;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

public class PanelContainer extends JPanel {
    
    static public final int PANEL_WIDTH = 1000;
    static public final int PANEL_HEIGHT = (int) (1000 * (0.55555));
    static public Dimension SCREEN_SIZE = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);

    public static MenuPanel getMenuPanelInstance() {
        return new MenuPanel();
    }

    public static GamePanel getGamePanelInstance(String playerName) {
        return new GamePanel(playerName);
    }

    public static InputPlayerNamePanel getInputPlayerNamePanelInstance() {
        return new InputPlayerNamePanel();
    }

    public static RestartMenu getRestartMenuInstance() {
        return new RestartMenu();
    }
}
