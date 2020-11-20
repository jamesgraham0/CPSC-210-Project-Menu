package panels;

import model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * The panel in which the game is rendered.
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener {

    private BottomPanel bottomPanel;
    private static final String REPLAY = "R to replay";
    private Game game;
    private JLabel background;

    public GamePanel(Game g) {
        setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        this.game = g;
        setBackground(Color.DARK_GRAY);

        bottomPanel = new BottomPanel(g);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.setColor(Color.black);
    }

    private void makeButton() {
        JButton backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setLayout(null);
        backButton.setActionCommand("back");
        backButton.setPreferredSize(new Dimension(100, 100));

        add(backButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("back".equals(e.getActionCommand())) {
            System.out.println("back");
        }
    }
}
