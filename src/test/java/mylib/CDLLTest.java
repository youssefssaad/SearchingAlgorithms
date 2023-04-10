package mylib;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import mylib.datastructures.linear.CDLL;
import mylib.datastructures.nodes.DNode;


public class CDLLTest {
    private CDLL cdll;

    @Before
    public void setUp() {
        cdll = new CDLL();
    }

    @Test
    public void testInsertHead() {
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
    public void testInsertTail() {
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
    public void testInsert() {
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
    public void testDeleteHead() {

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
    public void testDeleteTail() {

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
    public void testDelete() {

        DNode node = new DNode(1);
        cdll.insertHead(node);

        cdll.delete(node);
        assertTrue(cdll.isEmpty());

        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        cdll.insertHead(node);
        cdll.insertHead(node2);
        cdll.insertHead(node3);

        cdll.delete(node2);
        assertEquals(cdll.size(), 2);
        assertEquals(cdll.getHead(), node3);
        assertEquals(cdll.getTail(), node);
        assertEquals(cdll.getHead().getNext(), node);
        assertEquals(cdll.getTail().getPrev(), node3);
    }

}
