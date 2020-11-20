package panels;

import constants.Constants;
import model.Game;

import java.awt.*;
import java.awt.event.ActionEvent;
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























//package panels;
//
//import model.*;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.*;
//
///*
// * The panel in which the game is rendered.
// */
//@SuppressWarnings("serial")
//public class GamePanel extends JPanel implements ActionListener {
//
//    private BottomPanel bottomPanel;
//    private static final String REPLAY = "R to replay";
//    private Game game;
//    private JLabel background;
//
//    public GamePanel(Game g) {
//        setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
//        this.game = g;
//        setBackground(Color.DARK_GRAY);
//
//        bottomPanel = new BottomPanel(g);
//        add(bottomPanel, BorderLayout.SOUTH);
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
//        g.setColor(Color.black);
//    }
//
//}
