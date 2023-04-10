import org.junit.Test;
import static org.junit.Assert.*;

public class CSLLTest {

    @Test
    public void testInsertHead() {
        CSLL list = new CSLL();
        SNode node = new SNode(1);
        list.insertHead(node);
        assertEquals(list.search(node), node);
    }

    @Test
    public void testInsertTail() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        assertEquals(list.search(node3), node3);
    }

    @Test
    public void testInsert() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insert(node1, 0);
        list.insert(node2, 1);
        list.insert(node3, 1);
        assertEquals(list.search(node3), node3);
    }

    @Test
    public void testSortedInsert() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.sortedInsert(node2);
        list.sortedInsert(node1);
        list.sortedInsert(node3);
        assertEquals(list.search(node3), node3);
    }

    @Test
    public void testDeleteHead() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.deleteHead();
        assertEquals(list.search(node1), null);
    }

    @Test
    public void testDeleteTail() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.deleteTail();
        assertEquals(list.search(node3), null);
    }

    @Test
    public void testDelete() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.delete(node2);
        assertEquals(list.search(node2), null);
    }

    @Test
    public void testSort() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(3);
        SNode node2 = new SNode(1);
        SNode node3 = new SNode(2);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.sort();
        assertTrue(list.isSorted());
    }
}
