package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;
//NOTE - Match with assignment reqs
public class DLL {
    private DNode head;   // reference to the first node in the list
    private DNode tail;   // reference to the last node in the list
    
    // constructor to create an empty list
    public DLL() {
        this.head = null;
        this.tail = null;
    }
    
    // method to check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }
    
    // method to insert a node at the beginning of the list
    public void insertAtBeginning(int data) {
        DNode newNode = new DNode(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
    }
    
    // method to insert a node at the end of the list
    public void insertAtEnd(int data) {
        DNode newNode = new DNode(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }
    
    // method to delete a node with the given data from the list
    public void delete(int data) {
        if (isEmpty()) {
            return;
        }
        if (head.getData() == data) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.getNext();
                head.setPrev(null);
            }
            return;
        }
        if (tail.getData() == data) {
            tail = tail.getPrev();
            tail.setNext(null);
            return;
        }
        DNode current = head.getNext();
        while (current != null && current.getData() != data) {
            current = current.getNext();
        }
        if (current != null) {
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }
    }
    
    // method to print the contents of the list
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty.");
        } else {
            DNode current = head;
            while (current != null) {
                System.out.print(current.getData() + " <-> ");
                current = current.getNext();
            }
            System.out.println("null");
        }
    }
}

