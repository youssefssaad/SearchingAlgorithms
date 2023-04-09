import java.util.*;

public class DFS<T> {
    public List<T> dfs(Map<T, List<T>> adjList, T startNode) {
        List<T> visited = new ArrayList<>();
        Stack<T> stack = new Stack<>();
        visited.add(startNode);
        stack.push(startNode);
        while (!stack.isEmpty()) {
            T node = stack.pop();
            System.out.print(node + " ");
            for (T neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
        return visited;
    }
}
