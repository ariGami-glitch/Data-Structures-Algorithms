/**
 * Class based on lab and textbook example
 */
public class Tree {
    private FlyWeight fw;
    private Node root;

    /* Default Constructor*/
    public Tree() {
        fw = new FlyWeight();
        fw.setDepth(0);
        root = fw;
    }

    public void insert(String sequence) {
        //System.out.println("Inserting " + sequence);
        this.root = helperInsert(this.root, sequence, 0);

    }

    public Node helperInsert(Node rt, String n, int d) {
        //base case
        //if the root is a FW
        if(rt == fw) {
            LeafNode temp = new LeafNode(n);
            temp.setDepth(d);
            rt = temp;
            if(find(root, temp) == false) {
                System.out.println("sequence " + n + " inserted at level " + d);
            }

            //String seq = ((LeafNode)(rt)).getStringSequence();
            return rt;
        }
        //if it is a leaf node
        //must check if prefixes exists
        else if(rt.getProperty().equals("LN")) {
            InternalNode in = new InternalNode();
            //set depth
            in.setDepth(d);
            //set all the pointers to fw
            fw.setDepth(d+1);
            in.setA(fw);
            in.setC(fw);
            in.setG(fw);
            in.setT(fw);
            in.set$(fw);

            //root node already exist the tree, thus we just need to adjust the tree accordingly
            //check if the sequence exist in the tree
            LeafNode ln = new LeafNode(n);
            //if the sequence does exist in the tree, there is no need to add the internal node, so just return the root
            if(find(root, ln)) {
                System.out.println("sequence " + n + " already exists");
                return rt;
            }
            //if the sequence does not exist
            else {
                in = (InternalNode) (helperInsert(in, ((LeafNode)(rt)).getStringSequence(), d));
                in = (InternalNode) (helperInsert(in, n, d));
                return in;

            }
        }
        else {
            //get the sequence to be added
            String rtsequence;
            int length = n.length();
            if(d >= length) {
                ((InternalNode)(rt)).set$(helperInsert(((InternalNode)(rt)).get$(), n, d+1));
                return rt;
            }
            else {
                rtsequence = n.substring(d, d+1);
            }

            if(rtsequence.equals("A")) {
                ((InternalNode)(rt)).setA(helperInsert(((InternalNode)(rt)).getA(), n, d + 1));

            }
            else if(rtsequence.equals("C")) {
                ((InternalNode)(rt)).setC(helperInsert(((InternalNode)(rt)).getC(), n, d + 1));
                fw.setDepth(d+1);

            }
            else if(rtsequence.equals("G")) {
                ((InternalNode)(rt)).setG(helperInsert(((InternalNode)(rt)).getG(), n, d + 1));
                fw.setDepth(d+1);


            }
            else if(rtsequence.equals("T")) {
                ((InternalNode)(rt)).setT(helperInsert(((InternalNode)(rt)).getT(), n, d + 1));
                fw.setDepth(d+1);

            }

            return rt;
        }
    }

    public boolean find(Node rt, LeafNode n) {
        return searchHelper(rt, n);
    }

    private boolean searchHelper(Node rt, LeafNode n) {
        //if fw node
        if(rt == fw) {
            return false;
        }
        //if leaf node
        if(rt.getProperty().equals("LN")) {
            if(((LeafNode)(rt)).getStringSequence().equals(n.getStringSequence())) {
                return true;
            }
            else {
                return false;
            }
        }
        //if internal node
        else {
            return searchHelper(((InternalNode)(rt)).getA(), n) || searchHelper(((InternalNode)(rt)).getC(), n) ||
                    searchHelper(((InternalNode)(rt)).getG(), n) || searchHelper(((InternalNode)(rt)).getT(), n) || searchHelper(((InternalNode)(rt)).get$(), n);
        }
    }

    //regular print
    public void print(String printType) {
        System.out.println("tree dump:");
        if(printType.equals("regular")) {
            printHelper(this.root, 0);
        }
        else if(printType.equals("lengths")) {
            printLengthHelper(this.root, 0);
        }

        else {
            printStatHelper(this.root, 0);
        }


    }
    private void printHelper(Node rt, int depth) {

        for(int i = 0; i < depth; i++) {
            System.out.print(" ");
        }
        if(rt.getProperty().equals("LN")) {
            System.out.println(((LeafNode)(rt)).getStringSequence());
        }
        else if(rt.getProperty().equals("FW")) {
            //System.out.print(rt.getDepth());
            System.out.println("E");
        }
        else {
            System.out.println("I");
            printHelper(((InternalNode)(rt)).getA(), depth + 2);
            printHelper(((InternalNode)(rt)).getC(), depth + 2);
            printHelper(((InternalNode)(rt)).getG(), depth + 2);
            printHelper(((InternalNode)(rt)).getT(), depth + 2);
            printHelper(((InternalNode)(rt)).get$(), depth + 2);
        }
    }

