package ui;

import ui.model.Game;

import ui.panels.GamePanel;
//import ui.panels.BottomPanel;
import ui.panels.MainMenuPanel;

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
    private GamePanel gamePanel;


    // Constructs main window
    // effects: sets up window in which Space Invaders game will be played
    public DontGetHit() {
        super("Don't Get Hit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game = new Game();
        setResizable(false);

        initialize();
        addKeyListener(new KeyHandler());
        pack();
        centreOnScreen();
        setVisible(true);
        addTimer();
    }

    private void initialize() {
        mainMenuPanel = new MainMenuPanel(game);
//        gamePanel = new GamePanel();
        add(mainMenuPanel);
//        add(gamePanel);
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
