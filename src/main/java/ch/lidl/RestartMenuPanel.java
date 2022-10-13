package ch.lidl;

import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class RestartMenuPanel extends JPanel implements ActionListener {

JButton retryBtn = new JButton();
JButton returnBtn = new JButton();

JLabel gameOverText = new JLabel();
JLabel gameOverImg = new JLabel();

private final int BTN_WIDTH = 300;
static final int BTN_HEIGHT = 50;

private String playerName; 

    public RestartMenuPanel (String playerName) {

    this.playerName = playerName;
    
    this.setFocusable(true);

    this.setLayout(null);
    this.setFocusable(true);
    this.setPreferredSize(PanelContainer.SCREEN_SIZE);
    this.setBackground(Color.BLACK);   

    // Game Over Text
    this.gameOverText.setText("U DED!");
    this.gameOverText.setHorizontalAlignment(SwingConstants.CENTER);
    this.gameOverText.setVerticalAlignment(SwingConstants.CENTER);
    this.gameOverText.setForeground(Color.WHITE);
    this.gameOverText.setFont(new Font("Consolas", Font.PLAIN, 60));
    this.gameOverText.setBounds(PanelContainer.PANEL_WIDTH / 2 - 250, 70, 500, 200);
    this.add(gameOverText);

    this.setVisible(true);

    // Restart Button
    this.retryBtn.setBounds(PanelContainer.PANEL_WIDTH / 2 - BTN_WIDTH  /2, 300 + BTN_HEIGHT + 10, BTN_WIDTH, BTN_HEIGHT);
    this.retryBtn.addActionListener(this);
    this.retryBtn.setText("Retry"); 
    this.retryBtn.setBackground(Color.WHITE);
    this.retryBtn.setForeground(Color.BLACK);
    this.retryBtn.setFont(new Font("Consolas", Font.PLAIN, 20));
    this.retryBtn.setVerticalAlignment(SwingConstants.CENTER);
    this.retryBtn.setHorizontalAlignment(SwingConstants.CENTER);
    this.add(retryBtn);

    // Return Button
    this.returnBtn.setBounds(PanelContainer.PANEL_WIDTH / 2 - BTN_WIDTH  /2, 300 + (BTN_HEIGHT * 2) + 20, BTN_WIDTH, BTN_HEIGHT);
    this.returnBtn.addActionListener(this);
    this.returnBtn.setText("Return To Menu"); 
    this.returnBtn.setBackground(Color.WHITE);
    this.returnBtn.setForeground(Color.BLACK);
    this.returnBtn.setFont(new Font("Consolas", Font.PLAIN, 20));
    this.returnBtn.setVerticalAlignment(SwingConstants.CENTER);
    this.returnBtn.setHorizontalAlignment(SwingConstants.CENTER);
    this.add(returnBtn);
    }

	@Override
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
