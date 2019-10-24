package Game;

import java.util.ArrayList;

public class Player {

    private int id;
    private int foodCount;
    private int eggCount;
    private ArrayList<Bird> birds;
    private Board board;

    public Player(int id){
        this.id = id;
        this.foodCount = 10;
        this.eggCount = 10;
        birds = new ArrayList<>();
        this.board = new Board();
    }

    public void playABird(){

    }

    public void gainFood(){

    }

    public void layEggs(){

    }

    public void drawBird(){

    }

    public ArrayList<String> getAvailableMoves(){

        ArrayList<String> availableMoves = new ArrayList<>();
        for (int i = 0; i < birds.size(); i++){
            if (birds.get(i).getRequiredFood() <= foodCount){
                availableMoves.add("1: place bird");
                break;
            }
        }

        availableMoves.add("2: gain food");

        if (!board.isEmpty() && eggCount > 0){
            availableMoves.add("3: lay eggs");
        }

        availableMoves.add("4: draw bird card");
        return availableMoves;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
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
}
