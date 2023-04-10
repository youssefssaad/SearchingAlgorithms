package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CDLLTest {
    private CDLL cdll;

    @BeforeEach
    void setUp() {
        cdll = new CDLL();
    }

    @Test
    void testInsertHead() {
        DNode node = new DNode(1);
        cdll.insertHead(node);
        assertEquals(cdll.size(), 1);
        assertEquals(cdll.getHead(), node);
        assertEquals(cdll.getTail(), node);

        DNode node2 = new DNode(2);
        cdll.insertHead(node2);
        assertEquals(cdll.size(), 2);
        assertEquals(cdll.getHead(), node2);
        assertEquals(cdll.getTail(), node);
        assertEquals(cdll.getHead().getNext(), node);
        assertEquals(cdll.getTail().getPrev(), node2);
    }

    @Test
    void testInsertTail() {
        DNode node = new DNode(1);
        cdll.insertTail(node);
        assertEquals(cdll.size(), 1);
        assertEquals(cdll.getHead(), node);
        assertEquals(cdll.getTail(), node);

        DNode node2 = new DNode(2);
        cdll.insertTail(node2);
        assertEquals(cdll.size(), 2);
        assertEquals(cdll.getHead(), node);
        assertEquals(cdll.getTail(), node2);
        assertEquals(cdll.getHead().getNext(), node2);
        assertEquals(cdll.getTail().getPrev(), node);
    }

    @Test
    void testInsert() {
        DNode node = new DNode(1);
        cdll.insert(node, 0);
        assertEquals(cdll.size(), 1);
        assertEquals(cdll.getHead(), node);
        assertEquals(cdll.getTail(), node);

        DNode node2 = new DNode(2);
        cdll.insert(node2, 1);
        assertEquals(cdll.size(), 2);
        assertEquals(cdll.getHead(), node);
        assertEquals(cdll.getTail(), node2);
        assertEquals(cdll.getHead().getNext(), node2);
        assertEquals(cdll.getTail().getPrev(), node);

        DNode node3 = new DNode(3);
        cdll.insert(node3, 1);
        assertEquals(cdll.size(), 3);
        assertEquals(cdll.getHead(), node);
        assertEquals(cdll.getTail(), node2);
        assertEquals(cdll.getHead().getNext(), node3);
        assertEquals(cdll.getTail().getPrev(), node3);
    }

    @Test
    void testDeleteHead() {
        assertThrows(RuntimeException.class, () -> cdll.deleteHead());

        DNode node = new DNode(1);
        cdll.insertHead(node);

        cdll.deleteHead();
        assertTrue(cdll.isEmpty());

        DNode node2 = new DNode(2);
        cdll.insertHead(node);
        cdll.insertHead(node2);

        cdll.deleteHead();
        assertEquals(cdll.size(), 1);
        assertEquals(cdll.getHead(), node);
        assertEquals(cdll.getTail(), node);

    }

    @Test
    void testDeleteTail() {
        assertThrows(RuntimeException.class, () -> cdll.deleteTail());

        DNode node = new DNode(1);
        cdll.insertHead(node);

        cdll.deleteTail();
        assertTrue(cdll.isEmpty());

        DNode node2 = new DNode(2);
        cdll.insertHead(node);
        cdll.insertHead(node2);

        cdll.deleteTail();
        assertEquals(cdll.size(), 1);
        assertEquals(cdll.getHead(), node2);
        assertEquals(cdll.getTail(), node2);
    }

    @Test
    void testDelete() {
        assertThrows(RuntimeException.class, () -> cdll.delete(0));

        DNode node = new DNode(1);
        cdll.insertHead(node);

        cdll.delete(0);
        assertTrue(cdll.isEmpty());

        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        cdll.insertHead(node);
        cdll.insertHead(node2);
        cdll.insertHead(node3);

        cdll.delete(1);
        assertEquals(cdll.size(), 2);
        assertEquals(cdll.getHead(), node3);
        assertEquals(cdll.getTail(), node);
        assertEquals(cdll.getHead().getNext(), node);
        assertEquals(cdll.getTail().getPrev(), node3);
    }

}
