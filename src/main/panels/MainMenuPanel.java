package panels;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;


import image.Image;
import image.ImageFactory;
import model.*;
import persistence.FileReader;
import persistence.FileWriter;


/*
 * Represents the panel in which the scoreboard is displayed.
 */
@SuppressWarnings("serial")
public class MainMenuPanel extends JPanel implements ActionListener {
    private static final String JSON_STORE = "./data/savedPlayer.json";
    private FileReader fileReader;
    private FileWriter fileWriter;


    private Game game;
    private Player player;
    private BottomPanel bottomPanel;
    private SavedPlayerPanel savedPlayerPanel;
    private ArrayList<Level> availableLevels;
    private ArrayList<Level> lockedLevels;

    // Constructs a main menu panel
    // effects:  sets size and background colour of panel,
    //           updates this with the game to be displayed
    public MainMenuPanel(Game g) {
        this.fileWriter = new FileWriter(JSON_STORE);
        this.fileReader = new FileReader(JSON_STORE);

        setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        setBackground(Color.DARK_GRAY);
        this.game = g;
        savedPlayerPanel = new SavedPlayerPanel(g);
        add(savedPlayerPanel, BorderLayout.CENTER);
        addButtons();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    // TODO: implement level parts
    public void actionPerformed(ActionEvent e) {
        if ("load".equals(e.getActionCommand())) {
            try {
                player = fileReader.read();
                savedPlayerPanel.setNameTextBox(Player.getPlayerName());
                savedPlayerPanel.setColorTextBox(Player.getColor());
            } catch (IOException i) {
                System.out.println("Unable to read from file: " + JSON_STORE);
            }
        } else if ("save".equals(e.getActionCommand())) {
            try {
                player = fileReader.read();
            } catch (IOException i) {
                System.out.println("Unable to read from file: " + JSON_STORE);
            }
        } else if ("new game".equals(e.getActionCommand())) {
            savedPlayerPanel.setNameTextBox("");
            savedPlayerPanel.setColorTextBox("");
        } else if ("how to play".equals(e.getActionCommand())) {
            System.out.println("how to play");
        }
    }

    public void addButtons() {
        JButton loadButton = new JButton("Load");
        loadButton.addActionListener(this);
        loadButton.setActionCommand("load");

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        saveButton.setActionCommand("save");

        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(this);
        newGameButton.setActionCommand("new game");

        JButton howToPlayButton = new JButton("How To Play");
        howToPlayButton.addActionListener(this);
        howToPlayButton.setActionCommand("how to play");

        add(loadButton);
        add(saveButton);
        add(newGameButton);
        add(howToPlayButton);
    }

    // Draws the game
    // modifies: g
    // effects:  draws the game onto g
//    private void drawGame(Graphics g) {
//        drawPlayer(g);
//        drawEnemies(g);
//    }

    // Draw the tank
    // modifies: g
    // effects:  draws the tank onto g
//    private void drawPlayer(Graphics g) {
//        PlayerVisual p = game.getPlayer();
//        Color savedCol = g.getColor();
//        g.setColor(PlayerVisual.COLOR);
//        g.fillRect(p.getX() - PlayerVisual.SIZE_X / 2, PlayerVisual.Y_POS -
//        PlayerVisual.SIZE_Y / 2, PlayerVisual.SIZE_X, PlayerVisual.SIZE_Y);
//        g.setColor(savedCol);
//    }

    // Draw the invaders
    // modifies: g
    // effects:  draws the invaders onto g
//    private void drawEnemies(Graphics g) {
//        for (Enemies next : game.getEnemies()) {
//            drawEnemies(g, next);
//        }
//    }

    // Draw an invader
    // modifies: g
    // effects:  draws the invader i onto g
//    private void drawEnemies(Graphics g, Enemies i) {
//        Color savedCol = g.getColor();
//        g.setColor(Enemies.COLOR);
//        g.fillOval(i.getXcoord() - Enemies.SIZE_X / 2, i.getYcoord()
//                - Enemies.SIZE_Y / 2, Enemies.SIZE_X, Enemies.SIZE_Y);
//        g.setColor(savedCol);
//    }

    // Centres a string on the screen
    // modifies: g
    // effects:  centres the string str horizontally onto g at vertical position yPos
    private void centreString(String str, Graphics g, FontMetrics fm, int y) {
        int width = fm.stringWidth(str);
        g.drawString(str, (Game.WIDTH - width) / 2, y);
    }

}


//    TextField text = new TextField(20);


//    public MainMenuPanel() {
//        initializeMenu();
//        add(text);
//    }
//
//    public void initializeMenu() {


//        Container backgroundPanel = new JPanel();
//        backgroundPanel.setSize(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
//        backgroundPanel.setVisible(true);
//        backgroundPanel.setFocusable(true);
//        JButton play = new JButton("Play");
//        JButton exit = new JButton("Exit");
//
//        JPanel northPanel = new JPanel(new BorderLayout());
//        northPanel.add(play);
//        northPanel.add(exit);
//        northPanel.add(backgroundPanel, BorderLayout.NORTH);
//        northPanel.add(new JLabel("Hello", JLabel.CENTER));
//        northPanel.setVisible(true);
//
//        addButtons();
//    }
//
//    public void addButtons() {
//        JButton loadButton = new JButton("Load");
//        loadButton.addActionListener(this);
//        loadButton.setActionCommand("load");
//
//        JButton saveButton = new JButton("Save");
//        saveButton.addActionListener(this);
//        saveButton.setActionCommand("save");
//
//        JButton newGameButton = new JButton("New Game");
//        newGameButton.addActionListener(this);
//        newGameButton.setActionCommand("new game");
//
//        JButton howToPlayButton = new JButton("How To Play");
//        howToPlayButton.addActionListener(this);
//        howToPlayButton.setActionCommand("how to play");
//
//        JButton levelOneButton = new JButton("1");
//        levelOneButton.setLayout(null);
//        levelOneButton.setLocation(Constants.GAME_WIDTH / 2, Constants.GAME_HEIGHT / 2);
//        levelOneButton.addActionListener(this);
//        levelOneButton.setActionCommand("one");
//
//        add(loadButton);
//        add(saveButton);
//        add(newGameButton);
//        add(howToPlayButton);
//        add(levelOneButton);
//    }

//    public void makeLevelButtons() {
//        JButton levelOneButton = new JButton("1");
//        levelOneButton.setVerticalAlignment(SwingConstants.CENTER);
//        levelOneButton.setHorizontalTextPosition(SwingConstants.CENTER);
//        levelOneButton.addActionListener(this);
//        levelOneButton.setActionCommand("one");
//
//        JButton levelTwoButton = new JButton("2");
//        levelTwoButton.setVerticalTextPosition(Constants.GAME_HEIGHT / 2);
//        levelTwoButton.setHorizontalTextPosition(Constants.GAME_HEIGHT / 2);
//        levelTwoButton.addActionListener(this);
//        levelTwoButton.setActionCommand("two");
//
//        JButton levelThreeButton = new JButton("3");
//        levelThreeButton.setVerticalTextPosition(Constants.GAME_HEIGHT / 2);
//        levelThreeButton.setHorizontalTextPosition(Constants.GAME_HEIGHT / 2);
//        levelThreeButton.addActionListener(this);
//        levelThreeButton.setActionCommand("three");
//    }

//    public void actionPerformed(ActionEvent e) {
//
//        //TODO: make these buttons do the right things
//        if ("load".equals(e.getActionCommand())) {
//            text.setText("You selected load");
//        } else if ("save".equals(e.getActionCommand())) {
//            text.setText("You selected save");
//        } else if ("new game".equals(e.getActionCommand())) {
//            text.setText("You selected new game");
//        } else if ("how to play".equals(e.getActionCommand())) {
//            text.setText("You selected how to play");
//        }
//    }

//}
