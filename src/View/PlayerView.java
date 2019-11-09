package View;

import Model.Bird;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerView {

    // ask the user for an Input
    public static Bird chooseBirdFromList(ArrayList<Bird> birds){
        System.out.println("Enter number of the bird you want to choose: ");
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        return birds.get(i-1);
    }

    //prints the available birds to play
    public static void printAvailableBirds(ArrayList<Bird> availableBirds){
        for (int i = 0; i < availableBirds.size(); i++){
            System.out.println(i+1 + ": " + availableBirds.get(i).getName() + ". Food cost " + availableBirds.get(i).getRequiredFood()
                    + ". lives in " + availableBirds.get(i).getHabitat());
        }
    }

    //prints the gained food
    public static void printGainFood(int gainedFood, int foodCount){
        System.out.println("Your food count has increased by " + gainedFood + "! Your new food count is " + foodCount + "!");
    }

    //prints the how many eggs the player gained
    public static void printLayEggs(int newEggs, int eggCount) {
        System.out.println("Your egg count has increased by " + newEggs  + "! Your new egg count is " +eggCount + "!");
    }
}
