package Controller;

public class AcceptanceTestMain {

    public static void main(String[] args){
        int testID = Integer.parseInt(args[0]);

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
