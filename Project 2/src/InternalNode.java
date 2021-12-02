public class InternalNode extends Node {
    //fields
    private String property;
    private int depth;
    private Node a;
    private Node c;
    private Node t;
    private Node g;
    private Node $;
    private String seq;
    private int numLeaf;

    /*Default constructor*/
    public InternalNode() {
        property = "IN";
    }

    /*this method gets the property which is the type of node it is*/
    public String getProperty() {
        return property;
    }

    /*this method sets the depth at which the node is in the tree*/
    public void setDepth(int d) {
        this.depth = d;
    }

    /*this method gets the depth at which the node is in the tree*/
    public int getDepth() {
        return depth;
    }

    /*This method sets a node to the pointer for A*/
    public void setA(Node a) {
        this.a = a;
    }

    /*This method sets a node to the pointer for C*/
    public void setC(Node c) {
        this.c = c;
    }

    /*This method sets a node to the pointer for G*/
    public void setG(Node g) {
        this.g = g;
    }

    /*This method sets a node to the pointer for T*/
    public void setT(Node t) {
        this.t = t;
    }

    /*This method sets a node to the pointer for $*/
    public void set$(Node $) {
        this.$ = $;
    }

    /*This method gets a node to the pointer for A*/
    public Node getA() {
        return a;
    }

    /*This method gets a node to the pointer for C*/
    public Node getC() {
        return c;
    }

    /*This method gets a node to the pointer for G*/
    public Node getG() {
        return g;
    }

    /*This method gets a node to the pointer for T*/
    public Node getT() {
        return t;
    }

    /*This method gets a node to the pointer for $*/
    public Node get$() {
        return $;
    }
    public String getStringSequence() {
        return seq;
    }

    public int getNumLeaf() {
        numLeaf = 5;
        if(get$().getProperty().equals("FW")) {
            numLeaf -= 1;
        }
        if(getA().getProperty().equals("FW")) {
            numLeaf -= 1;
        }
        if(getC().getProperty().equals("FW")) {
            numLeaf -= 1;
        }
        if(getG().getProperty().equals("FW")) {
            numLeaf -= 1;
        }
        if(getT().getProperty().equals("FW")) {
            numLeaf -= 1;
        }
        return numLeaf;
    }

}
