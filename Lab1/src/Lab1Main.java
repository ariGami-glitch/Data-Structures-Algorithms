/**
 * Ariana Tran
 * CPSC 340
 * I pledge
 *
 * I am not very good at statistics, as I do not remember anything
 * from it, I am going to guess the proportion of girls to boys in a
 * country would be 2:1 assuming if they have a boy they would try again
 * for a girl.
 *
 */
public class Lab1Main {
    public static void main(String[] args) {
        Family[] families = new Family[5];

        for(int i = 0; i < families.length; i++) {
            Family f = new Family();
            f.step();
            System.out.println("Num of girls: " + f.getGirls());
            System.out.println("Num of boys: " + f.getBoys());
            System.out.println("----------------------------------");
            families[i] = f;

        }


    }
}
