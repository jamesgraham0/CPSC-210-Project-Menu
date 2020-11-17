package panels;

import model.Game;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


import model.Game;
import model.Level;
import model.Player;

import javax.swing.*;
import java.awt.*;

/*
 * Represents the panel in which the scoreboard is displayed.
 */
@SuppressWarnings("serial")
public class NullExceptionPanel extends JPanel {

    private static final int LBL_WIDTH = 700;
    private static final int LBL_HEIGHT = 100;
    private Game game;
    private JLabel nullExceptionLabel;

    // Constructs a score panel
    // effects: sets the background colour and draws the initial labels;
    //          updates this with the game whose score is to be displayed
    public NullExceptionPanel(Game g) {
        this.game = g;
        setBackground(Color.darkGray);

        nullExceptionLabel = new JLabel("Please enter a name and color");
        nullExceptionLabel.setForeground(Color.red);
        nullExceptionLabel.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        nullExceptionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(nullExceptionLabel);
    }
}
