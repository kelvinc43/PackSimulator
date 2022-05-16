import java.util.Arrays;
public class Item {

    private String itemName;
    private int itemCost = 25;
    private int value;
    private double rarity;

    private int[] rarityList   = {1,         30,      130,      280,      580,     1000}; // 0.1%, 3%, 10%, 15%, 30%, 42%
    private String[] itemNames = {"Secret", "test-1", "test-2", "test-3", "test-4", "test-5"};
    private int[] valueList    = {1000000,   1000,    250,     100,     40,      20};

    public Item(int rng) {
        int index = -1;
        for (int i = 0; i < itemNames.length; i++) {
            if (rng <= rarityList[i]) {
                index = i;
                break;
            }
        }
        this.itemName = itemNames[index];
        this.value = valueList[index];
        if (index > 1) {
            rarity = rarityList[index] - rarityList[index - 1];
        } else rarity = rarityList[index];
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
