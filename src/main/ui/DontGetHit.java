package ui;

import model.Game;

import panels.GamePanel;
import panels.BottomPanel;
import panels.MainMenuPanel;
import panels.SavedPlayerPanel;
import java.awt.BorderLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

/*
 * Represents the main window in which the space invaders
 * game is played
 */
@SuppressWarnings("serial")
public class DontGetHit extends JFrame {

    private static final int INTERVAL = 20;
    private Game game;
    private MainMenuPanel mainMenuPanel;
    private BottomPanel bottomPanel;
    private GamePanel gamePanel;
    private SavedPlayerPanel savedPlayerPanel;


    // Constructs main window
    // effects: sets up window in which Space Invaders game will be played
    public DontGetHit() {
        super("Don't Get Hit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game = new Game();

        initialize();
        addKeyListener(new KeyHandler());
        pack();
        centreOnScreen();
        setVisible(true);
        addTimer();
    }

    private void initialize() {
        mainMenuPanel = new MainMenuPanel(game);
        add(mainMenuPanel, BorderLayout.NORTH);
        JButton levelOneButton = new JButton("Level 1");
        levelOneButton.setLayout(null);
        levelOneButton.setLocation(Game.WIDTH / 2, Game.HEIGHT / 2);
//        levelOneButton.addActionListener(this);
        levelOneButton.setActionCommand("one");
        levelOneButton.setPreferredSize(new Dimension(100, 100));
//        add(levelOneButton, BorderLayout.LINE_START);

        JButton levelTwoButton = new JButton("Level 2");
        levelTwoButton.setLayout(null);
        levelTwoButton.setLocation(Game.WIDTH / 2, Game.HEIGHT / 2);
//        levelOneButton.addActionListener(this);
        levelTwoButton.setActionCommand("two");
        levelTwoButton.setPreferredSize(new Dimension(100, 100));
//        add(levelTwoButton, BorderLayout.LINE_START);

        JButton levelThreeButton = new JButton("Level 3");
        levelThreeButton.setLayout(null);
        levelThreeButton.setLocation(Game.WIDTH / 2, Game.HEIGHT / 2);
//        levelOneButton.addActionListener(this);
        levelThreeButton.setActionCommand("three");
        levelThreeButton.setPreferredSize(new Dimension(100, 100));
//        add(levelThreeButton, BorderLayout.LINE_START);

        JPanel panel = new JPanel();
        panel.add(levelOneButton);
        panel.add(levelTwoButton);
        panel.add(levelThreeButton);
        add(panel);
    }

    // Set up timer
    // modifies: none
    // effects:  initializes a timer that updates game each
    //           INTERVAL milliseconds
    private void addTimer() {
        Timer t = new Timer(INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.update();
//                bottomPanel.repaint();
            }
        });

        t.start();
    }

    // Centres frame on desktop
    // modifies: this
    // effects:  location of frame is set so frame is centred on desktop
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    /*
     * A key handler to respond to key events
     */
    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            game.keyPressed(e.getKeyCode());
        }
    }

    /*
     * Play the game
     */
    public static void main(String[] args) {
        new DontGetHit();
    }
}
