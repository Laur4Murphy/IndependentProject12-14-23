import java.util.ArrayList;

public class Tank {
    int x, y, xSpeed, size, lives;
    public Tank(int x, int y){
        this.x = x;
        this.y = y;
        xSpeed = 3;
        size = 80;
        lives = 2;
    }
    public void update(){
        x += xSpeed;
    }
    public void keepInBounds(){
        //if off the screen, wrap back to x = 0;
    }
    public boolean containsBullet(ArrayList<Bullet> bulletList){
        for (Bullet bullet: bulletList) {
            if (bullet.x>this.x&&bullet.x<right()) {
                if(bullet.y>this.y&& bullet.y<bottom()) {
                    return true;
                }
            }
        }
        return false;
    }
    public void draw(Game game){
        game.fill(255, 0, 0);
        game.rect(x, y, size, size);

    }
    public void minusLife(){
        lives--;
    }
    public int getLives(){
        return this.lives;
    }
    public int right(){
        return this.x+this.size;
    }
    public int bottom(){
       return this.y+this.size;
    }

}
