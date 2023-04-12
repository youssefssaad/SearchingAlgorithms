package mylib.datastructures.linear;


import mylib.datastructures.nodes.SNode;

public class QueueLL extends SLL {
    
    /**
     * Default constructor
     */
    public QueueLL() {
        super();
    }
    
    /**
     * Constructor with a node
     * @param newNode
     */
    public void enqueue(SNode newNode) {
        insertTail(newNode);
    }
    
    /**
     * removes the head from the queue
     */
    public void dequeue() {
        deleteHead();
    }
    
    /**
     * checkes if the queue is empty
     */
    public boolean isEmpty() {
        return getSize() == 0;
    }
    
    /**
     * prints the queue
     */
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
    @Override
    public void insertHead(SNode node) {}

    @Override
    public void insert(SNode node, int index) {}

    @Override
    public void sortedInsert(SNode node) {}

    @Override
    public void deleteTail() {}

    @Override
    public void delete(SNode node) {}

    @Override
    public void sort() {}

    @Override
    public void clear() {}
}

/*public class QueueLinkedListTest {

    @Test
    public void testEnqueue() {
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());
    }
    
    @Test
    public void testDequeue() {
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        int removed = queue.dequeue();
        assertEquals(1, removed);
        assertEquals(2, queue.size());
    }
    
    @Test
    public void testPeek() {
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        int peeked = queue.peek();
        assertEquals(1, peeked);
        assertEquals(3, queue.size());
    }
    
    @Test
    public void testIsEmpty() {
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }
    
    @Test
    public void testClear() {
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.clear();
        assertTrue(queue.isEmpty());
    }
    
    @Test
    public void testPrint() {
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        queue.print();
        String expectedOutput = "1 -> 2 -> 3 -> NULL\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
 */