package mylib.Graphalgo;

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

        DFS<Integer> dfs = new DFS<>();
        List<Integer> visited = dfs.dfs(graph, 1);

        System.out.println(visited);
    }
}
