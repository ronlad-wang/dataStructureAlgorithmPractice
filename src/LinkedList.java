public class LinkedList <T> {
    //Singly Linked List implementation with null node at the front
    public Node firstNode = new Node(null);

    public class Node {
        //Subclass Node contains an item and a next object
        public T item;
        public Node next;

        public Node(T input) {
            item = input;
        }

        public Node(T input, Node n) {
            item = input;
            next = n;
        }
    }

    public LinkedList() {}
    public LinkedList(T input) {
        firstNode.next = new Node(input);
    }

    public void addNext(T input) {
        Node restList = firstNode.next;
        firstNode.next = new Node(input, restList);
    }
}
