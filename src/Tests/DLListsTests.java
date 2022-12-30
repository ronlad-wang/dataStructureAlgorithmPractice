package Tests;
import DataStructures.DLLists;
import DataStructures.LinkedList;

public class DLListsTests {
    public static void main(String args[]) {
        DLLists<Integer> test = new DLLists<>();
        for(int i = 0; i < 5; i++) {
            test.addFirst(i);
        }
        assert test.getSize() == 5;
        test.printList();
        for(int i = 0; i < 3; i++) {
            test.removeFirst();
        }
        assert test.getSize() == 2;
        test.printList();



        test = new DLLists<>();
        for(int i = 0; i < 5; i++) {
            test.addLast(i);
        }
        assert test.getSize() == 5;
        test.printList();
        for(int i = 0; i < 3; i++) {
            test.removeLast();
        }
        assert test.getSize() == 2;
        test.printList();

        test = new DLLists<>();
        for(int i = 0; i < 20; i++) {
            if(i % 2 == 0) {
                test.addFirst(i);
            }
            else {
                test.addLast(i);
            }
        }
        test.printList();
        for(int i = 0; i < 10; i++) {
            if(i % 2 == 0) {
                test.removeLast();
            }
            else {
                test.removeFirst();
            }
        }
        test.printList();

        LinkedList<String> stringTest = new LinkedList<>();
        for(int i = 0; i < 5; i++) {
            stringTest.addFirst("hello " + i);
        }
        stringTest.printList();
    }
}
