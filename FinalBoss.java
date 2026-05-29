package main;
import utils.GameCharacters;
import java.util.Scanner;
import java.util.Random;

//Location: Takes place in the final level fight-> Castle Danger village
public class FinalBoss {
    private static Scanner myinput = new Scanner(System.in);
    private static boolean life = true;
    private static boolean gameRunning = true;

    private static GameCharacters pCharacter = new GameCharacters();
    private static GameCharacters Boss = new GameCharacters();

    private static Random diceRoll = new Random();

    public static void main (String[] args){
        System.out.println("--You arrive at the castle where a mysterious figure awaits--");

        System.out.println("I see you've made it.");
        System.out.println("--The door closes behind you--");
        System.out.println("You seem confident dumb one...");
        charCreate();
        System.out.printf("I see %s. Lets begin\n", pCharacter.getName());
        while (gameRunning & life){
            combat(pCharacter, Boss);
        }


    }

    public static void charCreate() {
        Boss.setName("Unknown Auditor");
        Boss.setCharType("Boss");
        Boss.setHealth(300);
        System.out.println("State your name.");
        pCharacter.setName(myinput.nextLine());
        pCharacter.setCharType("Human");
        pCharacter.setHealth(130);

    }

    public static void combat(GameCharacters human, GameCharacters monster){
        int tempHealthHuman, tempHealthMonster;
        int humanAttackroll, monsterAttackRoll;
        boolean flee = false;
        boolean fightOn = true;
//option to fight
        while(fightOn){
            System.out.println("What would you like to do. Unknown Auditor can damage between 2 to 56");
            System.out.println("[f]ight\n[r]un\n[s]hoot\n[h]eal\n[d]odge");
            String choice = myinput.nextLine().toLowerCase();
// if fought
            //========================================================================
            switch (choice){

                //================================================
                case "d":
                    //dodge Servant Empress attack
                    System.out.printf("%s Dodges Unknown Auditor attacks\n", human.getName());
                    monsterAttackRoll = diceRoll.nextInt(2);
                    break;



                //===================================


                //====================================
                case "h":
                    //heal human
                    System.out.printf("%s heals themselves by 12 hearts\n", human.getName());
                    tempHealthHuman = human.getHealth() + 12;
                    human.setHealth((tempHealthHuman));
                    System.out.printf("The %s combats your healing\n", Boss.getName());
                    monsterAttackRoll = diceRoll.nextInt(15); //attack results in loss of some health
                    tempHealthHuman = human.getHealth() - monsterAttackRoll;
                    human.setHealth(tempHealthHuman);

                    break;



                //==========================================================
                case "f":
                    //human attack fist
                    System.out.printf("You attempt to hit the %s\n", Boss.getName());
                    humanAttackroll = diceRoll.nextInt(44); //roll from 0-5
                    if(humanAttackroll <=0){
                        System.out.printf("You failed to hit the %s\n", Boss.getName());

                    }
                    else{
                        System.out.printf("You hit the %s for %d\n", Boss.getName(), humanAttackroll);
                        tempHealthMonster = monster.getHealth() - humanAttackroll;
                        monster.setHealth(tempHealthMonster);

                    }
                    //check if monster dead before chance to attack
                    if(Boss.getHealth() <=0){
                        System.out.println("You CHEATER *dies*");
                        System.out.println("You slain Unknown Auditor");
                        fightOn = false;
                        System.out.println("You won in this fight");
                        System.out.println("==Congrats you completed the game!==");
                        gameRunning = false;
                    }

                    //Monster attack
                    System.out.printf("The %s attempts to hit you\n", Boss.getName());
                    monsterAttackRoll = diceRoll.nextInt(56);
                    if(monsterAttackRoll <= 0){
                        System.out.printf("The %s failed to hit you\n", Boss.getName());

                    }
                    else{
                        System.out.printf("The %s hit you for %d\n", Boss.getName(), monsterAttackRoll);
                        tempHealthHuman = human.getHealth() - monsterAttackRoll;
                        human.setHealth(tempHealthHuman);
                    }
                    break;
                //=======================================================
                case "s":
                    //human attack
                    System.out.printf("You shoot the %s\n. It has slightly affected him ", Boss.getName());
                    humanAttackroll = diceRoll.nextInt(33); //shoots roll from 0-33
                    if(humanAttackroll <=0){
                        System.out.printf("You failed to hit the %s\n", Boss.getName());
                        System.out.println("How Amusing...");




                    }
                    else{
                        System.out.printf("You hit the %s for %d\n", Boss.getName(), humanAttackroll);
                        tempHealthMonster = Boss.getHealth() - humanAttackroll;
                        Boss.setHealth(tempHealthMonster);




                    }
                    //------------------------------------------------------------
                    //check if monster1 dead before chance to attack
                    if(Boss.getHealth() <=0){
                        System.out.println("You slain Unknown Auditor");
                        fightOn = false;
                        System.out.println("You won in the fight");
                        gameRunning = false;
                    }


                    //Boss attack
                    System.out.printf("The %s attempts to hit you\n", Boss.getName());
                    monsterAttackRoll = diceRoll.nextInt(33);
                    if(monsterAttackRoll <= 0){
                        System.out.printf("The %s failed to hit you\n", Boss.getName());

                    }


                    else{
                        System.out.printf("The %s hit you for %d\n", Boss.getName(), monsterAttackRoll);
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
                        System.out.println("You cannot escape your desire");
                        fightOn = false;
                        gameRunning = false;
                    }
                    else{
                        System.out.println("-You fail to flee the fight-");
                        System.out.println("Nuh uh");
                        System.out.printf("The %s attempts to hit you\n", Boss.getName());
                        monsterAttackRoll = diceRoll.nextInt(6);
                        if(monsterAttackRoll <= 0){
                            System.out.printf("The %s failed to hit you\n", Boss.getName());

                        }
                        else{
                            System.out.printf("The %s hit you for %d\n", Boss.getName(), monsterAttackRoll);
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
                System.out.println("lol");
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




