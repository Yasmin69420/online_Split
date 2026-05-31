package utiles;
/**
 * @author Victor van Bergen
 * @version 1.0
 * creates information for the items
 */
public class ItemInfo {

    private String itemName;
    private int qty;
    private double cost;
    private  int healingAmount;
    private int attackBonus;
    private int defenceBonus;
    private String description;

    /**
     * ItemInfo is used to store the info of each item
     *
     *
     * @param itemName
     * @param qty
     * @param cost
     * @param healingAmount
     * @param attackBonus
     * @param defenceBonus
     * @param description
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

    /**
     * puts the attributes into the item
     * @param gameShop
     *
     */

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
     gets itemName
     */

    public String getItemName() {
        return itemName;

    }

    /**
     * sets itemName
     * @param itemName
     */

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * gets Qty
     * @return
     */

    public int getQty() {
        return qty;
    }

    /**
     * sets qty
     * @param qty
     *
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * gets Cost
     * @return
     */

    public double getCost() {
        return cost;
    }

    /**
     * sets Cost
     * @param cost
     */

    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * gets HealingAmounts
     * @return
     */

    public int getHealingAmount() {
        return healingAmount;
    }

    /**
     * sets HealingAmounts
     * @param healingAmount
     */

    public void setHealingAmount(int healingAmount) {
        this.healingAmount = healingAmount;
    }

    /**
     * gets AttackBouns
     * @return
     */

    public int getAttackBonus() {
        return attackBonus;
    }

    /**
     * sets AttackBouns
     * @param attackBonus
     */

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    /**
     * gets DefenceBonus
     * @return
     */

    public int getDefenceBonus() {
        return defenceBonus;
    }

    /**
     * sets DefenceBonus
     * @param defenceBonus
     */

    public void setDefenceBonus(int defenceBonus) {
        this.defenceBonus = defenceBonus;
    }

    /**
     * gets  Description
     * @return
     */

    public String getDescription() {
        return description;
    }

    /**
     * sets Description
     * @param description
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * formats and prints qty itemName and cost
     * @return
     */

    public String toString() {
        return String.format("%dx\t%s\t$%.02f", this.qty, this.itemName, this.cost);
    }


}