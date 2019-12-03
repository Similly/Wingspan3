package MonopolyView;

import MonopolyModel.MonopolyPlayer;

import java.util.Scanner;

public class MonopolyMainView {
	// welcome message
	public static void welcomeMessage()
	{
		System.out.println("+++ Welcome to Monopoly! +++\n" +
				"Enter amount of players(1-4):");
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

	// demands the player to roll the dice
	public static void pleaseRollDice(){
		System.out.println("Please enter any character to roll the dice!");
	}

	// prints the number of steps a player can move forward
	public static void printNumSteps(int numSteps){
		System.out.println("You rolled a " + numSteps);
	}

	public static void printCard(String cardName, int cardCost, int score) {
		System.out.println("Do you want to buy the following field?\nName: " + cardName + "\nCost: " + cardCost + "\nScore: " + score);
	}

	public static void printPropertyBought() {
		System.out.println("Property Bought!");
	}


	public static void printPropertyNotBought() {
		System.out.println("Property not bought!");
	}

	public static void printWinner(MonopolyPlayer winner, int highscore) {
		System.out.println("Player " + winner.getId() + " won!\nScore: " + highscore);
	}
}
