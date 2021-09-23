import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class BigNumArithmetic {
    public static void main(String[] args) {
        File f = new File(args[0]);
        FileInputStream fis = new FileInputStream((f));
        Scanner input = new Scanner(fis);
        String line = input.nextLine();
        System.out.println(line);

    }
}
