import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataHandler {

    private Player player;

    public void dataHandle() {
        try {
            File f = new File("src/player.data");
            Scanner s = new Scanner(f);
            int line = 1;
            String name = "";
            int openCount = 0;
            double money = 0;
            int prestige = 0;
            String itemName = "";
            int value = 0;
            ArrayList<Item> save = new ArrayList<Item>();
            while (s.hasNextLine()) {
                String data = s.nextLine();
                if (line == 1) {
                    name = data;
                }
                if (line == 2) {
                    money = Double.parseDouble(data);
                }
                if (line == 3) {
                    openCount = Integer.parseInt(data);
                }
                if (line == 4) {
                    prestige = Integer.parseInt(data);
                }
                if (line > 4 && line % 2 == 1) {
                    itemName = data;
                }
                if (line > 4 && line % 2 == 0) {
                    value = Integer.parseInt(data);
                    Item temp = new Item(itemName, value);
                    save.add(temp);
                }
                line++;
            }
            Player p = new Player(name, money, prestige);
            p.setOpenCount(openCount);
            for (Item item : save) {
                p.addItem(item);
            }
            player = p;
        }
        catch (FileNotFoundException e) {
            Player p = new Player();
            System.out.print("What is your name? ");
            Scanner in = new Scanner(System.in);
            String name = in.nextLine();
            p.setName(name);
            p.setOpenCount(0);
            player = p;
        }
    }
    public Player getPlayer() { return player; }
}
