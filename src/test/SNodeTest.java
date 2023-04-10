import org.junit.Test;
import static org.junit.Assert.*;

public class SNodeTest {

    @Test
    public void testConstructor() {
        SNode node = new SNode(42);
        assertEquals(42, node.getData());
        assertNull(node.getNext());
    }

    @Test
    public void testSetData() {
        SNode node = new SNode(42);
        node.setData(13);
        assertEquals(13, node.getData());
    }

    @Test
    public void testSetNext() {
        SNode node1 = new SNode(42);
        SNode node2 = new SNode(13);
        node1.setNext(node2);
        assertEquals(node2, node1.getNext());
    }
}

