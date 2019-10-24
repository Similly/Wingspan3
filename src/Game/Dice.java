package Game;

//Dice class to produce a roll of dice for game 
public class Dice {
	private int roll;
	
	//constructor 
	public Dice() {
		roll=0;
	}
	//random number generator between 1-6 for roll
	//returns int roll 
	public int roll() {
		this.roll=(int)(Math.random()*6)+1;
		return this.roll; 
	}	
}
