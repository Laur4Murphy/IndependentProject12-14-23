import processing.core.PApplet;

import java.util.ArrayList;

public class Game extends PApplet {
    // TODO: declare game variables
    ArrayList<Tank> tankList;
    ArrayList<Tower> towerList;
    int timer = 50;

    int counter = 10;


    public void settings() {
        size(800, 800);   // set the window size

    }

    public void setup() {
        // TODO: initialize game variables
        tankList = new ArrayList<Tank>();
        towerList = new ArrayList<Tower>();
        for (int i = 0; i < 5; i++) {
            //made 15 balloons to start
            Tank ta = new Tank(-80, 360);
            tankList.add(ta);
        }

    }

    /***
     * Draws each frame to the screen.  Runs automatically in a loop at frameRate frames a second.
     * tick each object (have it update itself), and draw each object
     */
    public void draw() {
        //in here, the game finds the nearest tank to the tower and calculates the xSpeed and ySpeed, then pass that into shoot()
        background(255);    // paint screen white
        fill(0,255,0);          // load green paint color
        rect(0, 300, 800, 200);
        fill(255, 0, 0);
        timer--;			 // count down
        text("Click to place each tower", 10, 10);

        if (timer <= 0) {
            Tank b = new Tank(-80, 360);					// spawn it
            tankList.add(b);								// add it to list
            timer = 50;										// reset timer
        }

        for (Tank tank : tankList) {
            tank.update();
            tank.draw(this);
        }
        for (Tower tower : towerList) {
            tower.draw(this);
            double minDist = 100000;
            for (Tank tank : tankList) {
                int x1 = tower.x;
                int y1 = tower.y;
                int x2 = tank.x;
                int y2 = tank.y;
                double dist = Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1),2));
                if(dist<minDist){
                    minDist = dist;
                    //save the xSpeed and ySpeed,  Math.pow((x2-x1), 2)
                }
            }
            //give it the xSpeed and ySpeed
            tower.shoot();
        }


    }
    public void mouseReleased() {
        if(counter>0) {
            if(mouseX>=40&&mouseX<=760) {
                if (mouseY >= 40 && mouseY <= 760) {
                    Tower t = new Tower(mouseX - 40, mouseY - 40);
                    towerList.add(t);
                    counter--;
                }
            }
        }
    }


    public static void main(String[] args) {
        PApplet.main("Game");
    }
}
