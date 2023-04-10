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
        SNode prev = head;
        SNode curr = prev.getNext();
        while (curr != null && node.getData() > curr.getData()) {
            prev = curr;
            curr = curr.getNext();
        }
        prev.setNext(node);
        node.setNext(curr);
        if (curr == null) {
            tail = node;
        }
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

    public SNode getTail() {
        return tail;
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

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public SNode getHead() {
        return head;
    }
    
}

/*
package mylib.datastructures.linear;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import mylib.datastructures.nodes.SNode;

public class SLLTest {

    @Test
    public void testInsertHead() {
        SLL list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertHead(node1);
        list.insertHead(node2);
        list.insertHead(node3);
        assertEquals(node3, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(3, list.getSize());
    }

    @Test
    public void testInsertTail() {
        SLL list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(3, list.getSize());
    }

    @Test
    public void testInsert() {
        SLL list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node1);
        list.insertTail(node3);
        list.insert(node2, 1);
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(node2, list.getHead().getNext());
        assertEquals(3, list.getSize());
    }

    @Test
    public void testSortedInsert() {
        SLL list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.sortedInsert(node2);
        list.sortedInsert(node1);
        list.sortedInsert(node3);
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(node2, list.getHead().getNext());
        assertEquals(3, list.getSize());
    }

    @Test
    public void testSearch() {
        SLL list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        assertEquals(node2, list.search(node2));
        assertNull(list.search(new SNode(4)));
    }

    @Test
    public void testDeleteHead() {
        SLL list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.deleteHead();
        assertEquals(node2, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(2, list.getSize());
    }

    @Test
    public void testDeleteTail() {
        SLL list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list = new SLL();
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.deleteTail();
        assertEquals(node1, list.getHead());
        assertEquals(node2, list.getTail());
        assertEquals(2, list.getSize());
    }

    @Test
    public void testDelete() {
        SLL list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.delete(node2);
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(2, list.getSize());
    }

    @Test
    public void testIsSorted() {
        SLL list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        assertTrue(list.isSorted());
        list.deleteTail();
        list.insertTail(node1);
        assertFalse(list.isSorted());
    }

    @Test
    public void testClear() {
        SLL list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.clear();
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.getSize());
    }

    @Test
    public void testPrint() {
        SLL list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.print();
    }

 */
