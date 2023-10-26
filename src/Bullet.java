import java.util.ArrayList;
public class Bullet {
    int x, y;

    static int size;
    double xSpeed, ySpeed;
    public Bullet(int x, int y, double xSpeed, double ySpeed){
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
    public void draw (Game game){
        game.fill(255, 0, 0);
        game.ellipse(x, y, size, size);

    }
    //public boolean isCollide(ArrayList<Tank> tankslist){
        //loop through the given list and return true if collided with any one of them
    //}
}
