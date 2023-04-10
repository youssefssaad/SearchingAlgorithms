import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class GraphTest {

    @Test
    public void testDijkstra() {
        List<List<Node>> adjList = new ArrayList<>();
        adjList.add(Arrays.asList(new Node(1, 10), new Node(2, 3)));
        adjList.add(Arrays.asList(new Node(2, 1), new Node(3, 2)));
        adjList.add(Arrays.asList(new Node(1, 4), new Node(3, 8), new Node(4, 2)));
        adjList.add(Arrays.asList(new Node(4, 7)));
        adjList.add(new ArrayList<>());

        Graph graph = new Graph(5);
        graph.dijkstra(adjList, 0);

        assertEquals(0, graph.dist[0]);
        assertEquals(7, graph.dist[1]);
        assertEquals(3, graph.dist[2]);
        assertEquals(5, graph.dist[3]);
        assertEquals(Integer.MAX_VALUE, graph.dist[4]);
    }

}
