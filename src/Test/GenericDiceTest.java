package Test;

import static org.junit.Assert.*;

import org.junit.Test;
import GameFramework.GenericDice;

public class GenericDiceTest {

	@Test // tests the scripted rolls in the dice
	public void roll()
	{ 
		int i[] = {1,2,3,4};
		GenericDice dice = new GenericDice();
		dice.setScriptedRolls(i);
		assertEquals(dice.roll(),1);
	}
}
