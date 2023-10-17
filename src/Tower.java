import processing.core.PApplet;

public class Tower {
    int x, y, size;
    public Tower(int x, int y){
        this.x = x;
        this.y = y;
        size = 80;
    }
    public Bullet shoot(int xSpeed, int ySpeed){
        //if called, should produce a bullet at a certain position / going toward the first tank that's in the tower's range
        //needs to be passed the xSpeed and ySpeed that it sends a bullet out of. The bullet doesn't know these things
        return new Bullet(this.x, this.y, xSpeed, ySpeed);
    }
    public void draw(Game game){
        game.fill(255, 0, 255);
        game.rect(x, y, size, size);

    }
}
