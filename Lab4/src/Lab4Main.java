/*

 */
import java.util.ArrayList;
import java.util.LinkedList;
public class Lab4Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        long startTime = System.nanoTime();
        for(int i = 0; i < 500000; i++) {
            ll.addLast(i);
        }
        long endTime = System.nanoTime();
        long elapsedMS = (endTime - startTime) / 1000000;
        System.out.println("Elapsed time = " + elapsedMS + " milliseconds.");
    }
}
