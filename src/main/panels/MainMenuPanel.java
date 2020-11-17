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
    private HowToPlayPanel howToPlayPanel;
    private NullExceptionPanel nullExceptionPanel;
    private ArrayList<Level> availableLevels;
    private ArrayList<Level> lockedLevels;

    private JLabel howToPlayLabel;

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
        howToPlayPanel = new HowToPlayPanel(g);
        add(howToPlayPanel, BorderLayout.CENTER);
        howToPlayPanel.setVisible(false);

        nullExceptionPanel = new NullExceptionPanel(g);
        add(nullExceptionPanel, BorderLayout.CENTER);
        nullExceptionPanel.setVisible(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    //TODO: implement level parts
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
                nullExceptionPanel.setVisible(false);
                player.setName(savedPlayerPanel.getNameTextBox());
                player.setColor(savedPlayerPanel.getColorTextBox());

                fileWriter.open();
                fileWriter.write(player);
                fileWriter.close();
            } catch (IOException | NullPointerException i) {
                nullExceptionPanel.setVisible(true);
            }
        } else if ("new game".equals(e.getActionCommand())) {
            savedPlayerPanel.setNameTextBox("");
            savedPlayerPanel.setColorTextBox("");

        } else if ("how to play".equals(e.getActionCommand())) {
            howToPlayPanel.setVisible(true);
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

}