package DataStructures;

public class DLLists<T> {
    /*
    Another way to implement linked lists where each node connects to both the next and previous
    nodes, which enables us to remove the last node in constant time
     */

    public int size;

    //two sentinel nodes, one for the front and one for the end
    public Node firstNode = new Node(null);
    public Node lastNode = new Node(null, firstNode, null);

    public class Node {
        //note the prev Node, which allows us to connect backwards from the ending sentinel node
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
            //key difference with SLList is we also need to update the .prev for next Node
            firstNode.next.next.prev = firstNode;
            firstNode.next = firstNode.next.next;
            size--;
        }
    }
    public void addFirst(T input) {
        Node temp = new Node(firstNode.next, firstNode, input);
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

    public void printList() {
        if(size == 0) {
            System.out.println("Empty List");
        }
        Node temp = firstNode.next;
        for(int i = 0; i < size; i++) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.print("\n");
    }
}
