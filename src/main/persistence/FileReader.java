package persistence;

import model.Level;
import model.Player;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.json.*;

/**
 * This class is based largely off the example given in class
 */

// A reader that reads the JSON version of the Player in the file (savedPlayer)
public class FileReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public FileReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads Player from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Player read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parsePlayer(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // Effects: parses the available levels from the JSON file and returns it
    //          as an array list
    public ArrayList parser(JSONArray jsonArray) {
        ArrayList<Level> availableLevels = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            Level level = new Level(jsonArray.getJSONObject(i).getString("name"),
                    jsonArray.getJSONObject(i).getString("difficulty"));

            availableLevels.add(level);
        }
        return availableLevels;
    }

    // EFFECTS: parses the saved player from JSON object and returns it
    private Player parsePlayer(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String color = jsonObject.getString("color");
        JSONArray availableLevels = jsonObject.getJSONArray("available levels");
        JSONArray lockedLevels = jsonObject.getJSONArray("locked levels");
        ArrayList<Level> al1 = new ArrayList<>();
        al1 = parser(availableLevels);
        ArrayList<Level> al2 = new ArrayList<>();
        al2 = parser(lockedLevels);
        Player player = new Player(name, color, new ArrayList<>(), new ArrayList<>());
        player.availableLevels = al1;
        player.lockedLevels = al2;
        return player;
    }

}