    private void printLengthHelper(Node rt, int depth) {
        for(int i = 0; i < depth; i++) {
            System.out.print(" ");
        }
        if(rt.getProperty().equals("LN")) {
            System.out.println(((LeafNode)(rt)).getStringSequence() + " " + ((LeafNode)(rt)).getLength());
        }
        else if(rt.getProperty().equals("FW")) {
            //System.out.print(rt.getDepth());
            System.out.println("E");
        }
        else {
            System.out.println("I");
            printLengthHelper(((InternalNode)(rt)).getA(), depth + 2);
            printLengthHelper(((InternalNode)(rt)).getC(), depth + 2);
            printLengthHelper(((InternalNode)(rt)).getG(), depth + 2);
            printLengthHelper(((InternalNode)(rt)).getT(), depth + 2);
            printLengthHelper(((InternalNode)(rt)).get$(), depth + 2);
        }
    }

    private void printStatHelper(Node rt, int depth) {
        for(int i = 0; i < depth; i++) {
            System.out.print(" ");
        }
        if(rt.getProperty().equals("LN")) {
            String message = ((LeafNode)(rt)).getStat();
            System.out.println(((LeafNode)(rt)).getStringSequence() + " " + message);
        }
        else if(rt.getProperty().equals("FW")) {
            //System.out.print(rt.getDepth());
            System.out.println("E");
        }
        else {
            System.out.println("I");
            printStatHelper(((InternalNode)(rt)).getA(), depth + 2);
            printStatHelper(((InternalNode)(rt)).getC(), depth + 2);
            printStatHelper(((InternalNode)(rt)).getG(), depth + 2);
            printStatHelper(((InternalNode)(rt)).getT(), depth + 2);
            printStatHelper(((InternalNode)(rt)).get$(), depth + 2);
        }
    }

    public void searchExact(String sequence) {
        int visit = searchExactCount(this.root, sequence, 0);
        LeafNode ln = new LeafNode(sequence);
        boolean found = searchHelper(this.root, ln);
        System.out.println("# of nodes visited: " + visit);
        if(found) {
            System.out.println("sequence: " + sequence);
        }
        else {
            System.out.println("no sequence found");
        }
    }

    //need to revamp the search function to only follow given the sequence
    private int searchExactCount(Node rt, String sequence, int count) {
        //if fw node
        if(rt == fw) {
            return count + 1;
        }
        //if leaf node
        if(rt.getProperty().equals("LN")) {
            if(((LeafNode)(rt)).getStringSequence().equals(sequence)) {
                int c = count + 1;
                //System.out.println("# of nodes visited: " + c);
                return count + 1;
            }
            else {
                return count + 1;
            }
        }
        //if internal node
        else {
            if(count >= sequence.length()) {
                return searchExactCount(((InternalNode)(rt)).get$(), sequence, count + 1);
            }
            else {
                String cur = sequence.substring(count, count + 1);
                if(cur.equals("A")) {
                    return searchExactCount(((InternalNode)(rt)).getA(), sequence, count + 1);
                }
                else if(cur.equals("C")) {
                    return searchExactCount(((InternalNode)(rt)).getC(), sequence, count + 1);
                }
                else if(cur.equals("G")) {
                    return searchExactCount(((InternalNode)(rt)).getG(), sequence, count + 1);
                }
                else {
                    return searchExactCount(((InternalNode)(rt)).getT(), sequence, count + 1);
                }
            }
        }
    }
    //search for sequence that are close enough
    //print it out each time you encounter it in the tree
    //two separate functions for counting the number of nodes visited
    //function should return a boolean if anything is found
    //need to revamp the search function to only follow given the sequence
    private int searchCount(Node rt, String sequence, int count) {
        //if fw node
        if(rt == fw) {
            return 1;
        }
        //if leaf node
        if(rt.getProperty().equals("LN")) {
            return 1;
        }
        //if internal node
        else {
            if(count >= sequence.length()) {
                return 1 + searchCount(((InternalNode)(rt)).get$(), sequence, count + 1) +
                        searchCount(((InternalNode)(rt)).getA(), sequence, count + 1) +
                        searchCount(((InternalNode)(rt)).getC(), sequence, count + 1) +
                        searchCount(((InternalNode)(rt)).getG(), sequence, count + 1) +
                        searchCount(((InternalNode)(rt)).getT(), sequence, count + 1);
            }
            else {
                String cur = sequence.substring(count, count + 1);
                if(cur.equals("A")) {
                    return 1 + searchCount(((InternalNode)(rt)).getA(), sequence, count + 1);
                }
                else if(cur.equals("C")) {
                    return 1 + searchCount(((InternalNode)(rt)).getC(), sequence, count + 1);
                }
                else if(cur.equals("G")) {
                    return 1 + searchCount(((InternalNode)(rt)).getG(), sequence, count + 1);
                }
                else {
                    return 1 + searchCount(((InternalNode)(rt)).getT(), sequence, count + 1);
                }
            }
        }
    }
    public void search(String sequence) {
        int num = searchCount(root, sequence, 0);
        System.out.println("# of nodes visited: " + num);
        if(searchPrint(root, sequence, 0) == false) {
            System.out.println("no sequence found");
        }
    }
    private boolean searchPrint(Node rt, String sequence, int count) {
        //if fw node
        if(rt == fw) {
            return false;
        }
        //if leaf node
        if(rt.getProperty().equals("LN")) {
            if(((LeafNode)(rt)).getStringSequence().contains(sequence)) {
                System.out.println("sequence: " + ((LeafNode)(rt)).getStringSequence());
                return true;
            }
            else {
                return false;
            }
        }
        //if internal node
        else {
            if(count >= sequence.length()) {
                boolean A = searchPrint(((InternalNode)(rt)).getA(), sequence, count + 1);
                boolean C = searchPrint(((InternalNode)(rt)).getC(), sequence, count + 1);
                boolean G = searchPrint(((InternalNode)(rt)).getG(), sequence, count + 1);
                boolean T = searchPrint(((InternalNode)(rt)).getT(), sequence, count + 1);
                boolean $ = searchPrint(((InternalNode)(rt)).get$(), sequence, count + 1);
                return $ || A || C || G || T;
            }
            else {
                String cur = sequence.substring(count, count + 1);
                if(cur.equals("A")) {
                    return  searchPrint(((InternalNode)(rt)).getA(), sequence, count + 1);
                }
                else if(cur.equals("C")) {
                    return  searchPrint(((InternalNode)(rt)).getC(), sequence, count + 1);
                }
                else if(cur.equals("G")) {
                    return searchPrint(((InternalNode)(rt)).getG(), sequence, count + 1);
                }
                else {
                    return searchPrint(((InternalNode)(rt)).getT(), sequence, count + 1);
                }
            }
        }
    }
    public void remove(String sequence) {
        //System.out.println("Removing something here");
        //call the search function to determine if it exists
        LeafNode ln = new LeafNode(sequence);
        if(searchHelper(root, ln) == false) {
            System.out.println("sequence " + sequence + " does not exist");
        }
        //else return true, then remove it with the removeHelper
        else {
            root = removeHelper(root, sequence, 0);
        }

    }

