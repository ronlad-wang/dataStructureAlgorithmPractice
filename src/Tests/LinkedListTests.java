package Tests;



import DataStructures.LinkedList;


public class LinkedListTests {
    public static void main(String args[]) {
        LinkedList<Integer> test = new LinkedList<>();
        for(int i = 0; i < 5; i++) {
            test.addFirst(i);
        }
        assert test.getSize() == 5;
        test.printList();
        for(int i = 0; i < 3; i++) {
            assert test.getFirst() == 4 - i;
            test.removeFirst();
        }
        assert test.getSize() == 2;
        test.printList();

        test = new LinkedList<>();
        for(int i = 0; i < 5; i++) {
            test.addLast(i);
        }
        assert test.getSize() == 5;
        test.printList();
        for(int i = 0; i < 3; i++) {
            assert test.getLast() == 4-i;
            test.removeLast();
        }
        assert test.getSize() == 2;
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
        assert test.getSize() == 10 : "fail";
        test.printList();
    }
}
