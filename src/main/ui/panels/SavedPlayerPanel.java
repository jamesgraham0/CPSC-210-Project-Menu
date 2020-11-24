package ui.panels;


import java.awt.*;
import javax.swing.*;


import ui.model.Game;
import ui.model.Player;


// Represents a SavedPlayerPanel
public class SavedPlayerPanel extends JPanel {
    private final JTextField nameTextBox;
    private final JTextField colorTextBox;

    private static final int LBL_WIDTH = 200;
    private static final int LBL_HEIGHT = 50;
    private JLabel availableLevelsLabel;
    private JLabel lockedLevelsLabel;
    private Player player;

    // Constructs a SavedPlayerPanel
    // effects: sets the background colour, draws the labels, and sets the textfields
    public SavedPlayerPanel(Game g) {
        setBackground(new Color(109, 192, 236, 255));

        JLabel currentPlayerLabel = new JLabel("Current Player: ");
        currentPlayerLabel.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        currentPlayerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        nameTextBox = new JTextField(5);
        String nameText = "Name: ";
        JLabel nameLabel = new JLabel(nameText);
        nameLabel.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        colorTextBox = new JTextField(5);
        String colorText = "Color: ";
        JLabel colorLabel = new JLabel(colorText);
        colorLabel.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        colorLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(currentPlayerLabel);
        add(nameLabel);
        add(nameTextBox);
        add(colorLabel);
        add(colorTextBox);
    }

    public String getNameTextBox() {
        return nameTextBox.getText();
    }

    public String getColorTextBox() {
        return colorTextBox.getText();
    }

    public void setNameTextBox(String s) {
        nameTextBox.setText(s);
    }

    public void setColorTextBox(String s) {
        colorTextBox.setText(s);
    }

}