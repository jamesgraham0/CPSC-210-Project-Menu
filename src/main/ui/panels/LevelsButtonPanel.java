package ui.panels;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import ui.Game;
import model.Level;
import model.Player;


// Represents the Levels Button Panel where all levels are displayed
public class LevelsButtonPanel extends JPanel implements ActionListener {
    private final JButton levelOneButton;
    private final JButton levelTwoButton;
    private final JButton levelThreeButton;
    private Player player;
    public Level currentLevel;
    private final MainMenuPanel mainMenuPanel;

    // Constructs a LevelsButtonPanel
    // effects: sets the background, initializes player, and makes level buttons
    public LevelsButtonPanel(Game g, MainMenuPanel m, GamePanel gamePanel) {
        setBackground(new Color(113, 113, 113));
        this.mainMenuPanel = m;
        levelOneButton = new JButton("Level 1");
        levelTwoButton = new JButton("Level 2");
        levelThreeButton = new JButton("Level 3");
        initializePlayer();
        addLevelButtons();
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

    // modifies: this
    // effects: unlocks this button
    public void unlockLevelTwoButton() {
        levelTwoButton.setForeground(Color.black);
        levelTwoButton.setOpaque(true);
        levelTwoButton.setBackground(new Color(0xFADC52));
    }

    // modifies: this
    // effects: locks this button
    public void lockLevelTwoButton() {
        levelTwoButton.setForeground(Color.gray);
        levelTwoButton.setOpaque(false);
    }

    // modifies: this
    // effects: unlocks this button
    public void unlockLevelThreeButton() {
        levelThreeButton.setForeground(Color.black);
        levelThreeButton.setOpaque(true);
        levelThreeButton.setBackground(new Color(0xF31B3B));
    }

    // modifies: this
    // effects: locks this button
    public void lockLevelThreeButton() {
        levelThreeButton.setForeground(Color.gray);
        levelThreeButton.setOpaque(false);
    }

    // modifies: this
    // effects: sets up and adds the three level buttons to the panel
    private void addLevelButtons() {

        setupLevelOneButton();
        setupLevelTwoButton();
        setupLevelThreeButton();

        add(levelOneButton);
        add(levelTwoButton);
        add(levelThreeButton);
    }

    // modifies: this
    // effects: sets up level three button
    private void setupLevelThreeButton() {
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
    }

    // modifies: this
    // effects: sets up level two button
    private void setupLevelTwoButton() {
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
    }

    // modifies: this
    // effects: sets up level one button
    private void setupLevelOneButton() {
        levelOneButton.setBackground(new Color(0x4AEF4A));
        levelOneButton.addActionListener(this);
        levelOneButton.setLayout(null);
        levelOneButton.setActionCommand("one");
        levelOneButton.setPreferredSize(new Dimension(200, 200));
        levelOneButton.setOpaque(true);
    }

    // modifies: this
    // effects: sleeps the thread for time
    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // modifies: this
    // effects: if a level button is pressed, player does the level and returns to the main menu
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("one".equals(e.getActionCommand())) {
            mainMenuPanel.clearPanelsAndButtons();

            levelTwoButton.setOpaque(true);
            levelTwoButton.setForeground(Color.black);
            player.doLevel(player.level1);

            if (player.getNamesAvailableLevels().contains("medium")) {
                levelTwoButton.setBackground(new Color(0xFADC52));
            }

            mainMenuPanel.getGamePanel().setVisible(true);

        } else if ("two".equals(e.getActionCommand()) && player.getAvailableLevels().contains(player.level2)
                && levelTwoButton.isOpaque()) {
            mainMenuPanel.clearPanelsAndButtons();

            levelThreeButton.setOpaque(true);
            levelThreeButton.setForeground(Color.black);
            player.doLevel(player.level2);

            if (player.getNamesAvailableLevels().contains("hard")) {
                levelThreeButton.setBackground(new Color(0xF31B3B));
            }

        } else if ("three".equals(e.getActionCommand()) && player.getAvailableLevels().contains(player.level3)
                && levelThreeButton.isOpaque()) {
            mainMenuPanel.clearPanelsAndButtons();
            player.doLevel(player.level3);
        }
    }

    // modifies: this
    // effects: initializes a player
    public void initializePlayer() {
        ArrayList<Level> empty1 = new ArrayList<>();
        ArrayList<Level> empty2 = new ArrayList<>();

        player = new Player(" ", " ", empty1, empty2);
    }


}