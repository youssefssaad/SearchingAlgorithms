package mylib;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mylib.datastructures.linear.QueueLL;
import mylib.datastructures.nodes.SNode;

//enqueue has to be changed to node instread of int
public class QueueLLTest {

    @Test
    public void testEnqueue() {
        QueueLL queue = new QueueLL();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());
    }
    
    @Test
    public void testDequeue() {
        QueueLL queue = new QueueLL();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        int removed = queue.dequeue();
        assertEquals(1, removed);
        assertEquals(2, queue.size());
    }
    
    @Test
    public void testPeek() {
        QueueLL queue = new QueueLL();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        int peeked = queue.peek();
        assertEquals(1, peeked);
        assertEquals(3, queue.size());
    }
    
    @Test
    public void testIsEmpty() {
        QueueLL queue = new QueueLL();
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }
    
    @Test
    public void testClear() {
        QueueLL queue = new QueueLL();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.clear();
        assertTrue(queue.isEmpty());
    }
    

}