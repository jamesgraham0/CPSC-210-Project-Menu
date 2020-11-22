package ui;

import java.awt.*;

public class PlayerVisual {

//    public static final int SIZE_X = Constants.PLAYER_WIDTH;
//    public static final int SIZE_Y = Constants.PLAYER_HEIGHT;
//    public static final int Y_POS = Game.HEIGHT - 25;
//    public static final Color RED = new Color(227, 49, 49);
//    public static final Color BLUE = new Color(17, 138, 213);
//

    public static final int SIZE_X = 25;
    public static final int SIZE_Y = 25;
    public static final int DX = 4;
    public static final int DY = 4;
    public static final int Y_POS = Game.HEIGHT - 40;
    public static final Color COLOR = new Color(250, 128, 20);

    public int x;
    public int y;

    // Construct a tank.
    // effects: places tank at position (x, Y_POS) moving right.
    public PlayerVisual(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Updates the tank on clock tick
    // modifies: this
    // effects:  tank is moved DX units in whatever direction it is facing and is
    //           constrained to remain within vertical boundaries of game
    public void move() {
        x += DX;
        y = y + DY;

        handleBoundary();
    }

    // Constrains tank so that it doesn't travel of sides of screen
    // modifies: this
    // effects: tank is constrained to remain within vertical boundaries of game
    private void handleBoundary() {
        if (x < 0)
            x = 0;
        else if (x > Game.WIDTH)
            x = Game.WIDTH;
    }

//    public void keyReleased(KeyEvent e) {
//
//        int key = e.getKeyCode();
//
//        if (key == KeyEvent.VK_LEFT) {
//            dx = 0;
//        }
//
//        if (key == KeyEvent.VK_RIGHT) {
//            dx = 0;
//        }
//
//        if (key == KeyEvent.VK_UP) {
//            dy = 0;
//        }
//
//        if (key == KeyEvent.VK_DOWN) {
//            dy = 0;
//        }
//    }

}
