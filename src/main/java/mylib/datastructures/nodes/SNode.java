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

public class Main {

    public static void main(String[] args) {

        // SNode object with null data
        SNode node1 = new SNode(null);
        assert node1.getData() == null;

        // SNode object with non-null data
        SNode node2 = new SNode(5);
        assert node2.getData() == 5;

        // Setting next to null
        SNode node3 = new SNode(5);
        node3.setNext(null);
        assert node3.getNext() == null;

        // Setting next to non-null values
        SNode node4 = new SNode(5);
        SNode node5 = new SNode(10);
        node4.setNext(node5);
        assert node4.getNext() == node5;

        // Removing SNode object from SLL
        SNode node6 = new SNode(5);
        SNode node7 = new SNode(10);
        SNode node8 = new SNode(15);
        node6.setNext(node7);
        node7.setNext(node8);
        node6.setNext(node8);
        node7.setNext(null);
        assert node6.getNext() == node8;
        assert node7.getNext() == null;

        // Adding SNode object to SLL
        SNode node9 = new SNode(5);
        SNode node10 = new SNode(10);
        SNode node11 = new SNode(15);
        SNode node12 = new SNode(20);
        node9.setNext(node10);
        node10.setNext(node11);
        node12.setNext(node11);
        node10.setNext(node12);
        assert node9.getNext() == node10;
        assert node10.getNext() == node12;
        assert node12.getNext() == node11;

        // `getData()` to retrieve data of `SNode` object
        SNode node13 = new SNode(5);
        assert node13.getData() == 5;

        // `setData()` to set data of `SNode` object
        SNode node14 = new SNode(5);
        node14.setData(10);
        assert node14.getData() == 10;

        // `getNext()` to retrieve `SNode` object in SLL
        SNode node15 = new SNode(5);
        SNode node16 = new SNode(10);
        SNode node17 = new SNode(15);
        node15.setNext(node16);
        node16.setNext(node17);
        assert node15.getNext() == node16;
        assert node16.getNext() == node17;

        // `setNext()` to set next `SNode` object in SLL
        SNode node18 = new SNode(5);
        SNode node19 = new SNode(10);
        SNode node20 = new SNode(15);
        node18.setNext(node19);
        node19.setNext(node20);
        SNode node21 = new SNode(20);
        node19.setNext(node21);
        node21.setNext(node20);
        assert node18.getNext() == node19;
        assert node19.getNext() == node21;
        assert node21.getNext() == node20;
    }
}

