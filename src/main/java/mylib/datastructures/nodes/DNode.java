package mylib.datastructures.nodes;

public class DNode {
    private int data;           // data stored in the node
    private DNode prev;    // reference to the previous node in the list
    private DNode next;    // reference to the next node in the list
    
    // constructor to create a new node with given data
    public DNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
    
    // getter and setter methods for data
    public int getData() {
        return data;
    }
    
    public void setData(int data) {
        this.data = data;
    }
    
    // getter and setter methods for previous node reference
    public DNode getPrev() {
        return prev;
    }
    
    public void setPrev(DNode prev) {
        this.prev = prev;
    }
    
    // getter and setter methods for next node reference
    public DNode getNext() {
        return next;
    }
    
    public void setNext(DNode next) {
        this.next = next;
    }
}


