package Game;


/* A bird has 5 fields.
 * An Id, a name, a habitat, the required food to play it and the amount of eggs on the bird.
 */
public class Bird {
    private int id;
    private String name;
    private int habitat;
    private int requiredFood;
    private int eggsOnBird;

    public Bird(int habitat, int requiredFood, int eggsOnBird, int id, String name){
        this.habitat = habitat;
        this.requiredFood = requiredFood;
        this.eggsOnBird = 0;
        this.id = id;
        this.name = name;
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
}
