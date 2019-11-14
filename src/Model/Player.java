package Model;

import Controller.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player {

    private int id;
    private int eggCount;
    private int actionCubes;
    private ArrayList<Bird> birds;
    private Board board;
    private Dice dice;
    private HashMap<FoodTypes, Integer> food;

    public Player(int id){
        this.id = id;
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
    // lays eggs based on how many birds are in the middle habitat
    public int layEggs(){
    	int newEggs = 1;
    	newEggs += board.birdsInGrasslands();
    	eggCount += newEggs;

    	return newEggs;
    	//System.out.println("Your egg count has increased by " + newEggs  + "! Your new egg count is " +eggCount + "!");
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
