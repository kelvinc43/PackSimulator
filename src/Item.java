public class Item {

    private String itemName;
    private int itemCost;
    private int value;
    private double rarity;

    public Item(String name, int value, int rarity, int itemCost) {
        itemName = name;
        this.value = value;
        this.rarity = rarity;
        this.itemCost = itemCost;
    }

    public Item(String name, int value) {
        itemName = name;
        this.value = value;
    }
    
    public String getItemName() {
        return itemName;
    }

    public int getItemCost() {
        return itemCost;
    }

    public int getValue() {
        return value;
    }

    public double getRarity() {
        return rarity;
    }
}

