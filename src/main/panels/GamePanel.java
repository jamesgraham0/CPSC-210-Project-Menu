package panels;

import model.Enemies;
import model.Game;
import model.PlayerVisual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

/*
 * The panel in which the game is rendered.
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {

    private static final String OVER = "Game Over!";
    private static final String REPLAY = "R to replay";
    private Game game;

    // Constructs a game panel
    // effects:  sets size and background colour of panel,
    //           updates this with the game to be displayed
    public GamePanel(Game g) {
        setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        setBackground(Color.GRAY);
        this.game = g;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawGame(g);

        if (game.isOver()) {
            gameOver(g);
        }
    }

    // Draws the game
    // modifies: g
    // effects:  draws the game onto g
    private void drawGame(Graphics g) {
        drawPlayer(g);
        drawEnemies(g);
    }

    // Draw the tank
    // modifies: g
    // effects:  draws the tank onto g
    private void drawPlayer(Graphics g) {
        PlayerVisual p = game.getPlayer();
        Color savedCol = g.getColor();
        g.setColor(PlayerVisual.COLOR);
        g.fillRect(p.getX() - PlayerVisual.SIZE_X / 2, PlayerVisual.Y_POS - PlayerVisual.SIZE_Y / 2, PlayerVisual.SIZE_X, PlayerVisual.SIZE_Y);
        g.setColor(savedCol);
    }

    // Draw the invaders
    // modifies: g
    // effects:  draws the invaders onto g
    private void drawEnemies(Graphics g) {
        for (Enemies next : game.getEnemies()) {
            drawEnemies(g, next);
        }
    }

    // Draw an invader
    // modifies: g
    // effects:  draws the invader i onto g
    private void drawEnemies(Graphics g, Enemies i) {
        Color savedCol = g.getColor();
        g.setColor(Enemies.COLOR);
        g.fillOval(i.getXcoord() - Enemies.SIZE_X / 2, i.getYcoord()
                - Enemies.SIZE_Y / 2, Enemies.SIZE_X, Enemies.SIZE_Y);
        g.setColor(savedCol);
    }

    // Draws the "game over" message and replay instructions
    // modifies: g
    // effects:  draws "game over" and replay instructions onto g
    private void gameOver(Graphics g) {
        Color saved = g.getColor();
        g.setColor(new Color(0, 0, 0));
        g.setFont(new Font("Arial", 20, 20));
        FontMetrics fm = g.getFontMetrics();
        centreString(OVER, g, fm, Game.HEIGHT / 2);
        centreString(REPLAY, g, fm, Game.HEIGHT / 2 + 50);
        g.setColor(saved);
    }

    // Centres a string on the screen
    // modifies: g
    // effects:  centres the string str horizontally onto g at vertical position yPos
    private void centreString(String str, Graphics g, FontMetrics fm, int y) {
        int width = fm.stringWidth(str);
        g.drawString(str, (Game.WIDTH - width) / 2, y);
    }
}
