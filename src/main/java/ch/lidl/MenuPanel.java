package ch.lidl;

// Dependencies
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends JPanel implements ActionListener{

JLabel menuTitle = new JLabel();
Dimension menuTitleDimension = new Dimension(500, 500);

private final int BTN_WIDTH = 300;
static final int BTN_HEIGHT = 50;

JButton startGameBtn = new JButton();
JButton scoreBoardBtn = new JButton();
JButton exitBtn = new JButton();
JButton creditsBtn = new JButton();


    public MenuPanel() {

    this.setFocusable(true);
    
    this.setLayout(null);
    this.setFocusable(true);
    this.setPreferredSize(PanelContainer.SCREEN_SIZE);
    this.setBackground(Color.BLACK);   

    // Title-Config
    this.menuTitle.setText("PONG THE GAME");
    this.menuTitle.setHorizontalAlignment(SwingConstants.CENTER);
    this.menuTitle.setVerticalAlignment(SwingConstants.CENTER);
    this.menuTitle.setForeground(Color.WHITE);
    this.menuTitle.setFont(new Font("Consolas", Font.PLAIN, 60));
    this.menuTitle.setBounds(PanelContainer.PANEL_WIDTH / 2 - 250, 70, 500, 200);
    this.add(menuTitle);
    this.validate();
    this.repaint();
   
    // Start Game Button
    this.startGameBtn.setBounds(PanelContainer.PANEL_WIDTH / 2 - BTN_WIDTH  /2, 300, BTN_WIDTH, BTN_HEIGHT);
    this.startGameBtn.addActionListener(this);
    this.startGameBtn.setText("Start Game");
    this.startGameBtn.setBackground(Color.WHITE);
    this.startGameBtn.setForeground(Color.BLACK);
    this.startGameBtn.setFont(new Font("Consolas", Font.PLAIN, 20));
    this.startGameBtn.setVerticalAlignment(SwingConstants.CENTER);
    this.startGameBtn.setHorizontalAlignment(SwingConstants.CENTER);
    this.add(startGameBtn);
    
    // Scoreboard Button
    this.scoreBoardBtn.setBounds(PanelContainer.PANEL_WIDTH / 2 - BTN_WIDTH  /2, 300 + BTN_HEIGHT + 10, BTN_WIDTH, BTN_HEIGHT);
    this.scoreBoardBtn.addActionListener(this);
    this.scoreBoardBtn.setText("Scoreboard"); 
    this.scoreBoardBtn.setBackground(Color.WHITE);
    this.scoreBoardBtn.setForeground(Color.BLACK);
    this.scoreBoardBtn.setFont(new Font("Consolas", Font.PLAIN, 20));
    this.scoreBoardBtn.setVerticalAlignment(SwingConstants.CENTER);
    this.scoreBoardBtn.setHorizontalAlignment(SwingConstants.CENTER);
    this.add(scoreBoardBtn);

    // Credits Button
    this.creditsBtn.setBounds(PanelContainer.PANEL_WIDTH / 2 - BTN_WIDTH  /2, 300 + (BTN_HEIGHT * 2) + 20, BTN_WIDTH, BTN_HEIGHT);
    this.creditsBtn.addActionListener(this);
    this.creditsBtn.setText("Credits"); 
    this.creditsBtn.setBackground(Color.WHITE);
    this.creditsBtn.setForeground(Color.BLACK);
    this.creditsBtn.setFont(new Font("Consolas", Font.PLAIN, 20));
    this.creditsBtn.setVerticalAlignment(SwingConstants.CENTER);
    this.creditsBtn.setHorizontalAlignment(SwingConstants.CENTER);
    this.add(creditsBtn);

    // Exit Button
    this.exitBtn .setBounds(PanelContainer.PANEL_WIDTH / 2 - BTN_WIDTH  /2, 300 + (BTN_HEIGHT * 3) + 30, BTN_WIDTH, BTN_HEIGHT);
    this.exitBtn.addActionListener(this);
    this.exitBtn.setText("Exit"); 
    this.exitBtn.setBackground(Color.WHITE);
    this.exitBtn.setForeground(Color.BLACK);
    this.exitBtn.setFont(new Font("Consolas", Font.PLAIN, 20));
    this.exitBtn.setVerticalAlignment(SwingConstants.CENTER);
    this.exitBtn.setHorizontalAlignment(SwingConstants.CENTER);
    this.add(exitBtn );

    this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startGameBtn) {
            Frame frame = Frame.getInstance();
            frame.remove(this);
            frame.add(PanelContainer.getInputPlayerNamePanelInstance());
            frame.repaint();
            frame.validate();
        }
        
        if(e.getSource() == scoreBoardBtn) {

        }

        if(e.getSource() == creditsBtn) {

        } 

        if(e.getSource() == exitBtn) {
            Frame.exit();
        }
    }
}