package ui.panels;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;


import ui.constants.Constants;
import ui.model.*;
import persistence.FileReader;
import persistence.FileWriter;


// Represents a MainMenuPanel
public class MainMenuPanel extends JPanel implements ActionListener {
    private static final String JSON_STORE = "./data/savedPlayer.json";
    private final FileReader fileReader;
    private final FileWriter fileWriter;

    private Player player;
    private SavedPlayerPanel savedPlayerPanel;
    private LevelsButtonPanel levelsButtonPanel;
    private HowToPlayPanel howToPlayPanel;
    private GamePanel gamePanel;
    private JLabel backgroundLabel;

    private JButton loadButton;
    private JButton saveButton;
    private JButton newGameButton;
    private JButton howToPlayButton;
    private JButton backButton;

    private BufferedImage image;

    private ArrayList<Level> availableLevels = new ArrayList<>();
    private ArrayList<Level> lockedLevels = new ArrayList<>();

    // Constructs a main menu panel
    // effects:  sets size, adds space ui.image as background, initializes the ui.panels and player for the game
    public MainMenuPanel(Game g) {

        this.fileWriter = new FileWriter(JSON_STORE);
        this.fileReader = new FileReader(JSON_STORE);

        setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        setBackground(Color.DARK_GRAY);
        drawGamePanel();
        initializePlayer();
        setupPanels(g);
    }

    // modifies: this
    // effects: sets up all of the ui.panels that belong in the main menu
    private void setupPanels(Game g) {
        savedPlayerPanel = new SavedPlayerPanel(g);
        add(savedPlayerPanel, BorderLayout.CENTER);
        addMenuButtons();

        howToPlayPanel = new HowToPlayPanel(g);
        add(howToPlayPanel, BorderLayout.CENTER);
        howToPlayPanel.setVisible(false);

        gamePanel = new GamePanel();
        add(gamePanel);
        gamePanel.setVisible(false);

        levelsButtonPanel = new LevelsButtonPanel(g, this, gamePanel);
        add(levelsButtonPanel, BorderLayout.SOUTH);
        levelsButtonPanel.setVisible(true);

        setupBackgroundLabel();
    }

    // modifies: this
    // effects: sets up and adds the background Label to this
    private void setupBackgroundLabel() {
        backgroundLabel = new JLabel("You've now completed this level, "
                +  "click the back button to return to the menu");
        backgroundLabel.setPreferredSize(new Dimension(500, 500));
        backgroundLabel.setBackground(Color.white);
        backgroundLabel.setForeground(Color.white);
        add(backgroundLabel);
        backgroundLabel.setVisible(false);
    }

    // effects: returns true if the savedPlayerPanel is visible, otherwise false
    public boolean mainMenuIsVisible() {
        return savedPlayerPanel.isVisible();
    }

    // modifies: this
    // effects: clears the main menu of all ui.panels/buttons, sets the game ui.panels/buttons to visible
    public void clearPanelsAndButtons() {
        // Clear ui.panels
        savedPlayerPanel.setVisible(false);
        howToPlayPanel.setVisible(false);
        levelsButtonPanel.setVisible(false);

        // Make game message visible and back button
        backgroundLabel.setVisible(true);
        backButton.setVisible(true);

        // Clear buttons
        loadButton.setVisible(false);
        saveButton.setVisible(false);
        newGameButton.setVisible(false);
        howToPlayButton.setVisible(false);
    }

    // modifies: this
    // effects: sets all the main menu ui.panels/buttons to visible, sets the game ui.panels/buttons to false
    public void regeneratePanelsAndButtons() {
        // Clear ui.panels
        savedPlayerPanel.setVisible(true);
        levelsButtonPanel.setVisible(true);

        // Make game message invisible and back button invisible
        backgroundLabel.setVisible(false);
        backButton.setVisible(false);

        // Clear buttons
        loadButton.setVisible(true);
        saveButton.setVisible(true);
        newGameButton.setVisible(true);
        howToPlayButton.setVisible(true);
    }

