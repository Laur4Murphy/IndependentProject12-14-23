import java.util.ArrayList;

public class Tank {
    private int x, y, xSpeed, lives;
    private final int size = 80;

    public Tank(int x, int y){
        this.x = x;
        this.y = y;
        xSpeed = 3;
        lives = 2;
    }

    public void update(){
        x += xSpeed;
    }

    public boolean containsBullet(ArrayList<Bullet> bulletList){
        for (Bullet bullet: bulletList) {
            if (bullet.getX()>this.x&&bullet.getX()<right()) {
                if(bullet.getY()>this.y&& bullet.getY()<bottom()) {
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
    public int getX(){ return this.x;}
    public int getY(){return this.y;}

}
