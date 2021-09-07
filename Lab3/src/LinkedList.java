// LinkedList.java

public class LinkedList<Type> {
    // a Node of the list
    private class Node {
        public Type data;
        public Node next;
    }

    // the head of the list is first node
    private Node head;

    // the list starts empty
    public LinkedList() {
        head = null;
    }

    // add an item to the list
    public void add(Type item) {
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = head;
        head = newNode;
    }

    // add an item to the end of the list
    public void append(Type item) {
        if (head == null) {
            add(item);
        } else {
            Node newNode = new Node();
            newNode.data = item;
            newNode.next = null;

            Node last = head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = newNode;
        }
    }
    
    // remove an item based on the value
    public void remove(Type item) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.data.equals(item)) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
            }

            prev = current;
            current = current.next;
        }
    }

    // remove an item based on its index
    public void remove(int index) {
        Node current = head;
        Node prev = null;

        for (int i = 0; i < index; i++) {
            if (current == null) {
                return;
            }

            prev = current;
            current = current.next; 
        }
        
        if (prev == null) {
            head = current.next;
        } else {
            prev.next = current.next;
        }
    }
   
    // print the list from start to finsih
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // print a linked list backwards using recursion
    public void printBackwards(Node node) {
        if (node != null) {
            printBackwards(node.next);
            System.out.println(node.data);
        }
    }
    
    // helper function to begin printing a linked list backwards
    public void printBackwards() {
        printBackwards(head);
    }

    /**
     * This method returns the number of elements in the list
     *
     * @return an int that represents the size of the list
     */
    public int size() {
        //define a variable for size
        int sz = 0;
        //iterate through the linked list and count the number of elements
        Node current = head;
        while (current != null) {
            sz += 1;
            current = current.next;
        }
        return sz;
    }

    /**
     * This method checks it a given item exist in the list
     *
     * @param item which can be any type and represents the thing being checked for
     * @return hasit a boolean that represents if the item was found. True if found and false
     * otherwise.
     */
    public boolean contains(Type item) {
        //Initialize a boolean on whether the list has it to false. Assume they
        //do not have it
        boolean hasit = false;
        //Go through the nodes in the linked list until you get the item that is
        //being searched for.
        Node curr = head;
        while(curr != null) {
            if(curr.data == item) {
                hasit = true;
                //breaks out of loop if found
                break;
            }
            else {
                curr = curr.next;
            }
        }
        return hasit;
    }

    /**
     * This method gets an item given the index of it
     *
     * @param index an int which represents the position the item is in
     * @return item which is any type that is needed to be returned
     */
    public Type get(int index) {
        //declare variable for the item being returned given index
        Type item;
        //Go through the linked list until you reach index or ith node in the
        // linked list given, then return the data associated with that ith node.
        Node current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        item = current.data;
        return item;
    }
}

