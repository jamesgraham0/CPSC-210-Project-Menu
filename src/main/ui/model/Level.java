package ui.model;

// Creates a level with its name and difficulty
public class Level {
    private String name;
    private String difficulty;

    //REQUIRES: a non-empty string as a name, and a string > 0 representing difficulty
    //EFFECTS: creates a level with its name and difficulty
    public Level(String n, String d) {
        this.name = n;
        this.difficulty = d;
    }

    public String getLevelName() {
        return name;
    }

    public String getLevelDifficulty() {
        return difficulty;
    }

}
