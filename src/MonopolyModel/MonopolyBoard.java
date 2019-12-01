package MonopolyModel;

import GameFramework.BoardGeneric;
import Model.Bird;
import GameFramework.Card;

public class MonopolyBoard extends BoardGeneric {
	private int width=11; 
	private int height =11; 
	private Card[][] board;
	private Card card=new Card();
	
	public MonopolyBoard() {
		super();
	}
	
	public MonopolyBoard(String name)
	{
		super(getWidth(),getHeight(),name);
		board = new Card[height][width];
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
    	for(int row=0;row<height;row++)
		{
			for(int col=0;col<width;col++)
			{
				
				String name = board[row][col].getName();
				System.out.printf("%1.1s %12.12s", "|", name);
				
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println();
    }
    
  //place a card on the board in specified row and col 
  	public void placeCard(int row, int col, Card c)
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


}
