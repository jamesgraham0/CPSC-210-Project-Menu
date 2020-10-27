package model;


import org.json.JSONObject;

// Creates a level with its name and difficulty
public class Level {
    private String name;
    private String difficulty;
    private boolean complete;

    //REQUIRES: a non-empty string as a name, and an int [1, 3] for difficulty
    //EFFECTS: creates a level with its name and difficulty
    public Level(String n, String d) {
        this.name = n;
        this.difficulty = d;
        complete = false;
    }

    public String getLevelName() {
        return name;
    }

    public String getLevelDifficulty() {
        return difficulty;
    }

    public void doLevel() {
        complete = true;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("difficulty", difficulty);
        return json;
    }
}
