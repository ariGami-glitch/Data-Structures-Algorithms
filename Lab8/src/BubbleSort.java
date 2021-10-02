// BubbleSort.java

import java.util.Random;

public class BubbleSort {
    private static int SIZE = 25;

    public static void bubbleSort(int[] array) {
        boolean changed = true;

        while (changed) {
            changed = false;
            int change = 2;
            for (int i = 0; i <= array.length - change; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    changed = true;
                }
                change += 1;

            }
        }
    }

    public static void main(String args[]) {
        // put in random numbers
        String n = args[0];
        int size = Integer.valueOf(n);
        int[] nums = new int[size];
        Random rng = new Random();
        for (int i = 0; i < size; i++) {
            nums[i] = rng.nextInt(100);
        }

        /*// print them
        System.out.print("Unsorted numbers: ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("\n");*/

        // sort them
        long startTIme = System.nanoTime();
        bubbleSort(nums);
        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTIme) / 1000;
        System.out.println("Elapsed time = " + elapsedTime + " microseconds.");

        /*// print them again
        System.out.println("Sorted numbers: ");
        for (int i = 0; i < size; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("\n");*/
    }
}

