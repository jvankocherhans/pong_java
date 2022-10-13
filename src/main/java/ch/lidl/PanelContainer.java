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

    // Singleton Instamnces
    private static MenuPanel menuPanel;
    private static GamePanel gamePanel;
    private static InputPlayerNamePanel inputPlayerNamePanel;
    private static RestartMenuPanel restartMenuPanel;

    public static MenuPanel getMenuPanelInstance() {
        menuPanel = new MenuPanel();
        return menuPanel;
    }

    public static GamePanel getGamePanelInstance(String playerName) {
        gamePanel = new GamePanel(playerName);
        return gamePanel;
    }

    public static InputPlayerNamePanel getInputPlayerNamePanelInstance() {
        inputPlayerNamePanel = new InputPlayerNamePanel();
        return inputPlayerNamePanel;
    }

    public static RestartMenuPanel getRestartMenuPanelInstance(String playerName) {
        restartMenuPanel = null;
        restartMenuPanel = new RestartMenuPanel(playerName);
        return restartMenuPanel;
    }

    private void killPanels() {

        menuPanel = null;
        inputPlayerNamePanel = null;
    }
}
