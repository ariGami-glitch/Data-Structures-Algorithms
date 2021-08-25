import java.util.Random;

/**
 * This class represents one family in a country.
 */
public class Family {
    //private variables for girls and boys
    private int girls;
    private int boys;

    /* Default Constructor */
    public Family() {
        girls = 0;
        boys = 0;
    }

    /**
     * This method returns the number of girls the family have
     *
     * @return an int that represents the number of girls.
     */
    public int getGirls() {
        return girls;
    }

    /**
     * This method returns the number of boys the family have
     *
     * @return an int that represents the number of boys
     */
    public int getBoys() {
        return boys;
    }

    /**
     * This method represents one life cycle the family has. As in if the family
     * has a girl, they stop, if not, they keep trying for a girl.
     */
    public void step() {
        //instance of Random class
        Random rand = new Random();
        //variable for the random number
        int baby = rand.nextInt(2);

        //this represents if the family will keep trying to have kids
        boolean done = false;

        while(!done) {
            //if it is 0, it is a girl
            if(baby == 0) {
                girls += 1;
                //the family is done trying for a girl so loop terminates
                done = true;
            }

            //else, as in it is a 1, then it is a boy
            else {
                boys += 1;
                //the family tries again for a girl
                baby = rand.nextInt(2);
            }
        }
    }
}
