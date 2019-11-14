
package Controller;

import View.MainView;



public class AcceptanceTestMain {

    public static void main(){
    	 System.out.println("Enter the number of the test you want to run");
    	 System.out.println("Test 0: 1 player, plays a bird turn 1 then skips the rest of his turns");
    	 int testID = MainView.getInt(); 
        switch (testID){
            case 0:
                acceptanceTest0();
                break;

            case 1:
                acceptanceTest1();
                break;

            case 2:
                acceptanceTest2();
                break;

            case 3:
                acceptanceTest3();
                break;

            case 4:
                acceptanceTest4();
                break;
        }
    }

    private static void acceptanceTest0() {
        System.out.println("test 0");
        
        int[] moves = {1,5,5,5};
        Model.Player p1 = new Model.Player(1);
        Controller.Main.testTurn(p1, moves);
        
        System.out.println("The expected out put is: ");
        
        System.out.println("| Indigo Bunti|            -|            -|            -|            -|");
        System.out.println("|            -|            -|            -|            -|            -|");
        System.out.println("|            -|            -|            -|            -|            -|");
        
    }

    private static void acceptanceTest1() {
        System.out.println("test 1");
    }

    private static void acceptanceTest2() {
        System.out.println("test 2");
    }

    private static void acceptanceTest3() {
        System.out.println("test 3");
    }

    private static void acceptanceTest4() {
        System.out.println("test 4");
    }
}
