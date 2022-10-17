package ch.lidl;

// Dependencies
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RestartMenuPanel extends JPanel implements ActionListener {

// Membervariablen
private JButton retryBtn = new JButton();
private JButton returnBtn = new JButton();

private JLabel gameOverText = new JLabel();
private JLabel scoreText = new JLabel();

private final int BTN_WIDTH = 420;
private final int BTN_HEIGHT = 80;

private String playerName; 

    /**
     * Konstruktor der RestartMenuPanel-Klasse
     * @param playerName
     * @param playerScore
     */
    public RestartMenuPanel (String playerName, int playerScore) {

    this.playerName = playerName;
    
    this.setFocusable(true);

    this.setLayout(null);
    this.setFocusable(true);
    this.setPreferredSize(PanelContainer.SCREEN_SIZE);
    this.setBackground(Color.BLACK);   

    // Game Over Text
    this.gameOverText.setText("You failed " + playerName + "! ;(");
    this.gameOverText.setHorizontalAlignment(SwingConstants.CENTER);
    this.gameOverText.setVerticalAlignment(SwingConstants.CENTER);
    this.gameOverText.setForeground(Color.WHITE);
    this.gameOverText.setFont(new Font("Consolas", Font.PLAIN, 60));
    this.gameOverText.setBounds(PanelContainer.PANEL_WIDTH / 2 - 400, 70, 800, 200);
    this.add(gameOverText);

    // Score Text
    this.scoreText.setText("Score : " + playerScore);
    this.scoreText.setHorizontalAlignment(SwingConstants.CENTER);
    this.scoreText.setVerticalAlignment(SwingConstants.CENTER);
    this.scoreText.setForeground(Color.CYAN);
    this.scoreText.setFont(new Font("Consolas", Font.PLAIN, 40));
    this.scoreText.setBounds(PanelContainer.PANEL_WIDTH / 2 - 400, 250, 800, 200);
    this.add(scoreText);

    // Restart Button
    this.retryBtn.setBounds(PanelContainer.PANEL_WIDTH / 2 - BTN_WIDTH  /2, 400 + BTN_HEIGHT + 10, BTN_WIDTH, BTN_HEIGHT);
    this.retryBtn.addActionListener(this);
    this.retryBtn.setText("Retry"); 
    this.retryBtn.setBackground(Color.BLACK);
    this.retryBtn.setForeground(Color.WHITE);
    this.retryBtn.setFont(new Font("Consolas", Font.PLAIN, 30));
    this.retryBtn.setVerticalAlignment(SwingConstants.CENTER);
    this.retryBtn.setHorizontalAlignment(SwingConstants.CENTER);
    this.add(retryBtn);

    // Return Button
    this.returnBtn.setBounds(PanelContainer.PANEL_WIDTH / 2 - BTN_WIDTH  /2, 400 + (BTN_HEIGHT * 2) + 20, BTN_WIDTH, BTN_HEIGHT);
    this.returnBtn.addActionListener(this);
    this.returnBtn.setText("Return To Menu"); 
    this.returnBtn.setBackground(Color.BLACK);
    this.returnBtn.setForeground(Color.WHITE);
    this.returnBtn.setFont(new Font("Consolas", Font.PLAIN, 30));
    this.returnBtn.setVerticalAlignment(SwingConstants.CENTER);
    this.returnBtn.setHorizontalAlignment(SwingConstants.CENTER);
    this.add(returnBtn);
    }

	@Override
    /**
     * Actionlistener Methode
     */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == retryBtn) {
            Frame frame = Frame.getInstance();
            frame.remove(this);
            frame.add(PanelContainer.getGamePanelInstance(this.playerName));
            frame.repaint();
            frame.validate();
        }
		
        if (e.getSource() == returnBtn) {
            Frame frame = Frame.getInstance();
            frame.remove(this);
            frame.add(PanelContainer.getMenuPanelInstance());
            frame.repaint();
            frame.validate();
        }
	}
    
}
