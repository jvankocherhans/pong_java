package ch.lidl;

// Dependencies
import java.awt.*;

public class GameHUD {

    // Membervariablen
    private static int GAME_WIDTH;
    private static int GAME_HEIGHT;
    public int playerscore;
    private String playerName;

    /**
     * Konstruktor, der GameHud-Klasse
     * @param GAME_WIDTH
     * @param GAME_HEIGHT
     * @param playerName
     */
    public GameHUD(int GAME_WIDTH, int GAME_HEIGHT, String playerName) {
        this.GAME_WIDTH = GAME_WIDTH;
        this.GAME_HEIGHT = GAME_HEIGHT;
        this.playerName = playerName;
    }

    /**
     * Methode zeichnet die Grafiken des GameHuds
     * @param g
     */
    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.setFont(new Font("Consolas", Font.PLAIN, 25));
        g.drawString(String.valueOf("score: " + this.playerscore), GAME_WIDTH -160, 50);
        g.drawString(String.valueOf("user: " + this.playerName), 40, 50);
        if (playerscore < 1) {
            g.setColor(Color.YELLOW);
            g.drawString(String.valueOf("Betätige X und B um den Spieler zu steuern!"), GAME_WIDTH / 4 + 80, GAME_HEIGHT / 2);
        }
    }
}