    private Node removeHelper(Node rt, String sequence, int count) {
        //if fw node
        if(rt == fw) {
            return rt;
        }
        //if leaf node
        if(rt.getProperty().equals("LN")) {
            //if the sequence match, return a Fw
            if(((LeafNode)(rt)).getStringSequence().equals(sequence)) {
                System.out.println("sequence " + sequence + " removed");
                return fw;
            }
            //else just return the rt
            else {
                return rt;
            }
        }
        //if internal node
        else {
            if(count >= sequence.length()) {
                ((InternalNode)(rt)).set$(removeHelper(((InternalNode)(rt)).get$(), sequence, count + 1));
            }
            else {
                String cur = sequence.substring(count, count + 1);
                if(cur.equals("A")) {
                    ((InternalNode)(rt)).setA(removeHelper(((InternalNode)(rt)).getA(), sequence, count + 1));
                }
                else if(cur.equals("C")) {
                    ((InternalNode)(rt)).setC(removeHelper(((InternalNode)(rt)).getC(), sequence, count + 1));
                }
                else if(cur.equals("G")) {
                    ((InternalNode)(rt)).setG(removeHelper(((InternalNode)(rt)).getG(), sequence, count + 1));
                }
                else {
                    ((InternalNode)(rt)).setT(removeHelper(((InternalNode)(rt)).getT(), sequence, count + 1));
                }
            }
        }
        //check internal node count
        int innum = ((InternalNode)(rt)).getNumLeaf();
        if(innum == 0) {
            rt = fw;
        }
        else if(innum == 1) {
            //if there is only one node attached, then set the rt to that one leafnode
            if(((InternalNode)(rt)).getA().getProperty().equals("LN")) {
                return ((InternalNode)(rt)).getA();
            }
            else if(((InternalNode)(rt)).getC().getProperty().equals("LN")) {
                return ((InternalNode)(rt)).getC();
            }
            else if(((InternalNode)(rt)).getG().getProperty().equals("LN")) {
                return ((InternalNode)(rt)).getG();
            }
            else if(((InternalNode)(rt)).getT().getProperty().equals("LN")) {
                return ((InternalNode)(rt)).getT();
            }
            else if(((InternalNode)(rt)).get$().getProperty().equals("LN")) {
                return ((InternalNode)(rt)).get$();
            }
        }
        return rt;
    }
}