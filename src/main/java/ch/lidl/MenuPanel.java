package ch.lidl;

// Dependencies
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends JPanel implements ActionListener{

JLabel menuTitle = new JLabel("TEEEEEST", JLabel.CENTER);
Dimension menuTitleDimension = new Dimension(500, 500);

private final int BTN_WIDTH = 300;
static final int BTN_HEIGHT = 50;

JButton startGameBtn = new JButton();
JButton scoreBoardBtn = new JButton();
JButton exitBtn = new JButton();
JButton creditsBtn = new JButton();


    public MenuPanel() {
    this.setLayout(null);
    this.setFocusable(true);
    this.setPreferredSize(PanelContainer.SCREEN_SIZE);
    this.setBackground(Color.gray);   

    // Title-Config
    menuTitle.setAlignmentX(0);
    menuTitle.setAlignmentY(0);
    this.add(menuTitle);
    this.validate();
    this.repaint();
   
    // Start Game Button
    this.startGameBtn.setBounds(PanelContainer.PANEL_WIDTH / 2 - BTN_WIDTH  /2, 300, BTN_WIDTH, BTN_HEIGHT);
    this.startGameBtn.addActionListener(this);
    this.startGameBtn.setText("Start Game");
    this.add(startGameBtn);
    
    // Scoreboard Button
    this.scoreBoardBtn.setBounds(PanelContainer.PANEL_WIDTH / 2 - BTN_WIDTH  /2, 300 + BTN_HEIGHT + 10, BTN_WIDTH, BTN_HEIGHT);
    this.scoreBoardBtn.addActionListener(this);
    this.scoreBoardBtn.setText("Scoreboard"); 
    this.add(scoreBoardBtn);

    // Credits Button
    this.creditsBtn.setBounds(PanelContainer.PANEL_WIDTH / 2 - BTN_WIDTH  /2, 300 + (BTN_HEIGHT * 2) + 20, BTN_WIDTH, BTN_HEIGHT);
    this.creditsBtn.addActionListener(this);
    this.creditsBtn.setText("Credits"); 
    this.add(creditsBtn);

    // Exit Button
    this.exitBtn .setBounds(PanelContainer.PANEL_WIDTH / 2 - BTN_WIDTH  /2, 300 + (BTN_HEIGHT * 3) + 30, BTN_WIDTH, BTN_HEIGHT);
    this.exitBtn.addActionListener(this);
    this.exitBtn.setText("Exit"); 
    this.add(exitBtn );

    this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startGameBtn) {
            
        }
        
    }
}