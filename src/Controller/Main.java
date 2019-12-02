package Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import Model.*;
import View.MainView;
import View.PlayerView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

    private static int amountOfPlayers;
    private static WingspanPlayer[] players;
    private static Dice dice;
    private static int turn, round;
    private static ArrayList<Bird> birdStack = new ArrayList<>();

    public static void main(String[] args){
    	    	

        initBirds();
        init();

        turn = 0;
        round = 0;
        while (round < 3){
            turn(players[turn%amountOfPlayers]);
            turn++;
            if(turn%amountOfPlayers == 0)
            	round++;
        }
    	MainView.printScores(players);
        
        /*
        // code using to test lay eggs function
        WingspanPlayer player1 = new WingspanPlayer(1);
        Board board = new Board(5,3,"wingspan");
    	HashMap<FoodTypes, Integer> food = new HashMap<>();
    	food.put(FoodTypes.Seed,1);
    	ArrayList<Habitats> hab = new ArrayList<>();
    	hab.add(Habitats.Forrest); 
    	Bird bird = new Bird(0,1, "exampleBird", 5, 2, food,hab);
    	Bird bird2 = new Bird(0,2, "exampleBird2", 2, 2, food,hab);
    	
    	ArrayList<Habitats> hab2 = new ArrayList<>();
    	hab2.add(Habitats.Grasslands);
    	Bird bird3 = new Bird(0,3, "exampleBird3", 2, 2, food,hab2);
    	
    	
    	    
    	board.placeCard(0,0,bird);
    	board.placeCard(0,1,bird2);
    	board.placeCard(1, 0, bird3);
    	board.display();
    	
    	
    	player1.setBoard(board);
    	
    	boolean empty=board.isEmpty();
    	System.out.print(empty);*/
    	
    	
    
    	
    	
    }

    // checks the available actioncubes for a player and tells the player what options he can choose from to make a move
    private static void turn(WingspanPlayer player) {
        player.setActionCubes(8);
        while (player.getActionCubes() > 0){
        	if(player.getId() == 5)
        	{
        		AI(player);
        	}
        	else {
	            ArrayList<String> availableMoves = player.getAvailableMoves();
	            MainView.playerTurn(player.getId());
	            player.getBoard().display();
	            MainView.actionCubes(player.getActionCubes());
	            MainView.availableMoves(availableMoves);
	            int moveNumber;
	            moveNumber = MainView.getInt();
	
	            switch (moveNumber){
	                case 1:
	                    ArrayList<Bird> availableBirds = player.getAvailableBirds();
	                    PlayerView.printAvailableBirds(availableBirds);
	                    Bird bird = PlayerView.chooseBirdFromList(availableBirds);
	                    Habitats habitat = PlayerView.chooseHabitat(bird);
	                    player.playBird(bird, habitat);
	                    break;
	                case 2:
	                    PlayerView.printGainFood(player.gainFood());
	                    break;
	                case 3:
	                    int newEggs = player.layEggs();
	                    int totalEggCount = player.getEggCount();
	                    PlayerView.printLayEggs(newEggs, totalEggCount);
	                    break;
	                case 4:
	                    int newBirds = player.drawBird();
	                    PlayerView.printDrawBirds(newBirds);
	                    break;
	                case 5:
	                    player.setActionCubes(8);
	                    player.getBoard().display();
	                    return;
	            }
        	}
            player.getBoard().display();
            player.setActionCubes(player.getActionCubes()-1);
        }
    }
    // A start to the AI
    // It will always play a bird if it can
    // if it has a bird but not enough food it will gain food until it can play it
    // if the board is not full and its out of birds it will draw birds.
    // if the board is full of birds it will then lay eggs.
    private static void AI(WingspanPlayer player)
    {
    	ArrayList<String> availableMoves = player.getAvailableMoves();
        MainView.playerTurn(player.getId());
        player.getBoard().display();
        MainView.actionCubes(player.getActionCubes());
        MainView.availableMoves(availableMoves);
        
        ArrayList<Bird> availableBirds = player.getAvailableBirds();
        // play birds if we can
       if(availableBirds.size() >0)
       {
    	   Bird bird = availableBirds.get(0); // might want to change the way this works later
    	   Habitats habitat  = bird.getHabitats().get(0);
    	   player.playBird(bird, habitat);
    	   return;
       }
       // we have birds but not enought food. gain food.
       if(player.getNumBirds() > 0)
       {
    	   MainView.AIMoves(2);
    	   player.gainFood();
    	   return;
       }// if there is room on the board for more birds, get more birds!
       if(player.getNumBirds() == 0 && !player.getBoard().isFull())
       {
    	   MainView.AIMoves(4);
    	   player.drawBird();
    	   return;
       }
       //if the board is 100% full of birds check if we can lay eggs
       
       //check forrest
       ArrayList<Bird> birdsForrest = player.availableBirds(0);
       //check grasslands
       ArrayList<Bird> birdsGrass = player.availableBirds(1);
       //check wetlands
       ArrayList<Bird> birdsWet = player.availableBirds(2);
       //combine all birds into one list
       ArrayList<Bird> allBirds = new ArrayList<>();
       
       allBirds.addAll(birdsForrest);
       allBirds.addAll(birdsGrass);
       allBirds.addAll(birdsWet);
       // lay the eggs
       if (!allBirds.isEmpty()){
    	   MainView.AIMoves(3);
           player.layEggs();
       }
        
    }
    // initializes the game for the given amount of player
    private static void init(){
    	MainView.welcomeMessage();
    	amountOfPlayers = MainView.getInt();
    	// move to acceptance testing main
    	if(amountOfPlayers == 5)
    	{
    		
    		AcceptanceTestMain.main();
    		System.out.println("Acceptance test over");
    		System.exit(0);
    	}
    	// playing vs AI
    	if(amountOfPlayers == 6)
    	{
    		players = new WingspanPlayer[2];
    		players[0] = new WingspanPlayer(1);
    		players[1] = new WingspanPlayer(5); // 5 for AI.
    		// reset to real # of players
    		amountOfPlayers = 2;
    		
    	}
    	else { // playing solo or with other people
	        players = new WingspanPlayer[amountOfPlayers];
	
	        for (int i = 0 ; i < players.length ; i++) {
	            players[i] = new WingspanPlayer(i+1);
	        }
    	}
        dice = new Dice();
    }
    // adds the birds to the birdstack
    public static void initBirds(){

        int id;
        int eggLimit;
        String name;
        int points;

        JSONParser parser = new JSONParser();

        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("birds.json"));
            JSONArray birds = (JSONArray) jsonObject.get("birds");

            for (Object o : birds) {
                JSONObject bird = (JSONObject) o;

                id = ((Long) bird.get("ID")).intValue();
                name = (String) bird.get("EnglishName");

                ArrayList<Habitats> habitats = new ArrayList<>();
                HashMap<FoodTypes, Integer> foodTypes = new HashMap<>();

                if (bird.get("EggLimit") != null){
                    eggLimit = ((Long) bird.get("EggLimit")).intValue();
                } else {
                    eggLimit = 10;
                }

                if (bird.get("VictoryPoints") != null){
                    points = ((Long) bird.get("VictoryPoints")).intValue();
                } else {
                    points = 0;
                }

                //System.out.println(id);

                if (bird.get("HabitatForest").equals("y")){
                    habitats.add(Habitats.Forrest);
                }
                if (bird.get("HabitatGrasslands").equals("y")){
                    habitats.add(Habitats.Grasslands);
                }
                if (bird.get("HabitatWetlands").equals("y")){
                    habitats.add(Habitats.Wetlands);
                }

                if (bird.get("FoodSeed") != null){
                    foodTypes.put(FoodTypes.Seed, ((Long) bird.get("FoodSeed")).intValue());
                }
                if(bird.get("FoodNone") != null){
                    foodTypes.put(FoodTypes.None, ((Long) bird.get("FoodNone")).intValue());
                }
                if(bird.get("FoodWild") != null){
                    foodTypes.put(FoodTypes.Wild, ((Long) bird.get("FoodWild")).intValue());
                }
                if(bird.get("FoodInvertebrate") != null){
                    foodTypes.put(FoodTypes.Invertebrate, ((Long) bird.get("FoodInvertebrate")).intValue());
                }
                if(bird.get("FoodFruit") != null){
                    foodTypes.put(FoodTypes.Fruit, ((Long) bird.get("FoodFruit")).intValue());
                }
                if(bird.get("FoodFish") != null){
                    foodTypes.put(FoodTypes.Fish, ((Long) bird.get("FoodFish")).intValue());
                }
                if(bird.get("FoodRodent") != null){
                    foodTypes.put(FoodTypes.Rodent, ((Long) bird.get("FoodRodent")).intValue());
                }

                birdStack.add(new Bird(0, id, name, eggLimit, points, foodTypes, habitats));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // return a random bird card add removes it from the bird card stack
    public static Bird drawBirdFromStack(){
        Random r = new Random();
        int i = r.nextInt(birdStack.size());

        return birdStack.get(i);
    }
    
 // functions for Acceptance testing.
    //
    public static void testTurn(WingspanPlayer player, int[] input)
    {
    	for(int i = 0; i < 4; i++ )
    	{
    		switch(input[i])
    		{   
    			case 1: // just plays a bird
                    Bird bird = testDrawBird(1);
                    Habitats habitat = Habitats.Grasslands;
                    player.playBird(bird, habitat);
    				break;
    			case 2: // tries to print out available birds but cannot due to lack of food
    					// gains food and is then able to print the birds
    				System.out.println("printing available birds:");
    				ArrayList<Bird> availableBirds = player.getAvailableBirds();
    				PlayerView.printAvailableBirds(availableBirds);
    				System.out.println("gaining food");
    				player.testGainFood();
    				System.out.println("printing available birds again");
    				availableBirds = player.getAvailableBirds();
    				PlayerView.printAvailableBirds(availableBirds);
    				return;
    			case 3:
    				
    				player.playBird(player.getBirds().get(1), Habitats.Forrest);
                    int totalEggCount = player.getEggCount() +1;
                    int newEggs = 1;
                    player.setEggCount(totalEggCount);
                    System.out.println("You layed " + newEggs + " eggs Your total number of eggs is " + totalEggCount);
                    System.out.println("player 1 score is " + player.getScore());
                    return;
    				
    			case 4:
    				player.playBird(player.getBirds().get(0), Habitats.Forrest);
    				System.out.println("player "+player.getId()+ " score is " + player.getScore());
    				break;
    				
    			case 5:
    				player.getBoard().display();
    				break;
    			case 6: // lets us end the test early
    				return;
    				
    		}
   
    			
    	}
    }
    
    // Function to get specific birds for testing
    public static Bird testDrawBird(int n)
    {
    	return birdStack.get(n);
    }
}