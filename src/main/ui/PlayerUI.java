package ui;

import com.sun.tools.javac.processing.JavacMessager;
import model.Level;
import model.Player;

import java.util.Scanner;

// Player creation application
public class PlayerUI {
    private String name;
    private String color;
    private Scanner scanner;
    private Player player;

    // EFFECTS: runs the player creation application
    public PlayerUI() {
        runGame();
    }

    // MODIFIES: this
    // EFFECTS: processes input from user
    private void runGame() {
        boolean run = true;
        String command;

        init(" ", " ");

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
                selectingLevel = false;

            } else if (player.getNamesLockedLevels().contains(scanner1)) {
                System.out.println("Sorry, that level's locked");
            } else {
                System.out.println("Please enter a valid level");
            }
        }
    }

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

    private void newName(Scanner scanner) {
        System.out.println("Enter your name: ");
        String str = scanner.nextLine();
        this.player.setName(str);
        System.out.println("you character's name is: " + player.getPlayerName());
    }

    // MODIFIES: this
    // EFFECTS: initializes
    public void init(String name, String color) {
        this.player = new Player(name, color);
    }


    // EFFECTS: displays menu of options to user

    private void mainMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tn -> New Name");
        System.out.println("\tc -> New Color");
        System.out.println("\tl -> Select Level");
        System.out.println("\th -> How to Play");
        System.out.println("\tq -> Quit");

        System.out.println("Current Name: " + player.getPlayerName());
        System.out.println("Current Color: " + player.getColor());
        System.out.println("Current Level: " + player.getLevelName());
    }

    // EFFECTS: displays color option menu
    private void colorMenu() {
        System.out.println("\nSelect from color options:");
        System.out.println("\tr -> red");
        System.out.println("\tb -> blue");
        System.out.println("\tg -> green");
    }
}
