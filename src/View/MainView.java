package View;

import java.util.ArrayList;
import java.util.Scanner;

import Model.WingspanPlayer;

public class MainView {
	// welcome message
	public static void welcomeMessage() 
	{
		System.out.println("+++ Welcome to Wingspan! +++\n" +
                "Please enter amount of players(1-4) or press 5 for acceptance testing:");
	}	
	// don't close scanner the program will throw a NoSuchElement Exception
	@SuppressWarnings("resource")
	public static int getInt()
	{
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		return num;
	}
	// says which players turn it is
	public static void playerTurn(int id) {
		 System.out.println("It's the turn of Player " + id);
	}
	// prints number of action cubes
	public static void actionCubes(int cubes)
	{
		System.out.println("You have " + cubes + " Action Cubes left!");
	}
	// prints available moves
	public static void availableMoves(ArrayList<String> moves)
	{
		System.out.println("Your available moves are:\n");
        for (int j = 0; j < moves.size(); j++){
            System.out.println(moves.get(j));
        }
        System.out.println("5: End turn");
        System.out.println("\nChoose one of the available moves by typing its number!");
	}
	// prints the players scores
	public static void printScores(WingspanPlayer[] players)
	{
		int i = 1;
    	for(WingspanPlayer p : players)
    	{
    		System.out.println("player " + i + " score is " + p.getScore());
    		i++;
    	}
	}
}