import java.util.Scanner;

public class Runner {

    public void run(Player p) {
        boolean stop = false;
        while (stop != true) {
            System.out.print("Play? ");
            Scanner in = new Scanner(System.in);
            String ans = in.nextLine();
            if (ans.equals("yes")) {
                p.play();
                p.removeMoney(25);
            }
            if (ans.equals("yes10")) {
                p.playTen();
                p.removeMoney(250);
            }
            if (ans.equals("add")) {
                p.addMoney(250);
            }
            if (ans.equals("inv")) {
                p.showInventory();
            }
            if (ans.equals("sell")) {
                p.sellItem();
            }

            System.out.println("Money: " + p.getMoney());

            if (ans.equals("stop")) {
                stop = true;
            }
        }
    }
}
