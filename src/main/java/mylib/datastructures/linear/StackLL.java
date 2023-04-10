package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;

public class StackLL extends SLL{

    private SNode top;
    private int size;

    public StackLL() {
        top = null;
        size = 0;
    }

    public StackLL(SNode node) {
        top = node;
        size = 1;
    }

    //fix to call super
    public void push(int data) {
        SNode newNode = new SNode(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
        }
        size++;
    }

    //fix to call super
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    //fix to call super
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.getData();
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public int top() {
        return top.getData();
    }

}

/*import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackLinkedListTest {

    private StackLinkedList stack;
    
    @Before
    public void setUp() throws Exception {
        stack = new StackLinkedList();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPush() {
        stack.push(1);
        assertEquals(1, stack.top());
        stack.push(2);
        assertEquals(2, stack.top());
        stack.push(3);
        assertEquals(3, stack.top());
    }

    @Test
    public void testPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testTop() {
        stack.push(1);
        assertEquals(1, stack.top());
        stack.push(2);
        assertEquals(2, stack.top());
        stack.push(3);
        assertEquals(3, stack.top());
    }

}
 */
