package mylib;

import static org.junit.Assert.*;

import org.junit.*;

import mylib.datastructures.nodes.TNode;
import mylib.datastructures.trees.AVL;

public class AVLTest {
    private AVL avl;

    @Before
    public void setUp() {
        avl = new AVL();
    }

    @Test
    public void testSearch() {
        avl.insert(10);
        avl.insert(20);
        avl.insert(30);
        avl.insert(40);
        avl.insert(50);
        TNode node = avl.search(30);
        assertNotNull(node);
        assertEquals(30, node.getData());
    }

    @Test
    public void testInsertAndSearch() {
        avl.insert(new TNode(5));
        avl.insert(new TNode(3));
        avl.insert(new TNode(7));
        avl.insert(new TNode(1));
        avl.insert(new TNode(4));

        TNode node1 = avl.search(1);
        TNode node2 = avl.search(2);
        TNode node3 = avl.search(4);
        TNode node4 = avl.search(6);

        assertEquals(node1.getData(), 1);
        assertNull(node2);
        assertEquals(node3.getData(), 4);
        assertNull(node4);
    }

    @Test
    public void testDelete() {
        avl.insert(new TNode(5));
        avl.insert(new TNode(3));
        avl.insert(new TNode(7));
        avl.insert(new TNode(1));
        avl.insert(new TNode(4));

        avl.delete(1);
        assertNull(avl.search(1));

        avl.delete(5);
        assertNull(avl.search(5));

        avl.delete(7);
        assertNull(avl.search(7));

        avl.delete(3);
        assertNull(avl.search(3));

        avl.delete(4);
        assertNull(avl.search(4));
    }

    @Test
    public void testInsertNullNode() {
        avl.insert(null);
        assertNull(avl.getRoot());
    }

    @Test
    public void testAVLIntConstructor() {
        AVL avl = new AVL(5);
        TNode root = avl.getRoot();
        assertNotNull(root);
    }

    @Test
    public void testAVLTNodeConstructor() {
        TNode node = new TNode(5, 0, null, null, null);
        AVL avl = new AVL(node);
        TNode root = avl.getRoot();
        assertNotNull(root);
        assertSame(node, root);
    }

    @Test
    public void testAVLTNodeConstructorNull() {
        AVL avl = new AVL(null);
        assertNull(avl.getRoot());
    }
}
