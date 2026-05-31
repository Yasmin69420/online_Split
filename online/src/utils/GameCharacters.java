package utils;
import main.Item;

import java.util.ArrayList;

public class GameCharacters {

    private String name;
    private String charType;
    private int health;
    private int defense;
    private int attack;
    private int gold;
    private ArrayList<Item> backpack;

    //constructor
    public GameCharacters(){
        this.health = 120;
        this.defense = 50;
        this.attack = 33;
        this.gold = 50;
        this.backpack = new ArrayList<>();


    }

    public String getName(){

        return name;
    }

    public void setName(String TempName){
        this.name = TempName;
    }

    public String getCharType() {
        return charType;
    }

    public void setCharType(String charType) {
        this.charType = charType;
    }

    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }

    public int getGold() { return gold;}

    public void setHealth(int health) {
        this.health = health;


        }

    public void setDefense(int defense) {
        this.defense = defense;


    }

        //helper methods
    public boolean IsAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
        }
    }

    public int attackEnemy() {
        return attack;
    }

    public void addGold(int amount) {
        gold += amount;
    }

    public boolean spendGold(int amount) {
        if (gold >= amount) {
            gold -=amount;
            return true;
        }
        return false;
    }

    //Backpack Methods
    public void addItem(Item item) {
        backpack.add(item);
    }

    public void showBackpack() {
        if (backpack.size() == 0) {
            System.out.println("Backpack empty");
            return;
        }

    System.out.println("Your backpack:");
        for (int i = 0; i < backpack.size(); i++) {
            System.out.println(i + 1 + ", " + backpack.get(i));
        }
    }

    public void useItem(int index) {
        if (index < 0 || index >= backpack.size()) {
            System.out.println("Invalid item number");
        }
        Item item = backpack.get(index);

        if (item.getHealingAmount() > 0) {
            health += item.getHealingAmount();
            if (health > 120) {
                health = 120;
            }
            System.out.println("You used a " + item.getName() + " and gained health");
            backpack.remove(index);
        }
    else if (item.getAttackBonus() > 0) {
        attack += item.getAttackBonus();
        System.out.println("You used " + item.getName() + " and gained attack power");

        }
    else {
        System.out.println("You cannot use this item");
        }
    }




    @Override
    public String toString() {
        return String.format("character info");
    }
}
