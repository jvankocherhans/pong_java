package ch.lidl;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

public class PanelContainer extends JPanel {
    
    static public final int PANEL_WIDTH = 1500;
    static public final int PANEL_HEIGHT = (int) (1500 * (0.55555));
    static public Dimension SCREEN_SIZE = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);

    // Singleton Instamnces
    private static MenuPanel menuPanel;
    private static GamePanel gamePanel;
    private static InputPlayerNamePanel inputPlayerNamePanel;
    private static RestartMenuPanel restartMenuPanel;
    private static ScoreBoardPanel scoreBoardPanel;

    public static MenuPanel getMenuPanelInstance() {
        killPanels();
        menuPanel = new MenuPanel();
        return menuPanel;
    }

    public static GamePanel getGamePanelInstance(String playerName) {
        killPanels();
        gamePanel = new GamePanel(playerName);
        return gamePanel;
    }

    public static InputPlayerNamePanel getInputPlayerNamePanelInstance() {
        killPanels();
        inputPlayerNamePanel = new InputPlayerNamePanel();
        return inputPlayerNamePanel;
    }

    public static RestartMenuPanel getRestartMenuPanelInstance(String playerName) {
        killPanels();
        restartMenuPanel = new RestartMenuPanel(playerName);
        return restartMenuPanel;
    }

    public static ScoreBoardPanel getScoreBoardPanelInstance() {
        killPanels();
        scoreBoardPanel = new ScoreBoardPanel();
        return scoreBoardPanel;
    }

    private static void killPanels() {
        menuPanel = null;
        inputPlayerNamePanel = null;
        gamePanel = null;
        restartMenuPanel = null;
        scoreBoardPanel = null;
    }
}
