package ui.model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Json;

import java.util.ArrayList;

// Creates a player with a unique Name and Color
public class Player implements Json {
    private String name;
    public ArrayList<Level> availableLevels;
    public ArrayList<Level> lockedLevels;
    private String color;
    public Level currentLevel;
    public int deathCount;

    public Level level1;
    public Level level2;
    public Level level3;

    // constructs a new Player with a name, color, available and locked levels.
    // REQUIRES: n is a non-empty name (String), and
    //           color is one of red or blue (String).
    //EFFECTS: creates a player with a name and color, and sets up the levels
    public Player(String n, String c, ArrayList<Level> availableLevels, ArrayList<Level> lockedLevels) {
        name = n;
        this.color = c;
        this.availableLevels = availableLevels;
        this.lockedLevels = lockedLevels;
        currentLevel = null;
        deathCount = 0;

        level1 = new Level("easy", "1");
        level2 = new Level("medium", "2");
        level3 = new Level("hard", "3");
        setupLevels();
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    // MODIFIES: this
    // EFFECTS: the initial levels that a player can play, and those
    //          that are locked
    public void setupLevels() {
        this.availableLevels.add(level1);
        this.lockedLevels.add(level2);
        this.lockedLevels.add(level3);

        this.currentLevel = availableLevels.get(availableLevels.size() - 1);
    }

    public void setAvailableLevels(ArrayList<Level> availableLevels) {
        this.availableLevels = availableLevels;
    }

    public void setLockedLevels(ArrayList<Level> lockedLevels) {
        this.lockedLevels = lockedLevels;
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
            if (!lockedLevels.isEmpty()) {
                currentLevel = lockedLevels.get(0);
                availableLevels.add(lockedLevels.get(0));
                lockedLevels.remove(0);
            }
        }
    }

    // Effects: returns a list of all available level names
    public ArrayList<String> getNamesAvailableLevels() {
        ArrayList<String> namesOfAvailableLevels = new ArrayList<>();
        for (Level level : availableLevels) {
            namesOfAvailableLevels.add(level.getLevelName());
        }
        return namesOfAvailableLevels;
    }

    // Effects: returns a list of all locked level names
    public ArrayList<String> getNamesLockedLevels() {
        ArrayList<String> namesOfLockedLevels = new ArrayList<>();
        for (Level level : lockedLevels) {
            namesOfLockedLevels.add(level.getLevelName());
        }
        return namesOfLockedLevels;
    }

    /**
     * Next 3 methods are based largely off the example given in class
     */
    @Override
    // Effects: creates a player in JSON format
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("color", color);
        json.put("available levels", availableLevelsToJson());
        json.put("locked levels", lockedLevelsToJson());
        return json;
    }

    // EFFECTS: returns the available levels as JSON Array
    private JSONArray availableLevelsToJson() {
        JSONArray jsonAvailableLevels = new JSONArray();

        for (Level level : availableLevels) {
            JSONObject jsonLevel = new JSONObject();
            jsonLevel.put("name", level.getLevelName());
            jsonLevel.put("difficulty", level.getLevelDifficulty());
            jsonAvailableLevels.put(jsonLevel);
        }
        return jsonAvailableLevels;
    }

    // EFFECTS: returns the locked levels as JSON Array
    private JSONArray lockedLevelsToJson() {
        JSONArray jsonLockedLevels = new JSONArray();

        for (Level level : lockedLevels) {
            JSONObject jsonLevel = new JSONObject();
            jsonLevel.put("name", level.getLevelName());
            jsonLevel.put("difficulty", level.getLevelDifficulty());
            jsonLockedLevels.put(jsonLevel);
        }
        return jsonLockedLevels;
    }

}
