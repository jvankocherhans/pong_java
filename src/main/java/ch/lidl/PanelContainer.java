package ch.lidl;

// Dependencies
import java.awt.*;
import javax.swing.JPanel;

/**
 * Design-Pattern: Singleton-Container
 */
public class PanelContainer extends JPanel {
    
    // Membervariablen
    static public final int PANEL_WIDTH = 1500;
    static public final int PANEL_HEIGHT = (int) (1500 * (0.55555));
    static public Dimension SCREEN_SIZE = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);

    // Singleton Instances
    private static MenuPanel menuPanel;
    private static GamePanel gamePanel;
    private static InputPlayerNamePanel inputPlayerNamePanel;
    private static RestartMenuPanel restartMenuPanel;
    private static ScoreBoardPanel scoreBoardPanel;
    private static CreditsPanel creditsPanel;

    /**
     * Menupanel Objekt wird instanzziert
     * @return menuPanel
     */
    public static MenuPanel getMenuPanelInstance() {
        killPanels();
        menuPanel = new MenuPanel();
        return menuPanel;
    }

    /**
     * getGamePanel Objekt wird instanzziert
     * @param playerName
     * @return gamePanel
     */
    public static GamePanel getGamePanelInstance(String playerName) {
        killPanels();
        gamePanel = new GamePanel(playerName);
        return gamePanel;
    }

    /**
     * getInputPlayerNamePanel wird instanzziert
     * @return inputPlayerNamePanel
     */
    public static InputPlayerNamePanel getInputPlayerNamePanelInstance() {
        killPanels();
        inputPlayerNamePanel = new InputPlayerNamePanel();
        return inputPlayerNamePanel;
    }

    /**
     * getRestartMenuPanel Objekt wird instanzziert
     * @param playerName
     * @param playerScore
     * @return restartMenuPanel
     */
    public static RestartMenuPanel getRestartMenuPanelInstance(String playerName, int playerScore) {
        killPanels();
        restartMenuPanel = new RestartMenuPanel(playerName, playerScore);
        return restartMenuPanel;
    }

    /**
     * scoreBoardPanel Objekt wird instanzziert
     * @return scoreBoardPanel
     */
    public static ScoreBoardPanel getScoreBoardPanelInstance() {
        killPanels();
        scoreBoardPanel = new ScoreBoardPanel();
        return scoreBoardPanel;
    }

    /**
     * creditsPanel Objekt wird instanzziert
     * @return creditsPanel
     */
    public static CreditsPanel getCreditsPanelInstance() {
        killPanels();
        creditsPanel = new CreditsPanel();
        return creditsPanel;
    }

    /**
     * Alle Instanzen der Objekte werden vernichtet
     */
    private static void killPanels() {
        menuPanel = null;
        inputPlayerNamePanel = null;
        gamePanel = null;
        restartMenuPanel = null;
        scoreBoardPanel = null;
        creditsPanel = null;
    }
}
