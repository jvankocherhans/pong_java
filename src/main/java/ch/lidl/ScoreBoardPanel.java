package ch.lidl;

// Dependencies
import java.util.*;
import java.util.stream.Collectors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScoreBoardPanel extends JPanel implements ActionListener {

    SaveScoreFile saveScoreFile;

    JButton returnBtn;

    private final int BTN_WIDTH = 300;
    static final int BTN_HEIGHT = 50;

    JLabel scoreBoardTitle;
    JLabel firstRank, secondRank, thirdRank, fourthRank, fifthRank;
    JLabel[] ranks = { firstRank, secondRank, thirdRank, fourthRank, fifthRank };

    public ScoreBoardPanel() {
        this.setFocusable(true);

        this.setLayout(null);
        this.setFocusable(true);
        this.setPreferredSize(PanelContainer.SCREEN_SIZE);
        this.setBackground(Color.BLACK);

        saveScoreFile = SaveScoreFile.getSaveScoreFileInstance();

        // Return to Menu
        returnBtn = new JButton();
        this.returnBtn.setBounds(50, 50, BTN_WIDTH, BTN_HEIGHT);
        this.returnBtn.addActionListener(this);
        this.returnBtn.setText("<- Return to menu");
        this.returnBtn.setBackground(Color.BLACK);
        this.returnBtn.setForeground(Color.WHITE);
        this.returnBtn.setFont(new Font("Consolas", Font.PLAIN, 20));
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

        this.validate();
        this.repaint();
    }

    private void displayPlayerScore() {
        HashMap<String, Integer> scores = saveScoreFile.getFileData();

        for (int i = 0; i < 5; i++) {
            int index;
            int maxValue = (int) scores.values().toArray()[0];

            for (int j = 0; i < scores.size(); i++) {
                if ((int) scores.values().toArray()[0] > maxValue) {
                    index = j;
                    maxValue = (int) scores.values().toArray()[0];
                }
            }
        }

    }

    @Override
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
