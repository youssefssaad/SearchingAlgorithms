import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mylib.datastructures.nodes.TNode;

public class BSTTest {

    private BST bst;

    @Before
    public void setUp() {
        bst = new BST();
    }

    @Test
    public void testInsert() {
        bst.insert(new TNode(5));
        bst.insert(new TNode(2));
        bst.insert(new TNode(8));
        bst.insert(new TNode(1));
        bst.insert(new TNode(3));
        bst.insert(new TNode(7));
        bst.insert(new TNode(9));
        bst.insert(new TNode(4));
        bst.insert(new TNode(6));

        assertEquals("1 2 3 4 5 6 7 8 9 ", getInOrderTraversal(bst));
        assertEquals("5 2 8 1 3 7 9 4 6 ", getBFTraversal(bst));
    }

    @Test
    public void testDelete() {
        bst.insert(new TNode(5));
        bst.insert(new TNode(2));
        bst.insert(new TNode(8));
        bst.insert(new TNode(1));
        bst.insert(new TNode(3));
        bst.insert(new TNode(7));
        bst.insert(new TNode(9));
        bst.insert(new TNode(4));
        bst.insert(new TNode(6));

        bst.delete(5);
        bst.delete(8);
        bst.delete(2);
        bst.delete(4);

        assertEquals("1 3 6 7 9 ", getInOrderTraversal(bst));
        assertEquals("5 3 7 1 6 9 ", getBFTraversal(bst));
    }

    private String getInOrderTraversal(BST bst) {
        StringBuilder sb = new StringBuilder();
        bst.printInOrder(node -> sb.append(node.getData()).append(" "));
        return sb.toString();
    }

    private String getBFTraversal(BST bst) {
        StringBuilder sb = new StringBuilder();
        bst.printBF(node -> sb.append(node.getData()).append(" "));
        return sb.toString();
    }
}