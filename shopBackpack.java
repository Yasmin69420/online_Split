package main;
import java.util.ArrayList;
import java.util.Scanner;
import utiles.ItemInfo;
public class shopBackpack {
    private static ArrayList<ItemInfo> shopInventory = populateInventory();

    private static ArrayList<ItemInfo> backpack = new ArrayList<>();

    private static Scanner myInput = new Scanner(System.in);

    private static double gold = 30.00;


    public static void main(String[] args) {
        System.out.println("Welcome to the shop");
        viewShopItems();
        System.out.println(("Viewing backpack...."));
        viewBackpack();

    }

    public static ArrayList<ItemInfo> populateInventory() {
        shopInventory = new ArrayList<>();
        shopInventory.add(new ItemInfo("AK-47", 1, 20.50));
        shopInventory.add(new ItemInfo("bullet-proof vest", 1, 15.00));
        shopInventory.add(new ItemInfo("speed potion", 1, 5.00));
        return shopInventory;


    }

    public static void viewShopItems() {
        for (int i = 0; i < shopInventory.size(); i++) {
            System.out.println((shopInventory.get(i)));
        }

        while (!myInput.equals(("n"))){
            System.out.println("would you like to purchase anything?");
            String equals = myInput.nextLine().toLowerCase();
            switch (equals) {
                case "y":
                    purchaseItems();


                    break;
                case "n":
                    System.out.println("you opt not to purchase any items...");
                    break;
                default:
                    System.out.println("try again");
                    break;
            }


            }

        }
        public static void purchaseItems(){
        System.out.printf("you have $%.02f gold\n\n", gold);
        System.out.println("what item would you like to buy?");
        String itemSelect = myInput.nextLine();
        boolean found = false;
        double cost = 0.00;
        int index = 0;
        int itemQty = 0;
        int backpackIndex = 0;
        boolean backpackFound = false;
        for (int i = 0; i < shopInventory.size(); i++){
            if(itemSelect.equals(shopInventory.get(i).getItemName())){
                found = true;
                cost = shopInventory.get(i).getCost();
                index = i;
                itemQty = shopInventory.get(i).getQty();
            }
        }
        if(found && gold >= cost && itemQty > 0) {
            System.out.printf("\nThe item %s costs $%.02f\nwill you purchase this item?: [y]/[n]:\n", itemSelect, cost, gold);
            String pChoice = myInput.nextLine().toLowerCase();
            switch (pChoice) {
                case "y":
                    System.out.println(("Thank you for your purchase"));
                    for (int i = 0; i < backpack.size(); i++) {
                        if (itemSelect.equals((backpack.getFirst().getItemName()))) {
                            backpackIndex = i;
                            backpackFound = true;
                        }
                    }
                    if (backpackFound) {
                        backpack.get(backpackIndex).setQty(backpack.get(backpackIndex).getQty() + 1);
                    } else {
                        backpack.add(new ItemInfo(shopInventory.get(index).getItemName(), 1, shopInventory.get(index).getCost()));
                    }
                    gold -= cost;
                    shopInventory.get(index).setQty(shopInventory.get(index).getQty() - 1);
                    break;
                case "n":
                    System.out.println(("oh.....ok"));
                    break;

                default:
                    System.out.println(("not a valid input... you buy nothing"));
                }

        }else if (found && gold <cost) {
            System.out.println("you don't have enough money for " + itemSelect);

        }
        if(found == false || itemQty ==0){
            System.out.println("Item: "+ itemSelect + " not available");
        }

        }

    public static void viewBackpack() {
        for (int i = 0; i < backpack.size(); i++) {
            System.out.println(backpack.get(i));
        }

    }
    }








