import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Level{
    private final int BRICK_WIDTH = 40;
    private final int BRICK_HEIGHT = 20;
    private List<Brick> bricks;

    public Level(String levelTxtPath) {
        bricks = new ArrayList();
        loadBricks(levelTxtPath);
    }
    private void loadBricks(String levelTxtPath) {
        try(BufferedReader br = new BufferedReader(new FileReader(levelTxtPath))){
            int y=0;
            String line;
            while((line = br.readLine()) != null) {
                int x = 0;
                for(char ch : line.toCharArray()) {
                    if(Character.isDigit(ch)) {
                        Image image = new ImageIcon("data/images/brick" + y + ".png").getImage();
                        bricks.add(new Brick(x*BRICK_WIDTH, y*BRICK_HEIGHT, BRICK_WIDTH, BRICK_HEIGHT, image));
                    }
                    x++;
                }
                y++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        for(Brick b : bricks) {
            b.draw(g);
        }
    }
}
