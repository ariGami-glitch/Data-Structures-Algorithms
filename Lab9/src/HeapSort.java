// HeapSort.java
/**
 * Ariana Tran
 * CPSC 340
 * I pledge
 */

import java.util.Random;

class IntHeap {
    private int[] array;
    private int count;

    // start with nothing
    public IntHeap(int size) {
        array = new int[size];
        count = 0;
    }

    // find the left child of a node
    public int left(int node) {
        return 2 * node  + 1;
    }

    // find the right child of a node
    public int right(int node) {
        return 2 * node  + 2; 
    }

    // find the parent of a node
    public int parent(int node) {
        return (node - 1) / 2;
    }

    // insert an item into the heap
    public void insert(int item) {
        // put item in next available slot
        array[count] = item;

        // keep indices into node we inserted and its parent
        int node = count;
        int p = parent(node);

        // increment total number of items
        count++;

        // upheap until it's root, or parent is bigger
        while ((node != 0) && (array[node] < array[p])) {
            // swap values
            int temp = array[node];
            array[node] = array[p];
            array[p] = temp;

            // update indices
            node = p;
            p = parent(node);
        }
    }

    // remove the top item
    public int dequeue() {
        // set aside root
        int retValue = array[0];

        // move last value to the root
        array[0] = array[count - 1];
        count--;

        // find the children
        int node = 0;
        int l = left(node);
        int r = right(node);

        // while one child is bigger than us
        while ((l < count) && (array[l] < array[node]) ||
               (r < count) && (array[r] < array[node])) {

            // find biggest child
            int max;
            if (l < count && r < count) {
                if (array[l] < array[r]) {
                    max = l;
                } else {
                    max = r;
                }
            } else {
                max = l;
            }

            // swap with the biggest child
            int temp = array[node];
            array[node] = array[max];
            array[max] = temp;

            // update indices
            node = max;
            l = left(node);
            r = right(node);
        }
        
        // return orig. root
        return retValue;
    }

    // return the largest item in the heap
    public int max() {
        return array[0];
    }

    public int getCount() {
        return count;
    }

    // print the contents of the array
    public void print() {
        System.out.print("Heap: ");
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.print("\n");
    }
}

// main class does the actual sorting
public class HeapSort {
    public static void heapSort(int[] array) {
        // TODO the heap sort algorithm!
        IntHeap ih = new IntHeap(array.length);
        for(int i = 0; i < array.length; i++) {
            ih.insert(array[i]);
        }
        int i = 0;
        while(ih.getCount() != 0) {
            int temp = ih.dequeue();
            array[i] = temp;
            i++;
        }


    }

    public static void main(String args[]) {
        // get size from first argument
        int size = Integer.parseInt(args[0]);
        long startTime = System.nanoTime();

        // put in random numbers
        int[] nums = new int[size];
        Random rng = new Random();
        for (int i = 0; i < size; i++) {
            nums[i] = rng.nextInt(100);
        }

        /*// print them
        System.out.print("Unsorted numbers: ");
        for (int i = 0; i < size; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("\n");*/

        // sort them
        heapSort(nums);

        /*// print them again
        System.out.print("Sorted numbers: ");
        for (int i = 0; i < size; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("\n");*/

        long endTime = System.nanoTime();
        long elapsedMS = (endTime - startTime) / 1000;
        System.out.println("Sort completed in " + elapsedMS + " milliseconds.");
    }
}

/**
 * Answers to the Questions:
 * 1. How does heapsort compare to bubble sort and merge sort?
 * With N = 1000, heap sort took 4 milliseconds, which is faster than both the
 * bubble sort and optimized bubble sort, but it is still slower than merge sort,
 * which measured to 19 milliseconds. However, when N reaches 200000 elements,
 * both bubble sort and optimized bubble sort time went up exponentially, reaching
 * over 50000 milliseconds, while heapsort was just a little bit under, while
 * merge sort was of course faster, measuring under 50 microseconds.
 *
 * 2. What is the Big-O of heapsort?
 * Insertion and dequeue takes O(log n), but sometimes the root would be pushed
 * to the last node which would take O(log n) time, but since this is repeated
 * until the heap is empty, then you get O(n log n).
 */

