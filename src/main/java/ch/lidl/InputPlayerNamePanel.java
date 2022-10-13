package ch.lidl;

// Dependencies
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputPlayerNamePanel extends JPanel implements ActionListener {
    
    public InputPlayerNamePanel() {
    this.setFocusable(true);
    
    this.setLayout(null);
    this.setFocusable(true);
    this.setPreferredSize(PanelContainer.SCREEN_SIZE);
    this.setBackground(Color.BLACK);   

    this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
