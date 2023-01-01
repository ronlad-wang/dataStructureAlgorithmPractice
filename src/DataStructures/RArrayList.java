package DataStructures;

import java.lang.reflect.Array;

public class RArrayList<T> {

    //this variable keeps track of the number of items currently stored in the array
    //it is also used to check if the array is at capacity and for what index to store items in
    public int numItems = 0;

    //how large we want the new array to be set to after we resize
    //traditionally this is set to 2 to ensure an amortized runtime of O(1) for insertion
    public double resizeFactor = 1.3;
    public Object[] array;

    public RArrayList() {
        array = (T[]) new Object[10];
    }
    public RArrayList(int size) {
        array = (T[]) new Object[size];
    }

    public void add(T item) {
        if(numItems == array.length) {
            //if we are at capacity we need to resize
            resize();
        }
        array[numItems] = item;
        numItems++;
    }

    public void resize() {
        Object[] tempArray = (T[]) new Object[(int)Math.floor(numItems * resizeFactor)];
        for(int i = 0; i < numItems; i++) {
            tempArray[i] = array[i];
        }
        array = tempArray;
    }

    public Object get(int index) {
        if(index < 0 || index >= numItems) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public void printList() {
        for(int i = 0; i < numItems; i++) {
            System.out.print(array[i] +" ");
        }
    }
}
