package Test;

import static org.junit.Assert.*;

import Model.DumbAI;
import org.junit.Before;
import org.junit.Test;

import Controller.Main;

public class DumbAITest {

	 @Before
	    public void setUp() throws Exception {
	        Main.initBirds();
	    }
	 @Test
	 public void playBirdAI()
	 {
		 	DumbAI p1 = new DumbAI(1);
	        p1.testClearBirdStack(); // clear out random birds from stack
			p1.testAddBird(Main.testDrawBird(1)); // add specific birds that can lay eggs
			p1.playBirdAI();
			assertFalse(p1.getBoard().isEmpty() );
	 }
	 @Test
	 public void addEggs() 
	 {
		 	DumbAI p1 = new DumbAI(1);
	        p1.testClearBirdStack(); // clear out random birds from stack
			p1.testAddBird(Main.testDrawBird(1)); // add specific birds that can lay eggs
			p1.playBirdAI();
			p1.addEggs(Main.testDrawBird(1).getId());
			assertEquals(p1.getEggCount(), 1);
	 }
	 
	

}
