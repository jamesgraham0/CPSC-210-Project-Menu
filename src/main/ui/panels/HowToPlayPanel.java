package ui.panels;

import java.awt.*;
import javax.swing.*;
import ui.model.Game;

// Represents a panel that explains the instructions of how to play
public class HowToPlayPanel extends JPanel {

    private static final int LBL_WIDTH = 700;
    private static final int LBL_HEIGHT = 100;

    // Constructs a HowToPlayPanel
    public HowToPlayPanel(Game g) {
        setBackground(Color.black);

        JLabel howToPlayLabel = new JLabel("Use the up, down, left, and right keys to avoid "
                + "oncoming enemies and reach the other side of the screen!");
        howToPlayLabel.setForeground(Color.white);
        howToPlayLabel.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        howToPlayLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(howToPlayLabel);
    }
}
