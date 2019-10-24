
package Game;


public class Board {
	private String[][] board;
	private final String EMPTY="[ ]"; 
	
	//Constructor for Board
	public Board() {
	board = new String[3][5];
	
	//initialize board 
	for(int row=0;row<3;row++)
	{
		for(int col=0;col<5;col++)
		{
			board[row][col]=EMPTY; 
		}
	}
	}
	
	//print out the board 
	public void display () {

		for(int row=0;row<3;row++)
		{
			for(int col=0;col<5;col++)
			{
				System.out.print(board[row][col]); 
			}
			System.out.println();
		}
		System.out.println();
    }
	
	//place a card on the board in specified row and col 
	public void placeCard(int row, int col)
	{
		board[row][col]="[X]";
	}
	
	//input:the row and col player would like to check if space is occupied
	//output: true if not occupied
	public boolean spacefree(int row, int col) {
		
		if(board[row][col]=="[ ]")
			return true;
		return false;
	}


	public boolean isEmpty() {

		return true;
	}
}



