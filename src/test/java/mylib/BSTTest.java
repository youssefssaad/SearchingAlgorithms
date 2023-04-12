package mylib;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mylib.datastructures.nodes.TNode;
import mylib.datastructures.trees.BST;

public class BSTTest {

    private BST bst;

    @Before
    public void setUp() {
        bst = new BST();
        bst.insert(new TNode(5));
        bst.insert(new TNode(3));
        bst.insert(new TNode(7));
        bst.insert(new TNode(1));
        bst.insert(new TNode(4));
    }

    @Test
    public void testInsertionDeletionAndSearch() {
        TNode node1 = bst.search(1);
        TNode node2 = bst.search(2);
        TNode node3 = bst.search(4);
        TNode node4 = bst.search(6);

        assertEquals(node1.getData(), 1);
        assertNull(node2);
        assertEquals(node3.getData(), 4);
        assertNull(node4);

        bst.delete(1);
        assertNull(bst.search(1));

        bst.delete(5);
        assertNull(bst.search(5));

        bst.delete(7);
        assertNull(bst.search(7));

        bst.delete(3);
        assertNull(bst.search(3));

        bst.delete(4);
        assertNull(bst.search(4));
    }

    @Test
    public void testPrintInOrder() {
        bst.printInOrder();  // prints: 1 3 4 5 7
    }

    @Test
    public void testPrintBF() {
        bst.printBF();  // prints: 5 3 7 1 4
    }

    @Test
    public void testDefaultConstructor() {
        BST bst = new BST();
        assertNull(bst.getRoot());
    }

    @Test
    public void testOverloadConstructor() {
        BST bst = new BST(10);
        assertNotNull(bst.getRoot());
        assertEquals(10, bst.getRoot().getData());
        assertNull(bst.getRoot().getLeft());
        assertNull(bst.getRoot().getRight());
    }

    @Test
    public void testOverloadTNodeObjectConstructor() {
        TNode root = new TNode(10);
        root.setLeft(new TNode(5));
        root.setRight(new TNode(15));
        BST bst = new BST(root);
        assertNotNull(bst.getRoot());
        assertEquals(10, bst.getRoot().getData());
        assertNotNull(bst.getRoot().getLeft());
        assertEquals(5, bst.getRoot().getLeft().getData());
        assertNotNull(bst.getRoot().getRight());
        assertEquals(15, bst.getRoot().getRight().getData());
    }

    @Test
    public void testInsertionOne() {
        BST bst = new BST();
        bst.insert(10);
        assertNotNull(bst.getRoot());
        assertEquals(10, bst.getRoot().getData());
        assertNull(bst.getRoot().getLeft());
        assertNull(bst.getRoot().getRight());
    }

    @Test
    public void testInsertionTwo() {
        BST bst = new BST();
        bst.insert(new TNode(5));
        bst.insert(new TNode(3));

        TNode node1 = bst.search(5);
        TNode node2 = bst.search(3);
        TNode node3 = bst.search(4);

        assertEquals(node1.getData(), 5);
        assertEquals(node2.getData(), 3);
        assertNull(node3);
    }

    @Test
    public void testInsertionThree() {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        assertNotNull(bst.getRoot());
        assertEquals(10, bst.getRoot().getData());
        assertNotNull(bst.getRoot().getLeft());
        assertEquals(5, bst.getRoot().getLeft().getData());
        assertNull(bst.getRoot().getLeft().getLeft());
        assertNull(bst.getRoot().getLeft().getRight());
        assertNotNull(bst.getRoot().getRight());
        assertEquals(15, bst.getRoot().getRight().getData());
        assertNull(bst.getRoot().getRight().getLeft());
        assertNull(bst.getRoot().getRight().getRight());
    }
}