    // modifies: this
    // effects: paints the background ui.image to this
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    // modifies: this, player
    // effects: sets the actions for the buttons on the main menu
    public void actionPerformed(ActionEvent e) {
        if ("load".equals(e.getActionCommand())) {
            loadPlayer();
        } else if ("save".equals(e.getActionCommand())) {
            savePlayer();
        } else if ("new game".equals(e.getActionCommand())) {
            newGame();
        } else if ("how to play".equals(e.getActionCommand())) {
            howToPlayPanel.setVisible(!howToPlayPanel.isVisible());
        } else if ("back".equals(e.getActionCommand())) {
            regeneratePanelsAndButtons();
        }
    }

    // modifies: this
    // effects: initializes a new player and the main menu
    private void newGame() {
        savedPlayerPanel.setNameTextBox("");
        savedPlayerPanel.setColorTextBox("");
        howToPlayPanel.setVisible(false);
        levelsButtonPanel.getLevelTwoButton().setOpaque(false);
        levelsButtonPanel.getLevelThreeButton().setOpaque(false);
        levelsButtonPanel.getLevelTwoButton().setForeground(Color.gray);
        levelsButtonPanel.getLevelThreeButton().setForeground(Color.gray);
        initializePlayer();
    }

    // modifies: this
    // effects: saves the player with its name, color, available levels and locked levels
    private void savePlayer() {
        try {
            player.setName(savedPlayerPanel.getNameTextBox());
            player.setColor(savedPlayerPanel.getColorTextBox());

            if (levelsButtonPanel.getLevelTwoButton().isOpaque()) {
                ArrayList<Level> al1 = new ArrayList<>();
                al1.add(player.level1);
                al1.add(player.level2);
                player.setAvailableLevels(al1);
            }

            if (levelsButtonPanel.getLevelThreeButton().isOpaque()) {
                ArrayList<Level> al2 = new ArrayList<>();
                al2.add(player.level1);
                al2.add(player.level2);
                al2.add(player.level3);
                player.setAvailableLevels(al2);
            }

            fileWriter.open();
            fileWriter.write(player);
            fileWriter.close();
        } catch (IOException | NullPointerException i) {
            System.out.println("");
        }
    }

    // modifies: this
    // effects: loads the saved player and it's saved data,
    //          sets the available and locked levels in this
    private void loadPlayer() {
        try {
            player = fileReader.read();
            savedPlayerPanel.setNameTextBox(player.getPlayerName());
            savedPlayerPanel.setColorTextBox(player.getColor());
            howToPlayPanel.setVisible(false);

            if (player.getNamesAvailableLevels().contains("medium")) {
                levelsButtonPanel.unlockLevelTwoButton();
            }
            if (player.getNamesAvailableLevels().contains("hard")) {
                levelsButtonPanel.unlockLevelTwoButton();
                levelsButtonPanel.unlockLevelThreeButton();
            }

        } catch (IOException i) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // modifies: this
    // effects: creates and adds all menu buttons to this
    public void addMenuButtons() {
        loadButton = new JButton("Load");
        loadButton.addActionListener(this);
        loadButton.setActionCommand("load");

        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        saveButton.setActionCommand("save");

        newGameButton = new JButton("New Game");
        newGameButton.addActionListener(this);
        newGameButton.setActionCommand("new game");

        howToPlayButton = new JButton("How To Play");
        howToPlayButton.addActionListener(this);
        howToPlayButton.setActionCommand("how to play");

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setActionCommand("back");

        add(backButton);
        backButton.setVisible(false);

        add(loadButton);
        add(saveButton);
        add(newGameButton);
        add(howToPlayButton);
    }

    // modifies: this
    // effects: initializes player
    public void initializePlayer() {
        ArrayList<Level> empty1 = new ArrayList<>();
        ArrayList<Level> empty2 = new ArrayList<>();

        player = new Player(" ", " ", empty1, empty2);
    }


    public GamePanel getGamePanel() {
        return gamePanel;
    }

    // modifies: this
    // effects: draws the background ui.image to this
    public void drawGamePanel() {
        try {
            image = ImageIO.read(new File(Constants.BACKGROUND_IMAGE_URL));
            setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}