import java.util.Scanner;

public class Runner {

    public void run(Player p) {
        boolean stop = false;
        while (stop != true) {
            System.out.print("\nPlay? ");
            Scanner in = new Scanner(System.in);
            String ans = in.nextLine();
            System.out.println();
            if (ans.equals("yes")) {
                p.play();
            }
            if (ans.equals("yes10")) {
                p.playTen();
            }
            if (ans.equals("add")) {
                p.addMoney(2500);
            }
            if (ans.equals("inv")) {
                p.showInventory();
            }
            if (ans.equals("sell")) {
                p.sellItem();
            }
            if (ans.equals("sellall")) {
                p.sellAll();
            }
            if (ans.equals("rig")) {
                p.rig();
            }
            if (ans.equals("yessecret")) {
                p.playSecret();
            }

            System.out.println(" ~~~~~~~~\nMoney: " + p.getMoney() + "\nOpen Count " + p.getOpenCount() + "\n ~~~~~~~~~");

            if (ans.equals("stop")) {
                stop = true;
            }
        }
    }
}
