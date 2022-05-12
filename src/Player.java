import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Player {
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private String name;
    private int money;

    public Player() {
        name = null;
        money = 0;
    }
    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getMoney() {
        return money;
    }

    public void removeMoney(int m) { money -= m; }

    public void setMoney(int m) {
        money = m;
    }

    public void addItem(Item i) { inventory.add(i); }

    public void removeItem(Item i) {
        int index = 0;
        for (Item item : inventory) {
            index++;
            if (item.getItemName().equals(i.getItemName())) {
                inventory.remove(i);
                return;
            }
        }
        System.out.println("Failed");
    }

    public void play() {
        int rng = (int) (Math.random() * 100) + 1;
        System.out.println(rng);
        Item item = new Item(rng);
        addItem(item);
    }

    public void save() {
        try {
            File f = new File("src/player.data");
            f.createNewFile(); // this method will create the file if it does not exist, if it does exist, it does nothing
            FileWriter fw = new FileWriter("src/player.data");
            fw.write(name + "\n");
            fw.write(Integer.toString(money) + "\n");
            if (inventory != null) {
                for (int i = 0; i < inventory.size(); i++) {
                    fw.write(inventory.get(i).getItemName() + "\n");
                    fw.write(inventory.get(i).getValue() + "\n");
                }
            }
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }
}
