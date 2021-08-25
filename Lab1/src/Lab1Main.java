/**
 * Ariana Tran
 * CPSC 340
 * I pledge
 *
 * I am not very good at statistics, as I do not remember anything
 * from it, I am going to guess the proportion of girls to boys in a
 * country would be 1:1 assuming if they have a boy they would try again
 * for a girl. Based on biology, every family has a 50% chance of having a girl
 * and 50% of having a boy.
 */
public class Lab1Main {
    private static int girls = 0;
    private static int boys = 0;
    private static double total;

    /**
     * This method represents the main
     */
    public static void main(String[] args) {
        Family[] families = new Family[1000000];

        for(int i = 0; i < families.length; i++) {
            Family f = new Family();
            f.step();
            girls += f.getGirls();
            boys += f.getBoys();
            families[i] = f;
            total = boys + girls;
        }
        displayAnswer();
    }

    /**
     * This method displays the answer to the problem. It takes the
     * number of girls and boys and prints out the percentage of girls
     * and boys in a place with 1000000 families, followed by the number
     * of girls.
     */
    public static void displayAnswer() {
        double percentGirls = ((double)girls / total) * 100;
        double percentBoys = ((double)boys / total) * 100;
        System.out.println("% girls: " + percentGirls + ", %boys: " + percentBoys + ", total number of girls: " + girls);
    }
}
