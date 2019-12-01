package MonopolyView;

import MonopolyModel.MonopolyBoard;

public class MonopolyBoardView {
	
	public static void displayBoard(MonopolyBoard board)
	{
		for(int row=0;row<11;row++)
		{
			for(int col=0;col<11;col++)
			{
				
				String name = board.getBoard()[row][col].getName();
				System.out.printf("%1.1s %12.12s", "|", name);
				
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println();
	}

}
