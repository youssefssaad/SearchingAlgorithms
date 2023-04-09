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
