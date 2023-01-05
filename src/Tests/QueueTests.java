package Tests;

import DataStructures.Queue;

public class QueueTests {
    public static void main(String[] args) {
        Queue<Integer> test = new Queue(1);
        for(int i = 0; i < 10; i++) {
            test.add((int) (Math.random()*10));
            System.out.println(test.peek());
        }

        test.printList();

        for(int i = 0; i < (int) (Math.random() * 10); i++) {
            System.out.println(test.peek());
            System.out.println(test.remove());
        }

        test.printList();
    }
}
