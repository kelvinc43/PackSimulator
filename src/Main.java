import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            File f = new File("src/player.data");
            Scanner s = new Scanner(f);
            int line = 1;
            String name = "";
            int money = 0;
            String itemName = "";
            int value = 0;
            ArrayList<Item> save = new ArrayList<Item>();
            while (s.hasNextLine()) {
                String data = s.nextLine();
                if (line == 1) {
                    name = data;
                }
                if (line == 2) {
                    money = Integer.parseInt(data);
                }
                if (line > 2 && line % 2 == 1) {
                    itemName = data;
                }
                if (line > 2 && line % 2 == 0) {
                    value = Integer.parseInt(data);
                    Item temp = new Item(itemName, value);
                    save.add(temp);
                }
                line++;
            }
            Player p = new Player(name, money);
            for (Item item : save) {
                p.addItem(item);
            }
            System.out.println("Name: " + name + " || Money: " + money + " || Open Count: ");

            Runner runner = new Runner();
            runner.run(p);
            p.save();


        }
        catch (FileNotFoundException e) {
            Player p = new Player();
            System.out.print("What is your name? ");
            Scanner in = new Scanner(System.in);
            String name = in.nextLine();
            p.setName(name);
            p.setMoney(100);
            p.save();
        }
    }
}