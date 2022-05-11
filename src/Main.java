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
            String money = "";
        }
        catch (FileNotFoundException e) {

        }
    }
}