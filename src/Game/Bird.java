package Game;

public class Bird {
    private int habitat;
    private int requiredFood;
    private int eggsOnBird;

    public Bird(int habitat, int requiredFood, int eggsOnBird){
        this.habitat = habitat;
        this.requiredFood = requiredFood;
        this.eggsOnBird = 0;
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
}
