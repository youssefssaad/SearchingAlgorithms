package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;

public class SLL {
    private SNode head;
    private SNode tail;
    private int size;
    
    public SLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public SLL(SNode node) {
        this.head = node;
        this.tail = node;
        this.size = 1;
    }
    
    public void insertHead(SNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    }
    
    public void insertTail(SNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }
    
    public void insert(SNode node, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        }
        if (position == 0) {
            insertHead(node);
        } else if (position == size) {
            insertTail(node);
        } else {
            SNode curr = head;
            for (int i = 0; i < position - 1; i++) {
                curr = curr.getNext();
            }
            node.setNext(curr.getNext());
            curr.setNext(node);
            size++;
        }
    }
    
    public void sortedInsert(SNode node) {
        if (!isSorted()) {
            sort();
        }
        if (head == null || node.getData() < head.getData()) {
            insertHead(node);
            return;
        }
        SNode current = head;
        while (current.getNext() != null && current.getNext().getData() < node.getData()) {
            current = current.getNext();
        }
        node.setNext(current.getNext());
        current.setNext(node);
        size++;
    }
    
    public SNode search(SNode node) {
        SNode curr = head;
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
            SNode curr = head;
            while (curr.getNext() != tail) {
                curr = curr.getNext();
            }
            curr.setNext(null);
            tail = curr;
        }
        size--;
    }
    
    public void delete(SNode node) {
        if (head == null) {
            return;
        }
        if (head == node) {
            deleteHead();
            return;
        }
        SNode curr = head;
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
        SNode prev = head;
        SNode curr = prev.getNext();
        while (curr != null) {
            SNode innerPrev = null;
            SNode innerCurr = head;
            while (innerCurr != curr) {
                if (innerCurr.getData() > curr.getData()) {
                    // remove curr from its current position
                    prev.setNext(curr.getNext());
                    curr.setNext(null);
    
                    // insert curr at the beginning
                    curr.setNext(head);
                    head = curr;
    
                    // update innerPrev and innerCurr
                    if (innerPrev != null) {
                        innerPrev.setNext(prev.getNext());
                    }
                    innerCurr = curr.getNext();
                    break;
                }
                innerPrev = innerCurr;
                innerCurr = innerCurr.getNext();
            }
            prev = curr;
            curr = curr.getNext();
        }
    }


    public boolean isSorted() {
        if (size < 2) {
            return true;
        }
        SNode prev = head;
        SNode curr = prev.getNext();
        while (curr != null) {
            if (prev.getData() > curr.getData()) {
                return false;
            }
            prev = curr;
            curr = curr.getNext();
        }
        return true;
    }

    public void clear() {
        while (head != null) {
            deleteHead();
        }
    }
    
    
    public void print() {
        SNode curr = head;
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + (isSorted() ? "sorted" : "not sorted"));
        System.out.print("List content: ");
        while (curr != null) {
            System.out.print("The Value of the List Element is:"+curr.getData() + ". \n");
            curr = curr.getNext();
        }
        System.out.println();
    }
    
}
