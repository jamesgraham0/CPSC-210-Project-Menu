package model;

import java.util.ArrayList;

// Creates a level with its name and difficulty
public class Level {
    private String name;
    private String difficulty;
    private ArrayList<Player> players;

    //REQUIRES: a non-empty string as a name, and a string > 0 representing difficulty
    //EFFECTS: creates a level with its name and difficulty
    public Level(String n, String d) {
        this.name = n;
        this.difficulty = d;
        players = new ArrayList<>();
    }

    public String getLevelName() {
        return name;
    }

    public String getLevelDifficulty() {
        return difficulty;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    // effects: returns the names of the players on this level
    public ArrayList<String> getPlayerNames() {
        ArrayList<String> al = new ArrayList<>();
        for (Player player : players) {
            al.add(player.getPlayerName());
        }
        return al;
    }

    // modifies: this, Player
    // effects: if this player is not currently on this level, adds it,
    //          and sets the players level to this
    public void addPlayer(Player player) {
        if (!players.contains(player)) {
            players.add(player);
            player.setLevel(this);
        }
    }
}
