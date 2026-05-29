import java.util.Scanner;
public class Navigation {
    public static Scanner myInput = new Scanner(System.in);
    private static int currentLocation = 110;
    public static int tempLocation;
    private static boolean gameRunning = true;

    public static void main(String[] args){
        System.out.println("Welcome to the navigation tutorial");
        do{
            navigate();
        }while (gameRunning == true);
    }
    public static void gotoLocation(int locationEntered){
        switch (locationEntered){
            case 110:
                room110();
                break;
            case 120:
                room120();
                break;
            case 130:
                room130();
                break;
            case 140:
                room140();
                break;
            case 210:
                room210();
                break;
            case 220:
                room220();
                break;
            case 230:
                room230();
                break;
            case 240:
                room240();
                break;
            case 310:
                room310();
                break;
            case 320:
                room320();
                break;
            case 330:
                room330();
                break;
            case 340:
                room340();
                break;
            case 410:
                room410();
                break;
            case 420:
                room420();
                break;
            case 430:
                room430();
                break;
            case 440:
                room440();
                break;
            default:
                System.out.println("You can't go that way!");
                currentLocation = tempLocation;
        }

    }
    public static void room110() {
        System.out.println("Welcome to room 110");
    }
    public static void room120(){
        System.out.println("Welcome to room 120");
    }
    public static void room130(){
        System.out.println("Welcome to room 130");
    }
    public static void room140() {
        System.out.println("Welcome to room 140");
    }
    public static void room210(){
        System.out.println("Welcome to room 210");
    }
    public static void room220(){
        System.out.println("Welcome to room 220");
    }
    public static void room230() {
        System.out.println("Welcome to room 230");
    }
    public static void room240() {
        System.out.println("Welcome to room 240");
    }
    public static void room310() {
        System.out.println("Welcome to room 310");
    }
    public static void room320(){
        System.out.println("Welcome to room 320");
    }
    public static void room330() {
        System.out.println("Welcome to room 330");
    }
    public static void room340() {
        System.out.println("Welcome to room 340");
    }
    public static void room410() {
        System.out.println("Welcome to room 410");
    }
    public static void room420() {
        System.out.println("Welcome to room 420");
    }
    public static void room430() {
        System.out.println("Welcome to room 430");
    }
    public static void room440() {
        System.out.println("Welcome to room 440");
    }
    public static void navigate(){
        tempLocation = currentLocation;

        System.out.println("You currently in section " + currentLocation);
        System.out.println("which direction would you like to go?");
        System.out.println("North [w], South [s], East [d], West [a]\nPress [q] to quit");
        System.out.println("Enter Direction w,s,d,a");
        String directionEntered = myInput.nextLine().toLowerCase();

        switch (directionEntered){

            case "s":
                currentLocation = currentLocation + 100;
                gotoLocation(currentLocation);
                break;
            case "w":
                currentLocation = currentLocation - 100;
                gotoLocation(currentLocation);
                break;
            case "a":
                currentLocation = currentLocation - 10;
                gotoLocation(currentLocation);
                break;
            case "d":
                currentLocation = currentLocation + 10;
                gotoLocation(currentLocation);
                break;
            case "q":
                System.out.println("Thanks for playing!\nQuiting...");
                gameRunning = false;
                break;
        }
    }
}

