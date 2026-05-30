package main;

public class Item {
    // Instance Variables
    private String name;
    private String description;
    private int price;
    private int healingAmount;
    private int attackBonus;

    //Constuctor
    public Item (String name, String description, int price, int healingAmount, int attackBonus) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.healingAmount = healingAmount;
        this.attackBonus = attackBonus;

    }

    //Getters
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getPrice() {
        return price;
    }
    public int getAttackBonus() {
        return attackBonus;
    }
    public int getHealingAmount() {
        return healingAmount;
    }

    //To String
    public String toString() {
        return name + " - " + description;
    }




}
