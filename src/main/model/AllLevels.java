package model;

import java.util.ArrayList;

// This class stores all levels
public class AllLevels {
    private ArrayList<Level> levels;

    /**
     * Will likely have to make dedicated classes for each level
     */
    private static Level LEVEL_1;
    private static Level LEVEL_2;
    private static Level LEVEL_3;

    public AllLevels() {
        levels = new ArrayList<>();
        setupLevels();
    }

    public void setupLevels() {

        LEVEL_1 = new Level("easy", "1");
        LEVEL_2 = new Level("medium", "2");
        LEVEL_3 = new Level("hard", "3");

        levels.add(LEVEL_1);
        levels.add(LEVEL_2);
        levels.add(LEVEL_3);
    }

}
