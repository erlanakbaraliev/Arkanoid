import java.awt.*;

public class Paddle extends Sprite {
    private double velx;
    public Paddle(int x, int y, int width, int height, Image image){
        super(x, y, width, height, image);
    }
    public void setVelx(double velx){
        this.velx = velx;
    }
    public void move(){
        if((velx < 0 && velx > 9) || (velx > 0 && x + width <= 800)) {
            x += velx;
        }
    }
}