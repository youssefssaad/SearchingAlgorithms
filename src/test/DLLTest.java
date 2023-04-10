package mylib.datastructures.linear;

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
}