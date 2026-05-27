package main;
import utils.GameCharacters;
import java.util.Scanner;
import java.util.Random;

//location of file directory -> src -> main -> CampfireFight.java

public class CampfireFight {
    private static Scanner myinput = new Scanner(System.in);
    private static boolean life = true;
    private static boolean gameRunning = true;

    private static GameCharacters pCharacter = new GameCharacters();
    private static GameCharacters monster1 = new GameCharacters();
    private static GameCharacters monster2 = new GameCharacters();

    private static Random diceRoll = new Random();

    public static void main (String[] args){
        System.out.println("--You continue walking and stumble across a left over gun and a potion of regeneration. You are suprised there are still bullets contained, you notice a campfire where you encounter two grunts chatting among themselves--");

        System.out.println("Grunt 1: hey so where is your gun? ");
        System.out.println("Grunt 2: huh? i thought you were carrying it- OMG");
        charCreate();
        System.out.printf("dude... we are screwed\n", pCharacter.getName());
        while (gameRunning && life){
            combat(pCharacter, monster1);
            combat(pCharacter, monster2);
        }


    }

    public static void charCreate() {
        monster1.setName("Grunt 1");
        monster1.setCharType("Monster");
        monster1.setHealth(30);
        //for grunt 2
        monster2.setName(("Grunt 2"));
        monster2.setCharType("Monster");
        monster2.setHealth(30);
        System.out.println("Grunt 1: WHATS YOUR NAME ANYWAY-");
        System.out.println("Grunt 2: WHY WOULD WE WANNA KNOW THEIR NAME JUST FIGHT");

        pCharacter.setCharType("Human");
        pCharacter.setHealth(100);

    }

