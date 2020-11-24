package persistence;

import ui.model.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * class based on the example in class
 */

public class JsonTest {
    protected void checkLevel(String name, String difficulty, Level level) {
        assertEquals(name, level.getLevelName());
        assertEquals(difficulty, level.getLevelDifficulty());
    }
}
