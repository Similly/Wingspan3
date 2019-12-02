package Test;

//import org.junit.Before;
import org.junit.Test;

import GameFramework.Card;
import Model.Bird;
import Model.Board;
import Model.FoodTypes;
import Model.Habitats;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class BoardTest { 

    @Test
    public void spaceFree() {
    	Board board=new Board("wingspan"); 
    	assertTrue(board.spacefree(0,0));
    }

    @Test
    public void isEmpty() {
    	Board board=new Board("wingspan"); 

    	assertTrue(board.isEmpty());
    }

    @Test
    public void numBirdsOnBoard() {
    	Board board=new Board("wingspan"); 

    	HashMap<FoodTypes, Integer> food = new HashMap<>();
    	food.put(FoodTypes.Seed,1);
    	ArrayList<Habitats> hab = new ArrayList<>();
    	hab.add(Habitats.Forrest);    	
    	Bird bird = new Bird(2,2, "exampleBird", 2, 2, food,hab);
    
    	board.placeCard(0,0,bird);
    	
    	assertEquals(board.numBirdsOnBoard(),1);
    }
    	      
    @Test
    public void birdsInGrassLands()
    {
    	Board board=new Board("wingspan"); 

    	HashMap<FoodTypes, Integer> food = new HashMap<>();
    	food.put(FoodTypes.Seed,1);
    	ArrayList<Habitats> hab = new ArrayList<>();
    	hab.add(Habitats.Forrest);    	
    	Bird bird = new Bird(2,2, "exampleBird", 2, 2, food,hab);
    
    	board.placeCard(1,1,bird);
    	
    	assertEquals(board.birdsInGrasslands(),1);
    }
    @Test
    public void birdsInForrest()
    {
    	Board board=new Board("wingspan"); 
 
    	HashMap<FoodTypes, Integer> food = new HashMap<>();
    	food.put(FoodTypes.Seed,1);
    	ArrayList<Habitats> hab = new ArrayList<>();
    	hab.add(Habitats.Forrest);    	
    	Bird bird = new Bird(2,2, "exampleBird", 2, 2, food,hab);
    
    	board.placeCard(0,0,bird);
    	
    	assertEquals(board.birdsInForrest(),1);
    }
    @Test
    public void birdsInWetLands()
    {
    	Board board=new Board("wingspan"); 

    	HashMap<FoodTypes, Integer> food = new HashMap<>();
    	food.put(FoodTypes.Seed,1);
    	ArrayList<Habitats> hab = new ArrayList<>();
    	hab.add(Habitats.Forrest);    	
    	Bird bird = new Bird(2,2, "exampleBird", 2, 2, food,hab);
    
    	board.placeCard(2,0,bird);
    	
    	assertEquals(board.birdsInWetLands(),1);
    }
    
    @Test 
    public void findPos()
    {
    	Board board=new Board("wingspan"); 

    	HashMap<FoodTypes, Integer> food = new HashMap<>();
    	food.put(FoodTypes.Seed,1);
    	ArrayList<Habitats> hab = new ArrayList<>();
    	hab.add(Habitats.Forrest);    	
    	Bird bird = new Bird(2,2, "exampleBird", 2, 2, food,hab);
    
    	board.placeCard(0,0,bird);
    	
    	int[] pos = {0,0}; 
    	
    	assertArrayEquals(board.findPos(2),pos);
    }
    /*@Test
    public void searchBird() {
    	Board board=new Board(); 
    	HashMap<FoodTypes, Integer> food = new HashMap<>();
    	food.put(FoodTypes.Seed,1);
    	ArrayList<Habitats> hab = new ArrayList<>();
    	hab.add(Habitats.Forrest);    	
    	Bird bird = new Bird(2,2, "exampleBird", 2, 2, food,hab);
    
    	board.placeCard(0,0,bird);
    	
    	    	
    	assertThat(board.searchBoard(2)).isEqualToComparingFieldByField(bird);
    }*/
}
