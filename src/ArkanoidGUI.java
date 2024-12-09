import javax.swing.*;
import java.awt.*;

public class ArkanoidGUI {
    private JFrame frame;
    private GameEngine game;

    public ArkanoidGUI() {
        frame = new JFrame("Arkanoid");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 600));

        game = new GameEngine();
        frame.getContentPane().add(game.getGamePanel());

        frame.pack();
    }
}