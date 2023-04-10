import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class DFSTest {

    @Test
    public void testDfs() {
        Map<Character, List<Character>> adjList = new HashMap<>();
        adjList.put('A', Arrays.asList('B', 'C', 'D'));
        adjList.put('B', Arrays.asList('E', 'F'));
        adjList.put('C', Arrays.asList('G'));
        adjList.put('D', Arrays.asList('H'));
        adjList.put('E', new ArrayList<>());
        adjList.put('F', new ArrayList<>());
        adjList.put('G', new ArrayList<>());
        adjList.put('H', new ArrayList<>());

        DFS<Character> dfs = new DFS<>();
        List<Character> result = dfs.dfs(adjList, 'A');

        assertEquals(Arrays.asList('A', 'D', 'H', 'C', 'G', 'B', 'F', 'E'), result);
    }

}
