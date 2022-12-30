package DataStructures;

public class DLLists<T> {
    public int size;
    public Node firstNode = new Node(null);
    public Node lastNode = new Node(null, firstNode, null);
    public class Node {
        public T item;
        public Node next;
        public Node prev;

        public Node() {}
        public Node(T i) {
            item = i;
        }
        public Node(Node n, Node p, T i) {
            item = i;
            next = n;
            prev = p;
        }
    }

    public DLLists() {
        firstNode.next = lastNode;
    }

    public T getFirst() {
        return firstNode.next.item;
    }
    public void removeFirst() {
        if(size != 0) {
            firstNode.next.next.prev = firstNode;
            firstNode.next = firstNode.next.next;
            size--;
        }
    }
    public void addFirst(T input) {
        Node temp = new Node(firstNode.next.next, firstNode, input);
        firstNode.next.prev = temp;
        firstNode.next = temp;
        size++;
    }
    public T getLast() {
        return lastNode.prev.item;
    }
    public void removeLast() {
        if(size != 0) {
            lastNode.prev.prev.next = lastNode;
            lastNode.prev = lastNode.prev.prev;
            size--;
        }
    }
    public void addLast(T input) {
        Node temp = new Node(lastNode, lastNode.prev, input);
        lastNode.prev.next = temp;
        lastNode.prev = temp;
        size++;
    }
    public int getSize() {
        return size;
    }
}
