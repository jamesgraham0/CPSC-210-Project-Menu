package model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Represents a space invaders game.
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

    // Constructs a Space Invaders Game
    // effects:  creates empty lists of missiles and invaders, centres tank on screen
    public Game() {
        enemies = new ArrayList<Enemies>();
        setUp();
    }

    // Updates the game on clock tick
    // modifies: this
    // effects:  updates tank, missiles and invaders
    public void update() {
        moveEnemies();
        player.move();

        invade();
        checkCollisions();
        checkGameOver();
    }

    // Responds to key press codes
    // modifies: this
    // effects:  turns tank, fires missiles and resets game in response to
    //           given key pressed code
    public void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_R && isGameOver) {
            setUp();
        } else if (keyCode == KeyEvent.VK_X) {
            System.exit(0);
        } else {
            playerControl();
        }
    }

    // Exercise: fill in the documentation for this method
    public boolean isOver() {
        return isGameOver;
    }

    public int getNumEnemies() {
        return enemies.size();
    }

    public List<Enemies> getEnemies() {
        return enemies;
    }

    public PlayerVisual getPlayer() {
        return player;
    }

    public static int getDeathCount() {
        return deathCount;
    }

    // Sets / resets the game
    // modifies: this
    // effects:  clears list of missiles and invaders, initializes tank
    private void setUp() {
        enemies.clear();
        player = new PlayerVisual(WIDTH / 2, HEIGHT / 2);
        isGameOver = false;
    }

    // Controls the tank
    // modifies: this
    // effects: turns tank in response to key code
    private void playerControl() {
        player.move();
    }

    // updates the invaders
    // modifies: this
    // effects: moves the invaders
    private void moveEnemies() {
        for (Enemies next : enemies) {
            next.move();
        }
    }

    // Exercise: add the documentation for this method
    private void invade() {
        if (RND.nextInt(INVASION_PERIOD) < 1) {
            Enemies e = new Enemies(RND.nextInt(Game.WIDTH), 0);
            enemies.add(e);
        }
    }

    // Checks for collisions between an invader and a missile
    // modifies: this
    // effects:  removes any invader that has been shot with a missile
    //           and removes corresponding missile from play
    private void checkCollisions() {
        List<Enemies> invadersToRemove = new ArrayList<Enemies>();

        for (Enemies target : enemies) {
            if (checkEnemyHit(target, player)) {
                invadersToRemove.add(target);
            }
        }

//        player.removeAll();
    }

    // Exercise:  fill in the documentation for this method
    private boolean checkEnemyHit(Enemies target, PlayerVisual player) {
        for (Enemies next : enemies) {
            if (next.collidedWith(player)) {
//                player.removeAll();
                deathCount++;
                return true;
            }
        }
        return false;
    }


    // Is game over? (Has an invader managed to land?)
    // modifies: this
    // effects:  if an invader has landed, game is marked as
    //           over and lists of invaders & missiles cleared
    private void checkGameOver() {

        if (player.getY() < 50) {
            isGameOver = true;
        }

        if (isGameOver) {
            enemies.clear();
        }
    }
}
