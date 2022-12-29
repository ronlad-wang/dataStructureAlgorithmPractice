public class LinkedList <T> {
    //Singly Linked List implementation with null node at the front

    //Two sentinel nodes, one for the front and one for the back
    public Node firstNode = new Node(null);
    public Node lastNode = firstNode;

    public int size;

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

    public void addFirst(T input) {
        Node restList = firstNode.next;
        firstNode.next = new Node(input, restList);
        if(firstNode == lastNode) {
            lastNode = firstNode.next;
        }
        size += 1;
    }
    public T getFirst() {
        if(firstNode.next != null) {
            return firstNode.next.item;
        }
        return null;
    }
    public void removeFirst() {
        if(size == 0) {
            return;
        }
        size -= 1;
        firstNode.next = firstNode.next.next;
    }
    public void addLast(T input) {
        Node temp = new Node(input);
        lastNode.next = temp;
        lastNode = lastNode.next;
        size += 1;
    }
    public T getLast() {
        return lastNode.item;
    }
    public void removeLast() {
        if(size == 0) {
            return;
        }
        Node temp = firstNode;
        for(int i = 1; i < size; i++) {
            temp = temp.next;
        }
        temp.next = null;
        lastNode = temp;
        size--;
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        if(size == 0) {
            System.out.println("Empty List");
        }
        Node temp = firstNode.next;
        for(int i = 0; i < size; i++) {
            System.out.print(temp.item);
            temp = temp.next;
        }
    }
}
