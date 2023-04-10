package mylib;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mylib.datastructures.nodes.TNode;
import mylib.datastructures.trees.BST;

public class BSTTest {

    @Test
    public void testInsertAndSearch() {
        BST bst = new BST();

        bst.insert(new TNode(5));
        bst.insert(new TNode(3));
        bst.insert(new TNode(7));
        bst.insert(new TNode(1));
        bst.insert(new TNode(4));

        TNode node1 = bst.search(1);
        TNode node2 = bst.search(2);
        TNode node3 = bst.search(4);
        TNode node4 = bst.search(6);

        assertEquals(node1.getData(), 1);
        assertNull(node2);
        assertEquals(node3.getData(), 4);
        assertNull(node4);
    }

    @Test
    public void testDelete() {
        BST bst = new BST();

        bst.insert(new TNode(5));
        bst.insert(new TNode(3));
        bst.insert(new TNode(7));
        bst.insert(new TNode(1));
        bst.insert(new TNode(4));

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
        BST bst = new BST();

        bst.insert(new TNode(5));
        bst.insert(new TNode(3));
        bst.insert(new TNode(7));
        bst.insert(new TNode(1));
        bst.insert(new TNode(4));

        bst.printInOrder();  // prints: 1 3 4 5 7
    }

    @Test
    public void testPrintBF() {
        BST bst = new BST();

        bst.insert(new TNode(5));
        bst.insert(new TNode(3));
        bst.insert(new TNode(7));
        bst.insert(new TNode(1));
        bst.insert(new TNode(4));

        bst.printBF();  // prints: 5 3 7 1 4
    }
}