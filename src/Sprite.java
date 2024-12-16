import java.awt.*;

public class  Sprite {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Image image;

    public Sprite(int x, int y, int width, int height, Image image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }
    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, null);
    }
    public boolean collides(Sprite other) {
        Rectangle rect = new Rectangle(x, y, width, height);
        Rectangle otherRect = new Rectangle(other.x, other.y, other.width, other.height);
        return rect.intersects(otherRect);
    }
}
