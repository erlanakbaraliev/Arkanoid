import java.awt.*;

public class Ball extends Sprite{
    private int velx = 2;
    private int vely = 2;
    public Ball(int x, int y, int width, int height, Image image){
        super(x, y, width, height, image);
    }
    public void moveX() {
        super.x += velx;
        if(super.x <= 0 || super.x + width >= 800){
            invertVelX();
        }
    }
    public boolean moveY() {
        y += vely;
        if (y <= 0) {
            invertVelY();
        }
        else if(y >= 600){
            return false;
        }
        return true;
    }
    public void invertVelX(){
        velx = -velx;
    }
    public void invertVelY(){
        vely = -vely;
    }
}
