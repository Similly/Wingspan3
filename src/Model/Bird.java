package Model;


import java.util.ArrayList;
import java.util.HashMap;

/* A bird has 5 fields.
 * An Id, a name, a habitat, the required food to play it and the amount of eggs on the bird.
 */
public class Bird {

    private int id;
    private String name;
    private int habitat;
    private int requiredFood;
    private int eggsOnBird;
    private int maxEggCount;
    private int score;
    private HashMap<FoodTypes, Integer> food;
    private ArrayList<Habitats> habitats;
    
    public Bird()
    {
    	id=0;
    	name="-";
    }

    public Bird(int eggsOnBird, int id, String name, int maxEggCount, int score, HashMap<FoodTypes, Integer> food, ArrayList<Habitats> habitats){

        this.eggsOnBird = 0;
        this.maxEggCount = maxEggCount;
        this.score = score;
        this.id = id;
        this.name = name;
        this.habitats = habitats;
        this.food = food;
    }

    public int getHabitat() {
        return habitat;
    }

    public void setHabitat(int habitat) {
        this.habitat = habitat;
    }

    public int getRequiredFood() {
        return requiredFood;
    }

    public void setRequiredFood(int requiredFood) {
        this.requiredFood = requiredFood;
    }

    public int getEggsOnBird() {
        return eggsOnBird;
    }

    public void setEggsOnBird(int eggsOnBird) {
        this.eggsOnBird = eggsOnBird;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxEggCount() { return maxEggCount; }

    public void setMaxEggCount(int maxEggCount) { this.maxEggCount = maxEggCount; }

    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }

    public HashMap<FoodTypes, Integer> getFood() { return food; }

    public void setFood(HashMap<FoodTypes, Integer> food) { this.food = food; }

    public ArrayList<Habitats> getHabitats() { return habitats; }

    public void setHabitats(ArrayList<Habitats> habitats) { this.habitats = habitats; }
}
