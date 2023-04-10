
package mylib.datastructures.test;

import org.junit.Test;

import mylib.datastructures.linear.CDLL;
import mylib.datastructures.nodes.DNode;

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