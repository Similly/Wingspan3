package Model;

import java.util.ArrayList;
import java.util.Random;

import View.MainView;

public class DumbAI extends WingspanPlayer {

	public DumbAI(int id) {
		super(id);
		
	}
	// Directly add eggs to a bird
    // needed this for AI
    public void addEggs(int id) 
    {
    	Bird sel=board.searchBoard(id);
    	int addEggs = 1;
		addEggs += board.birdsInGrasslands();
		eggCount = eggCount+addEggs; //update the egg count of the player
    	sel.setEggsOnBird(addEggs);
    	//update the board with updated Bird object
    	int[] pos=board.findPos(sel.getCardId());
    	int row=pos[0];
    	int col=pos[1];
    	board.placeCard(row, col, sel);
    	
    }
    public void playBirdAI()
    {
    	ArrayList<Bird> availableBirds = getAvailableBirds();
        Bird bird = availableBirds.get(0); // might want to change the way this works later
 	    Habitats habitat  = bird.getHabitats().get(0);
 	    playBird(bird, habitat);
    }
    public void playTurn()
    {
    	ArrayList<String> availableMoves = getAvailableMoves();
    	availableMoves.add("5: skip turn");
    	Random rand = new Random();
    	int index = rand.nextInt(availableMoves.size());
    	String move = availableMoves.get(index);
    	switch(move)
    	{
    		case "1: place bird":
    			   MainView.AIMoves(1);
    			   playBirdAI();
    	    	   return;
    		
    		case "2: gain food":
    			   MainView.AIMoves(2);
    	    	   gainFood();
    	    	   return;
    		case "3: lay eggs":
    			
    			   MainView.AIMoves(3);
    			   ArrayList<Bird> allBirds = getBirdsCanLayEggs();
    			   int id = allBirds.get(0).getId();
    	           addEggs(id);
    	           return;
    		case "4: draw bird card":
    			   MainView.AIMoves(4);
    	    	   drawBird();
    	    	   return;
    		case "5: skip turn":
    			   MainView.AIMoves(5);
    			   return;
    		
    	}
    	return;
    }
}
