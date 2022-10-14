package ch.lidl;

// Dependencies
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputPlayerNamePanel extends JPanel implements ActionListener {

    JLabel inputNameInfo = new JLabel();
    JLabel errorMessage = new JLabel();

    JButton exitBtn = new JButton();

    JTextField nameInput = new JTextField(20);

    public InputPlayerNamePanel() {
        this.setFocusable(true);
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

        // Input Information
        this.inputNameInfo.setBounds(PanelContainer.PANEL_WIDTH / 2 - 500, 300, 1000, 50);
        this.inputNameInfo.setText("Enter you name (keyboard) and press ENTER:");
        this.inputNameInfo.setHorizontalAlignment(SwingConstants.CENTER);
        this.inputNameInfo.setVerticalAlignment(SwingConstants.CENTER);
        this.inputNameInfo.setForeground(Color.WHITE);
        this.inputNameInfo.setFont(new Font("Consolas", Font.PLAIN, 25));
        this.inputNameInfo.setVisible(true);
        this.add(this.inputNameInfo);

        // Input Feld für Playername
        this.nameInput.setBounds(PanelContainer.PANEL_WIDTH / 2 - 250, PanelContainer.PANEL_HEIGHT / 2, 500, 90);
        this.nameInput.setFont(new Font("Consolas", Font.PLAIN, 40));
        this.nameInput.setForeground(Color.YELLOW);
        this.nameInput.setBackground(Color.BLACK);
        this.nameInput.addActionListener(this);
        this.add(this.nameInput);

        // Error Message
        this.errorMessage.setBounds(PanelContainer.PANEL_WIDTH / 2 - 250, PanelContainer.PANEL_HEIGHT - 150, 500, 50);
        this.errorMessage.setText("Invalid Name. Please choose a valid name.");
        this.errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
        this.errorMessage.setVerticalAlignment(SwingConstants.CENTER);
        this.errorMessage.setForeground(Color.RED);
        this.errorMessage.setFont(new Font("Consolas", Font.PLAIN, 20));
        this.errorMessage.setVisible(false);
        this.add(this.errorMessage);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == exitBtn) {
            Frame frame = Frame.getInstance();
            frame.remove(this);
            frame.add(PanelContainer.getMenuPanelInstance());
            frame.repaint();
            frame.validate();
        }

        if (e.getSource() == nameInput) {
            if (nameInput.getText().charAt(0) == 32 || nameInput.getText().charAt(nameInput.getText().length() - 1) == 32 || nameInput.getText().length() >= 15 || nameInput.getText() == null) {
                this.errorMessage.setVisible(true);
            } else {
                this.errorMessage.setVisible(false); 
                Frame frame = Frame.getInstance();
                frame.remove(this);
                frame.add(PanelContainer.getGamePanelInstance(nameInput.getText()));
                frame.repaint();
                frame.validate();
            }
        }
    }

}
