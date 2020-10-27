package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Json;

import java.util.ArrayList;

// Creates a player with a unique Name and Color
public class Player implements Json {
    private String name; // name of player
    public ArrayList<Level> availableLevels;  // keeps track of available levels
    public ArrayList<Level> lockedLevels;    // keeps track of locked levels
    private String color;  // color of player
    public Level currentLevel;   // Level in which the player plays the game

    // constructs a new Player with a name and color
    // REQUIRES: n is a non-empty name (String), and
    //           color is one of red or blue.
    //EFFECTS: creates a player with a name and color,
    //         and sets up the levels
    public Player(String n, String c, ArrayList<Level> availableLevels, ArrayList<Level> lockedLevels) {
        this.name = n;
        this.color = c;
        this.availableLevels = availableLevels;
        this.lockedLevels = lockedLevels;
        setupLevels();
    }

    // MODIFIES: this
    // EFFECTS: the initial levels that a player can play, and those
    //          that are locked
    public void setupLevels() {

        Level level1 = new Level("easy", "1");
        Level level2 = new Level("medium", "2");
        Level level3 = new Level("hard", "3");

        this.availableLevels.add(level1);
        this.lockedLevels.add(level2);
        this.lockedLevels.add(level3);
    }

    public String getPlayerName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public ArrayList<Level> getAvailableLevels() {
        return availableLevels;
    }

    public ArrayList<Level> getLockedLevels() {
        return lockedLevels;
    }

    public String getLevelName() {
        return this.currentLevel.getLevelName();
    }

    public void setLevel(Level level) {
        this.currentLevel = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
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

    // Modifies: this
    // Effects: if level is the last in availableLevels, sets the current level to the first in lockedLevels,
    //          adds it to available levels, and removes it from lockedLevels.
    public void doLevel(Level level) {
        if (availableLevels.get(availableLevels.size() - 1) == level) {
            currentLevel = lockedLevels.get(0);
            availableLevels.add(lockedLevels.get(0));
            lockedLevels.remove(0);
        }
    }

    public ArrayList<String> getNamesAvailableLevels() {
        ArrayList<String> namesOfAvailableLevels = new ArrayList<String>();
        for (Level level : availableLevels) {
            namesOfAvailableLevels.add(level.getLevelName());
        }
        return namesOfAvailableLevels;
    }

    public ArrayList<String> getNamesLockedLevels() {
        ArrayList<String> namesOfLockedLevels = new ArrayList<String>();
        for (Level level : lockedLevels) {
            namesOfLockedLevels.add(level.getLevelName());
        }
        return namesOfLockedLevels;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("color", color);
        json.put("available levels", availableLevelsToJson());
//        json.put("locked levels", lockedLevelsToJson());
        return json;
    }

    // EFFECTS: return the available levels as JSON Array
    private JSONArray availableLevelsToJson() {
        JSONArray jsonAvailableLevels = new JSONArray();

        // available levels
        for (Level level : availableLevels) {
            jsonAvailableLevels.put(level.toJson());
        }
        return jsonAvailableLevels;
    }
//
//
//
//    // EFFECTS: return the locked levels as json array
//    private JSONArray lockedLevelsToJson() {
//        JSONArray jsonLockedLevels = new JSONArray();
//
//        //locked levels
//        for (Level level : savedPlayer.get(0).getLockedLevels()) {
//            jsonLockedLevels.put(level.toJson());
//        }
//        return jsonLockedLevels;
//    }

}
