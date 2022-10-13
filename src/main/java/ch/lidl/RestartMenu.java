package ch.lidl;

import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

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
    this.gameOverText.setBounds(100, 100, 100, 100);
    

    // this.gameOverImg.setBounds(PanelContainer.PANEL_WIDTH / 2 - 250, 70, 500, 200);

    this.add(gameOverText);
    this.validate();

    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    
}
