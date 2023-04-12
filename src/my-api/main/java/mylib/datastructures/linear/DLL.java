package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;
//NOTE - Match with assignment reqs
public class DLL {
    private DNode head;
    private DNode tail;
    private int size;

    /**
     * Default constructor
     */
    public DLL() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Constructor with a node
     * @param headNode
     */
    public DLL(DNode headNode) {
        head = headNode;
        tail = headNode;
        size = 1;
    }

    /**
     * inserts a head node
     */
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

    /**
     * inserts a tail node
     */
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

    /**
     * inserts a node at a given position
     * @param node
     * @param position
     */
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

    /**
     * inserts the node in a sorted manner
     * @param node
     */
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

    /**
     * searches the list
     * @param node
     */
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

    /**
     * deletes the head node
     */
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

    
    /**
     * deletes the tail node
     */
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

    /**
     * deletes a given node 
     * @param node
     */
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

    /**
     *  sort the list
     */
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

    /**
     * checks if the list is sorted
     * @return true if sorted, false otherwise
     */
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

    /** 
     * removes all elements from the list
     */
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

    /**
     * prints the list
     */
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

    /**
     * @return the head
     */
    public DNode getHead() {
        return head;
    }

    /**
     * @return the tail
     */
    public DNode getTail() {
        return tail;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }
}  

/*package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DLLTest {

    @Test
    public void testInsertHead() {
        DLL list = new DLL();
        list.insertHead(new DNode(3));
        assertEquals(1, list.getSize());
        assertEquals(3, list.getHead().getData());
        assertEquals(3, list.getTail().getData());

        list.insertHead(new DNode(2));
        assertEquals(2, list.getSize());
        assertEquals(2, list.getHead().getData());
        assertEquals(3, list.getTail().getData());

        list.insertHead(new DNode(1));
        assertEquals(3, list.getSize());
        assertEquals(1, list.getHead().getData());
        assertEquals(3, list.getTail().getData());
    }

    @Test
    public void testInsertTail() {
        DLL list = new DLL();
        list.insertTail(new DNode(1));
        assertEquals(1, list.getSize());
        assertEquals(1, list.getHead().getData());
        assertEquals(1, list.getTail().getData());

        list.insertTail(new DNode(2));
        assertEquals(2, list.getSize());
        assertEquals(1, list.getHead().getData());
        assertEquals(2, list.getTail().getData());

        list.insertTail(new DNode(3));
        assertEquals(3, list.getSize());
        assertEquals(1, list.getHead().getData());
        assertEquals(3, list.getTail().getData());
    }

    @Test
    public void testInsert() {
        DLL list = new DLL();
        list.insert(new DNode(1), 0);
        assertEquals(1, list.getSize());
        assertEquals(1, list.getHead().getData());
        assertEquals(1, list.getTail().getData());

        list.insert(new DNode(3), 1);
        assertEquals(2, list.getSize());
        assertEquals(1, list.getHead().getData());
        assertEquals(3, list.getTail().getData());

        list.insert(new DNode(2), 1);
        assertEquals(3, list.getSize());
        assertEquals(1, list.getHead().getData());
        assertEquals(3, list.getTail().getData());
        assertEquals(2, list.getHead().getNext().getData());

        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(new DNode(4), 4));
    }

    @Test
    public void testSortedInsert() {
        DLL list = new DLL();
        list.sortedInsert(new DNode(3));
        assertEquals(1, list.getSize());
        assertEquals(3, list.getHead().getData());
        assertEquals(3, list.getTail().getData());

        list.sortedInsert(new DNode(1));
        assertEquals(2, list.getSize());
        assertEquals(1, list.getHead().getData());
        assertEquals(3, list.getTail().getData());

        list.sortedInsert(new DNode(2));
        assertEquals(3, list.getSize());
        assertEquals(1, list.getHead().getData());
        assertEquals(3, list.getTail().getData());
        assertEquals(2, list.getHead().getNext().getData());

        list.sortedInsert(new DNode(4));
        assertEquals(4, list.getSize());
        assertEquals(1, list.getHead().getData());
        assertEquals(4, list.getTail().getData());
        assertEquals(3, list.getTail().getPrev().getData());
    }

    @Test
    public void testSearch() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        dll.insertHead(node1);
        dll.insertTail(node2);
        dll.insertTail(node3);
        assertEquals(node2, dll.search(new DNode(2)));
        assertNull(dll.search(new DNode(4)));
    }

     @Test
    public void testDeleteHead() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        dll.insertHead(node1);
        dll.insertTail(node2);
        dll.deleteHead();
        assertEquals(1, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node2, dll.getTail());
    }
    
    @Test
    public void testDeleteTail() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        dll.insertHead(node1);
        dll.insertTail(node2);
        dll.deleteTail();
        assertEquals(1, dll.getSize());
        assertEquals(node1, dll.getHead());
        assertEquals(node1, dll.getTail());
    }

    @Test
    public void testDelete() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        dll.insertHead(node1);
        dll.insertTail(node2);
        dll.insertTail(node3);
        dll.delete(1);
        assertEquals(2, dll.getSize());
        assertEquals(node1, dll.getHead());
        assertEquals(node3, dll.getTail());
        assertEquals(node3, dll.getHead().getNext());
    }

    @Test
    public void testIsSorted() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        dll.insertHead(node1);
        dll.insertTail(node2);
        dll.insertTail(node3);
        assertTrue(dll.isSorted());
        dll.insertTail(new DNode(0));
        assertFalse(dll.isSorted());
    }

    @Test
    public void testClear() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        dll.insertHead(node1);
        dll.insertTail(node2);
        dll.insertTail(node3);
        dll.clear();
        assertEquals(0, dll.getSize());
        assertNull(dll.getHead());
        assertNull(dll.getTail());
    }

    @Test
    public void testPrint() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        dll.insertHead(node1);
        dll.insertTail(node2);
        dll.insertTail(node3);
        assertEquals("1 2 3 ", dll.print());
    }
 */

