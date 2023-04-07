package mylib.datastructures.nodes;

public class SNode {
    //single node
    private int data;   // data stored in the node
    private SNode next;  // reference to the next node in the list
    
    // constructor to create a new node with given data
    public SNode(int data) {
        this.data = data;
        this.next = null;
    }
    
    // getter and setter methods for data
    public int getData() {
        return data;
    }
    
    public void setData(int data) {
        this.data = data;
    }
    
    // getter and setter methods for next node reference
    public SNode getNext() {
        return next;
    }
    
    public void setNext(SNode next) {
        this.next = next;
    }
}
