package ui;

import ui.model.Level;
import ui.model.Player;
import persistence.FileReader;
import persistence.FileWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// Player creation application
public class PlayerUI {
    private static final String JSON_STORE = "./data/savedPlayer.json";
    private Player player;

    private FileWriter fileWriter;
    private FileReader fileReader;

    // EFFECTS: runs the player creation application
    public PlayerUI() {
        runGame();
    }

    // MODIFIES: this
    // EFFECTS: processes input from user
    private void runGame() {
        boolean run = true;
        String command;
        this.fileWriter = new FileWriter(JSON_STORE);
        this.fileReader = new FileReader(JSON_STORE);
        init();

        while (run) {
            mainMenu();
            Scanner scanner = new Scanner(System.in);
            command = scanner.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                run = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGame Over");
    }

    // MODIFIES: this
    // EFFECTS: processes scanner
    private void processCommand(String command) {
        Scanner scanner = new Scanner(System.in);

        if (command.equals("n")) {
            newName(scanner);
        } else if (command.equals("load")) {
            loadPlayer();
        } else if (command.equals("save")) {
            savePlayer();
        } else if (command.equals("c")) {
            newColour(scanner);
        } else if (command.equals("l")) {
            selectLevel(scanner);
        } else if (command.equals("h")) {
            System.out.println("- Move your character using the arrow keys \n to dodge enemies and reach the end zone");
        } else {
            System.out.println("Please choose a valid option");
        }
    }

    // Modifies: this
    // Effects: if the level is available, assigns it as the current level; otherwise
    //          says that the level is locked. If a level is selected but doesn't exist,
    //          returns a statement for the user to input a valid level.
    private void selectLevel(Scanner scanner) {
        boolean selectingLevel = true;
        while (selectingLevel) {
            System.out.println("Select from the available levels below: ");
            System.out.println("Available Levels: " + player.getNamesAvailableLevels());
            System.out.println("Locked Levels: " + player.getNamesLockedLevels());

            String scanner1 = scanner.nextLine();
            scanner1 = scanner1.toLowerCase();
            if (player.getNamesAvailableLevels().contains(scanner1)) {
                System.out.println("you've selected level " + scanner1);
                Level l = player.getLevelFromName(scanner1);
                player.setLevel(l);
                promptDoLevel(scanner);
                selectingLevel = false;

            } else if (player.getNamesLockedLevels().contains(scanner1)) {
                System.out.println("Sorry, that level's locked");
            } else {
                System.out.println("Please enter a valid level");
            }
        }
    }

    // Modifies: this
    // Effects: Asks the user whether they want to complete the current level
    //          if yes, doLevel, if no, wish them luck next time, otherwise continue prompting
    public void promptDoLevel(Scanner scanner) {
        boolean waitingToDoLevel = true;
        while (waitingToDoLevel) {
            System.out.println("Do level? " + player.currentLevel.getLevelName());
            System.out.println("\ty -> yes");
            System.out.println("\tn -> no");

            String scanner2 = scanner.nextLine();
            if (scanner2.equals("y")) {
                if (player.availableLevels.contains(scanner2)) {
                    System.out.println("Level complete, next level: " + player.currentLevel.getLevelName());
                }
                player.doLevel(player.currentLevel);
                System.out.println("Level complete, next level: " + player.currentLevel.getLevelName());
                waitingToDoLevel = false;
            } else if (scanner2.equals("n")) {
                System.out.println("better luck next time");
                waitingToDoLevel = false;
            } else {
                System.out.println("Would you like to complete this level?");
            }
        }
    }

    // Modifies: this
    // Effects: Sets the character's color to one of red or blue
    private void newColour(Scanner scanner) {
        System.out.println("Select your color: Red or Blue");
        boolean correctColour = true;

        while (correctColour) {
            String str = scanner.nextLine();
            str = str.toLowerCase();
            if (str.equals("red") || str.equals("blue")) {
                player.setColor(str);
                System.out.println("your character's color is: " + str);
                correctColour = false;
            } else {
                System.out.println("Choose a valid colour: Red or Blue");
            }
        }
    }

    // Modifies: this
    // Effects: Sets the character's name to the given input
    private void newName(Scanner scanner) {
        System.out.println("Enter your name: ");
        String str = scanner.nextLine();
        this.player.setName(str);
        System.out.println("you character's name is: " + player.getPlayerName());
    }

    /**
     * savePlayer() and loadPlayer() methods are based on the example given in class
     */
    // Modifies: this
    // EFFECTS: saves the player to file
    public void savePlayer() {
        try {
            fileWriter.open();
            fileWriter.write(player);
            fileWriter.close();
            System.out.println("Saved " + player.getPlayerName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads savedPlayer from file
    public void loadPlayer() {
        try {
            player = fileReader.read();
            System.out.println("Loaded " + player.getPlayerName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes
    public void init() {
        ArrayList<Level> empty1 = new ArrayList<>();
        ArrayList<Level> empty2 = new ArrayList<>();

        player = new Player(" ", " ", empty1, empty2);
    }


    // EFFECTS: displays menu of options to user
    private void mainMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tsave -> Save Game");
        System.out.println("\tload -> Load Game \n");
        System.out.println("\tn -> New Name");
        System.out.println("\tc -> New Color");
        System.out.println("\tl -> Select Level");
        System.out.println("\th -> How to Play");
        System.out.println("\tq -> Quit");

        System.out.println("Current Name: " + player.getPlayerName());
        System.out.println("Current Color: " + player.getColor());
        System.out.println("Current Level: " + player.getLevelName());
    }
}
