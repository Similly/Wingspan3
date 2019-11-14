package Model;

import Controller.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import static Model.FoodTypes.*;

public class Player {

    private int id;
    private int foodCount;
    private int eggCount;
    private int actionCubes;
    private ArrayList<Bird> birds;
    private Board board;
    private Dice dice;
    private HashMap<FoodTypes, Integer> food;

    public Player(int id){
        this.id = id;
        this.foodCount = 5;
        this.eggCount = 0;
        this.actionCubes = 8;
        birds = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            birds.add(Main.drawBirdFromStack());
        }
        this.board = new Board();
        this.dice = new Dice();
        this.food = new HashMap<>();
        this.food.put(FoodTypes.None, 1);
        this.food.put(FoodTypes.Rodent, 1);
        this.food.put(FoodTypes.Fish, 1);
        this.food.put(FoodTypes.Fruit, 1);
        this.food.put(FoodTypes.Invertebrate, 1);
        this.food.put(Wild, 1);
        this.food.put(FoodTypes.Seed, 1);
    }

    //returns the available birds
    public ArrayList<Bird> getAvailableBirds(){
        ArrayList<Bird> availableBirds = new ArrayList<Bird>();
        HashMap<FoodTypes, Integer> requiredFood;
        Bird bird;
        boolean available = true;

        for(int i = 0; i < birds.size(); i++){
            bird = birds.get(i);
            requiredFood = bird.getFood();
            for (Map.Entry me : requiredFood.entrySet()){
                if ((me.getValue() != null && ((int) me.getValue()) <= this.food.get(me.getKey()))){
                    available = true;
                } else {
                    available = false;
                    break;
                }
            }
            if (available){
                availableBirds.add(bird);
            }
        }

        return availableBirds;
    }

    //plays a bird to the board
    public void playBird(Bird bird, Habitats habitat){
        HashMap<FoodTypes, Integer> requiredFood = bird.getFood();

        for (int i = 0; i < 5; i++){
            if (this.board.spacefree(habitat.getValue(), i)){

                this.board.placeCard(habitat.getValue(), i, bird);

                for (Map.Entry me : requiredFood.entrySet()){
                    if (me.getValue() != null){
                        food.put((FoodTypes) me.getKey(), food.get(me.getKey()) - (int) me.getValue());
                    }
                }

                birds.remove(bird);
                break;
            }
        }
    }

    // gets food based on how many birds are in the first habitat
    public HashMap<FoodTypes, Integer> gainFood(){

        int diceRolls = 1;
        diceRolls += board.birdsInForrest();

        for (int i = 0; i < diceRolls; i++){
            FoodTypes foodType = dice.rollForFood();
            this.food.put(foodType, this.food.get(foodType) + 1);
        }

        return this.food;
        //System.out.println("You have " + board.birdsInForrest() + " birds in your forrest section, so your food count has increased by " + gainedFood + "! Your new food count is " + this.foodCount + "!");
    }
    
    // lays eggs based on how many birds are in the middle habitat
    //get birds on board 
    //check available 
    //ask user to pick bird to lay egg(s) on
    //execute
    //number of eggs laying down depend on how many birds in habitats 
    //lay all eggs on one bird for now 
    public int layEggs(){
    	
    	//check forrest
    	ArrayList<Bird> birdsForrest = this.availableBirds(0);
    	//check grasslands
    	ArrayList<Bird> birdsGrass = this.availableBirds(1);
    	//check wetlands
    	ArrayList<Bird> birdsWet = this.availableBirds(2);
    	
    	//combine all birds into one list
    	ArrayList<Bird> allBirds = new ArrayList<>();
    	allBirds.addAll(birdsForrest);
    	allBirds.addAll(birdsGrass);
    	allBirds.addAll(birdsWet);
    	
    	System.out.println("All Available Birds to Lay Eggs on:");
    	for(int i =0;i<allBirds.size();i++)
    	{
    		System.out.println(i+1+". "+allBirds.get(i).getName()+" ");
    	}
    	System.out.println();
    	System.out.println("Please Enter the Number of the Bird You Would Like to Lay Your Eggs On");

		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int ID=allBirds.get(num-1).getId();
		Bird sel=board.searchBoard(ID);
		
		//need to get the habitat of the bird selected so i can figure out how many eggs to lay 
		
    	
    	//System.out.println(sel.getEggsOnBird());
    	sel.setEggsOnBird(3);//this will change when figure out how to get habitat of selected bird
    	//System.out.println(sel.getEggsOnBird());
    	//System.out.println(sel.getName());
    	
    	return 0; //unsure what the function should be returning?
    	}
    
    public ArrayList<Bird> availableBirds(int row)
    { int newEggs=1;
    	ArrayList<Bird> birds = board.getBirds(row);
    	ArrayList<Bird> birdsFinal = new ArrayList<>(); 
    	if(row == 0)
    	{
    	newEggs+=board.birdsInForrest();
    	}
    	else if(row==2)
    	{
    		newEggs+=board.birdsInGrasslands();
    	}
    	else {
    		newEggs+=board.birdsInWetLands();
    	}
    	
    		
    	
    	for(int index=0;index<(birds.size());index++)
    	{
    		
    		//check if egg can be added
    		if(birds.get(index).getMaxEggCount()>=(birds.get(index).getEggsOnBird()+newEggs))
    		{
    			birdsFinal.add(birds.get(index));
    		}
    		 
    		
    	}
    	
    	
return birdsFinal;
    }

    // add a bird to the players bird arraylist
    public void drawBird(){
        birds.add(Main.drawBirdFromStack());
    }

    // returns the moves a player can make
    public ArrayList<String> getAvailableMoves(){

        ArrayList<String> availableMoves = new ArrayList<>();

        HashMap<FoodTypes, Integer> requiredFood;
        Bird bird;
        boolean available = true;

        for(int i = 0; i < birds.size(); i++){
            bird = birds.get(i);
            requiredFood = bird.getFood();
            for (Map.Entry me : requiredFood.entrySet()){
                if ((me.getValue() != null && ((int) me.getValue()) <= this.food.get(me.getKey()))){
                    available = true;
                } else {
                    available = false;
                    break;
                }
            }
            if (available){
                availableMoves.add("1: place bird");
                break;
            }
        }

        availableMoves.add("2: gain food");

      
        availableMoves.add("3: lay eggs");
      

        availableMoves.add("4: draw bird card");
        return availableMoves;
    }
    // calculates score for the player
    public int getScore()
    {
    	return eggCount + board.numBirdsOnBoard();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }

    public int getEggCount() {
        return eggCount;
    }

    public void setEggCount(int eggCount) {
        this.eggCount = eggCount;
    }

    public ArrayList<Bird> getBirds() {
        return birds;
    }

    public void setBirds(ArrayList<Bird> birds) {
        this.birds = birds;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getActionCubes() { return actionCubes; }

    public void setActionCubes(int actionCubes) { this.actionCubes = actionCubes; }
}
