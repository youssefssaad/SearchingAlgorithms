package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;

public class SLL {
    private SNode head;   // reference to the first node in the list
    private int size;     // number of nodes in the list

    
    // constructor to create an empty list
    public SLL() {
        this.head = null;
    }

    public SLL(SNode head) {
        this.head = head;
    }
    
    // method to check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }
    
    // method to insert a node at the beginning of the list
    public void insertAtBeginning(int data) {
        SNode newNode = new SNode(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }
    
    // method to insert a node at the end of the list
    public void insertTail(int data) {
        SNode newNode = new SNode(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            SNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }
    
    // method to delete a node with the given data from the list
    public void delete(int data) {
        if (isEmpty()) {
            return;
        }
        if (head.getData() == data) {
            head = head.getNext();
            return;
        }
        SNode current = head;
        while (current.getNext() != null && current.getNext().getData() != data) {
            current = current.getNext();
        }
        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        }
    }
    
    // method to print the contents of the list
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty.");
        } else {
            SNode current = head;
            while (current != null) {
                System.out.print(current.getData() + " -> ");
                current = current.getNext();
            }
            System.out.println("null");
        }
    }
}
