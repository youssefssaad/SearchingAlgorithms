package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;
//NOTE - Match with assignment reqs
public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;
    
    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public SinglyLinkedList(Node node) {
        this.head = node;
        this.tail = node;
        this.size = 1;
    }
    
    public void insertHead(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    }
    
    public void insertTail(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }
    
    public void insert(Node node, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        }
        if (position == 0) {
            insertHead(node);
        } else if (position == size) {
            insertTail(node);
        } else {
            Node curr = head;
            for (int i = 0; i < position - 1; i++) {
                curr = curr.getNext();
            }
            node.setNext(curr.getNext());
            curr.setNext(node);
            size++;
        }
    }
    
    public void sortedInsert(Node node) {
        if (head == null || node.getData() < head.getData()) {
            insertHead(node);
            return;
        }
        Node curr = head;
        while (curr.getNext() != null && curr.getNext().getData() < node.getData()) {
            curr = curr.getNext();
        }
        node.setNext(curr.getNext());
        curr.setNext(node);
        size++;
    }
    
    public Node search(Node node) {
        Node curr = head;
        while (curr != null && curr.getData() != node.getData()) {
            curr = curr.getNext();
        }
        return curr;
    }
    
    public void deleteHead() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
        }
        size--;
    }
    
    public void deleteTail() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node curr = head;
            while (curr.getNext() != tail) {
                curr = curr.getNext();
            }
            curr.setNext(null);
            tail = curr;
        }
        size--;
    }
    
    public void delete(Node node) {
        if (head == null) {
            return;
        }
        if (head == node) {
            deleteHead();
            return;
        }
        Node curr = head;
        while (curr.getNext() != null && curr.getNext() != node) {
            curr = curr.getNext();
        }
        if (curr.getNext() == null) {
            return;
        }
        curr.setNext(curr.getNext().getNext());
        if (curr.getNext() == null) {
            tail = curr;
        }
        size--;
    }
    
    public void sort() {
        if (size < 2) {
            return; // list is already sorted
        }
        Node prev = head;
        Node curr = prev.next;
        while (curr != null) {
            Node innerPrev = null;
            Node innerCurr = head;
            while (innerCurr != curr) {
                if (innerCurr.value > curr.value) {
                    // remove curr from its current position
                    prev.next = curr.next;
                    curr.next = null;
    
                    // insert curr at the beginning
                    curr.next = head;
                    head = curr;
    
                    // update innerPrev and innerCurr
                    if (innerPrev != null) {
                        innerPrev.next = prev.next;
                    }
                    innerCurr = curr.next;
                    break;
                }
                innerPrev = innerCurr;
                innerCurr = innerCurr.next;
            }
            prev = curr;
            curr = curr.next;
        }
    }


    private boolean isSorted() {
        if (size < 2) {
            return true;
        }
        Node prev = head;
        Node curr = prev.next;
        while (curr != null) {
            if (prev.value > curr.value) {
                return false;
            }
            prev = curr;
            curr = curr.next;
        }
        return true;
    }

    public void clear() {
        while (head != null) {
            deleteHead();
        }
    }
    
    
    public void print() {
        Node curr = head;
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + (isSorted() ? "sorted" : "not sorted"));
        System.out.print("List content: ");
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}
