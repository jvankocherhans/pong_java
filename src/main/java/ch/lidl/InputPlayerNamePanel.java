package ch.lidl;

// Dependencies
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputPlayerNamePanel extends JPanel implements ActionListener {

    JLabel errorMessage = new JLabel();

    JTextField nameInput = new JTextField(20);

    public InputPlayerNamePanel() {
        this.setFocusable(true);
        this.setLayout(null);
        this.setFocusable(true);
        this.setPreferredSize(PanelContainer.SCREEN_SIZE);
        this.setBackground(Color.BLACK);

        // Input Feld für Playername
        this.nameInput.setBounds(PanelContainer.PANEL_WIDTH / 2 - 200, PanelContainer.PANEL_HEIGHT / 2, 400, 50);
        this.nameInput.setFont(new Font("Consolas", Font.PLAIN, 40));
        this.nameInput.addActionListener(this);
        this.add(this.nameInput);

        // Error Message
        this.errorMessage.setBounds(PanelContainer.PANEL_WIDTH / 2 - 150, PanelContainer.PANEL_HEIGHT - 150, 300, 50);
        this.errorMessage.setText("Invalid Name. Please be normal ;)");
        this.errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
        this.errorMessage.setVerticalAlignment(SwingConstants.CENTER);
        this.errorMessage.setForeground(Color.RED);
        this.errorMessage.setFont(new Font("Consolas", Font.PLAIN, 15));
        this.errorMessage.setVisible(false);
        this.add(this.errorMessage);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nameInput) {
            if (nameInput.getText().charAt(0) == 32 || nameInput.getText().charAt(nameInput.getText().length() - 1) == 32 || nameInput.getText().length() >= 15) {
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
