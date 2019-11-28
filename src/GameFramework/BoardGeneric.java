package GameFramework;

import java.util.Objects;

import Model.Bird;

public class BoardGeneric {
	
	protected static int width; 
	protected static int height; 
	private String name;
	
	private Card[][] board;
	private Card card=new Card();
	
	public BoardGeneric() {
		width=0;
		height=0;
		name="";
	}
	
	public BoardGeneric(int w, int h, String n) {
		this.height=h; 
		this.width=w;
		this.name=n;
		
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
	
	public static int getWidth() {
        return width;
    }

    public void setWidth(int w) {
        this.width=w;
    }
    
    public static int getHeight() {
        return height;
    }

    public void setHeight(int h) {
        this.height=h;
    }
    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name=n;
    }
    
  //input:the row and col player would like to check if space is occupied
  	//output: true if not occupied
  	public boolean spacefree(int row, int col) {
  		
  		if(board[row][col].getId()==0)
  			return true;
  		return false;
  	}

  //checks to see if the board is empty 
  	public boolean isEmpty() {
		System.out.print("called function2");

  		for (int row = 0; row < height; row++){
  			for (int col = 0; col < width; col++){
  				if (board[row][col].getId()!=0){
  					return false;
  				}
  			}
  		}
  		return true;
  	}
  	// returns the number of birds currently on the board
  	public int numCardsOnBoard()
  	{
  		int numCards = 0;
  		for (int row = 0; row < height; row++){
  			for (int col = 0; col < width; col++){
  				if (board[row][col].getId()!=0){
  					numCards++;
  				}
  			}
  		}
  		return numCards;
  	}
  	
  	public Card searchBoard(int ID)
	{
		for (int row = 0; row < height; row++){
			for (int col = 0; col < width; col++){
				if (board[row][col].getId()==ID){
					return board[row][col];
				}
			}
		}
		
		return null; 
	}
	
	//returns the position row, col) in an int[] of Card with specified ID
	public int[] findPos(int ID)
	{
		int[] pos = new int[2];
		for (int row = 0; row < height; row++){
			for (int col = 0; col < width; col++){
				if (board[row][col].getId()==ID){
					pos[0]=row;
					pos[1]=col;
					return pos;
				}
			}
		}
		
		return pos; 
	}
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardGeneric board = (BoardGeneric) o;
        return name == board.name &&
                height == board.height &&
                width == board.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, name);
    }

    @Override
    public String toString() {
        return "Board{" +
                "width=" + width +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
