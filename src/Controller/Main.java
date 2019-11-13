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
    private static Player[] players;
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
    	printScores();
    }

    // checks the available actioncubes for a player and tells the player what options he can choose from to make a move
    private static void turn(Player player) {
        player.setActionCubes(8);
        while (player.getActionCubes() > 0){
            ArrayList<String> availableMoves = player.getAvailableMoves();
            MainView.playerTurn(player.getId());
            player.getBoard().display();
            MainView.actionCubes(player.getActionCubes());
            MainView.availableMoves(availableMoves);
            int moveNumber;
            moveNumber = MainView.getInt();

            switch (moveNumber){
                case 1:
                    PlayerView.printAvailableBirds(player.getAvailableBirds());
                    player.playBird(PlayerView.chooseBirdFromList(player.getAvailableBirds()));
                    break;
                case 2:
                    PlayerView.printGainFood(player.gainFood());
                    break;
                case 3:
                    PlayerView.printLayEggs(player.layEggs(), player.getEggCount());
                    break;
                case 4:
                    player.drawBird();
                    break;
                case 5:
                    player.setActionCubes(8);
                    player.getBoard().display();
                    return;
            }
            player.getBoard().display();
            player.setActionCubes(player.getActionCubes()-1);
        }
    }

    // initializes the game for the given amount of player
    private static void init(){
    	MainView.welcomeMessage();
    	amountOfPlayers = MainView.getInt();
        players = new Player[amountOfPlayers];

        for (int i = 0 ; i < players.length ; i++) {
            players[i] = new Player(i+1);
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

            ArrayList<Habitats> habitats = new ArrayList<>();
            HashMap<FoodTypes, Integer> foodTypes = new HashMap<>();

            for (Object o : birds) {
                JSONObject bird = (JSONObject) o;

                id = ((Long) bird.get("ID")).intValue();
                name = (String) bird.get("EnglishName");

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
                } else if (bird.get("HabitatGrasslands").equals("y")){
                    habitats.add(Habitats.Grasslands);
                } else if (bird.get("HabitatWetlands").equals("y")){
                    habitats.add(Habitats.Wetlands);
                }

                if (bird.get("FoodSeed") != null){
                    foodTypes.put(FoodTypes.Seed, ((Long) bird.get("FoodSeed")).intValue());
                } else if(bird.get("FoodNone") != null){
                    foodTypes.put(FoodTypes.None, ((Long) bird.get("FoodNone")).intValue());
                } else if(bird.get("FoodWild") != null){
                    foodTypes.put(FoodTypes.Wild, ((Long) bird.get("FoodWild")).intValue());
                } else if(bird.get("FoodInvertebrate") != null){
                    foodTypes.put(FoodTypes.Invertebrate, ((Long) bird.get("FoodInvertebrate")).intValue());
                } else if(bird.get("FoodFruit") != null){
                    foodTypes.put(FoodTypes.Fruit, ((Long) bird.get("FoodFruit")).intValue());
                } else if(bird.get("FoodFish") != null){
                    foodTypes.put(FoodTypes.Fish, ((Long) bird.get("FoodFish")).intValue());
                } else if(bird.get("FoodRodent") != null){
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
    
    // prints the scores of all the players and says who the winner is
    private static void printScores()
    {
    	int i = 1;
    	for(Player p : players)
    	{
    		System.out.println("player " + i + " score is " + p.getScore());
    		i++;
    	}
    }
}