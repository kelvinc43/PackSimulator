import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File f = new File("src/player.data");
            Scanner s = new Scanner(f);
            int line = 1;
            String name = "";
            int money = 0;
            while (s.hasNextLine()) {
                String data = s.nextLine();
                if (line == 1) {
                    name = data;
                }
                if (line == 2) {
                    money = Integer.parseInt(data);
                }
                line++;
            }
            Player p = new Player(name, money);
            System.out.println("Name: " + name + " Money: " + money);
            boolean stop = false;

            while (stop != true) {
                System.out.print("Play? ");
                Scanner in = new Scanner(System.in);
                String ans = in.nextLine();
                if (ans.equals("yes")) {
                    p.play();
                    p.removeMoney(25);
                }
                if (ans.equals("add")) {
                    p.setMoney(250);
                }
                if (ans.equals("stop")) {
                    stop = true;
                }
                System.out.println("Money: " + p.getMoney());
            }
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