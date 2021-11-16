/**
 * Class based on lab and textbook example
 */
public class Tree {
    private FlyWeight fw;
    private Node root;
    /* Default Constructor*/
    public Tree() {
        fw = new FlyWeight();
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
            if(!find(root, temp)) {
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
                System.out.println("Sequence " + n + " already exists");
                return rt;
            }
            //if the sequence does not exist
            else {
                //check sequence of rt and insert it accordingly
                String rtsequence;
                //check if one is the prefix of the other, method called compare if prefix.
                //check the root and insert it accordingly
                rtsequence = ((LeafNode)(rt)).getStringSequence();
                if(d >= rtsequence.length()) {
                    rt.setDepth(d+1);
                    in.set$(helperInsert(in.get$(), ((LeafNode)(rt)).getStringSequence(), d + 1));
                }
                else {
                    //if not prefix of the other, then insert accordingly
                    //otherwise, the shorter one will be assigned the $
                    rtsequence = (String)(((LeafNode)(rt)).getSequence().get(d));
                    //System.out.println(rtsequence); PASSED
                    if(rtsequence.equals("A")) {
                        in.setA(helperInsert(in.getA(), ((LeafNode)(rt)).getStringSequence(), d + 1));
                        //rt.setDepth(d+1);
                        //in.setA(rt);
                    }
                    else if(rtsequence.equals("C")) {
                        in.setC(helperInsert(in.getC(), ((LeafNode)(rt)).getStringSequence(), d + 1));
                        //rt.setDepth(d+1);
                        //in.setC(rt);
                    }
                    else if(rtsequence.equals("G")) {
                        in.setG(helperInsert(in.getG(), ((LeafNode)(rt)).getStringSequence(), d + 1));
                        //rt.setDepth(d+1);
                        //in.setG(rt);

                    }
                    else if(rtsequence.equals("T")) {
                        in.setT(helperInsert(in.getT(), ((LeafNode)(rt)).getStringSequence(), d + 1));
                        //rt.setDepth(d+1);
                        //in.setT(rt);
                    }
                }


                //check sequence of the new node and insert it accordingly
                String rtsequence1;
                if(d >= n.length()) {
                    in.set$(helperInsert(in.get$(), n, d + 1));
                }
                else {
                    rtsequence1= (String)(((LeafNode)(ln)).getSequence().get(d));
                    //System.out.println(rtsequence); PASSED

                    if(rtsequence1.equals("A")) {
                        in.setA(helperInsert(in.getA(), n, d + 1));
                    }
                    else if(rtsequence1.equals("C")) {
                        in.setC(helperInsert(in.getC(), n, d + 1));
                    }
                    else if(rtsequence1.equals("G")) {
                        in.setG(helperInsert(in.getG(), n, d + 1));
                    }
                    else if(rtsequence1.equals("T")) {
                        in.setT(helperInsert(in.getT(), n, d + 1));
                    }
                }

                return in;

            }

        }
        else {
            //get the sequence to be added
            String rtsequence;
            int length = n.length();
            if(d >= length) {
                helperInsert(((InternalNode)(rt)).get$(), n, d+1);
                return rt;
            }
            else {
                rtsequence = n.substring(d, d+1);
            }

            if(rtsequence.equals("A")) {
                helperInsert(((InternalNode)(rt)).getA(), n, d + 1);
            }
            else if(rtsequence.equals("C")) {
                helperInsert(((InternalNode)(rt)).getC(), n, d + 1);
            }
            else if(rtsequence.equals("G")) {
                helperInsert(((InternalNode)(rt)).getG(), n, d + 1);

            }
            else if(rtsequence.equals("T")) {
                helperInsert(((InternalNode)(rt)).getT(), n, d + 1);
            }

            return rt;
        }
    }

    public boolean find(Node rt, LeafNode n) {
        return searchHelper(rt, n);
    }

    public boolean searchHelper(Node rt, LeafNode n) {
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
                    searchHelper(((InternalNode)(rt)).getG(), n) || searchHelper(((InternalNode)(rt)).getT(), n);
        }
    }
    public void print() {
        System.out.println("tree dump:");
        printHelper(this.root);

    }
    private void printHelper(Node rt) {
        int indent = rt.getDepth() * 2;
        for(int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        if(rt.getProperty().equals("LN")) {
            System.out.println(((LeafNode)(rt)).getStringSequence());
        }
        else if(rt.getProperty().equals("FW")) {
            System.out.println("E");
        }
        else {
            System.out.println("I");
            printHelper(((InternalNode)(rt)).getA());
            printHelper(((InternalNode)(rt)).getC());
            printHelper(((InternalNode)(rt)).getG());
            printHelper(((InternalNode)(rt)).getT());
            printHelper(((InternalNode)(rt)).get$());
        }

    }

}
