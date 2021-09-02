// DynamicList.java
// a partial implementation of ArrayList

public class DynamicList<Type> {
    private Type [] array;
    private int size;

    private void resize() {
        @SuppressWarnings("unchecked")
        Type [] temp = (Type[]) new Object[size * 2];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    /** 
     * constructs a DynamicList with an initial capacity of 10
     */
    public DynamicList() {
        @SuppressWarnings("unchecked")
        Type[] genericArray = (Type[]) new Object[10];
        array = genericArray;
        size = 0;
    }

    /**
     * constructs a DynamicList with the given initial capacity
     * @param capacity the starting capacity of the list
     */
    public DynamicList(int capacity) {
        @SuppressWarnings("unchecked")
        Type[] genericArray = (Type[]) new Object[capacity];
        array = genericArray;
        size = 0;
    }

    /**
     * adds a new item to the end of the list
     * @param item the item to be added
     */
    public void add(Type item) {
        if (size == array.length) {
            resize();
        }

        array[size] = item;
        size++;
    }
    
    /**
     * adds an element to a given position of the list
     * @param index the location the item is to be inserted at
     * @param item the object being inserted into the list
     */
    public void add(int index, Type item) {
       if (size == array.length) {
           resize();
       } 
       
       for (int i = size-1; i >= index; i--) {
            array[i + 1] = array[i];
       }

        array[index] = item;
        size++;
    }
    
    /**
     * removes an item from the list by position
     * @param index the index of the item to be removed
     */
    public void remove(int index) {
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }

        size--; 
    }
   
    /**
     * removes the first occurence of item from the list
     * @param item the value to be removed
     */
    public void remove(Type item) {
        int index = indexOf(item);
        if (index != -1) {
            remove(index);
        }
    }
   
    /**
     * searches the list for an item
     * @param target the item to search for
     * @return the index of the first item in the list equal to target, or -1 if not found
     */ 
    public int indexOf(Type target) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * returns an item from the list by position
     * @param index the location of the item to return
     * @return the item stored at that index
     * @throws IndexOutOfBoundsException when the index is not valid
     */
    public Type get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
           throw new IndexOutOfBoundsException();
        } 

        return array[index];
    }

    /**
     * resets the list back to an empty one
     */
    public void clear() {
        size = 0;
    }

    /** 
     * gets the number of elements stored in the list
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * This method changes an item in the list given an index and item
     * @param index an int which represent the position the item will be added
     * @param item any Type that will be added to the position given by the index
     * @throws IndexOutOfBoundsException if the given index is not in the array
     */
    public void set(int index, Type item) throws IndexOutOfBoundsException {
        //This checks if the index is valid
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        //if the index is valid, then change the item in the list
        else {
            array[index] = item;
        }
    }

    /**
     * This method searches the array for the last instance of a given item. If it
     * is not found, it will return -1.
     * @param item a Type that is being searched for
     * @return an int that represents the index at which the item was found
     */
    public int lastIndexOf(Type item) {
        //this sets the last index
        int index = size - 1;
        //this sets the index of the item to -1 in case it is not found
        int indexOfItem = -1;
        //this searches for the item
        while(index >= 0) {
            //if the item is found, the index of the item is changed from a -1 to the
            //current index in the loop and breaks the loop.
            if(array[index] == item) {
                indexOfItem = index;
                break;
            }
            //this decreases the current index so that we can work from the end of the array to
            //the front
            index--;
        }
        return index;
    }

    /**
     * This method resizes the array so that it is exactly large enough to hold the
     * items.
     */
    public void trimToSize() {
        //for testing purposes, the current size of the array is printed
        System.out.println("Size = " + size);
        //now to resize it
        //this creates a new empty array
        Type [] temp = (Type[]) new Object[size];
        //this goes through the current array and copy the items from it into the temporary
        //array created above.
        for(int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        //after copying the array, put the current array equal to the temp created
        array = temp;
        //for testing purposes, the capacity after the resize is printed
        System.out.println("Capacity = " + array.length);
    }
} 

