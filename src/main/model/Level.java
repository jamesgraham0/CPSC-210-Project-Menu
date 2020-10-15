package model;


// Creates a level with its name and difficulty
public class Level {
    private int difficulty;
    private String name;

    //REQUIRES: a non-empty string as a name, and an int [1, 3] for difficulty
    //EFFECTS: creates a level with its name and difficulty
    public Level(String n, int d) {
        this.name = n;
        this.difficulty = d;
    }

    public String getLevelName() {
        return this.name;
    }

    public int getLevelDifficulty() {
        return this.difficulty;
    }
}
