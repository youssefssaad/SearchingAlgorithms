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
      SNode node1 = new SNode(1);
      SNode node2 = new SNode(2);
      SNode node3 = new SNode(3);
      queue.enqueue(node1);
      queue.enqueue(node2);
      queue.enqueue(node3);
      assertEquals(queue.getHead(), node1);
      assertEquals(queue.getTail(), node3);
      assertEquals(queue.getSize(), 3);
    }
    
    @Test
    public void testDequeue() {
      QueueLL queue = new QueueLL();
      SNode node1 = new SNode(1);
      SNode node2 = new SNode(2);
      SNode node3 = new SNode(3);
      queue.enqueue(node1);
      queue.enqueue(node2);
      queue.enqueue(node3);
      queue.dequeue();
      assertEquals(queue.getHead(), node2);
      assertEquals(queue.getSize(), 2);
      queue.dequeue();
      assertEquals(queue.getHead(), node3);
      assertEquals(queue.getSize(), 1);
      queue.dequeue();
      assertEquals(queue.getSize(), 0);
      assertTrue(queue.isEmpty());
    }
    
    @Test
    public void testIsEmpty() {
      QueueLL queue = new QueueLL();
      assertTrue(queue.isEmpty());
      SNode node = new SNode(1);
      queue.enqueue(node);
      assertFalse(queue.isEmpty());
    }
    
    @Test
    public void testPrint() {
      QueueLL queue = new QueueLL();
      queue.print(); // expected output: "Queue is empty"
      SNode node1 = new SNode(1);
      SNode node2 = new SNode(2);
      SNode node3 = new SNode(3);
      queue.enqueue(node1);
      queue.enqueue(node2);
      queue.enqueue(node3);
      queue.print(); // expected output: "1 2 3"
    }
    
  }