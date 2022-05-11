import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Player {
    private ArrayList<Item> inventory;
    private String name;
    private int money;

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        inventory = null;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int m) {
        money = m;
    }

    public void save() {
        try {
            File f = new File("src/player.data");
            f.createNewFile(); // this method will create the file if it does not exist, if it does exist, it does nothing
            FileWriter fw = new FileWriter("src/player.data");
            fw.write(name + "\n");
            fw.write(money);
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }
}
