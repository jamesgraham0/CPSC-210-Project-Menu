package ui.constants;


// General Constants used in the game
public class Constants {

    private Constants() {
    }

    public static final String TITLE = "Don't Get Hit";

    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    // speed of the app
    public static final int GAME_SPEED = 10;
    public static final int PLAYER_WIDTH = 25;
    public static final int PLAYER_HEIGHT = 25;

    //Enemy Constants
    public static final int ENEMY_WIDTH = 35;
    public static final int ENEMY_HEIGHT = 27;
    public static final int ENEMY_INIT_X = 250;
    public static final int ENEMY_INIT_Y = 150;
    public static final int ENEMIES_LEVEL_1 = 4;
    public static final int ENEMIES_LEVEL_2 = 8;
    public static final int ENEMIES_LEVEL_3 = 12;


    // images for objects
    public static final String ENEMY_IMAGE_URL = "images/enemy.png";
    public static final String RED_PLAYER_IMAGE_URL = "images/red_player.jpg";
    public static final String BLUE_PLAYER_IMAGE_URL = "images/blue_player.jpg";
    public static final String BACKGROUND_IMAGE_URL = "images/stars.jpg";
}
