package mylib;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mylib.datastructures.nodes.TNode;
import mylib.datastructures.trees.AVL;


public class AVLTest {

    @Test
    public void testInsert() {
        AVL tree = new AVL();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);

        assertEquals(30, tree.getRoot().getData());
        assertEquals(20, tree.getRoot().getLeft().getData());
        assertEquals(40, tree.getRoot().getRight().getData());
        assertEquals(10, tree.getRoot().getLeft().getLeft().getData());
        assertEquals(50, tree.getRoot().getRight().getRight().getData());
    }

    @Test
    public void testDelete() {
        AVL tree = new AVL();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);

        tree.delete(20);

        assertEquals(40, tree.getRoot().getData());
        assertEquals(10, tree.getRoot().getLeft().getData());
        assertEquals(30, tree.getRoot().getLeft().getRight().getData());
        assertEquals(50, tree.getRoot().getRight().getData());

        tree.delete(30);

        assertEquals(40, tree.getRoot().getData());
        assertEquals(10, tree.getRoot().getLeft().getData());
        assertEquals(50, tree.getRoot().getRight().getData());

        tree.delete(10);

        assertEquals(50, tree.getRoot().getData());
        assertEquals(40, tree.getRoot().getLeft().getData());
    }

    @Test
    public void testGetBalanceFactor() {
        AVL tree = new AVL();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        assertEquals(0, tree.getBalanceFactor(tree.getRoot()));

        tree.insert(40);

        assertEquals(-1, tree.getBalanceFactor(tree.getRoot()));
    }

    @Test
    public void testRotateLeft() {
        AVL tree = new AVL();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        TNode newRoot = tree.rotateLeft(tree.getRoot());

        assertEquals(20, newRoot.getData());
        assertEquals(10, newRoot.getLeft().getData());
        assertEquals(30, newRoot.getRight().getData());
    }

    @Test
    public void testRotateRight() {
        AVL tree = new AVL();

        tree.insert(30);
        tree.insert(20);
        tree.insert(10);

        TNode newRoot = tree.rotateRight(tree.getRoot());

        assertEquals(20, newRoot.getData());
        assertEquals(10, newRoot.getLeft().getData());
        assertEquals(30, newRoot.getRight().getData());
    }

}