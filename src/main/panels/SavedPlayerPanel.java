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
public class SavedPlayerPanel extends JPanel {
    private String nameText = "Name: ";
    private String colorText = "Color: ";
    private JTextField nameTextBox;
    private JTextField colorTextBox;

//    private String availableLevelsText = "Available Levels: ";
//    private String lockedLevelsText = "Locked Levels: ";
//    private String currentPlayerText = "Current Player: ";
    private static final int LBL_WIDTH = 200;
    private static final int LBL_HEIGHT = 50;
    private Game game;
    private JLabel nameLabel;
    private JLabel colorLabel;
    private JLabel availableLevelsLabel;
    private JLabel lockedLevelsLabel;
    private JLabel currentPlayerLabel;
    private Player player;

    // Constructs a score panel
    // effects: sets the background colour and draws the initial labels;
    //          updates this with the game whose score is to be displayed
    public SavedPlayerPanel(Game g) {
        this.game = g;
        setBackground(new Color(109, 192, 236, 255));

        currentPlayerLabel = new JLabel("Current Player: ");
        currentPlayerLabel.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        currentPlayerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        nameTextBox = new JTextField(5);
        nameLabel = new JLabel(nameText);
        nameLabel.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        colorTextBox = new JTextField(5);
        colorLabel = new JLabel(colorText);
        colorLabel.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        colorLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(currentPlayerLabel);
        add(nameLabel);
        add(nameTextBox);
        add(colorLabel);
        add(colorTextBox);

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

    public String getNameTextBox() {
        return nameTextBox.getText();
    }

    public String getColorTextBox() {
        return colorTextBox.getText();
    }

    public void setNameTextBox(String s) {
        nameTextBox.setText(s);
    }

    public void setColorTextBox(String s) {
        colorTextBox.setText(s);
    }

}