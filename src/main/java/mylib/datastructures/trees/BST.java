package mylib.datastructures.trees;
import java.util.*;

import mylib.datastructures.nodes.TNode;
//so TNode has root as parent so we can choose to use root as parent or not    
public class BST {

    private TNode root;     //references the root of the tree

    // Default constructor initializing root to null
    public BST(){
        root = null;
    }

    // Overload constructor BST(int val)
    public BST(int val) {
        root = new TNode(val);
    }

    // Overload constructor BST(TNode obj)
    public BST(TNode obj) {
        root = obj;
    }

    // Getters and setters for root

    public TNode getRoot(){
        return root;
    }

    public void setRoot(TNode root){
        this.root = root;
    }

    // Recursive helper method to insert a new node into the tree
    private void insertNode(TNode current, TNode newNode) {
        if (newNode.getData() < current.getData()) {
            if (current.getLeft() == null) {
                current.setLeft(newNode);
            } else {
                insertNode(current.getLeft(), newNode);
            }
        } else {
            if (current.getRight() == null) {
                current.setRight(newNode);
            } else {
                insertNode(current.getRight(), newNode);
            }
        }
    }

    public void insert(TNode node) {
        if (root == null) {
            root = node;
        } else {
            insertNode(root, node);
        }
    }

    // Helper method to find the minimum node in a subtree
    private TNode findMinNode(TNode node) {
        TNode nodeMin = node;
        while (node.getLeft() != null) {
            nodeMin = node.getLeft();
        }
        return nodeMin;
    }

    // Recursive helper method to delete a node with a given value from the tree
    private TNode deleteNode(TNode current, int val) {
        if (current == null) {
            return null;
        } else if (val < current.getData()) {
            current.setLeft(deleteNode(current.getLeft(), val));
        } else if (val > current.getData()) {
            current.setRight(deleteNode(current.getRight(), val));
        } else {
            if (current.getLeft() == null && current.getRight() == null) { // node is a leaf (no children)
                current = null;
            } else if (current.getLeft() == null) { // node has one child on right
                current = current.getRight();
            } else if (current.getRight() == null) { // node has one child on left
                current = current.getLeft();
            } else { // node has two children
                TNode minNode = findMinNode(current.getRight());
                current.setData(minNode.getData());
                current.setRight(deleteNode(current.getRight(), minNode.getData()));
            }
        }
        return current;
    }

    public void delete(int val) {
        root = deleteNode(root, val);
    }

    // Search int value
    public TNode search(int val) {
        TNode current = root;
        while (current != null) {
            if (current.getData() == val) {
                return current;
            } else if (val < current.getData()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }

    // In-order traversal
    private void printInOrder(TNode node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            printInOrder(node.getRight());
        }
    }

    public void printInOrder() {
        printInOrder(root);
    }

    // Breadth-first traversal
    public void printBF() {
        Queue<TNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                TNode current = queue.remove();
                System.out.print(current.getData() + " ");
                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
        }
    }

}

/*package mylib.datastructures.trees;

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
 */
