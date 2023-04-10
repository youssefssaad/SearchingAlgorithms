import mylib.datastructures.nodes.TNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AVLTest {

    @Test
    public void testInsertAndBalance() {
        AVL tree = new AVL();
        tree.insert(5);
        tree.insert(10);
        tree.insert(15);
        tree.insert(20);
        assertEquals(15, tree.getRoot().getData());
        assertEquals(10, tree.getRoot().getLeft().getData());
        assertEquals(20, tree.getRoot().getRight().getData());
        assertEquals(5, tree.getRoot().getLeft().getLeft().getData());
    }

    @Test
    public void testDeleteAndBalance() {
        AVL tree = new AVL();
        tree.insert(5);
        tree.insert(10);
        tree.insert(15);
        tree.insert(20);
        tree.delete(tree.getRoot(), 10);
        assertEquals(15, tree.getRoot().getData());
        assertEquals(5, tree.getRoot().getLeft().getData());
        assertEquals(20, tree.getRoot().getRight().getData());
    }

    @Test
    public void testInsertAndGetRoot() {
        AVL tree = new AVL(10);
        assertEquals(10, tree.getRoot().getData());
    }

    @Test
    public void testSetAndGetRoot() {
        AVL tree = new AVL();
        tree.setRoot(new TNode(10));
        assertEquals(10, tree.getRoot().getData());
    }
}