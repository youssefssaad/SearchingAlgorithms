import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TNodeTest {
    
    @Test
    public void testDefaultConstructor() {
        TNode node = new TNode();
        assertEquals(0, node.getData());
        assertEquals(null, node.getLeft());
        assertEquals(null, node.getRight());
        assertEquals(null, node.getParent());
        assertEquals(0, node.getBalance());
    }
    
    @Test
    public void testParameterizedConstructor() {
        TNode node = new TNode(5);
        assertEquals(5, node.getData());
        assertEquals(null, node.getLeft());
        assertEquals(null, node.getRight());
        assertEquals(null, node.getParent());
        assertEquals(0, node.getBalance());
    }
    
    @Test
    public void testOverloadConstructor() {
        TNode leftChild = new TNode(2);
        TNode rightChild = new TNode(8);
        TNode parent = new TNode(5);
        TNode node = new TNode(6, -1, parent, leftChild, rightChild);
        assertEquals(6, node.getData());
        assertEquals(leftChild, node.getLeft());
        assertEquals(rightChild, node.getRight());
        assertEquals(parent, node.getParent());
        assertEquals(-1, node.getBalance());
    }
    
    @Test
    public void testGetData() {
        TNode node = new TNode(5);
        assertEquals(5, node.getData());
    }
    
    @Test
    public void testSetData() {
        TNode node = new TNode(5);
        node.setData(10);
        assertEquals(10, node.getData());
    }
    
    @Test
    public void testGetLeft() {
        TNode leftChild = new TNode(2);
        TNode node = new TNode(5, 0, null, leftChild, null);
        assertEquals(leftChild, node.getLeft());
    }
    
    @Test
    public void testSetLeft() {
        TNode node = new TNode(5);
        TNode leftChild = new TNode(2);
        node.setLeft(leftChild);
        assertEquals(leftChild, node.getLeft());
    }
    
    @Test
    public void testGetRight() {
        TNode rightChild = new TNode(8);
        TNode node = new TNode(5, 0, null, null, rightChild);
        assertEquals(rightChild, node.getRight());
    }
    
    @Test
    public void testSetRight() {
        TNode node = new TNode(5);
        TNode rightChild = new TNode(8);
        node.setRight(rightChild);
        assertEquals(rightChild, node.getRight());
    }
    
    @Test
    public void testGetParent() {
        TNode parent = new TNode(5);
        TNode node = new TNode(2, 0, parent, null, null);
        assertEquals(parent, node.getParent());
    }
    
    @Test
    public void testSetParent() {
        TNode node = new TNode(5);
        TNode parent = new TNode(2);
        node.setParent(parent);
        assertEquals(parent, node.getParent());
    }
    
    @Test
    public void testGetBalance() {
        TNode node = new TNode(5, -1, null, null, null);
        assertEquals(-1, node.getBalance());
    }
    
    @Test
    public void testSetBalance() {
        TNode node = new TNode(5);
        node.setBalance(-1);
        assertEquals(-1, node.getBalance());
    }
}

