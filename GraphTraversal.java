import java.util.*;
public class GraphTraversal {//O(V + E) time complexity
    List<List<Integer>> adjacencyList;
    public GraphTraversal(int vertices) {
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // Assuming an undirected graph
    }
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.println("DFS Traversal:");
        dfsHelper(start, visited);
        System.out.println();
    }
    void dfsHelper(int vertex, Set<Integer> visited) {
        if (visited.contains(vertex)) return;
        visited.add(vertex);
        System.out.print(vertex + " ");
        for (int neighbor : adjacencyList.get(vertex)) {
            dfsHelper(neighbor, visited);
        }
    }
    public static void main(String[] args) {
        int vertices = 5;
        GraphTraversal graph = new GraphTraversal(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.dfs(0);
    }
}
