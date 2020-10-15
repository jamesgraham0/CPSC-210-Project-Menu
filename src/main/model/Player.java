package model;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

// Creates a player with a unique Name and Color
public class Player {
    private String name; // name of player
    public ArrayList<Level> availableLevels = new ArrayList<>();  // keeps track of available levels
    public ArrayList<Level> lockedLevels = new ArrayList<>();     // keeps track of locked levels
    private String color;  // color of player
    public Level level;   // Level in which the player plays the game

    // constructs a new Player with a name and color
    // REQUIRES: n is a non-empty name (String), and
    //           color is one of red or blue.
    //EFFECTS: creates a player with a name and color,
    //         and sets up the levels
    public Player(String n, String c) {
        this.name = n;
        this.color = c;
        setupLevels();
    }

    // MODIFIES: this
    // EFFECTS: the initial levels that a player can play, and those
    //          that are locked
    public void setupLevels() {
        this.level = new Level(" ", 0);

        Level level1 = new Level("easy", 1);
        Level level2 = new Level("medium", 2);
        Level level3 = new Level("hard", 3);

        this.availableLevels.add(level1);
        this.lockedLevels.add(level2);
        this.lockedLevels.add(level3);

    }

    public ArrayList<Level> getAvailableLevels() {
        return this.availableLevels;
    }

    public ArrayList<Level> getLockedLevels() {
        return this.lockedLevels;
    }

    public String getPlayerName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public String getLevelName() {
        return this.level.getLevelName();
    }

    public Level getLevelFromName(String s) {
        for (Level level : availableLevels) {
            if (level.getLevelName().equals(s)) {
                return level;
            }
        }
        for (Level level : lockedLevels) {
            if (level.getLevelName().equals(s)) {
                return level;
            }
        }
        return null;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<String> getNamesAvailableLevels() {
        ArrayList<String> namesOfAvailableLevels = new ArrayList<String>();

        for (Level levelNames : availableLevels) {
            namesOfAvailableLevels.add(levelNames.getLevelName());
        }
        return namesOfAvailableLevels;
    }

    public ArrayList<String> getNamesLockedLevels() {
        ArrayList<String> namesOfLockedLevels = new ArrayList<String>();

        for (Level levelNames : lockedLevels) {
            namesOfLockedLevels.add(levelNames.getLevelName());
        }
        return namesOfLockedLevels;
    }
}
