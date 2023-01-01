package Tests;

import DataStructures.RArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        RArrayList<Integer> test = new RArrayList<>();
        test.printList();

        for(int i = 0; i < 5; i++) {
            test.add(i);
        }
        test.printList();

        for(int j = 0; j < 10; j++) {
            test.add(j);
        }
        test.printList();
        System.out.println(test.array.length);
    }
}
