package Game;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static int amountOfPlayers;
    private static Player[] players;
    private static Dice dice;
    private static int turn;

    public static void main(String[] args){
    	
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
        players = new Player[4];

        for (int i = 0 ; i < players.length ; i++) {
            players[i] = new Player(i+1);
        }

        dice = new Dice();
    }
}
