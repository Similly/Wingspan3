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

import Model.Bird;
import Model.FoodTypes;
import Model.Habitats;
import MonopolyModel.*;

public class Main {
	
	private static ArrayList<MonopolyCard> monopolyCardStack = new ArrayList<>();
	
	public static void main(String[] args){
		
		MonopolyBoard board = new MonopolyBoard("wingspan");
		board.display();
		
		
	}
	
	// adds the cards
    public static void initCards(){

        int id;
        String name;
        int score;
        String color;

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

               

                
                monopolyCardStack.add(new MonopolyCard(id, name, score,color));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
