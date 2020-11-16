package panels;


import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;


import model.Game;
import model.Player;


/*
 * Represents the panel in which the scoreboard is displayed.
 */
@SuppressWarnings("serial")
public class BottomPanel extends JPanel {
    private String nameText = "Name: ";
    private String deathsText = "Deaths: ";
    private static final int LBL_WIDTH = 200;
    private static final int LBL_HEIGHT = 50;
    private Game game;
    private JLabel nameLabel;
    private JLabel deaths;

    // Constructs a score panel
    // effects: sets the background colour and draws the initial labels;
    //          updates this with the game whose score is to be displayed
    public BottomPanel(Game g) {
        game = g;
        setBackground(new Color(100, 180, 180));
        nameLabel = new JLabel(nameText + Player.getPlayerName());
        nameLabel.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        deaths = new JLabel(deathsText + Game.getDeathCount());
        deaths.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        add(nameLabel);
        add(Box.createHorizontalStrut(10));
//        add(deaths);
    }

    // Updates the score panel
    // modifies: this
    // effects:  updates number of invaders shot and number of missiles
    //           remaining to reflect current state of game
    public void update() {
        nameLabel.setText(nameText + Player.getPlayerName());
        deaths.setText(deathsText + Game.getDeathCount());
        repaint();
    }

    public void setNameText(String s) {
        nameText = "Name: " + s;
    }

    public void setDeathsText(int s) {
        deathsText = "Deaths: " + s;
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