    public static void combat(GameCharacters human, GameCharacters monster){
        int tempHealthHuman, tempHealthMonster;
        int humanAttackroll, monsterAttackRoll;
        boolean flee = false;
        boolean fightOn = true;
//option to fight
        while(fightOn){
            System.out.println("What would you like to do");
            System.out.println("[f]ight\n[r]un\n[s]hoot\n[h]eal\n[d]odge");
            String choice = myinput.nextLine().toLowerCase();
// if fought
            switch (choice){
                //==============================================================
                case "d":
                    //dodge the grunts attacks although small amount of damage will be taken
                    System.out.printf("%s Dodges Servant Empress attacks\n", human.getName());
                    monsterAttackRoll = diceRoll.nextInt(2);
                    break;



                //===================================
                case "h":
                    //heal human
                    System.out.printf("%s heals themselves by 2 hearts\n", human.getName());
                    tempHealthHuman = human.getHealth() + 2;
                    human.setHealth((tempHealthHuman));
                    break;
                //Fight option
                case "f":
                    //human attack
                    System.out.printf("You attempt to hit the %s\n", monster1.getName());
                    humanAttackroll = diceRoll.nextInt(12); //roll from 0-12
                    if(humanAttackroll <=0){
                        System.out.printf("You failed to hit the %s\n", monster1.getName());


                    }
                    //For human to attack monster2
                    System.out.printf("You attempt to hit the %s\n", monster2.getName());
                    humanAttackroll = diceRoll.nextInt(12); //roll from 0-12
                    if(humanAttackroll <=0){
                        System.out.printf("You failed to hit the %s\n", monster2.getName());
                    }
                    else{
                        System.out.printf("You hit the %s for %d\n", monster1.getName(), humanAttackroll);
                        tempHealthMonster = monster1.getHealth() - humanAttackroll;
                        monster1.setHealth(tempHealthMonster);

                        System.out.printf("You hit the %s for %d\n", monster2.getName(), humanAttackroll);
                        tempHealthMonster = monster2.getHealth() - humanAttackroll;
                        monster2.setHealth(tempHealthMonster);



                    }
                    //------------------------------------------------------------
                    //check if monster1 dead before chance to attack
                    if(monster1.getHealth() <=0){
                        System.out.println("You slain the Grunt");
                        fightOn = false;
                        System.out.println("You won in the fight");
                        gameRunning = false;
                    }
                    //check if monster2 dead before chance to attack
                    if(monster2.getHealth() <=0){
                        System.out.println("You slain the Grunt 2");
                        fightOn = false;
                        System.out.println("You won in the fight");
                        gameRunning = false;
                    }
                    //----------------------------------------------------------------
                    //GRUNT FIGHT

                    //Grunt 1 attack
                    System.out.printf("The %s attempts to hit you\n", monster1.getName());
                    monsterAttackRoll = diceRoll.nextInt(6);
                    if(monsterAttackRoll <= 0){
                        System.out.printf("The %s failed to hit you\n", monster1.getName());

                    }
                    //Grunt 2 attack
                    System.out.printf("The %s attempts to hit you\n", monster2.getName());
                    monsterAttackRoll = diceRoll.nextInt(6);
                    if(monsterAttackRoll <= 0){
                        System.out.printf("The %s failed to hit you\n", monster2.getName());

                    }
                    else{
                        System.out.printf("The %s hit you for %d\n", monster1.getName(), monsterAttackRoll);
                        tempHealthHuman = human.getHealth() - monsterAttackRoll;
                        human.setHealth(tempHealthHuman);

                        System.out.printf("The %s hit you for %d\n", monster2.getName(), monsterAttackRoll);
                        tempHealthHuman = human.getHealth() - monsterAttackRoll;
                        human.setHealth(tempHealthHuman);
                    }
                    break;
                //=======================================================================================
                //Shooting option (Use of gun)
                case "s":
                    //human attack
                    System.out.printf("You attempt to shoot the %s\n", monster1.getName());
                    humanAttackroll = diceRoll.nextInt(56); //shoots roll from 0-56
                    if(humanAttackroll <=0){
                        System.out.printf("You failed to hit the %s\n", monster1.getName());
                        System.out.println("Grunt 1: Its your fault that we dont have the gun!");
                        System.out.println("Grunt 2: My fault?! YOU WERE THE ONE CARRYING IT");

                    }
                    //For human to attack monster2
                    System.out.printf("You attempt to hit the %s\n", monster2.getName());
                    humanAttackroll = diceRoll.nextInt(44); //shoots roll from 0-44
                    if(humanAttackroll <=0){
                        System.out.printf("You failed to hit the %s\n", monster2.getName());
                    }
                    else{
                        System.out.printf("You hit the %s for %d\n", monster1.getName(), humanAttackroll);
                        tempHealthMonster = monster1.getHealth() - humanAttackroll;
                        monster1.setHealth(tempHealthMonster);

                        System.out.printf("You hit the %s for %d\n", monster2.getName(), humanAttackroll);
                        tempHealthMonster = monster2.getHealth() - humanAttackroll;
                        monster2.setHealth(tempHealthMonster);



                    }
                    //------------------------------------------------------------
                    //check if monster1 dead before chance to attack
                    if(monster1.getHealth() <=0){
                        System.out.println("You slain the Grunt");
                        fightOn = false;
                        System.out.println("You won in the fight");
                        gameRunning = false;
                    }
                    //check if monster2 dead before chance to attack
                    if(monster2.getHealth() <=0){
                        System.out.println("You slain the Grunt 2");
                        fightOn = false;
                        System.out.println("You won in the fight");
                        System.out.println("-You observe the area and notice a shop nearby-");
                        gameRunning = false;
                    }
                    //----------------------------------------------------------------

                    //Grunt 1 attack
                    System.out.printf("The %s attempts to hit you\n", monster1.getName());
                    monsterAttackRoll = diceRoll.nextInt(6);
                    if(monsterAttackRoll <= 0){
                        System.out.printf("The %s failed to hit you\n", monster1.getName());

                    }
                    //Grunt 2 attack
                    System.out.printf("The %s attempts to hit you\n", monster2.getName());
                    monsterAttackRoll = diceRoll.nextInt(6);
                    if(monsterAttackRoll <= 0){
                        System.out.printf("The %s failed to hit you\n", monster2.getName());

                    }
                    else{
                        System.out.printf("The %s hit you for %d\n", monster1.getName(), monsterAttackRoll);
                        tempHealthHuman = human.getHealth() - monsterAttackRoll;
                        human.setHealth(tempHealthHuman);

                        System.out.printf("The %s hit you for %d\n", monster2.getName(), monsterAttackRoll);
                        tempHealthHuman = human.getHealth() - monsterAttackRoll;
                        human.setHealth(tempHealthHuman);
                    }
                    break;
                //==============================================================================
                //run option activated
                case "r":
                    flee = diceRoll.nextBoolean();
                    if (flee){
                        System.out.println("Grunt 2: HEY MY GUN GIVE ME BACK MY GUN!");
                        fightOn = false;
                        gameRunning = false;
                    }
                    else{
                        System.out.println("-You fail to flee the fight-");
                        System.out.println("Grunt 2: GET OVER HERE");
                        System.out.printf("The %s attempts to hit you\n", monster1.getName());
                        monsterAttackRoll = diceRoll.nextInt(6);
                        if(monsterAttackRoll <= 0){
                            System.out.printf("The %s failed to hit you\n", monster1.getName());

                        }
                        else{
                            System.out.printf("The %s hit you for %d\n", monster1.getName(), monsterAttackRoll);
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
                System.out.println("Grunt 2: *picks up gun* THEY WASTED ALL THE BULLETS DAMMIT");
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