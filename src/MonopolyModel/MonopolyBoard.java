package MonopolyModel;

import GameFramework.BoardGeneric;

public class MonopolyBoard extends BoardGeneric {
	private int width=11; 
	private int height =11; 
	public MonopolyBoard() {
		super();
	}
	
	public MonopolyBoard(String name)
	{
		super(getWidth(),getHeight(),name);
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

}
