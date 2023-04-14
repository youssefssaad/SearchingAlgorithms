package mylib;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mylib.datastructures.linear.StackLL;
import mylib.datastructures.nodes.SNode;

public class StackLLTest {

    private StackLL stack;
    
    @Before
    public void setUp() throws Exception {
        stack = new StackLL();
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