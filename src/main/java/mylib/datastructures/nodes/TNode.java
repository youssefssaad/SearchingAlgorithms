package mylib.datastructures.nodes;

public class TNode {
    private int data;          // data stored in the node
    private TNode leftChild;   // reference to the left child node
    private TNode rightChild;  // reference to the right child node
    private TNode parent;      // reference to the parent node
    private int balance;       // balance factor of the node

    // default constructor
    public TNode() {
        this.data = 0;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
        this.balance = 0;
    }

    // overload constructor
    public TNode(int data, int balance, TNode parent, TNode leftChild, TNode rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.parent = parent;
        this.balance = balance;
    }
    
    // getter and setter methods for data
    public int getData() {
        return data;
    }
    
    public void setData(int data) {
        this.data = data;
    }
    
    // getter and setter methods for left child node reference
    public TNode getLeftChild() {
        return leftChild;
    }
    
    public void setLeftChild(TNode leftChild) {
        this.leftChild = leftChild;
    }
    
    // getter and setter methods for right child node reference
    public TNode getRightChild() {
        return rightChild;
    }
    
    public void setRightChild(TNode rightChild) {
        this.rightChild = rightChild;
    }

    // getter and setter methods for parent node reference
    public TNode getParent() {
        return parent;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }

    // getter and setter methods for balance factor
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // print method to print node information in a user-friendly format
    public void print() {
        System.out.println("Data: " + data + ", Balance: " + balance);
    }

    // toString method to return data as a string
    public String toString() {
        return Integer.toString(data);
    }
}


public class Main {
    public static void main(String[] args) {

        // Test default constructor
        TNode node1 = new TNode();
        assertEquals(0, node1.getData());
        assertNull(node1.getLeftChild());
        assertNull(node1.getRightChild());
        assertNull(node1.getParent());
        assertEquals(0, node1.getBalance());

        // Test overload constructor
        TNode leftChild = new TNode(3, 0, null, null, null);
        TNode rightChild = new TNode(7, 0, null, null, null);
        TNode parent = new TNode(5, 0, null, leftChild, rightChild);
        TNode node2 = new TNode(10, 1, parent, null, null);
        assertEquals(10, node2.getData());
        assertNull(node2.getLeftChild());
        assertNull(node2.getRightChild());
        assertEquals(parent, node2.getParent());
        assertEquals(1, node2.getBalance());

        TNode node3 = new TNode(15, 0, parent, null, null);
        TNode node4 = new TNode(28, 0, rightChild, null, null);

        // test getters and setters
        node1.setData(20);
        assertEquals(20, node1.getData());

        node1.setParent(node4);
        assertEquals(node4, node1.getParent());

        node1.setLeftChild(node2);
        assertEquals(node2, node1.getLeftChild());

        node1.setRightChild(node3);
        assertEquals(node3, node1.getRightChild());

        node1.setBalance(-1);
        assertEquals(-1, node1.getBalance());

        // test print method
        node1.print();

        // test toString method
        assertEquals("20", node1.toString());
    }
}
