package ui;

import constants.Constants;
import model.Game;
import panels.BottomPanel;

import javax.swing.*;

public class GameMainFrame extends JFrame {

    public GameMainFrame() {
        initializeLayout();
    }

    private void initializeLayout() {

        add(new BottomPanel(new Game()));

        setTitle(Constants.TITLE);

        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
