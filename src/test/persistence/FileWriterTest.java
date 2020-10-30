package persistence;

import model.Level;
import model.Player;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is based on the example provided in class
 */

class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            ArrayList<Level> al = new ArrayList<>();
            ArrayList<Level> ll = new ArrayList<>();
            Player p = new Player(" ", " ", al, ll);
            FileWriter writer = new FileWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyPlayer() {
        try {
            ArrayList<Level> al = new ArrayList<>();
            ArrayList<Level> ll = new ArrayList<>();
            Player p = new Player(" ", " ", al, ll);
            FileWriter writer = new FileWriter("./data/testWriterEmptyPlayer.json");
            writer.open();
            writer.write(p);
            writer.close();

            FileReader reader = new FileReader("./data/testWriterEmptyPlayer.json");
            p = reader.read();
            assertEquals(" ", p.getPlayerName());
            assertEquals(1, p.getAvailableLevels().size());
            assertEquals(2, p.getLockedLevels().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterPlayer() {
        try {
            ArrayList<Level> al = new ArrayList<>();
            ArrayList<Level> ll = new ArrayList<>();

            Player p = new Player("james", "blue", al, ll);
            p.doLevel(p.getAvailableLevels().get(0));

            FileWriter writer = new FileWriter("./data/testWriterPlayer.json");
            writer.open();
            writer.write(p);
            writer.close();

            FileReader reader = new FileReader("./data/testWriterPlayer.json");
            p = reader.read();
            assertEquals("james", p.getPlayerName());
            assertEquals("blue", p.getColor());
            List<Level> availableLevels = p.getAvailableLevels();
            assertEquals(2, availableLevels.size());

            List<Level> lockedLevels = p.getLockedLevels();
            assertEquals(1, lockedLevels.size());

            checkLevel("easy", "1", availableLevels.get(0));
            checkLevel("medium", "2", availableLevels.get(1));

            checkLevel("hard", "3", lockedLevels.get(0));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}