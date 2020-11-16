package panels;


import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;


import model.Game;
import model.Level;
import model.Player;


/*
 * Represents the panel in which the scoreboard is displayed.
 */
@SuppressWarnings("serial")
public class SavedPlayerPanel extends JPanel {
    private String nameText = "Name: ";
    private String colorText = "Color: ";
    private String availableLevelsText = "Available Levels: ";
    private String lockedLevelsText = "Locked Levels: ";
    private static final int LBL_WIDTH = 50;
    private static final int LBL_HEIGHT = 200;
    private Game game;
    private JLabel nameLabel;
    private JLabel colorLabel;
    private JLabel availableLevelsLabel;
    private JLabel lockedLevelsLabel;
    private Player player;

    // Constructs a score panel
    // effects: sets the background colour and draws the initial labels;
    //          updates this with the game whose score is to be displayed
    public SavedPlayerPanel(Game g) {
        game = g;
        setBackground(new Color(217, 217, 140));
        nameLabel = new JLabel(nameText + Player.getPlayerName());
        nameLabel.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));

        colorLabel = new JLabel(colorText + Player.getColor());
        colorLabel.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));

//        availableLevelsLabel = new JLabel(availableLevelsText + player.getAvailableLevels());
//        availableLevelsLabel.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));

//        lockedLevelsLabel = new JLabel(lockedLevelsText + player.getLockedLevels());
//        lockedLevelsLabel.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        add(nameLabel);
        add(colorLabel);
//        add(availableLevelsLabel);
//        add(lockedLevelsLabel);
        add(Box.createHorizontalStrut(10));
//        add(deaths);
    }

    // Updates the score panel
    // modifies: this
    // effects:  updates number of invaders shot and number of missiles
    //           remaining to reflect current state of game
    public void update() {
//        nameLabel.setText(nameText + Player.getPlayerName());
//        colorLabel.setText(colorText + Player.getColor());
//        availableLevelsLabel.setText(availableLevelsText + Player.getAvailableLevels());
//        lockedLevelsLabel.setText(lockedLevelsText + Player.getLockedLevels());
        repaint();
    }

    public void setNameText(String s) {
        nameText = "Name: " + s;
    }

    public void setColorText(String color) {
        colorText = "Color: " + color;
    }

    public void setAvailableLevels(ArrayList<Level> availableLevels) {
        availableLevelsText = "Available Levels: " + availableLevels;
    }

    public void setLockedLevels(ArrayList<Level> lockedLevels) {
    }
}