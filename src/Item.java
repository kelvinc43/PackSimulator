import java.util.Arrays;
public class Item {

    private String itemName;
    private int value;
    private int[] rarityList   = {1, 3, 6, 10, 100};
    private String[] itemNames = {"test1", "test2", "test3", "test4", "test5"};
    private int[] valueList    = {100, 50, 30, 20, 10};

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
}
