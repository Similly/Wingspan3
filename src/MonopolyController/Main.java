package MonopolyController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Model.Dice;
import Model.WingspanPlayer;
import MonopolyModel.*;
import MonopolyView.MonopolyMainView;


public class Main {
	
	private static ArrayList<MonopolyCard> monopolyCardStack = new ArrayList<>();
	
	private static MonopolyBoard board = new MonopolyBoard("monopoly");
	
	private int width,height=11;
	private static  int amountOfPlayers;
	private static MonopolyPlayer[] players;
	
	public static void main(String[] args){
		
		initCards();
		initBoard();
		MonopolyMainView.welcomeMessage();
    	amountOfPlayers = MonopolyMainView.getInt();
    	
    	players = new MonopolyPlayer[amountOfPlayers];
    	
        for (int i = 0 ; i < players.length ; i++) {
            players[i] = new MonopolyPlayer(i+1);
        }
	
		board.display();
		
	}
	
	// adds the cards to board
    public static void initCards(){

        int id;
        String name;
        int score;
        String color;
        int player;

        JSONParser parser = new JSONParser();

        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("MonopolyCards.json"));
            JSONArray cards = (JSONArray) jsonObject.get("cards");

            for (Object o : cards) {
                JSONObject card = (JSONObject) o;

                id = ((Long) card.get("ID")).intValue();
                name = (String) card.get("Name");
                score = ((Long) card.get("Score")).intValue();
                color = (String) card.get("Color");
                player = ((Long) card.get("Player")).intValue();
                

               

                
                monopolyCardStack.add(new MonopolyCard(id, name, score,color,player));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void initBoard() {
    	
    	board.placeCard(10, 10, monopolyCardStack.get(0));
    	board.placeCard(10, 9, monopolyCardStack.get(1));
    	board.placeCard(10, 8, monopolyCardStack.get(2));
    	board.placeCard(10, 7, monopolyCardStack.get(3));
    	board.placeCard(10, 6, monopolyCardStack.get(4));
    	board.placeCard(10, 5, monopolyCardStack.get(5));
    	board.placeCard(10, 4, monopolyCardStack.get(6));
    	board.placeCard(10, 3, monopolyCardStack.get(7));
    	board.placeCard(10, 2, monopolyCardStack.get(8));
    	board.placeCard(10, 1, monopolyCardStack.get(9));
    	board.placeCard(10, 0, monopolyCardStack.get(10));
    	board.placeCard(9, 0, monopolyCardStack.get(11));
    	board.placeCard(8, 0, monopolyCardStack.get(12));
    	board.placeCard(7, 0, monopolyCardStack.get(13));
    	board.placeCard(6, 0, monopolyCardStack.get(14));
    	board.placeCard(5, 0, monopolyCardStack.get(15));
    	board.placeCard(4, 0, monopolyCardStack.get(16));
    	board.placeCard(3, 0, monopolyCardStack.get(17));
    	board.placeCard(2, 0, monopolyCardStack.get(18));
    	board.placeCard(1, 0, monopolyCardStack.get(19));
    	board.placeCard(0, 0, monopolyCardStack.get(20));
    	board.placeCard(0, 1, monopolyCardStack.get(21));
    	board.placeCard(0, 2, monopolyCardStack.get(22));
    	board.placeCard(0, 3, monopolyCardStack.get(23));
    	board.placeCard(0, 4, monopolyCardStack.get(24));
    	board.placeCard(0, 5, monopolyCardStack.get(25));
    	board.placeCard(0, 6, monopolyCardStack.get(26));
    	board.placeCard(0, 7, monopolyCardStack.get(27));
    	board.placeCard(0, 8, monopolyCardStack.get(28));
    	board.placeCard(0, 9, monopolyCardStack.get(29));
    	board.placeCard(0, 10, monopolyCardStack.get(30));
    	board.placeCard(1, 10, monopolyCardStack.get(31));
    	board.placeCard(2, 10, monopolyCardStack.get(32));
    	board.placeCard(3, 10, monopolyCardStack.get(33));
    	board.placeCard(4, 10, monopolyCardStack.get(34));
    	board.placeCard(5, 10, monopolyCardStack.get(35));
    	board.placeCard(6, 10, monopolyCardStack.get(36));
    	board.placeCard(7, 10, monopolyCardStack.get(37));
    	board.placeCard(8, 10, monopolyCardStack.get(38));
    	board.placeCard(9, 10, monopolyCardStack.get(39));

    	







    	
    }

}
