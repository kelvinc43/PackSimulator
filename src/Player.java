import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class Player {
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private String name;
    private int money;
    private int openCount;

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

    public int getOpenCount() { return openCount; }

    public void play() {

        int rng = (int) (Math.random() * 1000) + 1;
        Item item = new Item(rng);
        if (money - item.getItemCost() > 0) {
            removeMoney(item.getItemCost());
            System.out.println("You got " + item.getItemName() + "! (" + (item.getRarity() / 10) + "%)");
            if (item.getItemName().equals("Secret")) { System.out.print("!!!!!!!!!!!!"); }
            openCount++;
            addItem(item);
        }
        else {
            System.out.println("Sorry! You do not have enough money to buy this! You can either sell your items or restart");
        }
    }

    public void rig() {
        Item item = new Item(1);
        System.out.println(item.getItemName() + " added!");
        addItem(item);
    }

    public void playSecret() {
        int rng = (int) (Math.random() * 1000) + 1;
        while (rng != 1) {
            rng = (int) (Math.random() * 1000) + 1;
            Item item = new Item(rng);
            System.out.print("You got " + item.getItemName() + "! (" + (item.getRarity() / 10) + "%)");
            if (item.getItemName().equals("Secret")) { System.out.print("!!!!!!!!!!!!"); }
            System.out.println();
            openCount++;
            addItem(item);
        }
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
        String ans = in.nextLine();
        if (ans.equals("Stop") || ans.equals("stop")) {
            return;
        }
        try {
            int index = Integer.parseInt(ans) - 1;
            addMoney(inventory.get(index).getValue());
            inventory.remove(index);
        }
        catch (Exception e) {
            System.out.println("Sorry! That item does not exist in your inventory!");
            sellItem();
        }
    }

    public void sellAll() {
        System.out.println("Are you sure?");
        Scanner in = new Scanner(System.in);
        String ans = in.nextLine();
        ans = ans.toLowerCase();
        if (ans.equals("yes")) {
            for (int i = 0; i < inventory.size(); i++) {
                addMoney(inventory.get(i).getValue());
                inventory.remove(i);
                i--;
            }
        }
        else return;
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
