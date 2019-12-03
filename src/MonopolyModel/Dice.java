package MonopolyModel;

import GameFramework.GenericDice;

//Dice class to produce a roll of dice for game
public class Dice extends GenericDice {
	
	//constructor 
	public Dice() {
		super();
	}
	public int getRoll()
	{
		return roll();
	}
}
