package mylib.datastructures.trees;

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

    // Create a new node with data val to be inserted into the tree
    public void insert(int val) {
        TNode newNode = new TNode(val);
        insert(newNode);
    }

    // Insert TNode
    public void insert(TNode node) {
    }

    // Delete int value
    public void delete(int val) {
        root = delete(root, val);
    }

    private TNode delete(TNode current, int val) {
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
    }
}
