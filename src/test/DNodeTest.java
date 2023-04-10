

import org.junit.Test;
import static org.junit.Assert.*;

public class DNodeTest {

    @Test
    public void testDNode() {
        // create a new DNode with data value 5
        DNode node = new DNode(5);
        
        // test that the node's data value is 5
        assertEquals(5, node.getData());
        
        // set a new data value for the node and test that it was set correctly
        node.setData(10);
        assertEquals(10, node.getData());
        
        // create a new DNode and set it as the previous node of the first node
        DNode prevNode = new DNode(3);
        node.setPrev(prevNode);
        
        // test that the previous node of the first node is the new node we just created
        assertEquals(prevNode, node.getPrev());
        
        // create another new DNode and set it as the next node of the first node
        DNode nextNode = new DNode(7);
        node.setNext(nextNode);
        
        // test that the next node of the first node is the new node we just created
        assertEquals(nextNode, node.getNext());
    }

    @Test
    public void testGetData() {
        DNode node = new DNode(10);
        assertEquals(10, node.getData());
    }

    @Test
    public void testSetData() {
        DNode node = new DNode(10);
        node.setData(20);
        assertEquals(20, node.getData());
    }

    @Test
    public void testGetPrev() {
        DNode prev = new DNode(5);
        DNode node = new DNode(10);
        node.setPrev(prev);
        assertEquals(prev, node.getPrev());
    }

    @Test
    public void testSetPrev() {
        DNode prev = new DNode(5);
        DNode node = new DNode(10);
        node.setPrev(prev);
        assertEquals(prev, node.getPrev());
    }

    @Test
    public void testGetNext() {
        DNode next = new DNode(15);
        DNode node = new DNode(10);
        node.setNext(next);
        assertEquals(next, node.getNext());
    }

    @Test
    public void testSetNext() {
        DNode next = new DNode(15);
        DNode node = new DNode(10);
        node.setNext(next);
        assertEquals(next, node.getNext());
    }
}

