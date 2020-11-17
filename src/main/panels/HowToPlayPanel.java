package panels;


import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


import model.Game;
import model.Level;
import model.Player;


/*
 * Represents the panel in which the scoreboard is displayed.
 */
@SuppressWarnings("serial")
public class HowToPlayPanel extends JPanel {

    private static final int LBL_WIDTH = 700;
    private static final int LBL_HEIGHT = 100;
    private Game game;
    private JLabel howToPlayLabel;

    // Constructs a score panel
    // effects: sets the background colour and draws the initial labels;
    //          updates this with the game whose score is to be displayed
    public HowToPlayPanel(Game g) {
        this.game = g;
        setBackground(Color.darkGray);

        howToPlayLabel = new JLabel("Use the up, down, left, and right keys to avoid "
                + "oncoming enemies and reach the other side of the screen!");
        howToPlayLabel.setForeground(Color.white);
        howToPlayLabel.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        howToPlayLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(howToPlayLabel);
    }
}
