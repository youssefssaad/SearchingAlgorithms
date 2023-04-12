package mylib.datastructures.linear;


import mylib.datastructures.nodes.SNode;

public class CSLL extends SLL {
    private SNode head;
    private SNode tail;
    private int size;

    /**
     * Default constructor
     */
    public CSLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Constructor with a node
     * @param node
     */
    public CSLL(SNode node) {
        this.head = node;
        this.head.setNext(head);
        this.tail = node;
        this.size = 1;
    }

    /**
     * inserts a head node
     * @param node
     */
    @Override
    public void insertHead(SNode node) {
        if (isEmpty()) {
            head = node;
            head.setNext(head);
        } else {
            node.setNext(head);
            SNode current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(node);
            head = node;
        }
        size++;
    }

    /**
     * inserts a tail node
     * @param node
     */
    @Override
    public void insertTail(SNode node) {
        if (isEmpty()) {
            head = node;
            head.setNext(head);
        } else {
            SNode current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(node);
            node.setNext(head);
        }
        size++;
    }

    /**
     * inserts a node at a given position
     * @param node
     * @param position
     */
    @Override
    public void insert(SNode node, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 0) {
            insertHead(node);
        } else if (position == size) {
            insertTail(node);
        } else {
            SNode current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    /**
     * inserts a node into a sorted position
     * @param node
     */
    @Override
    public void sortedInsert(SNode node) {
        if (isEmpty()) {
            insertHead(node);
        } else if (node.getData() <= head.getData()) {
            insertHead(node);
        } else {
            SNode current = head;
            while (current.getNext() != head && current.getNext().getData() < node.getData()) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    /**
     * searches for a node
     * @param node
     * @return node
     */
    @Override
    public SNode search(SNode node) {
        SNode current = head;
        do {
            if (current == node) {
                return current;
            }
            current = current.getNext();
        } while (current != head);
        return null;
    }

    /**
     * deletes a head node
     */
    @Override
    public void deleteHead() {
        if (isEmpty()) {
            System.out.println("List is empty!");
        } else {
            SNode current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(head.getNext());
            head = head.getNext();
            size--;
        }
    }

    /**
     * deletes a tail node
     */
    @Override
    public void deleteTail() {
        if (isEmpty()) {
            System.out.println("List is empty!");
        } else if (head.getNext() == head) {
            head = null;
            size--;
        } else {
            SNode current = head;
            while (current.getNext().getNext() != head) {
                current = current.getNext();
            }
            current.setNext(head);
            size--;
        }
    }

    /**
     * deletes a node at a given position
     * @param position
     */
    @Override
    public void delete(SNode node) {
        if (isEmpty()) {
            System.out.println("List is empty. Deletion failed.");
            return;
        }
    
        if (head == node) {
            head = node.getNext();
            tail.setNext(head);
            size--;
            return;
        }
    
        SNode current = head;
        while (current.getNext() != head) {
            if (current.getNext() == node) {
                current.setNext(node.getNext());
                size--;
                return;
            }
            current = current.getNext();
        }
    
        if (tail == node) {
            tail = current;
            tail.setNext(head);
            size--;
            return;
        }
    
        System.out.println("Node not found. Deletion failed.");
    }
    
    /**
     * sorts the list
     * @param node
     */
    @Override
    public void sort() {
        if (isEmpty()) {
            System.out.println("List is empty. Sort failed.");
            return;
        }
    
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            SNode current = head;
            while (current.getNext() != head) {
                if (current.getData() > current.getNext().getData()) {
                    int temp = current.getData();
                    current.setData(current.getNext().getData());
                    current.getNext().setData(temp);
                    swapped = true;
                }
                current = current.getNext();
            }
        }
    }
    
    /**
     * checks if the list is sorted
     * @return boolean
     */
    @Override
    public boolean isSorted() {
        if (isEmpty() || head == tail) {
            return true;
        }
    
        SNode current = head;
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
        SNode current = head;
        do {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        } while (current != head);
        System.out.println("\nList Length: " + size);
        System.out.println("Sorted Status: " + isSorted());
    }

    public boolean isEmpty() {
        return head == null;
    }
}
/*
import org.junit.Test;
import static org.junit.Assert.*;

public class CSLLTest {

    @Test
    public void testInsertHead() {
        CSLL list = new CSLL();
        SNode node = new SNode(1);
        list.insertHead(node);
        assertEquals(list.search(node), node);
    }

    @Test
    public void testInsertTail() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        assertEquals(list.search(node3), node3);
    }

    @Test
    public void testInsert() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insert(node1, 0);
        list.insert(node2, 1);
        list.insert(node3, 1);
        assertEquals(list.search(node3), node3);
    }

    @Test
    public void testSortedInsert() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.sortedInsert(node2);
        list.sortedInsert(node1);
        list.sortedInsert(node3);
        assertEquals(list.search(node3), node3);
    }

    @Test
    public void testDeleteHead() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.deleteHead();
        assertEquals(list.search(node1), null);
    }

    @Test
    public void testDeleteTail() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.deleteTail();
        assertEquals(list.search(node3), null);
    }

    @Test
    public void testDelete() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.delete(node2);
        assertEquals(list.search(node2), null);
    }

    @Test
    public void testSort() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(3);
        SNode node2 = new SNode(1);
        SNode node3 = new SNode(2);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.sort();
        assertTrue(list.isSorted());
    }
}

 */    
       


