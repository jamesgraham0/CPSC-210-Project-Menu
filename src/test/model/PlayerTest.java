package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;

    @BeforeEach
    void runBefore() {
        player = new Player("Player", "red");
    }

    @Test
    void testGetAvailableLevels() {
        assertEquals(1, player.getAvailableLevels().size()); // Test 1: make sure level 1 is available

        assertEquals(player.availableLevels, player.getAvailableLevels());

    }

    @Test
    void testGetLockedLevels() {
        assertEquals(2, player.getLockedLevels().size());
        assertEquals(player.lockedLevels, player.getLockedLevels());

    }

    @Test
    void testGetPlayerName() {
        assertEquals("Player", player.getPlayerName());

        player.setName("James");
        assertEquals("James", player.getPlayerName());
    }

    @Test
    void testSetName() {
        assertEquals("Player", player.getPlayerName());

        player.setName("James");
        assertEquals("James", player.getPlayerName());
    }

    @Test
    void testGetColor() {
        assertEquals("red", player.getColor());

        player.setColor("blue");
        assertEquals("blue", player.getColor());
    }

    @Test
    void testSetColor() {
        assertEquals("red", player.getColor());

        player.setColor("blue");
        assertEquals("blue", player.getColor());
    }

    @Test
    void testGetLevelName() {
        Level level1 = new Level("easy", 1);
        Level level2 = new Level("medium", 2);
        Level level3 = new Level("hard", 3);


        assertEquals("easy", level1.getLevelName());
        assertEquals("medium", level2.getLevelName());
        assertEquals("hard", level3.getLevelName());
    }

    @Test
    void testGetLevelDifficulty() {
        Level level1 = new Level("easy", 1);
        Level level2 = new Level("medium", 2);
        Level level3 = new Level("hard", 3);


        assertEquals(1, level1.getLevelDifficulty());
        assertEquals(2, level2.getLevelDifficulty());
        assertEquals(3, level3.getLevelDifficulty());
    }

    @Test
    void testGetLevelFromName() {
        Player pLayer = new Player("James", "red");

        assertEquals(player.getAvailableLevels().get(0), player.getLevelFromName("easy"));
        assertEquals(player.getLockedLevels().get(0), player.getLevelFromName("medium"));
    }

    @Test
    void testSetLevel() {
        Player player = new Player("James", "red");
        player.setLevel(player.getAvailableLevels().get(0));

        assertEquals("easy", player.level.getLevelName());
    }




    @Test
    void testGetNamesAvailableLevels() {
        ArrayList<String> al = new ArrayList<>();
        al.add("easy");

        assertEquals(al, player.getNamesAvailableLevels());
    }

    @Test
    void testGetNamesLockedLevels() {
        ArrayList<java.lang.String> al = new ArrayList<>();
        al.add("medium");
        al.add("hard");

        assertEquals(al, player.getNamesLockedLevels());
    }
}