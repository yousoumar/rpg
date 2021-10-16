package game;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        boolean gameOver = false;
        System.out.println("\nBienvenue, voici les détails :\n");
        System.out.println("\t J désigne le joueur");
        System.out.println("\t M désigne les monstres");
        System.out.println("\t t + Entrez pour aller en haut");
        System.out.println("\t b + Entrez pour déscendre en bas");
        System.out.println("\t l + Entrez pour aller à gauche");
        System.out.println("\t r + Entrez pour aller à droite");
        System.out.println("\t q + Entrez pour quitter");
        System.out.println("\nBonne partie, et attention aux monstres !\n");
        Game map = new Game();
        
        while (!gameOver) {
        	
            Scanner inputDirection = new Scanner(System.in);
            System.out.print("\nEntrez votre commande : ");
            String direction = inputDirection.nextLine();

            switch (direction) {
                case "q" :
                	inputDirection.close();
                	System.out.print("Au revoir !");
                	gameOver = true;
                	break;
                default :
                	map.updatePositions(direction);
                	break;
            }
        }
    }


}
