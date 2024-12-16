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
        if((velx > 0  && x <= 800-width) || (velx < 0  && x >= 0)) {
            super.x += velx;
        }
    }
}