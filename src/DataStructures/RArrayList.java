package DataStructures;

import java.lang.reflect.Array;

public class RArrayList<T> {
    public int numItems = 0;
    public double resizeFactor = 2;
    public Object[] array;

    public RArrayList() {
        array = (T[]) new Object[10];
    }
    public RArrayList(int size) {
        array = (T[]) new Object[size];
    }

    public void add(T item) {
        if(numItems == array.length) {
            resize();
        }
        array[numItems] = item;
        numItems++;
    }

    public void resize() {
        Object[] tempArray = (T[]) new Object[numItems * 2];
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
}
