package Model;

import java.util.ArrayList;

import View.MainView;

public class SmartAI extends DumbAI{

	public SmartAI(int id) {
		super(id);
		
	}
	
	
	
    // A start to the AI
    // It will always play a bird if it can
    // if it has a bird but not enough food it will gain food until it can play it
    // if the board is not full and its out of birds it will draw birds.
    // if the board is full of birds it will then lay eggs.
	
	@Override
	public void playTurn()
	{
		ArrayList<String> availableMoves = getAvailableMoves();
		ArrayList<Bird> availableBirds = getAvailableBirds();
		 if(availableBirds.size() >0)
	       {
	    	  
	    	  playBirdAI();
	       }
	       // we have birds but not enough food. gain food.
	       if(getNumBirds() > 0)
	       {
	    	   MainView.AIMoves(2);
	    	   gainFood();
	    	   return;
	       }// if there is room on the board for more birds, get more birds!
	       if(getNumBirds() == 0 && !getBoard().isFull())
	       {
	    	   MainView.AIMoves(4);
	    	   drawBird();
	    	   return;
	       }
	       
	       // lay the eggs
	       ArrayList<Bird> allBirds = getBirdsCanLayEggs();
	       if (!allBirds.isEmpty()){
	    	   MainView.AIMoves(3);
	           int id = allBirds.get(0).getId();
	           addEggs(id);
	       }
	        
	}
}
