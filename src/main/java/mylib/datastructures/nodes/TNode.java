package mylib.datastructures.nodes;

public class TNode {
    private int data;          // data stored in the node
    private TNode left;   // reference to the left child node
    private TNode right;  // reference to the right child node
    private TNode parent;      // reference to the parent node
    private int balance;       // balance factor of the node

    /**
     * Default constructor
     */
    public TNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }

    /**
     * Overload constructor
     * @param data
     */
    public TNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }

    /**
     * Overload constructor 2
     * @param data
     * @param balance
     * @param parent
     * @param left
     * @param right
     */
    public TNode(int data, int balance, TNode parent, TNode left, TNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.balance = balance;
    }
    
    // getter and setter methods for data
    /**
     * getter for data
     * @return data
     */
    public int getData() {
        return data;
    }
    
    /**
     * setter for data
     * @param data
     */
    public void setData(int data) {
        this.data = data;
    }
    
    /**
     * getter for left child node reference
     * @return left
     */
    public TNode getLeft() {
        return left;
    }
    
    /**
     * setter for left child node reference
     * @param left
     */
    public void setLeft(TNode left) {
        this.left = left;
    }
    
    // getter and setter methods for right child node reference
    /**
     * getter for right child node reference
     * @return right
     */
    public TNode getRight() {
        return right;
    }
    
    /**
     * setter for right child node reference
     * @param right
     */
    public void setRight(TNode right) {
        this.right = right;
    }

    // getter and setter methods for parent node reference
    /**
     * getter for parent node reference
     * @return parent
     */
    public TNode getParent() {
        return parent;
    }

    /**
     * setter for parent node reference
     * @param parent
     */
    public void setParent(TNode parent) {
        this.parent = parent;
    }

    // getter and setter methods for balance factor
    /**
     * getter for balance factor
     * @return balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * setter for balance factor
     * @param balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    // print method to print node information in a user-friendly format
    /**
     * print method to print node information in a user-friendly format
     */
    public void print() {
        System.out.println("Data: " + data + ", Balance: " + balance);
    }

    // toString method to return data as a string
    /**
     * toString method to return data as a string
     */
    public String toString() {
        return Integer.toString(data);
    }
}

/* 
public class Main {
    public static void main(String[] args) {

        // Test default constructor
        TNode node1 = new TNode();
        assertEquals(0, node1.getData());
        assertNull(node1.getLeft());
        assertNull(node1.getRight());
        assertNull(node1.getParent());
        assertEquals(0, node1.getBalance());

        // Test overload constructor
        TNode left = new TNode(3, 0, null, null, null);
        TNode right = new TNode(7, 0, null, null, null);
        TNode parent = new TNode(5, 0, null, left, right);
        TNode node2 = new TNode(10, 1, parent, null, null);
        assertEquals(10, node2.getData());
        assertNull(node2.getLeft());
        assertNull(node2.getRight());
        assertEquals(parent, node2.getParent());
        assertEquals(1, node2.getBalance());

        TNode node3 = new TNode(15, 0, parent, null, null);
        TNode node4 = new TNode(28, 0, right, null, null);

        // test getters and setters
        node1.setData(20);
        assertEquals(20, node1.getData());

        node1.setParent(node4);
        assertEquals(node4, node1.getParent());

        node1.setLeft(node2);
        assertEquals(node2, node1.getLeft());

        node1.setRight(node3);
        assertEquals(node3, node1.getRight());

        node1.setBalance(-1);
        assertEquals(-1, node1.getBalance());

        // test print method
        node1.print();

        // test toString method
        assertEquals("20", node1.toString());
    }
}
*/