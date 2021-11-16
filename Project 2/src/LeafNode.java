/**
 * This class represents the leaf node in the tree that
 * stores the sequence of DNA
 */
public class LeafNode extends Node {
    //fields
    private String property;
    private String seq;
    private LinkedList sequence;
    private int depth;
    private int length;

    /*default constructor*/
    public LeafNode() {
        property = "LN";
    }
    public LeafNode(String seq) {
        property = "LN";
        convertSequence(seq);
        this.seq = seq;
        length = seq.length();
    }

    /*This method gets the type of node this is, which is a leaf node*/
    public String getProperty() {return property;}

    public int getDepth() {
        return depth;
    }

    public void setDepth(int d) {
        this.depth = d;
    }

    /*This method converts the String sequence into a linked list*/
    private void convertSequence(String seq) {
        sequence = new LinkedList();
        for(int i = 0; i < seq.length(); i++) {
            String dnaseq = seq.substring(i, i + 1);
            sequence.append(dnaseq);
        }
    }

    /*This method gets the linked list sequence*/
    public LinkedList getSequence() {
        return sequence;
    }

    /*This method gets the String version of the sequence*/
    public String getStringSequence() {
        return seq;
    }

    /*This method gets the length of the sequence*/
    public int getLength() {
        return length;
    }

    public void setSeq(String seq) {
        this.seq = seq;
        convertSequence(this.seq);
        length = this.seq.length();

    }
}
