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

/* 
public class Main {

    public static void main(String[] args) {

        // SNode object with null data
        SNode node = new SNode(null);
        assert node.getData() == null;

        // SNode object with non-null data
        SNode node = new SNode(5);
        assert node.getData() == 5;

        // Setting next to null
        SNode node = new SNode(5);
        node.setNext(null);
        assert node.getNext() == null;

        // Setting next to non-null values
        SNode node1 = new SNode(5);
        SNode node2 = new SNode(10);
        node1.setNext(node2);
        assert node1.getNext() == node2;

        // Removing SNode object from SLL
        SNode node1 = new SNode(5);
        SNode node2 = new SNode(10);
        SNode node3 = new SNode(15);
        node1.setNext(node2);
        node2.setNext(node3);
        node1.setNext(node3);
        node2.setNext(null);
        assert node1.getNext() == node3;
        assert node2.getNext() == null;

        // Adding SNode object to SLL
        SNode node1 = new SNode(5);
        SNode node2 = new SNode(10);
        SNode node3 = new SNode(15);
        SNode node4 = new SNode(20);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node3);
        node4.setNext(node4);
        assert node1.getNext() == node2;
        assert node2.getNext() == node4;
        assert node4.getNext() == node3;

        // `getData()` to retrieve data of `SNode` object
        SNode node = new SNode(5);
        assert node.getData() == 5;

        // `setData()` to set data of `SNode` object
        SNode node = new SNode(5);
        node.setData(10);
        assert node.getData() == 10;

        // `getNext()` to retrieve `SNode` object in SLL
        SNode node1 = new SNode(5);
        SNode node2 = new SNode(10);
        SNode node3 = new SNode(15);
        node1.setNext(node2);
        node2.setNext(node3);
        assert node1.getNext() == node2;
        assert node2.getNext() == node3;

        // `setNext()` to set next `SNode` object in SLL
        SNode node1 = new SNode(5);
        SNode node2 = new SNode(10);
        SNode node3 = new SNode(15);
        node1.setNext(node2);
        node2.setNext(node3);
        SNode node4 = new SNode(20);
        node2.setNext(node4);
        node4.setNext(node3);
        assert node1.getNext() == node2;
        assert node2.getNext() == node4;
        assert node4.getNext() == node3;
    }
}*/

