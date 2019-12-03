package GameFramework;


public class GenericDice {
	private int roll;
	private int numSides; // default size is 6
	private boolean isScripted;
	private int[] scriptedRolls;
	private int index; // holds current position in scriptedRolls array
	public GenericDice() 
	{
		
		numSides = 6;
		index = 0;
		isScripted = false;
		
	}
	// if the user has passed in specific rolls they want it will return those rolls
	// if not it will return a random number between 1 and the numSides
	public int roll() {
		if(isScripted) 
		{
			roll = scriptedRolls[index];
			index++;
			return roll;
		}
		else
		{
			this.roll=(int)(Math.random()*numSides)+1;
			return this.roll;
		}
	}
	//user can set the size of the dice they want to use
	public void setNumSides(int sides) { numSides = sides;}
	public int getNumSides() {return numSides;}
	// lets the user pass in an array of ints for the rolls
	public void setScriptedRolls(int[] a)
	{
		if(a != null)
		{
			scriptedRolls = a;
			isScripted = true;
		}
		
	}
	public boolean isScripted() {return isScripted;}
}
