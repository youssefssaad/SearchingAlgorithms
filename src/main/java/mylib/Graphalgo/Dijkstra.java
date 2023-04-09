import java.util.*;

class Graph {
    int[] dist;
    Set<Integer> visited;
    PriorityQueue<Node> queue;
    int numVertices;
    List<List<Node> > adjList;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        dist = new int[numVertices];
        visited = new HashSet<Integer>();
        queue = new PriorityQueue<Node>(numVertices, new Node());
    }

    public void dijkstra(List<List<Node> > adjList, int src) {
        this.adjList = adjList;

        for (int i = 0; i < numVertices; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        queue.add(new Node(src, 0));

        dist[src] = 0;

        while (visited.size() != numVertices) {
            int u = queue.remove().node;

            visited.add(u);
            processAdjacentNodes(u);
        }
    }

    private void processAdjacentNodes(int u) {
        int edgeDistance = -1;
        int newDistance = -1;

        for (int i = 0; i < adjList.get(u).size(); i++) {
            Node v = adjList.get(u).get(i);

            if (!visited.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                if (newDistance < dist[v.node]) {
                    dist[v.node] = newDistance;
                }

                queue.add(new Node(v.node, dist[v.node]));
            }
        }
    }
}

class Main{
    public static void main(String arg[])   {
        int numVertices = 5;
        int source = 2;
        List<List<Node>> adjList = new ArrayList<List<Node>>();

        for (int i = 0; i < numVertices; i++) {
            List<Node> item = new ArrayList<Node>();
            adjList.add(item);
        }

        adjList.get(2).add(new Node(1, 4));
        adjList.get(2).add(new Node(3, 5));
        adjList.get(3).add(new Node(1, 1));
        adjList.get(3).add(new Node(2, 2));
        adjList.get(4).add(new Node(2, 6));


        Graph graph = new Graph(numVertices);
        graph.dijkstra(adjList, source);

        System.out.println("The shortest path from source node to other nodes:");
        System.out.println("Source\t\t" + "Node#\t\t" + "Distance");
        for (int i = 0; i < graph.dist.length; i++) {
            System.out.println(source + " \t\t " + i + " \t\t "  + graph.dist[i]);
        }
    }
}

class Node implements Comparator<Node> {
    public int node;
    public int cost;
    public Node() { }

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2)
    {
        if (node1.cost < node2.cost)
            return -1;
        if (node1.cost > node2.cost)
            return 1;
        return 0;
    }
}