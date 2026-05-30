package utiles;

public class ItemInfo {

    private String itemName;
    private int qty;
    private double cost;
    private  int healingAmount;
    private int attackBonus;
    private int defenceBonus;
    private String description;

    /**
     ItemInfo is used to store the info of each item
     */

    public ItemInfo(String itemName, int qty, double cost, int healingAmount ,int attackBonus,  int defenceBonus, String description) {
        this.itemName = itemName;
        this.qty = qty;
        this.cost = cost;
        this. healingAmount = healingAmount;
        this.attackBonus = attackBonus;
        this. description = description;
        this. defenceBonus = defenceBonus;


    }

    public ItemInfo(ItemInfo gameShop) {
        this.itemName = gameShop.getItemName();
        this.qty = gameShop.getQty();
        this.cost = gameShop.getCost();
        this. healingAmount = gameShop.getHealingAmount();
        this.attackBonus = gameShop.getAttackBonus();
        this. description = gameShop.getDescription();
        this. defenceBonus = gameShop.getDefenceBonus();


    }
    /**
     getItemName finds the shop items and attaches attributes to them
     */

    public String getItemName() {
        return itemName;

    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getHealingAmount() {
        return healingAmount;
    }

    public void setHealingAmount(int healingAmount) {
        this.healingAmount = healingAmount;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public int getDefenceBonus() {
        return defenceBonus;
    }

    public void setDefenceBonus(int defenceBonus) {
        this.defenceBonus = defenceBonus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return String.format("%dx\t%s\t$%.02f", this.qty, this.itemName, this.cost);
    }


}