package ch.lidl;

// Dependencies
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends JPanel implements ActionListener {

JLabel menuTitle = new JLabel();
Dimension menuTitleDimension = new Dimension(500, 500);

private final int BTN_WIDTH = 420;
static final int BTN_HEIGHT = 80;

private Ball ball;
static private final int BALL_DIAMETER = 20;

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
    this.menuTitle.setFont(new Font("Consolas", Font.PLAIN, 140));
    this.menuTitle.setBounds(PanelContainer.PANEL_WIDTH / 2 - 750, 150, 1500, 200);
    this.add(menuTitle);
    this.validate();
    this.repaint();
   
    // Start Game Button
    this.startGameBtn.setBounds(PanelContainer.PANEL_WIDTH / 2 - BTN_WIDTH  /2, 385, BTN_WIDTH, BTN_HEIGHT);
    this.startGameBtn.addActionListener(this);
    this.startGameBtn.setText("Start Game");
    this.startGameBtn.setBackground(Color.BLACK);
    this.startGameBtn.setForeground(Color.WHITE);
    this.startGameBtn.setFont(new Font("Consolas", Font.PLAIN, 30));
    this.startGameBtn.setVerticalAlignment(SwingConstants.CENTER);
    this.startGameBtn.setHorizontalAlignment(SwingConstants.CENTER);
    this.add(startGameBtn);
    
    // Scoreboard Button
    this.scoreBoardBtn.setBounds(PanelContainer.PANEL_WIDTH / 2 - BTN_WIDTH  /2, 380 + BTN_HEIGHT + 15, BTN_WIDTH, BTN_HEIGHT);
    this.scoreBoardBtn.addActionListener(this);
    this.scoreBoardBtn.setText("Scoreboard"); 
    this.scoreBoardBtn.setBackground(Color.BLACK);
    this.scoreBoardBtn.setForeground(Color.WHITE);
    this.scoreBoardBtn.setFont(new Font("Consolas", Font.PLAIN, 30));
    this.scoreBoardBtn.setVerticalAlignment(SwingConstants.CENTER);
    this.scoreBoardBtn.setHorizontalAlignment(SwingConstants.CENTER);
    this.add(scoreBoardBtn);

    // Credits Button
    this.creditsBtn.setBounds(PanelContainer.PANEL_WIDTH / 2 - BTN_WIDTH  /2, 380 + (BTN_HEIGHT * 2) + 25, BTN_WIDTH, BTN_HEIGHT);
    this.creditsBtn.addActionListener(this);
    this.creditsBtn.setText("Credits"); 
    this.creditsBtn.setBackground(Color.BLACK);
    this.creditsBtn.setForeground(Color.WHITE);
    this.creditsBtn.setFont(new Font("Consolas", Font.PLAIN, 30));
    this.creditsBtn.setVerticalAlignment(SwingConstants.CENTER);
    this.creditsBtn.setHorizontalAlignment(SwingConstants.CENTER);
    this.add(creditsBtn);

    // Exit Button
    this.exitBtn .setBounds(PanelContainer.PANEL_WIDTH / 2 - BTN_WIDTH  /2, 380 + (BTN_HEIGHT * 3) + 35, BTN_WIDTH, BTN_HEIGHT);
    this.exitBtn.addActionListener(this);
    this.exitBtn.setText("Exit"); 
    this.exitBtn.setBackground(Color.BLACK);
    this.exitBtn.setForeground(Color.WHITE);
    this.exitBtn.setFont(new Font("Consolas", Font.PLAIN, 30));
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
            Frame frame = Frame.getInstance();
            frame.remove(this);
            frame.add(PanelContainer.getScoreBoardPanelInstance());
            frame.repaint();
            frame.validate();
        }

        if(e.getSource() == creditsBtn) {
            Frame frame = Frame.getInstance();
            frame.remove(this);
            frame.add(PanelContainer.getCreditsPanelInstance());
            frame.repaint();
            frame.validate();
        } 

        if(e.getSource() == exitBtn) {
            Frame.exit();
        }
    }
    
}