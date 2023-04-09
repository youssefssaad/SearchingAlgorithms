import java.util.*;

public class BFS<T> {
    public List<T> bfs(Map<T, List<T>> adjList, T startNode) {
        List<T> visited = new ArrayList<>();
        Queue<T> queue = new LinkedList<>();
        visited.add(startNode);
        queue.add(startNode);
        while (!queue.isEmpty()) {
            T node = queue.poll();
            System.out.print(node + " ");
            for (T neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return visited;
    }
}

class Main{
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList(3));
        graph.put(3, Arrays.asList(4,5));
        graph.put(4, Arrays.asList());
        graph.put(5, Arrays.asList(6,7));
        graph.put(6, Arrays.asList());
        graph.put(7, Arrays.asList());

        BFS<Integer> bfs = new BFS<>();
        List<Integer> visited = bfs.bfs(graph, 1);

        System.out.println(visited);
    }
}
