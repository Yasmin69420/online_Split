package main;
import java.util.Scanner;
import utils.GameCharacters;
import java.util.Random;
import main.Driver;
import main.CampfireFight;
import main.FinalBoss;
import main.minibossfight0;



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
                System.out.println("The space warps and distorts with dark magic as you are turned back to where you came from...\nYou can't escape.");
                currentLocation = tempLocation;
        }

    }
    //The room(areas) are all ordered in their number value, combined with the directional inputs, this gives an illusion to the player of a 4x4 grid
    public static void room110() {
        System.out.println("==You observe the area noticing that there is an abandoned village nearby==");


    }
    public static void room120(){
        System.out.println("==As you enter the abandoned village you notice a grunt attempting to loot the already broken village==");
        System.out.println("OI YOU BETTER LEAVE!");

        Driver.StartTutorialFight();

    }
    public static void room130(){
        System.out.println("==Entering outside of the village==");
        System.out.println("--You continue walking and stumble across a left over gun and a potion of regeneration. You are suprised there are still bullets contained, you notice a campfire where you encounter two grunts chatting among themselves--");
    }
    public static void room140() {
        System.out.println("==Entering campsite==");

        CampfireFight.StartCampfireFight(); //starts campfire fight
    }

    public static void room240() {
        System.out.println("==Outside of the campsite==");
        System.out.println("-The grunts weren't tough but they were starting to becoming noticably stronger");
        System.out.println("-You observe the plainfield and notice a shop nearby-");
        System.out.println("-Continue West to enter the shop-");


    }

    public static void room230() {
        System.out.println("==Entering shop==");
    }

    public static void room220(){

        System.out.println("=Leaving shop=");
        System.out.println("-Continue west-");
    }


    public static void room210(){

        System.out.println("=You continue west and the path appears to go south where a burning feeling tense up in your lungs=");
        System.out.println("=Enter south=");
    }



    public static void room310() {
        System.out.println("==The path continues and you notice a tall building that looks sinister==");
        System.out.println("-Go East to Enter the building-");
    }
    public static void room320(){
        System.out.println("==You enter the building==");
        System.out.println("-Its... unnerving-");

        minibossfight0.startFight(); //starts the mini boss fight


    }
    public static void room330() {
        System.out.println("==Outside of the building==");
        System.out.println("-The enemy was challenging, however you must press forth...");
        System.out.println("-Continue East-");
    }
    public static void room340() {
        System.out.println("=The path continues southward... the scenery noticibly getting less greener...=");
        System.out.println("-Continue South-");
    }

    public static void room440() {
        System.out.println("=You notice now that there is a distinct lack of vegitation, the air thick with smoke=");
        System.out.println("-Continue West-");
    }

    public static void room430() {
        System.out.println("=All around lays only waste and distruction and the air thick with the smoke of gunfire and something more sinister=");
        System.out.println("=Amongst all this, a lone shop stands in the near distance=");
        System.out.println("-Continue West to enter the shop-");
    }

    public static void room420() {
        System.out.println("Foreboding walls of the castle loom west-side, a Threatening miasma making the very air feel toxic to breath.");
        System.out.println("==Entering shop==");
    }

    public static void room410() {
        System.out.println("=Leaving shop=");
        System.out.println("The threatening miasma intensifies...");
        FinalBoss.FINALBATTLE();

    }



    public static void navigate(){
        tempLocation = currentLocation;

        System.out.println("You currently in area " + currentLocation);
        System.out.println("which direction would you like to go?");
        System.out.println("North [w], South [s], East [d], West [a]\nPress [q] to quit");
        System.out.println("Enter Direction w,s,d,a");
        String directionEntered = myInput.nextLine().toLowerCase();

        switch (directionEntered){

            case "s": //button for south
                currentLocation = currentLocation + 100;
                gotoLocation(currentLocation);
                break;
            case "w": //button for north
                currentLocation = currentLocation - 100;
                gotoLocation(currentLocation);
                break;
            case "a": //button for west
                currentLocation = currentLocation - 10;
                gotoLocation(currentLocation);
                break;
            case "d": //Button for east
                currentLocation = currentLocation + 10;
                gotoLocation(currentLocation);
                break;
            case "q"://Exit game button
                System.out.println("Thanks for playing!\nQuiting...");
                gameRunning = false;
                break;
        }
    }
}
