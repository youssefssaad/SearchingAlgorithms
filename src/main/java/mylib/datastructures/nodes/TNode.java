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

