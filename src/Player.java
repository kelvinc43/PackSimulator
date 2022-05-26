import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.text.NumberFormat;
import java.util.Scanner;

public class Player {
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private String name;
    private double money;
    private int openCount;
    private int prestige;
    private final int PRESTIGE_COST = 2500;
    private final double START_MONEY = 100;

    public Player() {
        name = null;
        money = START_MONEY;
        prestige = 0;
        openCount = 0;
    }
    public Player(String name, double money, int prestige) {
        this.name = name;
        this.money = money;
        this.prestige = prestige;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void removeMoney(double m) {
            money -= m;
    }

    public void addMoney(double m) { money += m; }

    public String getName() { return name; }

    public void addItem(Item i) { inventory.add(i); }

    public int getOpenCount() { return openCount; }

    public void setOpenCount(int c) { openCount = c; }

    public int getPrestige() { return prestige; }

    public void play(int pack) {
        Gacha roll = new Gacha(pack);
        Item item = roll.getItem();
        double itemCost = item.getItemCost() * ((prestige/1.5) + 1);
        if (money - itemCost >= 0) {
            removeMoney(itemCost);
            System.out.print("You got a " + item.getItemName() + "! (" + (item.getRarity() / 10) + "%)");
            if (item.getRarity() == 1) { System.out.print("!!!!!!!!!!!!!!!!!!"); }
            System.out.println();
            openCount++;
            addItem(item);
        }
        else {
            System.out.println("Sorry! You do not have enough money to buy this! You can either sell your items or restart");
        }
    }
    public void spendAll(int pack) {
        int loops = 0;
        Gacha roll = new Gacha(pack);
        Item item = roll.getItem();
        double itemCost = item.getItemCost() * ((prestige/1.5) + 1);
        while (money - itemCost >= 0 && loops <= 24999) {
            play(pack);
            loops++;
        }
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        double total = itemCost * loops;
        String moneySpent = currency.format(total);
        System.out.println("Successfully opened " + loops + " packs! (" + moneySpent + ")");
    }

    public void playSecret(int pack) {
        int rng = (int) (Math.random() * 1000) + 1;
        while (rng != 1) {
            rng = (int) (Math.random() * 1000) + 1;
            Gacha roll = new Gacha(pack);
            Item item = roll.getItem();
            System.out.print("You got " + item.getItemName() + "! (" + (item.getRarity() / 10) + "%)");
            if (rng == 1) { System.out.print("!!!!!!!!!!!!"); }
            System.out.println();
            openCount++;
            addItem(item);
        }
    }
    public void playTen(int ans) {
        for (int i = 0; i < 10; i++) {
            play(ans);
        }
    }
    public void showInventory() {
        ArrayList<Item> tempInv = new ArrayList<>(inventory);
        int count = 1;
        for (Item item : inventory) {
           System.out.println("Item #" + count + ":");
           System.out.println("Name: " + item.getItemName());
           double itemValue = item.getValue() * Math.pow(1.2, prestige);
           NumberFormat currency = NumberFormat.getCurrencyInstance();
           String value = currency.format(itemValue);
           System.out.println("Value: " + value);
           System.out.println("----");
           count++;
       }
        // Item counter
        for (int a = 0; a < tempInv.size(); a++) {
            int amount = 0;
            String name = tempInv.get(a).getItemName();
            for (int i = 0; i < tempInv.size(); i++)
            {
                if (tempInv.get(i).getItemName().equals(name)) {
                    amount++;
                    tempInv.remove(i);
                    i--;
                }
            }
            if (amount > 0) a--;
            System.out.println(name + ": x" + amount);
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
            double value = inventory.get(index).getValue() * Math.pow(1.2, prestige);
            addMoney(value);
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            String moneyGained = currency.format(value);
            System.out.println("Successfully sold " + inventory.get(index).getItemName() + " for " + moneyGained + "!");
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
        try {
            ans = ans.toLowerCase();
            if (ans.equals("yes")) {
                double total = 0;
                for (int i = 0; i < inventory.size(); i++) {
                    double value = inventory.get(i).getValue() * Math.pow(1.2, prestige);
                    addMoney(value);
                    total += value;
                    inventory.remove(i);
                    i--;
                }
                NumberFormat currency = NumberFormat.getCurrencyInstance();
                String moneyGained = currency.format(total);
                System.out.println("Successfully sold all for " + moneyGained + "!");
            }
        }
        catch (Exception e) {
            System.out.println("Invalid response.");
        }
    }

    public void prestige() {
        double prestigeCost = (PRESTIGE_COST * Math.pow(1.75, prestige));
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String cost = currency.format(prestigeCost);
        System.out.println("Cost to prestige: " + cost + ", Are you sure you want to proceed?");
        Scanner in = new Scanner(System.in);
        String ans = in.nextLine();
        if (ans.equals("yes") && money >= prestigeCost) {
            prestige++;
            money = START_MONEY * ((prestige/1.5) + 1);
            for (int i = 0; i < inventory.size(); i++) {
                inventory.remove(i);
                i--;
            }
            System.out.print(" ~~~~~~~~\n");
            System.out.println("Prestige: " + prestige);
        }
        else System.out.println("Error");
    }

    public void restart() {
        money = START_MONEY;
        prestige = 0;
        openCount = 0;
        for (int i = 0; i < inventory.size(); i++) {
            inventory.remove(i);
            i--;
        }
    }

    public void save() {
        try {
            File f = new File("src/player.data");
            f.createNewFile(); // this method will create the file if it does not exist, if it does exist, it does nothing
            FileWriter fw = new FileWriter("src/player.data");
            fw.write(name + "\n");
            fw.write(Double.toString(money) + "\n");
            fw.write(Integer.toString(getOpenCount()) + "\n");
            fw.write(Integer.toString(getPrestige()) + "\n");
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