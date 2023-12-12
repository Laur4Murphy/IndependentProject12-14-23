
import java.util.ArrayList;

public class Tower {
    private int x, y;
    private double timer;
    private final int size = 80;
    public Tower(int x, int y){
        this.x = x;
        this.y = y;
        timer = (int) (60+Math.random()*30);

    }
    public Bullet shoot(){
        //if called, should produce a bullet at a certain position / going toward the first tank that's in the tower's range
        //needs to be passed the xSpeed and ySpeed that it sends a bullet out of. The bullet doesn't know these things
        return new Bullet((this.x)+40, (this.y)+40, 0, 0);
    }
    public static Tank getClosest(Bullet b, ArrayList<Tank> tankList){
        Tank returnTank = new Tank (-100, -100);
        double minDist = Math.sqrt(Math.pow(((b.getX())-(tankList.get(0).getX())), 2)+Math.pow((b.getY()-(tankList.get(0).getY())),2));
        for (Tank tank : tankList) {
            double x1 = b.getX();
            double y1 = b.getY();
            int x2 = tank.getX();
            int y2 = tank.getY();

            double dist = Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1),2));
            if(dist<minDist){
                minDist = dist;
                returnTank = tank;
            }
        }
        return returnTank;
    }
    public void draw(Game game){
        game.fill(255, 0, 255);
        game.rect(x, y, size, size);

    }
    public double getTimer(){ return this.timer;}
    public void setTimer(double newVal){ this.timer = newVal; }
}
