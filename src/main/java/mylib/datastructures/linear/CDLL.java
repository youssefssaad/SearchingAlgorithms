package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class CDLL extends DLL {
    private DNode head;
    private DNode tail;
    private int size;

    /**
     * Default constructor
     */
    public CDLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    /**
     * Constructor with a node
     * @param node
     */
    public CDLL(DNode node) {
        this.head = node;
        head.setNext(head);
        this.tail = node;
        this.size = 1;
    }
    
    /**
     * Returns the size of the list
     * @return size
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * inserts a head node
     * @param node
     */
    @Override
    public void insertHead(DNode node) {
        if (isEmpty()) {
            tail = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
        }
        head = node;
        tail.setNext(head);
        head.setPrev(tail);
        size++;
    }
    
    /**
     * inserts a tail node
     * @param node
     */
    @Override
    public void insertTail(DNode node) {
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        tail.setNext(head);
        head.setPrev(tail);
        size++;
    }
    
    /**
     * inserts a node at a given position
     * @param node
     * @param position
     */
    @Override
    public void insert(DNode node, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
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
            node.setNext(current.getNext());
            node.setPrev(current);
            current.getNext().setPrev(node);
            current.setNext(node);
            size++;
        }
    }
    
    /**
     * deletes the head node
     */
    @Override
    public void deleteHead() {
        if (isEmpty()) {
            System.out.println("List is empty");
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrev(tail);
            tail.setNext(head);
        }
        size--;
    }
    
    /**
     * deletes the tail node
     */
    @Override
    public void deleteTail() {
        if (isEmpty()) {
            System.out.println("List is empty");
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(head);
            head.setPrev(tail);
        }
        size--;
    }
    
    /**
     * deletes a node at a given position
     * @param position
     */
    @Override
    public void delete(DNode node) {
        if (isEmpty()) {
            System.out.println("List is empty");
        }
        if (node == head) {
            deleteHead();
        } else if (node == tail) {
            deleteTail();
        } else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            size--;
        }
    }
    
    /**
     * deletes a node at a given position
     * @param position
     */
    @Override
    public void sort() {
        if (isEmpty() || isSorted()) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            DNode current = head;
            do {
                if (current.getData() > current.getNext().getData()) {
                    swap(current, current.getNext());
                    swapped = true;
                }
                current = current.getNext();
            } while (current != head);
        } while (swapped);
    }

    public void swap(DNode node1, DNode node2) {
        if (node1 == node2) {
            return;
        }
        DNode temp;
        if (node1.getNext() == node2) {
            temp = node1.getPrev();
            node1.setPrev(node2);
            node2.setNext(node1);
            node2.setPrev(temp);
            temp.setNext(node2);
            temp = node1.getNext();
            node1.setNext(node2.getNext());
            node1.getNext().setPrev(node1); //might be error
            node2.setNext(temp);
            temp.setPrev(node2);
        } else if (node2.getNext() == node1) {
            temp = node2.getPrev();
            node2.setPrev(node1);
            node1.setNext(node2);
            node1.setPrev(temp);
            temp.setNext(node1);
            temp = node2.getNext();
            node2.setNext(node1.getNext());
            node2.getNext().setPrev(node2); //possible error
            node1.setNext(temp);
            temp.setPrev(node1);
        } else {
            temp = node1.getPrev();
            node1.setPrev(node2.getPrev());
            node1.getPrev().setNext(node1);
            node2.setPrev(temp);
            node2.getPrev().setNext(node2);
            temp = node1.getNext();
            node1.setNext(node2.getNext());
            node1.getNext().setPrev(node1);
            node2.setNext(temp);
            node2.getNext().setPrev(node2);
        }
    }
    
    /**
     * checks if the list is sorted
     * @return true if sorted, false if not
     */
    @Override
    public boolean isSorted() {
        if (isEmpty() || head == tail) {
            return true;
        }
    
        DNode current = head;
        while (current.getNext() != head) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    /**
     * prints the list
     */
    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
    
        System.out.print("List: ");
        DNode current = head;
        do {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        } while (current != head);
        System.out.println("\nList Length: " + size);
        System.out.println("Sorted Status: " + isSorted());
    }

    /**
     * returns the size of the list
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     *  gets the head node
     * @return head
     */
    public DNode getHead() {
        return head;
    }

    /**
     * gets the tail node
     * @return tail
     */
    public DNode getTail() {
        return tail;
    }
}

/* package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class CDLLTest {

    @Test
    public void testInsertionAndDeletion() {
        CDLL cdll = new CDLL();

        assertTrue(cdll.isEmpty());

        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        cdll.insertHead(node1);
        cdll.insertTail(node3);
        cdll.insert(node2, 1);

        assertFalse(cdll.isEmpty());
        assertEquals(3, cdll.size());

        cdll.delete(node1);

        assertEquals(node2, cdll.head);
        assertEquals(node3, cdll.tail);
        assertEquals(2, cdll.size());

        cdll.deleteHead();

        assertEquals(node2, cdll.head);
        assertEquals(1, cdll.size());

        cdll.deleteTail();

        assertTrue(cdll.isEmpty());
    }

    @Test
    public void testSorting() {
        CDLL cdll = new CDLL();

        DNode node1 = new DNode(5);
        DNode node2 = new DNode(1);
        DNode node3 = new DNode(3);

        cdll.insertHead(node1);
        cdll.insertTail(node2);
        cdll.insert(node3, 1);

        assertFalse(cdll.isSorted());

        cdll.sort();

        assertTrue(cdll.isSorted());
        assertEquals(node2, cdll.head);
        assertEquals(node1, cdll.tail);
    }
}
*/

