package Game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int amountOfPlayers;
    private static Player[] players;
    private static Dice dice;
    private static int turn;
    private static ArrayList<Bird> birdStack = new ArrayList<>();

    public static void main(String[] args){

        initBirds();
        System.out.println(birdStack.size());
        init();

        turn = 0;
        while (true){
            turn(players[turn%amountOfPlayers]);
            turn++;
        }
    	
    }

    private static void turn(Player player) {
        ArrayList<String> availableMoves = player.getAvailableMoves();
        System.out.println("It's the turn of Player " + player.getId());
        player.getBoard().display();
        System.out.println("Your available moves are:\n");
        for (int i = 0; i < availableMoves.size(); i++){
            System.out.println(availableMoves.get(i));
        }
        System.out.println("\nChoose one of the available moves by typing its number!");
        Scanner in = new Scanner(System.in);
        int moveNumber = in.nextInt();

        switch (moveNumber){
            case 1:
                player.playABird();
                break;
            case 2:
                player.gainFood();
                break;
            case 3:
                player.layEggs();
                break;
            case 4:
                player.drawBird();
                break;
        }
        player.getBoard().display();
    }

    private static void init(){
        System.out.println("+++ Welcome to Wingspan! +++\n" +
                "Please enter amount of players(1-4):");
        Scanner in = new Scanner(System.in);
        amountOfPlayers = in.nextInt();
        players = new Player[amountOfPlayers];

        for (int i = 0 ; i < players.length ; i++) {
            players[i] = new Player(i+1);
        }

        dice = new Dice();
    }

    private static void initBirds(){
        birdStack.add(new Bird(0,1,0,0,"Hawk"));
        birdStack.add(new Bird(1,3,0,1,"Klaus"));
        birdStack.add(new Bird(2,4,0,2,"Gunther"));
        birdStack.add(new Bird(0,2,0,3,"Rudiger"));
        birdStack.add(new Bird(1,1,0,4,"Maria"));
        birdStack.add(new Bird(2,1,0,5,"Stephanie"));
        birdStack.add(new Bird(0,4,0,6,"Mustafa"));
        birdStack.add(new Bird(1,11,0,7,"Elke"));
        birdStack.add(new Bird(2,14,0,8,"Hawk"));
    }

    public static Bird drawBirdFromStack(){
        Random r = new Random();
        System.out.println(birdStack.size());
        int i = r.nextInt(birdStack.size());
        Bird bird = birdStack.get(i);
        birdStack.remove(i);

        return bird;
    }
}
