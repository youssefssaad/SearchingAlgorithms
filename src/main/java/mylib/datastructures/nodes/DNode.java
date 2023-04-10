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


public class Main {

    public static void main(String[] args) {

        // DNode object with null data
        DNode node = new DNode(null);
        assert node.getData() == null;

        // DNode object with non-null data
        DNode node = new DNode(5);
        assert node.getData() == 5;

        // Setting prev and next to null
        DNode node = new DNode(5);
        node.setPrev(null);
        node.setNext(null);
        assert node.getPrev() == null;
        assert node.getNext() == null;

        // Setting prev and next to non-null values
        DNode node1 = new DNode(5);
        DNode node2 = new DNode(10);
        node1.setNext(node2);
        node2.setPrev(node1);
        assert node1.getNext() == node2;
        assert node2.getPrev() == node1;

        // Removing DNode object from DLL
        DNode node1 = new DNode(5);
        DNode node2 = new DNode(10);
        DNode node3 = new DNode(15);
        node1.setNext(node2);
        node2.setPrev(node1);
        node2.setNext(node3);
        node3.setPrev(node2);
        node1.setNext(node3);
        node3.setPrev(node1);
        node2.setPrev(null);
        node2.setNext(null);
        assert node1.getNext() == node3;
        assert node3.getPrev() == node1;
        assert node2.getPrev() == null;
        assert node2.getNext() == null;

        // Adding DNode object to DLL
        DNode node1 = new DNode(5);
        DNode node2 = new DNode(10);
        DNode node3 = new DNode(15);
        DNode node4 = new DNode(20);
        node1.setNext(node2);
        node2.setPrev(node1);
        node2.setNext(node3);
        node3.setPrev(node2);
        node4.setPrev(node2);
        node4.setNext(node3);
        node2.setNext(node4);
        node3.setPrev(node4);
        assert node1.getNext() == node2;
        assert node2.getPrev() == node1;
        assert node2.getNext() == node4;
        assert node4.getPrev() == node2;
        assert node4.getNext() == node3;
        assert node3.getPrev() == node4;

        // `getData()` to retrieve data of `DNode` object
        DNode node = new DNode(5);
        assert node.getData() == 5;

        // `setData()` to set data of `DNode` object
        DNode node = new DNode(5);
        node.setData(10);
        assert node.getData() == 10;

        // `getPrev()` to retrieve previous `DNode` object in DLL
        DNode node1 = new DNode(5);
        DNode node2 = new DNode(10);
        DNode node3 = new DNode(15);
        node1.setNext(node2);
        node2.setPrev(node1);
        node2.setNext(node3);
        node3.setPrev(node2);
        assert node2.getPrev() == node1;

        // `setPrev()` to set previous `DNode` object in DLL
        DNode node1 = new DNode(5);
        DNode node2 = new DNode(10);
        DNode node3 = new DNode(15);
        node1.setNext(node2);
        node2.setPrev(node1);
        node2.setNext(node3);
        node3.setPrev(node2);
        DNode node4 = new DNode(20);
        node4.setPrev(node2);
        node2.setPrev(node4);
        node4.setNext(node2);
        node2.setNext(node3);
        assert node4.getNext() == node2;
        assert node2.getPrev() == node4;
        assert node2.getNext() == node3;
        assert node3.getPrev() == node2;

        // `getNext()` to retrieve `DNode` object in DLL
        DNode node1 = new DNode(5);
        DNode node2 = new DNode(10);
        DNode node3 = new DNode(15);
        node1.setNext(node2);
        node2.setPrev(node1);
        node2.setNext(node3);
        node3.setPrev(node2);
        assert node2.getNext() == node3;

        // `setNext()` to set next `DNode` object in DLL
        DNode node1 = new DNode(5);
        DNode node2 = new DNode(10);
        DNode node3 = new DNode(15);
        node1.setNext(node2);
        node2.setPrev(node1);
        node2.setNext(node3);
        node3.setPrev(node2);
        DNode node4 = new DNode(20);
        node4.setPrev(node2);
        node2.setNext(node4);
        node4.setNext(node3);
        node3.setPrev(node4);
        assert node1.getNext() == node2;
        assert node2.getPrev() == node1;
        assert node2.getNext() == node4;
        assert node4.getPrev() == node2;
        assert node4.getNext() == node3;
        assert node3.getPrev() == node4;

    }
}


