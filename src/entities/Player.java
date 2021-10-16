package entities;
import java.util.ArrayList;


public class Player extends Entity {
  
    protected ArrayList<String> inventory;

    public Player(int x, int y) {
        super(x, y);
    }


    public void setPositionX(int x) {
    	super.x = x;
    	
    }
    public void setPositionY(int y) {
    	super.y = y;
    	
    }

    public boolean isIntersect(Monster monster) {
       if (this.getPositionX() == monster.getPositionX() && this.getPositionY() == monster.getPositionY()) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isPlayerAtHome(int width) {
    	if (super.x == 1 && super.y == width-2 ) {
    		return true;
    	}
    	return false;
    }

   

}
