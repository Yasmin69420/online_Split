package utiles;

public class ItemInfo {

    private String itemName;
    private int qty;
    private double cost;

    /**
     ItemInfo is used to store the info of each item
     */

    public ItemInfo(String itemName, int qty, double cost) {
        this.itemName = itemName;
        this.qty = qty;
        this.cost = cost;


    }

    public ItemInfo(ItemInfo gameShop) {
        this.itemName = gameShop.getItemName();
        this.qty = gameShop.getQty();
        this.cost = gameShop.getCost();


    }
    /**
     getItemName finds the shop items and attaches atrubuts to them
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


    public String toString() {
        return String.format("%dx\t%s\t$%.02f", this.qty, this.itemName, this.cost);
    }


}