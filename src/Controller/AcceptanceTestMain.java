
package Controller;

import java.util.ArrayList;
import java.util.Arrays;

import Model.WingspanPlayer;
import View.MainView;



public class AcceptanceTestMain {

    public static void main(){
    	 System.out.println("Enter the number of the test you want to run");
    	 System.out.println("Test 0: 1 player, plays a bird turn 1 then skips the rest of his turns");
    	 System.out.println("Test 1: 1 player, gains food then plays a bird he could not play before");
    	 System.out.println("Test 2: 1 player, plays a bird that is worth 6 points lays 1 egg \n"
    	 		+ "		  for 1 point then ends game and prints score");
    	 System.out.println("Test 3: 4 players, each player plays a bird then prints the boards and scores for the players");
    	 int testID = MainView.getInt(); 
        switch (testID){
            case 0:
                acceptanceTest0();
                break;

            case 1:
                acceptanceTest1();
                break;

            case 2:
                acceptanceTest2();
                break;

            case 3:
                acceptanceTest3();
                break;

            case 4:
                acceptanceTest4();
                break;
        }
    }
    private static void acceptanceTest0() {
        System.out.println("test 0");
        
        int[] moves = {1,5,6};
        WingspanPlayer p1 = new WingspanPlayer(1);
        Controller.Main.testTurn(p1, moves);
        
        System.out.println("The expected out put is: ");
        
        System.out.println("|            -|            -|            -|            -|            -|");
        System.out.println("| Indigo Bunti|            -|            -|            -|            -|");
        System.out.println("|            -|            -|            -|            -|            -|");
        
    }
 // the player should not be able to play birds at first 
 // the player should then gain food and gain the ability to play birds
    private static void acceptanceTest1() {
        System.out.println("test 1");
        
        int [] moves = {2};
        WingspanPlayer p1 = new WingspanPlayer(1);
        p1.testClearFood(); // clearing food so that no birds can be played
		p1.testClearBirdStack(); // clearing the random birds we start with
		p1.testAddBird(Main.testDrawBird(1)); // adding specific birds the players hand for testing
		p1.testAddBird(Main.testDrawBird(2));
		
        Controller.Main.testTurn(p1, moves);
        System.out.println("\nThe expected out put is:");
        
        System.out.println("no birds printed before gaining food");
        System.out.println("first bird is Indigo bunting");
        System.out.println("second bird is Rose-breasted Grosebeak");
    }

    private static void acceptanceTest2() {
        System.out.println("test 2");
        int [] moves = {3};
        WingspanPlayer p1 = new WingspanPlayer(1);
        p1.testClearBirdStack(); // clear out random birds from stack
		p1.testAddBird(Main.testDrawBird(1)); // add specific birds that can lay eggs
		p1.testAddBird(Main.testDrawBird(2)); // and or be played with starting food
		p1.testAddBird(Main.testDrawBird(3));
		
		Controller.Main.testTurn(p1, moves);
		
        System.out.println("\nThe expected out put is:");
        System.out.println("The player lays 1 egg and has a total of 1");
        System.out.println("The players score is 7");
        
    }

    private static void acceptanceTest3() {
        System.out.println("test 3");
        int [] moves = {4,5,6};
        WingspanPlayer p1 = new WingspanPlayer(1);
        WingspanPlayer p2 = new WingspanPlayer(2);
        WingspanPlayer p3 = new WingspanPlayer(3);
        WingspanPlayer p4 = new WingspanPlayer(4);
        // clear the random birds
        p1.testClearBirdStack();
        p2.testClearBirdStack();
        p3.testClearBirdStack();
        p4.testClearBirdStack();
        // add specific birds to the players hands
        p1.testAddBird(Main.testDrawBird(1));
		p2.testAddBird(Main.testDrawBird(2));
		p3.testAddBird(Main.testDrawBird(3));
		p4.testAddBird(Main.testDrawBird(4));
		// plays each players bird then prints board and score
		Controller.Main.testTurn(p1,moves);
		Controller.Main.testTurn(p2,moves);
		Controller.Main.testTurn(p3, moves);
		Controller.Main.testTurn(p4, moves);
		
		System.out.println("\nThe expected out put is:");
		System.out.println("player 1 score is 5\r\n" + 
				"| Indigo Bunti|            -|            -|            -|            -|\r\n" + 
				"|            -|            -|            -|            -|            -|\r\n" + 
				"|            -|            -|            -|            -|            -|\r\n" + 
				"\r\n" + 
				"player 2 score is 6\r\n" + 
				"| Rose-breaste|            -|            -|            -|            -|\r\n" + 
				"|            -|            -|            -|            -|            -|\r\n" + 
				"|            -|            -|            -|            -|            -|\r\n" + 
				"\r\n" + 
				"player 3 score is 6\r\n" + 
				"| Western Tana|            -|            -|            -|            -|\r\n" + 
				"|            -|            -|            -|            -|            -|\r\n" + 
				"|            -|            -|            -|            -|            -|\r\n" + 
				"\r\n" + 
				"player 4 score is 9\r\n" + 
				"|   Bald Eagle|            -|            -|            -|            -|\r\n" + 
				"|            -|            -|            -|            -|            -|\r\n" + 
				"|            -|            -|            -|            -|            -|");
        
    }

    private static void acceptanceTest4() {
        System.out.println("test 4");
    }
}
