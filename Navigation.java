package main;
import java.util.Scanner;
import utils.GameCharacters;
import java.util.Random;
import main.Driver;
import main.CampfireFight;
import main.FinalBoss;
import main.minibossfight0;


/**
 * <h1>Navigation</h1>
 * <p>Public Class Navigation process all navigation related code.</p>
 * <p>The aim of this code is to process directional inputs of the player and utilising a framework/system in its processing, determine where the player is. Then it should either initialize shops, fights or descriptive text depending on where the methods have determined the player is.</p>
 */
public class Navigation {
    public static Scanner myInput = new Scanner(System.in);
    private static int currentLocation = 110;
    public static int tempLocation;
    private static boolean gameRunning = true;

    /**
     * <h1>Main Method</h1>
     * <p>The purpose of the main method is to initialise and run the navigation system e.i the base of the game, until the game is to stop running. as this is meant to run on first start up of the game, it doubles as the beginning of the navigation.</p>
     * @param args
     */
    public static void main(String[] args){
        System.out.println("Welcome to the navigation tutorial");
        do{
            navigate();
        }while (gameRunning == true);
    }

    /**
     * <h1>gotoLocation Method</h1>
     * <p>This entire method is meant to translate the numbered values from the locationEntered variable into methods to which the navigation can carry out. in the event the location entered value doesn't match any of the cases, the code prints out a message and sets currentLocation to equal tempLocation. This in effect sends the player back to within the possible location values</p>
     * @param locationEntered
     */
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


    /**
     * <h1>Navigation Method</h1>
     * <p>This method first stores the player's current location into the variable temp location then prints prompts for the player to enter the direction in which they would like to travel. then depending on which direction is entered alters the values of the currentLocation and directs the code to run its corresponding case in the gotoLocation method.</p>
     * <p>The processing of location is determined by having the hundreds place of the integer represent the location of the player on an imaginary y axis, and the tens unit of the value represent the location of the player on an inmaginary x axis.The method also allows an option to quit the game with the entering of the key q, which will set game running to false and print out a message.</p>
     */
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
