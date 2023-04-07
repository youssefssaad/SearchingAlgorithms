package mylib.datastructures.nodes;

public class TNode {
    private int data;             // data stored in the node
    private TNode leftChild;   // reference to the left child node
    private TNode rightChild;  // reference to the right child node
    
    // constructor to create a new node with given data
    public TNode(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
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
}

