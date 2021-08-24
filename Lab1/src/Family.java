import java.util.Random;
public class Family {
    //private variables for girls and boys
    private int girls;
    private int boys;

    /* Default Constructor */
    public Family() {
        girls = 0;
        boys = 0;
    }

    /* Getter method to get the number of girls the family has */
    public int getGirls() {
        return girls;
    }

    /* Getter method to get the number of boys the family has */
    public int getBoys() {
        return boys;
    }

    public void step() {
        //instance of Random class
        Random rand = new Random();
        //variable for the random number
        int baby = rand.nextInt(2);

        boolean done = false;

        while(!done) {
            //if it is 0, it is a girl
            if(baby == 0) {
                girls += 1;
                done = true;
            }

            //else, as in it is a 1, then it is a boy
            else {
                boys += 1;
                //System.out.print("Try again");
                baby = rand.nextInt(2);
            }
        }
    }

}
