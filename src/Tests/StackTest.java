package Tests;

import DataStructures.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> test = new Stack(1);
        for(int i = 0; i < 6; i++) {
            test.push((int) (Math.random() * 10));
        }

        test.printStack();

        System.out.println(test.peek());
        System.out.println(test.pop());
        System.out.println(test.peek());
        System.out.println(test.pop());
        test.printStack();
    }
}
