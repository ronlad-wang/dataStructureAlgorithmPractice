package Tests;


import DataStructures.LinkedList;


public class LinkedListTests {
    public static void main(String args[]) {
        LinkedList<Integer> test = new LinkedList<>();
        for(int i = 0; i < 5; i++) {
            test.addFirst(i);
        }
        test.printList();
        for(int i = 0; i < 5; i++) {
            assert test.getFirst() == 4 - i;
            test.removeFirst();
        }
        test.printList();

        test = new LinkedList<>();
        for(int i = 0; i < 5; i++) {
            test.addLast(i);
        }
        test.printList();
        for(int i = 0; i < 5; i++) {
            assert test.getLast() == 4-i;
            test.removeLast();
        }
        test.printList();

        test = new LinkedList<>();
        for(int i = 0; i < 10; i++) {
            if(i % 2 == 0) {
                test.addLast(i);
            }
            else {
                test.addFirst(i);
            }
        }
        test.printList();
    }
}
