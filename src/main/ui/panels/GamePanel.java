package ui.panels;

import ui.constants.Constants;
import ui.model.Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;



// Creates a GamePanel with a space background
public class GamePanel extends JPanel {

    // Constructor for the GamePanel
    public GamePanel() {
        try {
            BufferedImage image = ImageIO.read(new File(Constants.BACKGROUND_IMAGE_URL));
            setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}





//package ui.panels;
//
//import ui.model.Level;
//import ui.model.Player;
//import ui.model.Enemies;
//import ui.Game;
//import ui.model.PlayerVisual;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.util.ArrayList;
//import javax.swing.*;
//
//// Represents a GamePanel with a space background
//public class GamePanel extends JPanel implements ActionListener {
//    private static final String WIN = "You Win!";
//    private Game game;
//    private Player playerModel;
//    private ScorePanel scorePanel;
//    private JButton backButton;
//    private MainMenuPanel mainMenuPanel;
//    private SavedPlayerPanel savedPlayerPanel;
//
//    private PlayerVisual player;
//
//    private final Timer timer;
//
//    // Constructor for the GamePanel
//    public GamePanel(Game g) {
//
//        setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
//        setBackground(Color.BLACK);
//        this.game = g;
//        initializePlayer();
//        savedPlayerPanel = new SavedPlayerPanel(g);
//
//        timer = new Timer(0, this::actionPerformed);
//        timer.start();
//    }
//
//    public void actionPerformed(ActionEvent e) {
//        repaint();
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        drawGame(g);
//
//        if (game.isOver()) {
//            youWinMessage(g);
//        }
//    }
//
//    // Draws the game
//    // modifies: g
//    // effects:  draws the game onto g
//    private void drawGame(Graphics g) {
//        drawPlayer(g);
//        drawEnemies(g);
//    }
//
//    // Draw the player
//    // modifies: g
//    // effects:  draws the player onto g
//    private void drawPlayer(Graphics g) {
//        Color savedCol = g.getColor();
//        g.setColor(Color.white);
//        g.fillRect(Game.WIDTH / 2 - 12, Game.HEIGHT - 100, 25, 25);
//        g.setColor(savedCol);
//    }
//
//    // Draw the enemies
//    // modifies: g
//    // effects:  draws the enemies onto g
//    private void drawEnemies(Graphics g) {
//        for (Enemies next : game.getEnemies()) {
//            drawEnemy(g, next);
//        }
//    }
//
//    // Draw an enemy
//    // modifies: g
//    // effects:  draws the enemy e onto g
//    private void drawEnemy(Graphics g, Enemies e) {
//        Color savedCol = g.getColor();
//        g.setColor(Color.YELLOW);
//        g.fillOval(e.getXcoord() - Enemies.SIZE_X / 2, e.getYcoord() - Enemies.SIZE_Y / 2, 40, 40);
//        g.setColor(savedCol);
//    }
//
//    // modifies: g
//    // effects:  draws "You win!"
//    private void youWinMessage(Graphics g) {
//        Color saved = g.getColor();
//        g.setColor(new Color(150, 41, 151));
//        g.setFont(new Font("Arial", 20, 20));
//        FontMetrics fm = g.getFontMetrics();
//        centreString(WIN, g, fm, Game.HEIGHT / 2);
//        g.setColor(saved);
//    }
//
//    // Centres a string on the screen
//    // modifies: g
//    // effects:  centres the string str horizontally onto g at vertical position yPos
//    private void centreString(String str, Graphics g, FontMetrics fm, int y) {
//        int width = fm.stringWidth(str);
//        g.drawString(str, (Game.WIDTH - width) / 2, y);
//    }
//
//    // modifies: this
//    // effects: initializes player
//    public void initializePlayer() {
//        ArrayList<Level> empty1 = new ArrayList<>();
//        ArrayList<Level> empty2 = new ArrayList<>();
//
//        playerModel = new Player(" ", " ", empty1, empty2);
//    }
//
//}