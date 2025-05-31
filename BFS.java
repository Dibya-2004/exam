import java.util.*;
import java.util.Queue;
import java.util.LinkedList;


public class BFS { // O(V + E) time complexity
    List<List<Integer>> graph;

    public BFS(int vertices) {
        graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to) {
        graph.get(from).add(to);
        graph.get(to).add(from); // Undirected graph
    }

    public void bfs(int start) {
        if (start < 0 || start >= graph.size()) {
            System.out.println("Invalid start node.");
            return;
        }
        
        boolean[] visited = new boolean[graph.size()]; // Keep track of visited nodes
        Queue<Integer> queue = new LinkedList<>(); // Stores the nodes to visit next
        
        queue.add(start);
        visited[start] = true;
        
        System.out.println("BFS Traversal:");
        while (!queue.isEmpty()) {
            int node = queue.poll(); // Remove a node
            System.out.print(node + " ");

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) { // If not visited... visit
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BFS graph = new BFS(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        
        graph.bfs(0); // Start BFS from node 0
    }
}
