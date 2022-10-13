package ch.lidl;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RestartMenu extends JPanel implements ActionListener {

JButton retryBtn = new JButton();
JButton returnBtn = new JButton();

JLabel gameOverText = new JLabel();
JLabel gameOverImg = new JLabel();

    public RestartMenu () {

    this.setFocusable(true);
    
    this.setLayout(null);
    this.setFocusable(true);
    this.setPreferredSize(PanelContainer.SCREEN_SIZE);
    this.setBackground(Color.BLACK);   

    // Game Over Text
    this.gameOverText.setText("U DED!");
    // this.gameOverText

    // Game Over img
    this.gameOverImg.setIcon(new ImageIcon("gameover.png"));
    // this.gameOverImg.setBounds(PanelContainer.PANEL_WIDTH / 2 - 250, 70, 500, 200);

    this.add(gameOverImg);
    this.validate();

    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    
}
