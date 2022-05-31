public class Packs {

    private Item item;
    private int packCost;

    //Pack 1 - 25
    private int[] rarityList   = {1,         30,       150,      350,      650,      1000}; // 0.1%, 3%, 12%, 20%, 30%, 35%
    private String[] itemNames = {"S",       "A", "B", "C", "D", "F"};
    private int[] valueList    = {11111,     250,      100,       55,       25,       15};

    //Pack 2 - 260
    private int[] rarityList2   = {1,         334,    1000}; // 0.1%, 33%, 66%
    private String[] itemNames2 = {"Middle", "Left", "Right"};
    private int[] valueList2    = {66666,     525,    100};

    //Pack 3 - 1750
    private int[] rarityList3 = {10, 40, 1000};
    private String[] itemNames3 = {"Win", "???", "Garbage"};
    private int[] valueList3 = {75000, 10000, 500};

    public Packs(int number) {
        String itemName = "";
        int value = 0;
        int rarity = 0;

        int rng = (int) (Math.random() * 1000) + 1;
        if (number == 1) {
            int index = -1;
            for (int i = 0; i < itemNames.length; i++) {
                if (rng <= rarityList[i]) {
                    index = i;
                    break;
                }
            }
            itemName = itemNames[index];
            value = valueList[index];
            packCost = 25;
            if (index >= 1) {
                rarity = rarityList[index] - rarityList[index - 1];
            } else rarity = rarityList[index];
        }
        if (number == 2) {
            int index = -1;
            for (int i = 0; i < itemNames2.length; i++) {
                if (rng <= rarityList2[i]) {
                    index = i;
                    break;
                }
            }
            itemName = itemNames2[index];
            value = valueList2[index];
            packCost = 260;
            if (index >= 1) {
                rarity = rarityList2[index] - rarityList2[index - 1];
            } else rarity = rarityList2[index];
        }
        if (number == 3) {
            int index = -1;
            for (int i = 0; i < itemNames3.length; i++) {
                if (rng <= rarityList3[i]) {
                    index = i;
                    break;
                }
            }
            itemName = itemNames3[index];
            value = valueList3[index];
            packCost = 1750;
            if (index >= 1) {
                rarity = rarityList3[index] - rarityList3[index - 1];
            } else rarity = rarityList3[index];
        }
        item = new Item(itemName, value, rarity);
    }

    public Item getItem() {
        return item;
    }
    public int getPackCost() {
        return packCost;
    }
}
