package Model;

import Controller.Main;
import GameFramework.Player;
import View.PlayerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WingspanPlayer extends Player {

    private int eggCount;
    private int actionCubes;
    private ArrayList<Bird> birds;
    private Board board;
    private Dice dice;
    private HashMap<FoodTypes, Integer> food;

    public WingspanPlayer(int id){
        super(id);
        this.eggCount = 0;
        this.actionCubes = 8;
        birds = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            birds.add(Main.drawBirdFromStack());
        }
        this.board = new Board("wingspan");
        this.dice = new Dice();
        this.food = new HashMap<>();
        this.food.put(FoodTypes.None, 1);
        this.food.put(FoodTypes.Rodent, 1);
        this.food.put(FoodTypes.Fish, 1);
        this.food.put(FoodTypes.Fruit, 1);
        this.food.put(FoodTypes.Invertebrate, 1);
        this.food.put(FoodTypes.Wild, 1);
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
    
    //lay eggs on the selected bird
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
    	
    	PlayerView.printLayEggBirds(allBirds);
    	
    	int num=PlayerView.selectBird();
		int ID=allBirds.get(num-1).getCardId();
		Bird sel=board.searchBoard(ID);

		int addEggs = 1;
		addEggs += board.birdsInGrasslands();
		
		
		eggCount = eggCount+addEggs; //update the egg count of the player
    	
    	sel.setEggsOnBird(addEggs);
    	
    	//update the board with updated Bird object
    	int[] pos=board.findPos(sel.getCardId());
    	
    	int row=pos[0];
    	int col=pos[1];
    	
    	board.placeCard(row, col, sel);
    	
    	return addEggs; 
    }
    // Directly add eggs to a bird
    // needed this for AI
    public void addEggs(int id) 
    {
    	Bird sel=board.searchBoard(id);
    	int addEggs = 1;
		addEggs += board.birdsInGrasslands();
		eggCount = eggCount+addEggs; //update the egg count of the player
    	sel.setEggsOnBird(addEggs);
    	//update the board with updated Bird object
    	int[] pos=board.findPos(sel.getCardId());
    	int row=pos[0];
    	int col=pos[1];
    	board.placeCard(row, col, sel);
    	
    }
    // returns all birds that can lay eggs
    public ArrayList<Bird> getBirdsCanLayEggs()
    {
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
    	return allBirds;
    }
    //goes through specified habitat and returns an array of available birds to lay eggs on
    public ArrayList<Bird> availableBirds(int row) {
        int newEggs=1;
    	ArrayList<Bird> birds = board.getBirds(row);
    	ArrayList<Bird> birdsFinal = new ArrayList<>(); 
    	newEggs+=board.birdsInGrasslands();
    	
    	for(int index=0;index<(birds.size());index++) {
    		
    		//check if egg can be added
    		if(birds.get(index).getMaxEggCount()>=(birds.get(index).getEggsOnBird()+newEggs)) {
    			birdsFinal.add(birds.get(index));
    		}  
    		
    	}     	
        return birdsFinal;
    }

    // add a bird to the players bird arraylist
    public int drawBird(){
        int drawBirds = 1;
        drawBirds += board.birdsInWetLands();

        for (int i = 0; i < drawBirds; i++){
            birds.add(Main.drawBirdFromStack());
        }

        return drawBirds;
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

        //TODO check if move is available
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

        if (!allBirds.isEmpty()){
            availableMoves.add("3: lay eggs");
        }

        availableMoves.add("4: draw bird card");
        return availableMoves;
    }
    // calculates score for the player
    public int getScore() {

        ArrayList<Bird> birdsOnBoard = board.getBirds(0);
        birdsOnBoard.addAll(board.getBirds(1));
        birdsOnBoard.addAll(board.getBirds(2));

        int birdScore = 0;

        for (Bird bird : birdsOnBoard){
            birdScore += bird.getCardScore();
        }
        return eggCount + birdScore;
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
    
    public int getNumBirds() {return birds.size();}
    
 // for acceptance test.
    public void testAddBird(Bird b)
    {
    	birds.add(b);
    }
    public void testClearBirdStack() { birds.clear();}
    public void testGainFood() {
    this.food.put(FoodTypes.Rodent, 1);
    this.food.put(FoodTypes.Fish, 1);
    this.food.put(FoodTypes.Fruit, 1);
    this.food.put(FoodTypes.Invertebrate, 1);
    this.food.put(FoodTypes.Wild, 1);
    this.food.put(FoodTypes.Seed, 1);
    }
    public void testClearFood() {
    	this.food.put(FoodTypes.Rodent, 0);
        this.food.put(FoodTypes.Fish, 0);
        this.food.put(FoodTypes.Fruit, 0);
        this.food.put(FoodTypes.Invertebrate, 0);
        this.food.put(FoodTypes.Wild, 0);
        this.food.put(FoodTypes.Seed, 0);
    }
}
