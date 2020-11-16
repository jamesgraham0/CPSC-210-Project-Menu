package model;

import constants.Constants;
import image.Image;
import image.ImageFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayerVisual {

    public static final int SIZE_X = Constants.PLAYER_WIDTH;
    public static final int SIZE_Y = Constants.PLAYER_HEIGHT;
    public static final int Y_POS = Game.HEIGHT - 40;
    public static final Color COLOR = new Color(250, 20, 20);

    private int dx = 0;
    private int dy = 0;
    private int xcoord;
    private int ycoord;

    // Constructs a player
    // effects: missile is positioned at coordinates (x, y)
    public PlayerVisual(int x, int y) {
        this.xcoord = x;
        this.ycoord = y;
    }

    public int getX() {
        return xcoord;
    }

    public int getY() {
        return ycoord;
    }

    public void setXcoord(int x) {
        this.xcoord = x;
    }

    public void setYcoord(int y) {
        this.ycoord = y;
    }

    public void setImage(ImageIcon i) {
    }

    public void move() {
        xcoord += dx;
        ycoord += dy;

        // BOUNDS

        // LEFT
        if (xcoord < 0) {
            xcoord = 0;
        }

        // RIGHT
        if (xcoord > Constants.GAME_WIDTH - Constants.PLAYER_WIDTH) {
            xcoord = Constants.GAME_WIDTH - Constants.PLAYER_WIDTH;
        }

        // TOP
        if (ycoord < 0) {
            ycoord = 0;
        }

        // BOTTOM
        if (ycoord > Constants.GAME_HEIGHT - Constants.PLAYER_WIDTH) {
            ycoord = Constants.GAME_HEIGHT - Constants.PLAYER_WIDTH;
        }
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

}
