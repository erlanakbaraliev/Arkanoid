import java.awt.*;

public class Brick extends Sprite{
    public Brick(int x, int y, int width, int height, Image image) {
        super(x, y, width, height, image);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }
}
