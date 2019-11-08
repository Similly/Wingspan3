package view;

import Game.Board;


public class BoardView {
	
	public static void displayBoard(Board board)
	{
		for(int row=0;row<3;row++)
		{
			for(int col=0;col<5;col++)
			{
				//String name=board[row][col].getName();
				//System.out.printf("%1.1s %12.12s", "|", name);
				
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println();
	}

}
