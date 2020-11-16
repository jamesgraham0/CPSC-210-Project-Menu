package model;

import constants.Constants;

import java.awt.*;

/*
 * Represents a an enemy
 */
public class Enemies {

    public static final int SIZE_X = Constants.ENEMY_WIDTH;
    public static final int SIZE_Y = Constants.ENEMY_HEIGHT;
    public static final int DY = 1;
    public static final Color COLOR = new Color(10, 50, 188);
    private static final int JIGGLE_X = 1;

    private int xcoord;
    private int ycoord;

    // Constructs an invader
    // effects: invader is positioned at coordinates (x, y)
    public Enemies(int x, int y) {
        this.xcoord = x;
        this.ycoord = y;
    }

    public int getXcoord() {
        return xcoord;
    }

    public int getYcoord() {
        return ycoord;
    }

    // Updates enemy on clock tick
    // modifies: this
    // effects:  enemy is moved down the screen DY units and randomly takes
    //           a step of size no greater than JIGGLE_X to the left or right
    public void move() {
        xcoord = xcoord + Game.RND.nextInt(2 * JIGGLE_X + 1) - JIGGLE_X;
        ycoord = ycoord + DY;

        handleBoundary();
    }

    // Determines if this invader has collided with a missile
    // modifies: none
    // effects:  returns true if this invader has collided with missile m,
    //           false otherwise
    public boolean collidedWith(PlayerVisual p) {
        Rectangle enemyHitBox = new Rectangle(getXcoord() - SIZE_X / 2, getYcoord() - SIZE_Y / 2, SIZE_X,
                SIZE_Y);
        Rectangle playerHitBox = new Rectangle(p.getX() - PlayerVisual.SIZE_X / 2, p.getY()
                - PlayerVisual.SIZE_Y / 2, PlayerVisual.SIZE_X, PlayerVisual.SIZE_Y);
        return enemyHitBox.intersects(playerHitBox);
    }

    // Constrains invader so that it doesn't travel off sides of screen
    // modifies: this
    // effects: tank is constrained to remain within horizontal boundaries of game
    private void handleBoundary() {
        if (xcoord < 0) {
            xcoord = 0;
        } else if (xcoord > Game.WIDTH) {
            xcoord = Game.WIDTH;
        }
    }
}

