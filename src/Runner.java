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
                try {
                    System.out.print("Which pack? ");
                    Scanner input = new Scanner(System.in);
                    int pack = input.nextInt();
                    p.play(pack);
                }
                catch (Exception e) {
                    System.out.println("Sorry that command does not exist!");
                }
            }
            if (ans.equals("1")) {
                p.play(1);
            }
            if (ans.equals("all")) {
                try {
                    System.out.print("Which pack? ");
                    Scanner input = new Scanner(System.in);
                    int pack = input.nextInt();
                    p.spendAll(pack);
                }
                catch (Exception e) {
                    System.out.println("Sorry that command does not exist!");
                }
            }
            if (ans.equals("yes10")) {
                try {
                    System.out.print("Which pack? ");
                    Scanner input = new Scanner(System.in);
                    int pack = input.nextInt();
                    p.playTen(pack);
                }
                catch (Exception e) {
                    System.out.println("Sorry that command does not exist!");
                }
            }
            if (ans.equals("10")) {
                p.playTen(1);
            }
            if (ans.equals("add")) {
                p.addMoney(999999);
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
            System.out.print(" ~~~~~~~~\n");
            if (ans.equals("prestige")) {
                p.prestige();
            }

            if (ans.equals("rig")) {
                System.out.print("\nPack? ");
                Scanner input = new Scanner(System.in);
                int pack = input.nextInt();
                p.rig(pack);
            }
            if (ans.equals("yessecret")) {
                System.out.print("\nPack? ");
                Scanner input = new Scanner(System.in);
                int pack = input.nextInt();
                p.playSecret(pack);
            }

            System.out.println("Money: " + p.getMoney() + "\nOpen Count: " + p.getOpenCount() + "\n ~~~~~~~~~");

            if (ans.equals("stop")) {
                stop = true;
            }
        }
    }
}
