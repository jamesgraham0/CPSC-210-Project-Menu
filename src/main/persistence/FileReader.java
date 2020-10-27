package persistence;

import model.Level;
import model.Player;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;


// A reader that reads the JSON version of the savedPlayer in the file
public class FileReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public FileReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads SavedPlayer from file and returns it;
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

    // EFFECTS: parses SavedPlayer from JSON object and returns it
    private Player parsePlayer(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Player player = new Player(name, "red", null, null);
        addAvailableLevels(player, jsonObject);
        return player;
    }

    // MODIFIES: wr
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addAvailableLevels(Player player, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("available levels");
        for (Object json : jsonArray) {
            JSONObject savedPlayer = (JSONObject) json;
            addAvailableLevel(player, savedPlayer);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addAvailableLevel(Player player, JSONObject jsonObject) {
        String name = jsonObject.getString("available levels");
        String difficulty = jsonObject.getString("difficulty");
        Level level = new Level(name, difficulty);

        player.availableLevels.add(level);
    }

}

