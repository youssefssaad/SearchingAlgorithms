package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;

public class StackLL extends SLL{

    private SNode top;
    private int size;

    /**
     * Default constructor
     */
    public StackLL() {
        top = null;
        size = 0;
    }

    /**
     * Constructor with a node
     * @param node
     */
    public StackLL(SNode node) {
        top = node;
        size = 1;
    }

    /**
     * Pushes a node onto the stack
     * @param data
     */
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

    /**
     * Pops a node off the stack
     * @return data
     */
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    /**
     * Peeks at the top of the stack
     * @return data
     */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.getData();
    }

    /**
     * Returns the size of the stack
     * @return size
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Returns the size of the stack
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * Returns the top of the stack
     * @return top
     */
    public int top() {
        return top.getData();
    }

    @Override
    public void insertHead(SNode node) {}

    @Override
    public void insertTail(SNode node) {}

    @Override
    public void insert(SNode node, int index) {}

    @Override
    public void sortedInsert(SNode node) {}

    @Override
    public void deleteHead() {}

    @Override
    public void deleteTail() {}

    @Override
    public void delete(SNode node) {}

    @Override
    public void sort() {}

    @Override
    public void clear() {}

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
