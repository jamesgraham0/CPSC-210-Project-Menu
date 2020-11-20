package panels;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;


//import app.AudioHandler;
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

//    private AudioHandler audio;


    private Game game;
    private Player player;
    private SavedPlayerPanel savedPlayerPanel;
    private LevelsButtonPanel levelsButtonPanel;
    private HowToPlayPanel howToPlayPanel;
    private NullExceptionPanel nullExceptionPanel;
    private GamePanel gamePanel;

    private ArrayList<Level> availableLevels = new ArrayList<>();
    private ArrayList<Level> lockedLevels = new ArrayList<>();

    // Constructs a main menu panel
    // effects:  sets size and background colour of panel,
    //           updates this with the game to be displayed
    public MainMenuPanel(Game g) {

        this.fileWriter = new FileWriter(JSON_STORE);
        this.fileReader = new FileReader(JSON_STORE);
        this.game = g;
        setupPanels(g);

        setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        setBackground(Color.DARK_GRAY);
        initializePlayer();
    }

    private void setupPanels(Game g) {
        savedPlayerPanel = new SavedPlayerPanel(g);
        add(savedPlayerPanel, BorderLayout.CENTER);
        addMenuButtons();

        howToPlayPanel = new HowToPlayPanel(g);
        add(howToPlayPanel, BorderLayout.CENTER);
        howToPlayPanel.setVisible(false);

        nullExceptionPanel = new NullExceptionPanel(g);
        add(nullExceptionPanel, BorderLayout.CENTER);
        nullExceptionPanel.setVisible(false);

        gamePanel = new GamePanel(g);
        add(gamePanel);
        gamePanel.setVisible(false);

        levelsButtonPanel = new LevelsButtonPanel(g, this, gamePanel);
        add(levelsButtonPanel, BorderLayout.SOUTH);
        levelsButtonPanel.setVisible(true);


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void actionPerformed(ActionEvent e) {
        if ("load".equals(e.getActionCommand())) {
            try {
                player = fileReader.read();
                savedPlayerPanel.setNameTextBox(player.getPlayerName());
                savedPlayerPanel.setColorTextBox(player.getColor());
                howToPlayPanel.setVisible(false);
                nullExceptionPanel.setVisible(false);

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

        } else if ("save".equals(e.getActionCommand())) {
            try {

                nullExceptionPanel.setVisible(false);
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
        } else if ("new game".equals(e.getActionCommand())) {
            savedPlayerPanel.setNameTextBox("");
            savedPlayerPanel.setColorTextBox("");
            howToPlayPanel.setVisible(false);
            levelsButtonPanel.getLevelTwoButton().setOpaque(false);
            levelsButtonPanel.getLevelThreeButton().setOpaque(false);
            levelsButtonPanel.getLevelTwoButton().setForeground(Color.gray);
            levelsButtonPanel.getLevelThreeButton().setForeground(Color.gray);
            initializePlayer();
//            initializeLevelsButtonPanel();
        } else if ("how to play".equals(e.getActionCommand())) {
            if (howToPlayPanel.isVisible()) {
                howToPlayPanel.setVisible(false);
            } else {
                howToPlayPanel.setVisible(true);
            }
        }
    }

    private void initializeLevelsButtonPanel() {
        levelsButtonPanel = new LevelsButtonPanel(game, this, gamePanel);
    }

    public void addMenuButtons() {
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

    public void initializePlayer() {
        ArrayList<Level> empty1 = new ArrayList<>();
        ArrayList<Level> empty2 = new ArrayList<>();

        player = new Player(" ", " ", empty1, empty2);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }


}