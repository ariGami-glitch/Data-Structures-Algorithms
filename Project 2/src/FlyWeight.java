/**
 * This class extends the Node base class,
 * and represents the flyweight node when a
 * node is empty in a tree.
 */
public class FlyWeight extends Node{
    //fields
    private String property;
    private int depth;
    private String seq;

    /*default constructor*/
    public FlyWeight() {
        property = "FW";
    }

    /*This method gets the type of node it is*/
    public String getProperty() {
        return property;
    }

    /*This method gets the depth at which the node is located in the tree*/
    public int getDepth() {
        return depth;
    }

    /*This method sets the depth at which the node is located in the tree*/
    public void setDepth(int d) {
        this.depth = d;
    }
    public String getStringSequence() {
        return seq;
    }
}
