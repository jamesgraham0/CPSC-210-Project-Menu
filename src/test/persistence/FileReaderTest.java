package persistence;

import ui.model.Level;
import ui.model.Player;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class based on the example given in class
 */

class FileReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        FileReader reader = new FileReader("./data/noSuchFile.json");
        try {
            Player p = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyPlayer() {
        FileReader reader = new FileReader("./data/testReaderEmptyPlayer.json");
        try {
            Player p = reader.read();
            assertEquals(" ", p.getPlayerName());
            assertEquals(" ", p.getColor());
            assertEquals(1, p.getAvailableLevels().size());
            assertEquals(2, p.getLockedLevels().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderPlayer() {
        FileReader reader = new FileReader("./data/testReaderPlayer.json");
        try {
            Player p = reader.read();
            assertEquals("james", p.getPlayerName());
            assertEquals("blue", p.getColor());
            List<Level> listAvailableLevels = p.getAvailableLevels();
            assertEquals(2, listAvailableLevels.size());

            List<Level> listLockedLevels = p.getLockedLevels();
            assertEquals(1, listLockedLevels.size());

            checkLevel("easy", "1", listAvailableLevels.get(0));
            checkLevel("medium", "2", listAvailableLevels.get(1));

            checkLevel("hard", "3", listLockedLevels.get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}