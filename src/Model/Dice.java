package Model;

import java.util.Random;
import GameFramework.GenericDice;

//Dice class to produce a roll of dice for game
public class Dice extends GenericDice {
	
	//constructor 
	public Dice() {
		super();
	}
	
	public FoodTypes rollForFood(){
		return FoodTypes.values()[new Random().nextInt(FoodTypes.values().length)];
	}
}
