package image;

import constants.Constants;

import javax.swing.*;

// Creates the imageIcon of the loaded images for the game
public class ImageFactory {

    public static ImageIcon createImage(Image image) {
        ImageIcon imageIcon = null;
        switch (image) {
            case ENEMY:
                imageIcon = new ImageIcon(Constants.ENEMY_IMAGE_URL);
                break;
            case BLUE_PLAYER:
                imageIcon = new ImageIcon(Constants.BLUE_PLAYER_IMAGE_URL);
                break;
            case RED_PLAYER:
                imageIcon = new ImageIcon(Constants.RED_PLAYER_IMAGE_URL);
                break;
            case BACKGROUND:
                imageIcon = new ImageIcon(Constants.BACKGROUND_IMAGE_URL);
                break;
            default:
                return null;
        }

        return imageIcon;
    }
}
