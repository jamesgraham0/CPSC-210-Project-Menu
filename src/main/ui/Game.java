package ui;

import model.Level;
import model.Player;
import ui.panels.MainMenuPanel;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Represents a game of Dont Get Hit
 */
public class Game {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final Random RND = new Random();
    private static final int INVASION_PERIOD = 20;   // on average, one invader each 250 updates
    private int deathCount;

    private List<Enemies> enemies;
    private PlayerVisual player;
    private boolean isGameOver;
    private MainMenuPanel mainMenuPanel;


    // Constructs a Dont Get Hit Game
    // effects:  creates empty lists of enemies, sets player on screen
    public Game() {
        player = new PlayerVisual(Game.WIDTH / 2, Game.HEIGHT / 2);
        enemies = new ArrayList<Enemies>();
        setUp();
    }

    // Updates the game on clock tick
    // modifies: this
    // effects:  updates player and enemies
    public void update() {
        moveEnemies();
        player.move();

        enemiesAttack();
        checkCollisions();
        checkWin();
        checkGameOver();
    }

    public void checkWin() {
        if (player.getY() < 100) {
            isGameOver = true;
        }
    }

    // checks to see if the game is over
    public boolean isOver() {
        return isGameOver;
    }

    public void setGameOver() {
        isGameOver = true;
    }

    public int getNumEnemies() {
        return enemies.size();
    }

    public List<Enemies> getEnemies() {
        return enemies;
    }

    public void keyPressed(int keyCode) {
        playerControl(keyCode);
    }

    // Sets / resets the game
    // modifies: this
    // effects:  clears enemies, initializes player
    private void setUp() {
        enemies.clear();
        isGameOver = false;
    }

    // Controls the player
    // modifies: this
    // effects: moves player in response to keyCode
    private void playerControl(int keyCode) {
        if (keyCode == KeyEvent.VK_KP_LEFT || keyCode == KeyEvent.VK_LEFT) {
            player.x -= 4;
        } else if (keyCode == KeyEvent.VK_KP_RIGHT || keyCode == KeyEvent.VK_RIGHT) {
            player.x += 4;
        } else if (keyCode == KeyEvent.VK_KP_UP || keyCode == KeyEvent.VK_UP) {
            player.y -= 4;
        } else if (keyCode == KeyEvent.VK_KP_DOWN || keyCode == KeyEvent.VK_DOWN) {
            player.y += 4;
        }
    }

    // updates the enemies
    // modifies: this
    // effects: moves the enemies
    private void moveEnemies() {
        for (Enemies next : enemies) {
            next.move();
        }
    }

    // modifies: this
    // effects: Enemies start attack
    private void enemiesAttack() {
        if (RND.nextInt(INVASION_PERIOD) < 1) {
            Enemies e = new Enemies(RND.nextInt(Game.WIDTH), 0);
            enemies.add(e);
        }
    }

    // Checks for collisions between enemies and the player
    // modifies: this
    // effects: returns true if player collides with enemy, otherwise false
    private boolean checkCollisions() {
        List<Enemies> enemiesToRemove = new ArrayList<Enemies>();

        for (Enemies target : enemies) {
            if (checkEnemyHit(target, player)) {
                return true;
            }
        }
        return false;
    }

    // modifies: this
    // effects: checks to see if an enemy and player collide, increases death count++
    private boolean checkEnemyHit(Enemies target, PlayerVisual player) {
        for (Enemies next : enemies) {
            if (next.collidedWith(player)) {
                deathCount++;
                return true;
            }
        }
        return false;
    }


    // Is game over? (Have enemy and player collided)
    // modifies: this
    // effects:  if player and enemy collide, sets isGameOver = true
    private void checkGameOver() {

        if (checkCollisions()) {
            isGameOver = true;
        }
    }

    public PlayerVisual getPlayer() {
        return player;
    }
}
