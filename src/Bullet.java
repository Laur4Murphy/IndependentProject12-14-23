
public class Bullet {
    private float x, y;

    private static int size;
    private double xSpeed, ySpeed;
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
    public double getX(){ return this.x;}
    public double getY(){ return this.y;}

    public void aimAt(Tank tank){
        int x2 = tank.getX();
        int y2 = tank.getX();
        double x1 = this.x;
        double y1 = this.y;
        this.xSpeed = (x2-x1)/8;
        this.ySpeed = (y2-y1)/8;
    }
}
