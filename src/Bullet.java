import java.util.ArrayList;
public class Bullet {
    int xSpeed, ySpeed, x, y, size;
    public Bullet(int x, int y, int xSpeed, int ySpeed){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        size = 20;
    }
    public void update(){
        x+=xSpeed;
        y+=ySpeed;
    }
    //public boolean isCollide(ArrayList<Tank> tankslist){
        //loop through the given list and return true if collided with any one of them
    //}
}
