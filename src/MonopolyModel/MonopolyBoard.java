package MonopolyModel;

import GameFramework.BoardGeneric;
import Model.Bird;
import MonopolyView.MonopolyBoardView;
import View.BoardView;
import GameFramework.Card;

public class MonopolyBoard extends BoardGeneric {
	private int width=11; 
	private int height =11; 
	private MonopolyCard[][] board;
	private MonopolyCard card = new MonopolyCard();
	
	public MonopolyBoard() {
		super();
	}
	
	public MonopolyBoard(String name)
	{
		super(getWidth(),getHeight(),name);
		board = new MonopolyCard[height][width];
		//initialize board
		for(int row=0;row<height;row++)
		{
			for(int col=0;col<width;col++)
			{
				board[row][col]=card; 
			}
		}
	}
	
	public int getBoardWidth() {
        return getWidth();
    }

    

    public String getBoardName() {
        return getName();
    }

    public void setBoardName(String name) {
        setName(name);
    }
    
    
    
    public int getBoardHeight()
    {
    	return getHeight(); 
    }
    
    public void display() {
    	
    		
    		MonopolyBoardView.displayBoard(this);  		
    				
        
    }
    
  //place a card on the board in specified row and col 
  	public void placeCard(int row, int col, MonopolyCard c)
  	{
  		
  		board[row][col]=c;
  	}
  	
  	//input:the row and col player would like to check if space is occupied
  	//output: true if not occupied
  	public boolean spacefree(int row, int col) {
  		
  		if(board[row][col].getId()==0)
    			return true;
    		return false;
  		
  		
  	}
  	
  //returns the current board 
  		public MonopolyCard[][] getBoard()
  		{
  			return board;
  		}


	public MonopolyCard getCard(int row, int col) {
		return board[row][col];
	}
}
