import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class BFSTest {

    @Test
    public void testBfs() {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(0, Arrays.asList(1, 2));
        adjList.put(1, Arrays.asList(2));
        adjList.put(2, Arrays.asList(0, 3));
        adjList.put(3, Arrays.asList(3));

        BFS<Integer> bfs = new BFS<>();
        List<Integer> result = bfs.bfs(adjList, 2);

        assertEquals(Arrays.asList(2, 0, 3, 1), result);
    }

}
