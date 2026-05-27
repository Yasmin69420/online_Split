package main;
import utils.GameCharacters;
import java.util.Scanner;
import java.util.Random;
//location of file directory -> src -> main -> driver.java
public class Driver {

    private static Scanner myinput = new Scanner(System.in);
    private static boolean life = true;
    private static boolean gameRunning = true;

    private static GameCharacters pCharacter = new GameCharacters();
    private static GameCharacters monster1 = new GameCharacters();

    private static Random diceRoll = new Random();

    public static void main (String[] args){

        System.out.println("YOU BETTER LEAVE");
        charCreate();
        System.out.printf("UGH %s. IM GETTING TIRED OF THIS\n", pCharacter.getName());
        while (gameRunning & life){
            combat(pCharacter, monster1);
        }


    }

    public static void charCreate() {
        monster1.setName("Zombie");
        monster1.setCharType("Monster");
        monster1.setHealth(10);
        System.out.println("Whats your name");
        pCharacter.setName(myinput.nextLine());
        pCharacter.setCharType("Human");
        pCharacter.setHealth(20);

    }

    public static void combat(GameCharacters human, GameCharacters monster){
        int tempHealthHuman, tempHealthMonster;
        int humanAttackroll, monsterAttackRoll;
        boolean flee = false;
        boolean fightOn = true;
//option to fight
        while(fightOn){
            System.out.println("What would you like to do");
            System.out.println("[f]ight\n[r]un");
            String choice = myinput.nextLine().toLowerCase();

            switch (choice){
                case "f":
                    //human attack
                    System.out.printf("You attempt to hit the %s\n", monster.getName());
                    humanAttackroll = diceRoll.nextInt(6); //roll from 0-5
                    if(humanAttackroll <=0){
                        System.out.printf("You failed to hit the %s\n", monster.getName());

                    }
                    else{
                        System.out.printf("You hit the %s for %d\n", monster.getName(), humanAttackroll);
                        tempHealthMonster = monster.getHealth() - humanAttackroll;
                        monster.setHealth(tempHealthMonster);

                    }
                    //check if monster dead before chance to attack
                    if(monster.getHealth() <=0){
                        System.out.println("You slain the Grunt");
                        fightOn = false;
                        System.out.println("You won in the beginner fight");
                        gameRunning = false;
                    }

                    //Monster attack
                    System.out.printf("The %s attempts to hit you\n", monster.getName());
                    monsterAttackRoll = diceRoll.nextInt(6);
                    if(monsterAttackRoll <= 0){
                        System.out.printf("The %s failed to hit you\n", monster.getName());

                    }
                    else{
                        System.out.printf("The %s hit you for %d\n", monster.getName(), monsterAttackRoll);
                        tempHealthHuman = human.getHealth() - monsterAttackRoll;
                        human.setHealth(tempHealthHuman);
                    }
                    break;

                case "r":
                    flee = diceRoll.nextBoolean();
                    if (flee){
                        System.out.println("You fled the battle");
                        fightOn = false;
                        gameRunning = false;
                    }
                    else{
                        System.out.println("You fail to flee the fight");
                        System.out.printf("The %s attempts to hit you\n", monster.getName());
                        monsterAttackRoll = diceRoll.nextInt(6);
                        if(monsterAttackRoll <= 0){
                            System.out.printf("The %s failed to hit you\n", monster.getName());

                        }
                        else{
                            System.out.printf("The %s hit you for %d\n", monster.getName(), monsterAttackRoll);
                            tempHealthHuman = human.getHealth() - monsterAttackRoll;
                            human.setHealth(tempHealthHuman);
                        }
                    }
                    break;
                default:
                    System.out.println("Not a valid choice");

            }
            if(human.getHealth() <= 0){
                life = false;
                fightOn = false;
                System.out.println("GAME OVER, You died...");
                gameRunning = false;
                break;
            }
            else{
                System.out.printf("You have %d health left\n", human.getHealth());
            }

        }


    }
}
