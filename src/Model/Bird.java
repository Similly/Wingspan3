package Model;


import GameFramework.Card;

import java.util.ArrayList;
import java.util.HashMap;

/* A bird has 5 fields.
 * An Id, a name, a habitat, the required food to play it and the amount of eggs on the bird.
 */
public class Bird extends Card {

    private int eggsOnBird;
    private int maxEggCount;
    private HashMap<FoodTypes, Integer> food;
    private ArrayList<Habitats> habitats;
    
    public Bird()
    {
    	super();
    }

    public Bird(int eggsOnBird, int id, String name, int maxEggCount, int score, HashMap<FoodTypes, Integer> food, ArrayList<Habitats> habitats){

        super(id, name, score);
        this.eggsOnBird = eggsOnBird;
        this.maxEggCount = maxEggCount;
        this.habitats = habitats;
        this.food = food;
    }


    /*public void getHabitatIndex() {
        return habitats
        		.getValue();
    }

    public void setHabitat(int habitat) {
        this.habitat = habitat;
    }

    public int getRequiredFood() {
        return requiredFood;
    }

    public void setRequiredFood(int requiredFood) {
        this.requiredFood = requiredFood;
    }*/


    public int getEggsOnBird() {
        return eggsOnBird;
    }

    public void setEggsOnBird(int eggsOnBird) {
        this.eggsOnBird = eggsOnBird;
    }

    public int getCardId() {
        return getId();
    }

    public void setCardId(int id) {
        setId(id);
    }

    public String getCardName() {
        return getName();
    }

    public void setCardName(String name) {
        setName(name);
    }

    public int getMaxEggCount() { return maxEggCount; }

    public void setMaxEggCount(int maxEggCount) { this.maxEggCount = maxEggCount; }

    public int getCardScore() { return getScore(); }

    public void setCardScore(int score) { setScore(score); }

    public HashMap<FoodTypes, Integer> getFood() { return food; }

    public void setFood(HashMap<FoodTypes, Integer> food) { this.food = food; }

    public ArrayList<Habitats> getHabitats() { return habitats; }

    public void setHabitats(ArrayList<Habitats> habitats) { this.habitats = habitats; }
    
    
}
