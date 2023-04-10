public class QueueLLTest {

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