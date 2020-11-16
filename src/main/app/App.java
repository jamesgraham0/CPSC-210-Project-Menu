package app;

import ui.GameMainFrame;

import java.awt.*;

public class App {

    public static void main(String[] args) {

        //invokeLater() allows for heavy computations to be done
        // outside of the GUI so that the app is responsive
        EventQueue.invokeLater(() -> {
            new GameMainFrame();
        });
    }
}
