package Game;

public class Dice {
	private int roll;
	
	public Dice() {
		roll=0;
	}
	
	public int Roll() {
		this.roll=(int)(Math.random()*6)+1;
		return this.roll; 
	}	
}
