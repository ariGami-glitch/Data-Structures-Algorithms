/**
 * This class represents the base class for all nodes
 * used in this program.
 *
 */
public class Node {
    private int depth;
    private String property;
    private String seq;

    public Node() {
        property = "Node";
    }

    /*This method gets the property of the node, as in what type of node it is*/
    public String getProperty() {
        return property;
    }

    /*This method gets the depth of the node in a tree*/
    public int getDepth() {
        return depth;
    }

    /*This method sets the depth of the node in a tree*/
    public void setDepth(int d) {
        this.depth = d;
    }

    /*public String getStringSequence() {
        return seq;
    }*/
}
