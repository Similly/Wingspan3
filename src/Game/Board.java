
package Game;


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

		for(int row=0;row<3;row++)
		{
			for(int col=0;col<5;col++)
			{
				
				System.out.printf("|"+String.format("%8s", board[row][col].getName()));
			}
			System.out.println();
		}
		System.out.println();
    }
	
	//place a card on the board in specified row and col 
	public void placeCard(int row, int col, Bird b)
	{
		board[row][col]=b;
	}
	
	//input:the row and col player would like to check if space is occupied
	//output: true if not occupied
	public boolean spacefree(int row, int col) {
		
		if(board[row][col].getId()==0)
			return true;
		return false;
	}


	public boolean isEmpty() {
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 5; col++){
				if (board[row][col].getId()!=0){
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
				if (board[row][col].getId()!=0){
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
			if(!board[1][i].getName().equals(""))
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
			if(!board[0][i].getName().equals(""))
				numBirds++;
		}
		return numBirds;
	}
}



