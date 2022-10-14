package ch.lidl;

// Dependencies
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;


public class CreditsPanel extends JPanel implements ActionListener {

    JLabel reneInstaQR = new JLabel(new ImageIcon("reneInsta.png"));
    JLabel jvanGitHubQR = new JLabel(new ImageIcon("s3rp3ntGitHub.png"));

    JLabel reneInstaText = new JLabel("Instagram / René");
    JLabel jvanGitHubText = new JLabel("GitHub / Jvan");

    JButton exitBtn = new JButton();

    public CreditsPanel() {
        this.setLayout(null);
        this.setFocusable(true);
        this.setPreferredSize(PanelContainer.SCREEN_SIZE);
        this.setBackground(Color.BLACK);

        // Exit Button
        this.exitBtn.setBounds(50, 50, 100, 100);
        this.exitBtn.addActionListener(this);
        this.exitBtn.setText("X");
        this.exitBtn.setBackground(Color.BLACK);
        this.exitBtn.setForeground(Color.WHITE);
        this.exitBtn.setBorder(null);
        this.exitBtn.setFont(new Font("Consolas", Font.PLAIN, 50));
        this.exitBtn.setVerticalAlignment(SwingConstants.CENTER);
        this.exitBtn.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(exitBtn);

        // QR Code
        this.reneInstaQR.setBounds(PanelContainer.PANEL_WIDTH / 2 + 200, PanelContainer.PANEL_HEIGHT / 8, 300, 300);
        this.jvanGitHubQR.setBounds(PanelContainer.PANEL_WIDTH / 2 + 200, PanelContainer.PANEL_HEIGHT / 2, 300, 300);

        this.reneInstaText.setBounds(200, PanelContainer.PANEL_HEIGHT / 8, 600, 300);
        this.reneInstaText.setFont(new Font("Consolas", Font.BOLD, 50));
        this.reneInstaText.setForeground(Color.WHITE);
        this.jvanGitHubText.setBounds(200, PanelContainer.PANEL_HEIGHT / 2, 600, 300);
        this.jvanGitHubText.setFont(new Font("Consolas", Font.BOLD, 50));
        this.jvanGitHubText.setForeground(Color.WHITE);

        this.add(reneInstaQR);
        this.add(reneInstaText);
        this.add(jvanGitHubText);
        this.add(jvanGitHubQR);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitBtn) {
            Frame frame = Frame.getInstance();
            frame.remove(this);
            frame.add(PanelContainer.getMenuPanelInstance());
            frame.repaint();
            frame.validate();
        }

    }

}
