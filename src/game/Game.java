package game;
import java.util.*;

import entities.*;

public class Game {
	final int c = 10;
	private final Player player; 
    private final String[][] map = new String[c][c];
    private final ArrayList<Monster> monsters = new ArrayList<Monster>();
   
    public Game() {
    	Player player = new Player(c-2, 1);
    	this.player = player;
    	Monster monster1 = new Monster(2, 5);
    	Monster monster2 = new Monster(5, 3);
    	Monster monster3 = new Monster(3, 8);
    	Monster monster4 = new Monster(6, 1);
        this.monsters.add(monster1);
        this.monsters.add(monster2);
        this.monsters.add(monster3);
        this.monsters.add(monster4);
        newRound();
    }
    public void newRound() {
    	 generateBox();
         AddEntities();
         printCard();
    }
    public void generateBox() {
       
        for (int row=0; row<c; row++)
        {
            for (int col=0; col<c; col++)
            {
                if(col == c-1 || row == c-1) {
                	map[row][col] = " . ";
                
                	if (col == c-1) {
                		map[row][col] += "\n";
                	
                	}
                  
                }else if(col == 0 || row == 0) {
                	map[row][col] = " . ";
                	
                }
                
                else {
                
                	map[row][col] = "   ";
                }
            }
        }
       
    }
    
    private void printCard() {
        for (int i = 0; i<c; i++) {
            for (int j = 0; j<c; j++) {
                System.out.print(map[i][j]);
            }
  
        }
       
  
    }

    
    private void AddEntities() {
        int y;
        int x;
        
        for (int i = 0; i < monsters.size(); i++) {
            Monster monster = monsters.get(i);
            x = monster.getPositionX();
            y = monster.getPositionY();
            if ( player.isIntersect(monster)) {
                 map[x][y] = "💥 ";
                 printCard();
            	 System.out.println("\nVous avez croisez un monstre, vous êtes mort(e) !");
                 System.exit(0);
               

            }else if (player.isPlayerAtHome(c)) {
            	 map[player.getPositionX()][player.getPositionY()] = "🎉 ";
                 printCard();
             	 System.out.println("\nBravo, voues êtes rentré(e)s chez vous !");
                 System.exit(0);
            }
            else {
            	map[x][y] = " M ";
            }
          
           
        }
    	map[player.getPositionX()][player.getPositionY()] = " J ";

    }

    public void updatePositions(String direction) {
    	int x, y;
        switch (direction) {
            case "t" :
            	x = ((player.getPositionX() - 1) > 0) ? player.getPositionX() - 1 : player.getPositionX();
            	player.setPositionX(x);
            	break;
            case "b" :
            	x = ((player.getPositionX() + 1) < c-1) ? player.getPositionX() + 1 : player.getPositionX();
            	player.setPositionX(x);
            	break;
            case "r" :
            	y = ((player.getPositionY() + 1) < c-1) ? player.getPositionY() + 1 : player.getPositionY();
            	player.setPositionY(y);
            	break;
            case "l" :
            	y = ((player.getPositionY() - 1) > 0) ? player.getPositionY() - 1 : player.getPositionY();
            	player.setPositionY(y);
            	break;
        }
        
        for (int i = 0; i<c; i++) {
            for (int j = 0; j<c; j++) {
                map[i][j] = "";
            }
  
        }
        newRound();
    }

    

}
