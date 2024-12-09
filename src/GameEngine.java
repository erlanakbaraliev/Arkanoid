import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameEngine {
    private static final int FPS = 240;
    private static final int PADDLE_Y = 540;
    private static final int PADDLE_WIDTH = 150;
    private static final int PADDLE_HEIGHT = 40;
    private static final int PADDLE_MOVEMENT = 2;
    private static final int BALL_RADIUS = 20;

    private boolean paused = false;
    private Image background;
    private int levelNum = 1;
    private Level level;
    private Ball ball;
    private Paddle paddle;

    private JPanel gamePanel;

    public GameEngine() {
        background = new ImageIcon("data/images/background.jpg").getImage();
        restart(); // Set level, paddle, ball images

        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGame(g);
            }
        };
        gamePanel.setPreferredSize(new Dimension(800, 600));

        setKeyStrokes();
    }
    private void setKeyStrokes(){
        gamePanel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "pressed left");
        gamePanel.getActionMap().put("pressed left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paddle.setVelx(-PADDLE_MOVEMENT);
            }
        });
        gamePanel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "pressed right");
        gamePanel.getActionMap().put("pressed right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paddle.setVelx(PADDLE_MOVEMENT);
            }
        });
        gamePanel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "pressed down");
        gamePanel.getActionMap().put("pressed down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paddle.setVelx(0);
            }
        });
    }

    private void restart() {
        level = new Level("data/levels/level1.txt");

        Image paddleImage = new ImageIcon("data/images/paddle.png").getImage();
        paddle = new Paddle(335, PADDLE_Y, PADDLE_WIDTH, PADDLE_HEIGHT, paddleImage);

        Image ballImage = new ImageIcon("data/images/ball.png").getImage();
        ball = new Ball(400, 300, BALL_RADIUS, BALL_RADIUS, ballImage);
    }

    // Draw the game elements
    private void drawGame(Graphics g) {
        g.drawImage(background, 0, 0, 800, 600, null);
        level.draw(g);
        paddle.draw(g);
        ball.draw(g);
    }

    // Get the game panel
    public JPanel getGamePanel() {
        return gamePanel;
    }
}
