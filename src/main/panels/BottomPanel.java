package panels;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


import model.Game;
import model.Player;


/*
 * Represents the panel in which the scoreboard is displayed.
 */
@SuppressWarnings("serial")
public class BottomPanel extends JPanel implements ActionListener {
    private String nameText = "Name: ";
    private String deathsText = "Deaths: ";
    private static final int LBL_WIDTH = 200;
    private static final int LBL_HEIGHT = 50;
    private Game game;
    private JLabel nameLabel;
    private JLabel deathsLabel;
    private JButton backButton;
    private GamePanel gamePanel;
    private Player player;

    // Constructs a score panel
    // effects: sets the background colour and draws the initial labels;
    //          updates this with the game whose score is to be displayed
    public BottomPanel(Game g) {
        game = g;
        setBackground(new Color(236, 217, 217));
        setOpaque(true);

        nameLabel = new JLabel(nameText);
        nameLabel.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));

        addBackButton();
        add(nameLabel);
    }

    // Updates the score panel
    // modifies: this
    // effects:  updates number of invaders shot and number of missiles
    //           remaining to reflect current state of game
    public void update() {
        nameLabel.setText(nameText + player.getPlayerName());
        deathsLabel.setText(deathsText + Game.getDeathCount());
        repaint();
    }

    public void setNameText(String s) {
        nameText = "Name: " + s;
    }

    public void setDeathsText(int s) {
        deathsText = "Deaths: " + s;
    }

    public void addBackButton() {
        backButton = new JButton("Back");
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
