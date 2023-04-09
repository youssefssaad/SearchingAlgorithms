package mylib.datastructures.linear;


import mylib.datastructures.nodes.SNode;

public class QueueLL extends SLL {
    
    // Constructor to initialize an empty QueueLinkedList
    public QueueLL() {
        super();
    }
    
    // Add element to the back of the queue
    public void enqueue(SNode newNode) {
        insertTail(newNode);
    }
    
    // Remove element from the front of the queue
    public void dequeue() {
        deleteHead();
    }
    
    // Check if the queue is empty
    public boolean isEmpty() {
        return getSize() == 0;
    }
    
    // Print the elements in the queue
    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            SNode currentNode = getHead();
            while (currentNode != null) {
                System.out.print(currentNode.getData() + " ");
                currentNode = currentNode.getNext();
            }
            System.out.println();
        }
    }
}

