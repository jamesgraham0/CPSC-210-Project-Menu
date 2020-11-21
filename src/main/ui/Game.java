package ui;

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
    public static final int MAX_ENEMIES = 20;
    public static final Random RND = new Random();
    private static final int INVASION_PERIOD = 250;   // on average, one invader each 250 updates
    private static int deathCount = 0;

    private List<Enemies> enemies;
    private PlayerVisual player;
    private boolean isGameOver;

    // Constructs a Dont Get Hit Game
    // effects:  creates empty lists of enemies, sets player on screen
    public Game() {
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
        checkGameOver();
    }

    // Responds to key press codes
    // modifies: this
    // effects:  moves player, resets game if hit
    public void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_R && isGameOver) {
            setUp();
        } else if (keyCode == KeyEvent.VK_X) {
            System.exit(0);
        } else {
            playerControl();
        }
    }

    // checks to see if the game is over
    public boolean isOver() {
        return isGameOver;
    }

    public int getNumEnemies() {
        return enemies.size();
    }

    public List<Enemies> getEnemies() {
        return enemies;
    }

    public static int getDeathCount() {
        return deathCount;
    }

    // Sets / resets the game
    // modifies: this
    // effects:  clears enemies, initializes player
    private void setUp() {
        enemies.clear();
        player = new PlayerVisual(WIDTH / 2, HEIGHT / 2);
        isGameOver = false;
    }

    // Controls the player
    // modifies: this
    // effects: moves player in response to keyCode
    private void playerControl() {
        player.move();
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
        List<Enemies> invadersToRemove = new ArrayList<Enemies>();

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
}
