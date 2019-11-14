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
            HashMap<FoodTypes, Integer> food = availableBirds.get(i).getFood();
            System.out.println(i+1 + ": " + availableBirds.get(i).getName());
            for (Map.Entry me : food.entrySet()){
                System.out.println("    FoodType: " + me.getKey() + "; Amount: " + me.getValue());
            }
            for (Habitats habitat : availableBirds.get(i).getHabitats()){
                System.out.println("    Habitat: " + habitat.name());
            }

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

    //lets the player choose a habitat to play a bird in
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

    //prints how many new birds the player got
    public static void printDrawBirds(int newBirds) {
        System.out.println("You drawed " + newBirds + " bird card(s)!");
    }
    
    public static void printLayEggBirds(ArrayList<Bird> allBirds)
    {
    	System.out.println("All Available Birds to Lay Eggs on:");
    	for(int i =0;i<allBirds.size();i++)
    	{
    		System.out.println(i+1+". "+allBirds.get(i).getName()+" ");
    	}
    	System.out.println();
    }
    
    public static int selectBird()
    {
    	System.out.println("Please Enter the Number of the Bird You Would Like to Lay Your Eggs On");

		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		return num;
    }
}
