public class Item {

    private String itemName;
    private int value;
    private double rarity;

    public Item(String name, int value, int rarity) {
        itemName = name;
        this.value = value;
        this.rarity = rarity;
    }

    public Item(String name, int value) {
        itemName = name;
        this.value = value;
    }
    
    public String getItemName() {
        return itemName;
    }

    public int getValue() {
        return value;
    }

    public double getRarity() {
        return rarity;
    }
}

