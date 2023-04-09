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
        DNode node1 = new DNode(null);
        assert node1.getData() == null;

        // DNode object with non-null data
        DNode node2 = new DNode(5);
        assert node2.getData() == 5;

        // Setting prev and next to null
        DNode node3 = new DNode(5);
        node3.setPrev(null);
        node3.setNext(null);
        assert node3.getPrev() == null;
        assert node3.getNext() == null;

        // Setting prev and next to non-null values
        DNode node4 = new DNode(5);
        DNode node5 = new DNode(10);
        node4.setNext(node5);
        node5.setPrev(node4);
        assert node4.getNext() == node5;
        assert node5.getPrev() == node4;

        // Removing DNode object from DLL
        DNode node6 = new DNode(5);
        DNode node7 = new DNode(10);
        DNode node8 = new DNode(15);
        node6.setNext(node7);
        node7.setPrev(node6);
        node7.setNext(node8);
        node8.setPrev(node7);
        node6.setNext(node8);
        node8.setPrev(node6);
        node7.setPrev(null);
        node7.setNext(null);
        assert node6.getNext() == node8;
        assert node8.getPrev() == node6;
        assert node7.getPrev() == null;
        assert node7.getNext() == null;

        // Adding DNode object to DLL
        DNode node9 = new DNode(5);
        DNode node10 = new DNode(10);
        DNode node11 = new DNode(15);
        DNode node12 = new DNode(20);
        node9.setNext(node10);
        node10.setPrev(node9);
        node10.setNext(node11);
        node11.setPrev(node10);
        node12.setPrev(node10);
        node12.setNext(node11);
        node10.setNext(node12);
        node11.setPrev(node12);
        assert node9.getNext() == node10;
        assert node10.getPrev() == node9;
        assert node10.getNext() == node12;
        assert node12.getPrev() == node10;
        assert node12.getNext() == node11;
        assert node11.getPrev() == node12;

        // `getData()` to retrieve data of `DNode` object
        DNode node13 = new DNode(5);
        assert node13.getData() == 5;

        // `setData()` to set data of `DNode` object
        DNode node14 = new DNode(5);
        node14.setData(10);
        assert node14.getData() == 10;

        // `getPrev()` to retrieve previous `DNode` object in DLL
        DNode node15 = new DNode(5);
        DNode node16 = new DNode(10);
        DNode node17 = new DNode(15);
        node15.setNext(node16);
        node16.setPrev(node15);
        node16.setNext(node17);
        node17.setPrev(node16);
        assert node16.getPrev() == node15;

        // `setPrev()` to set previous `DNode` object in DLL
        DNode node17 = new DNode(5);
        DNode node18 = new DNode(10);
        DNode node19 = new DNode(15);
        node17.setNext(node18);
        node18.setPrev(node17);
        node18.setNext(node19);
        node19.setPrev(node18);
        DNode node20 = new DNode(20);
        node20.setPrev(node18);
        node18.setPrev(node20);
        node20.setNext(node18);
        node18.setNext(node19);
        assert node20.getNext() == node18;
        assert node18.getPrev() == node20;
        assert node18.getNext() == node19;
        assert node19.getPrev() == node18;

        // `getNext()` to retrieve `DNode` object in DLL
        DNode node21 = new DNode(5);
        DNode node22 = new DNode(10);
        DNode node23 = new DNode(15);
        node21.setNext(node22);
        node22.setPrev(node21);
        node22.setNext(node23);
        node23.setPrev(node22);
        assert node22.getNext() == node23;

        // `setNext()` to set next `DNode` object in DLL
        DNode node24 = new DNode(5);
        DNode node25 = new DNode(10);
        DNode node26 = new DNode(15);
        node24.setNext(node25);
        node25.setPrev(node24);
        node25.setNext(node26);
        node26.setPrev(node25);
        DNode node27 = new DNode(20);
        node27.setPrev(node25);
        node25.setNext(node27);
        node27.setNext(node26);
        node26.setPrev(node27);
        assert node24.getNext() == node25;
        assert node25.getPrev() == node24;
        assert node25.getNext() == node27;
        assert node27.getPrev() == node25;
        assert node27.getNext() == node26;
        assert node26.getPrev() == node27;

    }
}


