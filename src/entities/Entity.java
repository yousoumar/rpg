package entities;

public abstract class Entity {

    protected int x;
	protected int y;

    public Entity(int x, int y) {
        this.x =x; this.y = y;
    }

    


    public int getPositionX() {
        return x;
    }
    public int getPositionY() {
        return y;
    }
    

}
