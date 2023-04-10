
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
}
