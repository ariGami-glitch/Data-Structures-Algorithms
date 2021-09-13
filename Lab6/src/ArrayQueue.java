// ArrayQueue.java

import java.util.NoSuchElementException;

// a queue based on an array
class Queue {
        private int[] array;
        private int start;
        private int end;
        private int size;

        // constructor
        public Queue(int capacity) {
            array = new int[capacity];
            start = -1;
            end = -1;
            size = 0;
        }

        // enqueue - add at end
        public void enqueue(int number) {
            if(full()) {
                //call resize method
                resize();
            }
            end++;
            if (end == array.length) {
                end = 0;
            }

            array[end] = number;
            size++;
        
            if (start == -1) {
                start = end;
            }
        }

        // dequeue - remove from start
        public int dequeue() {
            //check if the array queue is empty, if so throw an exception
            if(empty()) {
                throw new NoSuchElementException("Empty array queue.");
            }
            int returnVal = array[start];
            start++;
            if (start == array.length) {
                start = 0;
            }

            size--;
            if (size == 0) {
                start = -1;
                end = -1;
            }
            return returnVal;
        }

        // get the size
        public int getSize() {
            return size;
        }

        // return whether or not we're empty
        public boolean empty() {
            return size == 0;
        }

        // return whether or not we're full
        public boolean full() {
            return size == array.length;
        }

    /**
     * This method resizes the array to double the size and copies
     * over the elements from the old array
     *
     * @return an array of integers that represents the new array made
     */
    private void resize() {
        int[] newArray = new int[array.length * 2]; //make the new array but double the size
        int original = start; //keeps track of where we are in the old array, so start
        int now = 0; //keeps track of where we are in the new array
        while(now < array.length) {
            //copy element from original array into newArray
            newArray[now] = array[original];
            //increment now
            now++;
            //increment original
            original++;
            //if original is equal to old size of array, wrap it back to 0
            if(original == array.length) {
                original = 0;
            }
        }
        //set start to 0
        start = 0;
        //set end to now - 1
        end = now - 1;
        //use newArray instead of old array
        array = newArray;
    }
}

public class ArrayQueue {
    public static void main(String args[]) {
        Queue queue = new Queue(5);

        // add some things to the queue (causing wraparound)
        queue.enqueue(99);
        queue.enqueue(99);
        queue.enqueue(99);
        queue.enqueue(99);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(99);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4); // causes resize
        
        // add some more stuff
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(11); // causes resize
        
        // add some more
        queue.enqueue(12);
        queue.enqueue(13);
        queue.enqueue(14);
        queue.enqueue(15);
        queue.enqueue(16);
        queue.enqueue(17);
        queue.enqueue(18);
        
        // print it all out
        while (!queue.empty()) {
            System.out.println(queue.dequeue());
        }
        
        // test the exception
        try {
            queue.dequeue();
        } catch (NoSuchElementException e) {
            System.out.println("Exception thrown correctly!");
        }
    }
}
