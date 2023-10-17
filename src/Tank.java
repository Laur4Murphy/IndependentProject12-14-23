public class Tank {
    int x, y, xSpeed, size;
    public Tank(int x, int y){
        this.x = x;
        this.y = y;
        xSpeed = 4;
        size = 80;
    }
    public void update(){
        x += xSpeed;
    }
    public void keepInBounds(){
        //if off the screen, wrap back to x = 0;
    }
    public void draw(Game game){
        game.fill(255, 0, 0);
        game.rect(x, y, size, size);

    }


}
