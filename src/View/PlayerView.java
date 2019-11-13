package View;

import Model.Bird;
import Model.FoodTypes;
import Model.Habitats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
    public static void printGainFood(HashMap<FoodTypes, Integer> gainedFood){
        System.out.println("Your new food count is:");
        for (Map.Entry me : gainedFood.entrySet()){
            System.out.println("Food Type: " + me.getKey() + " ; Value: " + me.getValue());
        }
        System.out.println("\n");
    }

    //prints the how many eggs the player gained
    public static void printLayEggs(int newEggs, int eggCount) {
        System.out.println("Your egg count has increased by " + newEggs  + "! Your new egg count is " +eggCount + "!");
    }

    public static Habitats chooseHabitat(Bird bird) {
        System.out.println("The bird " + bird.getName() + " can be placed in the following habitats: ");
        System.out.println(bird.getHabitats().size());
        for (Habitats habitat : bird.getHabitats()){
            System.out.println(habitat.getValue() + " " + habitat);
        }
        System.out.println("Enter number of the habitat you want to place the bird in: ");
        Scanner in = new Scanner(System.in);
        int temp = in.nextInt();
        for (Habitats habitat : bird.getHabitats()){
            if (habitat.getValue() == temp){
                return habitat;
            }
        }
        return bird.getHabitats().get(0);
    }
}
