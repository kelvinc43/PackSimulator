import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

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

    public void removeMoney(int m) {
        money -= m;
    }

    public void setMoney(int m) {
        money = m;
    }

    public void addMoney(int m) { money += m; }

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
        Item item = new Item(rng);
        System.out.println("You got " + item.getItemName() + "! (" + item.getRarity() + "%)");
        addItem(item);
    }

    public void playTen() {
        for (int i = 0; i < 10; i++) {
            play();
        }
    }

    public void showInventory() {
        int count = 1;
        for (Item item : inventory) {
           System.out.println("Item #" + count + ":");
           System.out.println("Name: " + item.getItemName());
           System.out.println("Value: " + item.getValue());
           System.out.println("----");
           count++;
       }
    }

    public void sellItem() {
        showInventory();
        System.out.println("Which item (#) do you want to sell?");
        Scanner in = new Scanner(System.in);
        int ans = in.nextInt();
        ans -= 1;
        try {
            addMoney(inventory.get(ans).getValue());
            inventory.remove(ans);
        }
        catch (Exception e) {
            System.out.println("Sorry! That item does not exist in your inventory!");
            sellItem();
        }
    }

    public void sellAll() {

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
