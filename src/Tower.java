import processing.core.PApplet;

import java.util.ArrayList;

public class Tower {
    int x, y, size, timer;
    public Tower(int x, int y){
        this.x = x;
        this.y = y;
        size = 80;
        timer = (int) (60+Math.random()*30);
    }
    public Bullet shoot(){
        //if called, should produce a bullet at a certain position / going toward the first tank that's in the tower's range
        //needs to be passed the xSpeed and ySpeed that it sends a bullet out of. The bullet doesn't know these things
        Bullet b = new Bullet((this.x)+40, (this.y)+40, 0, 0);
        return b;
    }
    public static Tank getClosest(Bullet b, ArrayList<Tank> tankList){
        Tank returnTank = new Tank (-100, -100);
        double minDist = Math.sqrt(Math.pow((b.x-tankList.get(0).x), 2)+Math.pow((b.y-tankList.get(0).y),2));
        for (Tank tank : tankList) {
            int x1 = b.x;
            int y1 = b.y;
            int x2 = tank.x;
            int y2 = tank.y;

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
}
