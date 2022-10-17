package ch.lidl;

// Dependencies
import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScoreBoardPanel extends JPanel implements ActionListener {

    // Membervariablen
    private SaveScoreFile saveScoreFile;
    private JButton returnBtn;
    private final int BTN_WIDTH = 400;
    private  final int BTN_HEIGHT = 50;

    private JLabel scoreBoardTitle;
    private JLabel firstRank, secondRank, thirdRank, fourthRank, fifthRank;
    private JLabel[] ranks = { firstRank, secondRank, thirdRank, fourthRank, fifthRank };

    /**
     * Konstruktor der ScoreBoardPanel-Klasse
     */
    public ScoreBoardPanel() {
        this.setFocusable(true);

        this.setLayout(null);
        this.setFocusable(true);
        this.setPreferredSize(PanelContainer.SCREEN_SIZE);
        this.setBackground(Color.BLACK);

        saveScoreFile = SaveScoreFile.getSaveScoreFileInstance();

        // Return to Menu
        returnBtn = new JButton();
        this.returnBtn.setBounds(50, 50, 100, 100);
        this.returnBtn.addActionListener(this);
        this.returnBtn.setText("x");
        this.returnBtn.setBackground(Color.BLACK);
        this.returnBtn.setForeground(Color.WHITE);
        this.returnBtn.setBorder(null);
        this.returnBtn.setFocusPainted(false);
        this.returnBtn.setFont(new Font("Consolas", Font.PLAIN, 50));
        this.returnBtn.setVerticalAlignment(SwingConstants.CENTER);
        this.returnBtn.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(returnBtn);

        // Title-Config
        scoreBoardTitle = new JLabel();
        this.scoreBoardTitle.setText("Scoreboard");
        this.scoreBoardTitle.setHorizontalAlignment(SwingConstants.CENTER);
        this.scoreBoardTitle.setVerticalAlignment(SwingConstants.CENTER);
        this.scoreBoardTitle.setForeground(Color.WHITE);
        this.scoreBoardTitle.setFont(new Font("Consolas", Font.PLAIN, 60));
        this.scoreBoardTitle.setBounds(PanelContainer.PANEL_WIDTH / 2 - 250, 70, 500, 200);
        this.add(scoreBoardTitle);

        // Ranks
        this.ranks[0] = new JLabel();
        this.ranks[0].setText("1");
        this.ranks[0].setHorizontalAlignment(SwingConstants.CENTER);
        this.ranks[0].setVerticalAlignment(SwingConstants.CENTER);
        this.ranks[0].setForeground(Color.YELLOW);
        this.ranks[0].setFont(new Font("Consolas", Font.PLAIN, 40));
        this.ranks[0].setBounds(PanelContainer.PANEL_WIDTH / 2 - 250, 200, 500, 200);
        this.add(ranks[0]);

        this.ranks[1] = new JLabel();
        this.ranks[1].setText("2");
        this.ranks[1].setHorizontalAlignment(SwingConstants.CENTER);
        this.ranks[1].setVerticalAlignment(SwingConstants.CENTER);
        this.ranks[1].setForeground(Color.cyan);
        this.ranks[1].setFont(new Font("Consolas", Font.PLAIN, 40));
        this.ranks[1].setBounds(PanelContainer.PANEL_WIDTH / 2 - 250, 280, 500, 200);
        this.add(ranks[1]);

        this.ranks[2] = new JLabel();
        this.ranks[2].setText("3");
        this.ranks[2].setHorizontalAlignment(SwingConstants.CENTER);
        this.ranks[2].setVerticalAlignment(SwingConstants.CENTER);
        this.ranks[2].setForeground(Color.ORANGE);
        this.ranks[2].setFont(new Font("Consolas", Font.PLAIN, 40));
        this.ranks[2].setBounds(PanelContainer.PANEL_WIDTH / 2 - 250, 360, 500, 200);
        this.add(ranks[2]);

        this.ranks[3] = new JLabel();
        this.ranks[3].setText("4");
        this.ranks[3].setHorizontalAlignment(SwingConstants.CENTER);
        this.ranks[3].setVerticalAlignment(SwingConstants.CENTER);
        this.ranks[3].setForeground(Color.LIGHT_GRAY);
        this.ranks[3].setFont(new Font("Consolas", Font.PLAIN, 40));
        this.ranks[3].setBounds(PanelContainer.PANEL_WIDTH / 2 - 250, 500, 500, 200);
        this.add(ranks[3]);

        this.ranks[4] = new JLabel();
        this.ranks[4].setText("5");
        this.ranks[4].setHorizontalAlignment(SwingConstants.CENTER);
        this.ranks[4].setVerticalAlignment(SwingConstants.CENTER);
        this.ranks[4].setForeground(Color.LIGHT_GRAY);
        this.ranks[4].setFont(new Font("Consolas", Font.PLAIN, 40));
        this.ranks[4].setBounds(PanelContainer.PANEL_WIDTH / 2 - 250, 580, 500, 200);
        this.add(ranks[4]);

        displayPlayerScore();

        this.validate();
        this.repaint();
    }

    /**
     * Die Scores der Spieler werden ausgegeben und angezeigt, sofern mahr als 4 Spieler vorhanden sind.
     */
    private void displayPlayerScore() {
        HashMap<String, Integer> scores = saveScoreFile.getFileData();

        if(scores.size() >= 5) {
        for (int i = 0; i < 5; i++) {
            int index;
            int maxValue = (int) scores.values().toArray()[0];
            String key = (String) scores.keySet().toArray()[0];
            this.ranks[i].setText(key + ":" + maxValue);

            for (int j = 0; j < scores.size(); j++) {
                if ((int) scores.values().toArray()[j] > maxValue) {
                    index = j;
                    maxValue = (int) scores.values().toArray()[j];
                    key = (String) scores.keySet().toArray()[j];
                    this.ranks[i].setText(key + ":" + maxValue);
                }
            }
            scores.remove(key);
            this.validate();
            this.repaint();
        }
    }

    }

    @Override
    /**
     * Actionlistener Methode
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnBtn) {
            Frame frame = Frame.getInstance();
            frame.remove(this);
            frame.add(PanelContainer.getMenuPanelInstance());
            frame.repaint();
            frame.validate();
        }

    }

}
