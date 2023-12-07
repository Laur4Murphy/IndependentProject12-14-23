import processing.core.PApplet;

import java.util.ArrayList;

public class Game extends PApplet {
    // TODO: declare game variables
    ArrayList<Tank> tankList;
    ArrayList<Tower> towerList;
    ArrayList<Bullet> bulletList;
    int timer = 50;
    int lostCount = 0;
    int tankNum = 0;
    boolean stillPlacing = true;
    boolean gameOver = false;

    int counter = 10;
    double xSpeed;
    double ySpeed;
    Bullet b;

    public void settings() {
        size(800, 800);   // set the window size

    }

    public void setup() {
        // TODO: initialize game variables
        tankList = new ArrayList<>();
        towerList = new ArrayList<>();
        bulletList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            //made 15 tanks to start
            Tank ta = new Tank(-80, 360);
            tankList.add(ta);
            tankNum +=5;
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
            timer = 50;// reset timer
            tankNum ++;
        }


        for (int i = 0; i < tankList.size(); i++) {
            if(tankList.get(i).containsBullet(bulletList)){
                tankList.get(i).minusLife();
                if(tankList.get(i).getLives()<=0) {
                    tankList.remove(i);
                    i--;
                }
            }else {
                //if(gameOver) {
                    tankList.get(i).update();
                    tankList.get(i).draw(this);
                //}

            }
            if((tankList.get(i).x) >= 800){
                lostCount++;
            }
        }

        for (Tower tower : towerList) {
            tower.draw(this);
            if(!stillPlacing) {
                tower.timer --;
                if(tower.timer<=0) {
                    b = tower.shoot();
                    Tank t = Tower.getClosest(b, tankList);
                    b.aimAt(t);
                    bulletList.add(b);
                    tower.timer = (int) (Math.random()*30+60);
                }
            }
        }
        for(Bullet bullet : bulletList){
            bullet.update();
            bullet.draw(this);

        }

        if(tankNum>=50){

            setup();
            background(0);
            textSize(15);
            text("Game Over!", 100, 100);
            text("Your Score: " + (double) lostCount / tankNum *100 + "%", 100, 150);
        }

    }
    public void mouseReleased() {
        if(counter>0) {
            if(mouseX>=40&&mouseX<=760) {
                if (mouseY >= 40 && mouseY <= 760) {
                    if(mouseY>=540||mouseY<=260) {
                        Tower t = new Tower(mouseX - 40, mouseY - 40);
                        towerList.add(t);
                        counter--;
                        stillPlacing = true;
                    }
                }
            }
        }else{
            stillPlacing = false;
        }
    }


    public static void main(String[] args) {
        PApplet.main("Game");
    }
}
