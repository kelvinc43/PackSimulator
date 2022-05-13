import java.util.Arrays;
public class Item {

    private String itemName;
    private int value;
    private int[] rarityList   = {1, 3, 6, 30, 100};
    private double rarity;
    private String[] itemNames = {"test1", "test2", "test3", "test4", "test5"};
    private int[] valueList    = {1000, 250, 100, 40, 20};

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
        if (index != 1) {
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

    public double getRarity() {
        return rarity;
    }
    public int getValue() {
        return value;
    }
}
