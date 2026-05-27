import java.util.Scanner;
public class Navigation {
    public static Scanner myInput = new Scanner(System.in);
    private static int currentLocation = 220;
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
            case 120:
                room120();
                break;
            case 130:
                room130();
                break;
            case 210:
                room210();
                break;
            case 220:
                room220();
                break;
            case 320:
                room320();
                break;
            default:
                System.out.println("You can't go that way!");
                currentLocation = tempLocation;
        }

    }
    public static void room120(){
        System.out.println("Welcome to room 120");
    }
    public static void room130(){
        System.out.println("Welcome to room 130");
    }
    public static void room210(){
        System.out.println("Welcome to room 210");
    }
    public static void room220(){
        System.out.println("Welcome to room 220");
    }
    public static void room320(){
        System.out.println("Welcome to room 320");
    }
    public static void navigate(){
        tempLocation = currentLocation;

        System.out.println("You currently in section " + currentLocation);
        System.out.println("which direction would you like to go?");
        System.out.println("[n]orth, [s]outh, [e]ast, [w]est\nPress [q] to quit");
        System.out.println("Enter Direction n,s,e,w");
        String directionEntered = myInput.nextLine().toLowerCase();

        switch (directionEntered){

            case "n":
                currentLocation = currentLocation + 100;
                gotoLocation(currentLocation);
                break;
            case "s":
                currentLocation = currentLocation - 100;
                gotoLocation(currentLocation);
                break;
            case "w":
                currentLocation = currentLocation - 10;
                gotoLocation(currentLocation);
                break;
            case "e":
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
