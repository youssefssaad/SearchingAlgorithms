package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;
//NOTE - Match with assignment reqs
public class DLL {
    private DNode head;
    private DNode tail;
    private int size;

    // Constructor with no arguments
    public DLL() {
        head = null;
        tail = null;
        size = 0;
    }

    // Constructor with node argument to use as head
    public DLL(DNode headNode) {
        head = headNode;
        tail = headNode;
        size = 1;
    }

    // Inserts node at the head of the list
    public void insertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
        size++;
    }

    // Inserts node at the tail of the list
    public void insertTail(DNode node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    // Inserts node at the specified position in the list
    public void insert(DNode node, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        }
        if (position == 0) {
            insertHead(node);
        } else if (position == size) {
            insertTail(node);
        } else {
            DNode current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            node.setPrev(current);
            node.setNext(current.getNext());
            current.getNext().setPrev(node);
            current.setNext(node);
            size++;
        }
    }

    // Inserts node in its proper position in a sorted list
    public void sortedInsert(DNode node) {
        if (!isSorted()) {
            sort();
        }
        if (head == null || node.getData() <= head.getData()) {
            insertHead(node);
        } else if (node.getData() >= tail.getData()) {
            insertTail(node);
        } else {
            DNode current = head.getNext();
            while (current != null && node.getData() > current.getData()) {
                current = current.getNext();
            }
            node.setPrev(current.getPrev());
            node.setNext(current);
            current.getPrev().setNext(node);
            current.setPrev(node);
            size++;
        }
    }

    // Looks up node in the list, returns the node if found, otherwise null
    public DNode search(DNode node) {
        DNode current = head;
        while (current != null) {
            if (current.getData() == node.getData()) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    // Deletes the head node
    public void deleteHead() {
        if (head == null) {
            return;
        }
        head = head.getNext();
        if (head == null) {
            tail = null;
        } else {
            head.setPrev(null);
        }
        size--;
    }

    // Deletes the tail node
    public void deleteTail() {
        if (tail == null) {
            return;
        }
        tail = tail.getPrev();
        if (tail == null) {
            head = null;
        } else {
            tail.setNext(null);
        }
        size--;
    }

    public void delete(DNode node) {
        if (node == null || head == null) {
            return;
        }
    
        // Node is the head node
        if (node == head) {
            head = node.getNext();
            if (head != null) {
                head.setPrev(null);
            }
            size--;
            return;
        }
    
        // Node is the tail node
        if (node == tail) {
            tail = node.getPrev();
            if (tail != null) {
                tail.setNext(null);
            }
            size--;
            return;
        }
    
        // Node is neither head nor tail
        DNode prev = node.getPrev();
        DNode next = node.getNext();
        if (prev != null) {
            prev.setNext(next);
        }
        if (next != null) {
            next.setPrev(prev);
        }
        size--;
    }

    public void sort() {
        if (head == null) {
            return;
        }
    
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            DNode current = head;
            while (current.getNext() != null) {
                if (current.getData() > current.getNext().getData()) {
                    // Swap the two nodes
                    DNode temp = current.getNext();
                    current.setNext(temp.getNext());
                    if (temp.getNext() != null) {
                        temp.getNext().setPrev(current);
                    }
                    temp.setPrev(current.getPrev());
                    temp.setNext(current);
                    if (current.getPrev() != null) {
                        current.getPrev().setNext(temp);
                    } else {
                        head = temp;
                    }
                    current.setPrev(temp);
                    swapped = true;
                } else {
                    current = current.getNext();
                }
            }
        }
    }

    public boolean isSorted() {
        if (head == null || head.getNext() == null) {
            return true;
        }
        DNode current = head;
        while (current.getNext() != null) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    public void clear() {
        if (head == null) {
            return;
        }
        DNode current = head;
        while (current != null) {
            DNode next = current.getNext();
            current.setPrev(null);
            current.setNext(null);
            current = next;
        }
        head = null;
        tail = null;
        size = 0;
    }

    public void print() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.print("The list contains " + size + " element(s): ");
        DNode current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}    

