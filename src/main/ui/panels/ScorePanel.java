package ui.panels;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


import ui.Game;
import model.Player;


/*
 * Represents the panel in which the current player's name and number of deaths
 * are displayed while playing the game
 */
public class ScorePanel extends JPanel implements ActionListener {
    private String nameText = "Name: ";
    private String deathsText = "Deaths: ";
    private static final int LBL_WIDTH = 200;
    private static final int LBL_HEIGHT = 50;
    private final JLabel nameLabel;
    private JLabel deathsLabel;
    private GamePanel gamePanel;
    private Player player;

    // Constructs a score panel
    // effects: sets the background colour and draws the initial labels;
    //          updates this with the game whose score is to be displayed
    public ScorePanel(Game g) {
        setBackground(new Color(236, 217, 217));
        setOpaque(true);

        nameLabel = new JLabel(nameText);
        nameLabel.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));

        addBackButton();
        add(nameLabel);
    }

    // Updates the score panel
    // modifies: this
    // effects:  updates the score panel with players' name and number of times they've died
    public void update() {
        nameLabel.setText(nameText + player.getPlayerName());
        deathsLabel.setText(deathsText + player.deathCount);
        repaint();
    }

    public void setNameText(String s) {
        nameText = "Name: " + s;
    }

    public void setDeathsText(int s) {
        deathsText = "Deaths: " + s;
    }

    // modifies: this
    // effects: adds the back button to the score panel
    public void addBackButton() {
        JButton backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setActionCommand("back");

        add(backButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("back".equals(e.getActionCommand())) {
//            mainMenuPanel.setVisible(false);
        }
    }
}
