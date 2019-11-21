package Model;

import java.util.ArrayList;

import View.BoardView;

public class Board {
	private Bird[][] board;
	private Bird bird=new Bird();
	
	//Constructor for Board
	public Board() {
	board = new Bird[3][5];
	
	//initialize board 
	for(int row=0;row<3;row++)
	{
		for(int col=0;col<5;col++)
		{
			board[row][col]=bird; 
		}
	}
	}
	
	//print out the board 
	public void display () {
		
		BoardView.displayBoard(this);
				
    }
	
	//place a card on the board in specified row and col 
	public void placeCard(int row, int col, Bird b)
	{
		board[row][col]=b;
	}
	
	//input:the row and col player would like to check if space is occupied
	//output: true if not occupied
	public boolean spacefree(int row, int col) {
		
		if(board[row][col].getCardId()==0)
			return true;
		return false;
	}

//checks to see if the board is empty 
	public boolean isEmpty() {
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 5; col++){
				if (board[row][col].getCardId()!=0){
					return false;
				}
			}
		}
		return true;
	}
	// returns the number of birds currently on the board
	public int numBirdsOnBoard()
	{
		int numBirds = 0;
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 5; col++){
				if (board[row][col].getCardId()!=0){
					numBirds++;
				}
			}
		}
		return numBirds;
	}

	// returns the number of birds currently on the grasslands section of the board
	public int birdsInGrasslands()
	{
		int numBirds = 0;
		for(int i =0 ; i < 5; i++)
		{
			if(!board[1][i].getCardName().equals("-"))
				numBirds++;
		}
		return numBirds;
	}

	// returns the number of birds currently on the forrest section of the board
	public int birdsInForrest()
	{
		int numBirds = 0;
		for(int i =0 ; i < 5; i++)
		{
			if(!board[0][i].getCardName().equals("-"))
				numBirds++;
		}
		return numBirds;
	}
	// returns the number of birds currently on the forrest section of the board
		public int birdsInWetLands()
		{
			int numBirds = 0;
			for(int i =0 ; i < 5; i++)
			{
				if(!board[2][i].getCardName().equals("-"))
					numBirds++;
			}
			return numBirds;
		}
		//returns the current board 
		public Bird[][] getBoard()
		{
			return board;
		}
		
		//returns all the birds from specified row
		public ArrayList<Bird> getBirds(int row)
		{
			ArrayList<Bird> birds=new ArrayList<>();
			
				for(int col=0;col<5;col++)
				{
					
					if(board[row][col].getCardId()!=0)
					{
						
					birds.add(board[row][col]);
					}
				}				
				
			return birds;
		}
	
		//returns a Bird with specified ID
		public Bird searchBoard(int ID)
		{
			for (int row = 0; row < 3; row++){
				for (int col = 0; col < 5; col++){
					if (board[row][col].getCardId()==ID){
						return board[row][col];
					}
				}
			}
			
			return null; 
		}
		
		//returns the position row, col) in an int[] of Bird with specified ID
		public int[] findPos(int ID)
		{
			int[] pos = new int[2];
			for (int row = 0; row < 3; row++){
				for (int col = 0; col < 5; col++){
					if (board[row][col].getCardId()==ID){
						pos[0]=row;
						pos[1]=col;
						return pos;
					}
				}
			}
			
			return pos; 
		}
}
