package panels;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.*;


import model.Game;
import model.Level;
import model.Player;


/*
 * Represents the panel in which the scoreboard is displayed.
 */
@SuppressWarnings("serial")
public class LevelsButtonPanel extends JPanel implements ActionListener {
    private Game game;
    private JButton levelOneButton;
    private JButton levelTwoButton;
    private JButton levelThreeButton;
    private Player player;
    public Level currentLevel;
    private GamePanel gamePanel;
    private MainMenuPanel mainMenuPanel;

    // Constructs a score panel
    // effects: sets the background colour and draws the initial labels;
    //          updates this with the game whose score is to be displayed
    public LevelsButtonPanel(Game g, MainMenuPanel m, GamePanel gamePanel) {
        game = g;
        setBackground(new Color(113, 113, 113));
        this.mainMenuPanel = m;
        this.gamePanel = gamePanel;
        levelOneButton = new JButton("Level 1");
        levelTwoButton = new JButton("Level 2");
        levelThreeButton = new JButton("Level 3");
        initializePlayer();
        makeLevelButtons();
    }

    public JButton getLevelOneButton() {
        return levelOneButton;
    }

    public JButton getLevelTwoButton() {
        return levelTwoButton;
    }

    public JButton getLevelThreeButton() {
        return levelThreeButton;
    }

    public void unlockLevelTwoButton() {
        levelTwoButton.setForeground(Color.black);
        levelTwoButton.setOpaque(true);
    }

    public void lockLevelTwoButton() {
        levelTwoButton.setForeground(Color.gray);
        levelTwoButton.setOpaque(false);
    }

    public void unlockLevelThreeButton() {
        levelThreeButton.setForeground(Color.black);
        levelThreeButton.setOpaque(true);
    }

    public void lockLevelThreeButton() {
        levelThreeButton.setForeground(Color.gray);
        levelThreeButton.setOpaque(false);
    }

    private void makeLevelButtons() {

        levelOneButton.addActionListener(this);
        levelOneButton.setLayout(null);
        levelOneButton.setActionCommand("one");
        levelOneButton.setPreferredSize(new Dimension(200, 200));
        levelOneButton.setOpaque(true);


        levelTwoButton.addActionListener(this);
        levelTwoButton.setLayout(null);
        levelTwoButton.setOpaque(false);

        if (player.getNamesAvailableLevels().contains("medium")) {
            levelTwoButton.setForeground(Color.black);
        } else {
            levelThreeButton.setForeground(Color.gray);
        }

        levelTwoButton.setForeground(Color.gray);
        levelTwoButton.setActionCommand("two");
        levelTwoButton.setPreferredSize(new Dimension(200, 200));


        levelThreeButton.addActionListener(this);
        levelThreeButton.setLayout(null);
        levelThreeButton.setOpaque(false);

        if (player.getNamesAvailableLevels().contains("hard")) {
            levelThreeButton.setForeground(Color.black);
        } else {
            levelThreeButton.setForeground(Color.gray);
        }

        levelThreeButton.setActionCommand("three");
        levelThreeButton.setPreferredSize(new Dimension(200, 200));

        add(levelOneButton);
        add(levelTwoButton);
        add(levelThreeButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("one".equals(e.getActionCommand())) {

            // BRINGS THE SPACE IMAGE FORWARD, WAITS A FEW SECONDS, AND SETS ITS VISIBILITY TO FALSE,
            // ALSO SETTING LEVEL TWO AS AN AVAILABLE LEVEL

//            mainMenuPanel.setVisible(false);
//            gamePanel.setVisible(true);

            mainMenuPanel.add(gamePanel);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
//            mainMenuPanel.remove(gamePanel);
            levelTwoButton.setOpaque(true);
            levelTwoButton.setForeground(Color.black);
            player.doLevel(player.level1);

        } else if ("two".equals(e.getActionCommand()) && player.getAvailableLevels().contains(player.level2)
                && levelTwoButton.isOpaque()) {

            mainMenuPanel.setVisible(false);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            mainMenuPanel.setVisible(true);
            levelThreeButton.setOpaque(true);
            levelThreeButton.setForeground(Color.black);
            player.doLevel(player.level2);

        } else if ("three".equals(e.getActionCommand()) && player.getAvailableLevels().contains(player.level3)
                && levelThreeButton.isOpaque()) {
            mainMenuPanel.setVisible(false);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            mainMenuPanel.setVisible(true);
            player.doLevel(player.level3);
        }
    }

    public void initializePlayer() {
        ArrayList<Level> empty1 = new ArrayList<>();
        ArrayList<Level> empty2 = new ArrayList<>();

        player = new Player(" ", " ", empty1, empty2);
    }

}