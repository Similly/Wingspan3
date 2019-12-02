package MonopolyView;

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

}
