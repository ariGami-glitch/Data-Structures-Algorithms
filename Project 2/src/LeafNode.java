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
    private double anum;
    private double cnum;
    private double gnum;
    private double tnum;

    /*default constructor*/
    public LeafNode() {
        property = "LN";
    }
    public LeafNode(String seq) {
        property = "LN";
        convertSequence(seq);
        this.seq = seq;
        length = seq.length();

        anum = 0;
        cnum = 0;
        gnum = 0;
        tnum = 0;
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

    //this sets the sequence of the leaf node
    public void setSeq(String seq) {
        this.seq = seq;
        convertSequence(this.seq);
        length = this.seq.length();

    }

    //this method gets that stat for the sequence
    public String getStat() {
        for(int i = 0; i < length; i++) {
            String cur = (String)sequence.get(i);
            if(cur.equals("A")) {
                anum += 1;
            }
            else if(cur.equals("C")) {
                cnum += 1;
            }
            else if(cur.equals("G")) {
                gnum += 1;
            }
            else {
                tnum += 1;
            }
        }
        double aratio = (anum / length) * 100.0;
        double cratio = (cnum / length) * 100.0;
        double gratio = (gnum / length) * 100.0;
        double tratio = (tnum / length) * 100.0;

        String message = "" + "A:" + String.format("%.2f", aratio);
        message += " C:" + String.format("%.2f", cratio);
        message += " G:" + String.format("%.2f", gratio);
        message += " T:" + String.format("%.2f", tratio);
        anum = 0;
        cnum = 0;
        gnum = 0;
        tnum = 0;

        return message;
    }

}
