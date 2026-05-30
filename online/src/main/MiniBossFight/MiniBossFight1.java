package main.MiniBossFight;
import main.Item;
import utils.GameCharacters;
import utils.ItemInfo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import main.shopBackPack;
//Location: Takes place in the third level fight-> abandoned village

public class MiniBossFight1 {
    private static Scanner myinput = new Scanner(System.in);
    private static boolean life = true;
    private static boolean gameRunning = true;
    private static ArrayList<ItemInfo> backpack = new ArrayList<>();


    private static GameCharacters pCharacter = new GameCharacters();
    private static GameCharacters MiniBoss = new GameCharacters();

    private static Random diceRoll = new Random();



    public static void main (String[] args){
        System.out.println("--After being granted upgraded abilities by the shop keeper you arrive at the fort--");

        System.out.println("I see you've made it halfway through the forest... lets start with a real challenge");
        charCreate();
        System.out.printf("I see %s. Lets begin\n", pCharacter.getName());
        while (gameRunning & life){
            combat(pCharacter, MiniBoss);
        }


    }

    public static void charCreate() {
        MiniBoss.setName("Servant Empress");
        MiniBoss.setCharType("MiniBoss");
        MiniBoss.setHealth(150);
        System.out.println("Whats your name dear?");
        pCharacter.setName(myinput.nextLine());
        pCharacter.setCharType("Human");


    }








    public static void combat(GameCharacters human, GameCharacters monster){
        int tempHealthHuman, tempHealthMonster;
        int humanAttackroll, monsterAttackRoll;
        boolean flee = false;
        boolean fightOn = true;
        boolean found = false;
        double cost = 0.00;
        int index = 0;
        int itemQty = 0;
        int backpackIndex = 0;
        boolean backpackFound = false;
//option to fight
        while(fightOn){
            System.out.println("What would you like to do. Tips: Utilize dodge and heal as Servant Empress's health is 150 and can damage player between 2 to 24 ");
            System.out.println("[f]ight\n[r]un\n[s]hoot\n[h]eal\n[d]odge\n[b]ackpack");
            String choice = myinput.nextLine().toLowerCase();
// if fought
            //========================================================================
            switch (choice){






                //================================================
                case "d":
                    //dodge Servant Empress attack
                    System.out.printf("%s Dodges Servant Empress attacks\n", human.getName());
                    monsterAttackRoll = diceRoll.nextInt(2);
                    break;



                //===================================


                //====================================
                case "h":
                    //heal human
                    System.out.printf("%s heals themselves by 12 hearts\n", human.getName());
                    tempHealthHuman = human.getHealth() + 12;
                    human.setHealth((tempHealthHuman));
                    System.out.printf("The %s combats your healing\n", MiniBoss.getName());
                    monsterAttackRoll = diceRoll.nextInt(12); //attack results in loss of some health
                    tempHealthHuman = human.getHealth() - monsterAttackRoll;
                    human.setHealth(tempHealthHuman);

                    break;



                //==========================================================
                case "f":
                    //human attack fist
                    System.out.printf("You attempt to hit the %s\n", MiniBoss.getName());
                    humanAttackroll = diceRoll.nextInt(22); //roll from 0-5
                    if(humanAttackroll <=0){
                        System.out.printf("You failed to hit the %s\n", MiniBoss.getName());

                    }
                    else{
                        System.out.printf("You hit the %s for %d\n", MiniBoss.getName(), humanAttackroll);
                        tempHealthMonster = monster.getHealth() - humanAttackroll;
                        monster.setHealth(tempHealthMonster);

                    }
                    //check if monster dead before chance to attack
                    if(MiniBoss.getHealth() <=0){
                        System.out.println("You... seem... worthy....");
                        System.out.println("You slain the Servant Empress");
                        fightOn = false;
                        System.out.println("You won in this fight");
                        System.out.println("==Your attack stats increased by 20==");
                        gameRunning = false;
                    }

                    //Monster attack
                    System.out.printf("The %s attempts to hit you\n", MiniBoss.getName());
                    monsterAttackRoll = diceRoll.nextInt(24);
                    if(monsterAttackRoll <= 0){
                        System.out.printf("The %s failed to hit you\n", MiniBoss.getName());

                    }
                    else{
                        System.out.printf("The %s hit you for %d\n", MiniBoss.getName(), monsterAttackRoll);
                        tempHealthHuman = human.getHealth() - monsterAttackRoll;
                        human.setHealth(tempHealthHuman);
                    }
                    break;
                    //=======================================================
                case "s":
                    //human attack
                    System.out.printf("You attempt to shoot the %s\n. Unfortanely she is more immune to bullets ", MiniBoss.getName());
                    humanAttackroll = diceRoll.nextInt(20); //shoots roll from 0-20
                    if(humanAttackroll <=0){
                        System.out.printf("You failed to hit the %s\n", MiniBoss.getName());
                        System.out.println("How Amusing...");




                    }
                    else{
                        System.out.printf("You hit the %s for %d\n", MiniBoss.getName(), humanAttackroll);
                        tempHealthMonster = MiniBoss.getHealth() - humanAttackroll;
                        MiniBoss.setHealth(tempHealthMonster);




                    }
                    //------------------------------------------------------------
                    //check if monster1 dead before chance to attack
                    if(MiniBoss.getHealth() <=0){
                        System.out.println("You slain the Servant Empress");
                        fightOn = false;
                        System.out.println("You won in the fight");
                        gameRunning = false;
                    }


                    //MiniBoss attack
                    System.out.printf("The %s attempts to hit you\n", MiniBoss.getName());
                    monsterAttackRoll = diceRoll.nextInt(16);
                    if(monsterAttackRoll <= 0){
                        System.out.printf("The %s failed to hit you\n", MiniBoss.getName());

                    }


                    else{
                        System.out.printf("The %s hit you for %d\n", MiniBoss.getName(), monsterAttackRoll);
                        tempHealthHuman = human.getHealth() - monsterAttackRoll;
                        human.setHealth(tempHealthHuman);
                    }
                    break;
                //==============================================================================
                //run option activated
                //run option activated
                //====================================================
                case "r":
                    flee = diceRoll.nextBoolean();
                    if (flee){
                        System.out.println("See you dear");
                        fightOn = false;
                        gameRunning = false;
                    }
                    else{
                        System.out.println("-You fail to flee the fight-");
                        System.out.println("Not so fast %s\n");
                        System.out.printf("The %s attempts to hit you\n", MiniBoss.getName());
                        monsterAttackRoll = diceRoll.nextInt(6);
                        if(monsterAttackRoll <= 0){
                            System.out.printf("The %s failed to hit you\n", MiniBoss.getName());

                        }
                        else{
                            System.out.printf("The %s hit you for %d\n", MiniBoss.getName(), monsterAttackRoll);
                            tempHealthHuman = human.getHealth() - monsterAttackRoll;
                            human.setHealth(tempHealthHuman);
                        }
                    }
                    break;
                default:
                    System.out.println("Not a valid choice");

            }
            //failed screen
            if(human.getHealth() <= 0){
                life = false;
                fightOn = false;
                System.out.println("GAME OVER, You died...");
                System.out.println("How dissapointing");
                gameRunning = false;
                break;
            }
            //shows current health left
            else{
                System.out.printf("You have %d health left\n", human.getHealth());

            }

        }


    }
}




