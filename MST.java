
import java.util.Arrays;
public class MST {

    private static final int INF = Integer.MAX_VALUE;

    // Function to find the vertex with the minimum key value
    private int minKey(int[] key, boolean[] mstSet, int V) {
        int min = INF, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Function to construct and print the MST using Prim's algorithm
    public void primMST(int[][] graph, int V) {
        int[] parent = new int[V]; // Array to store constructed MST
        int[] key = new int[V]; // Key values used to pick minimum weight edge
        boolean[] mstSet = new boolean[V]; // To represent set of vertices included in MST

        // Initialize all keys as infinite and mstSet[] as false
        Arrays.fill(key, INF);
        Arrays.fill(mstSet, false);

        key[0] = 0; // Make key 0 so that this vertex is picked as first vertex
        parent[0] = -1; // First node is always the root of MST

        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet, V); // Pick the minimum key vertex
            mstSet[u] = true;

            // Update key values of the adjacent vertices of the picked vertex
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print the MST and its total cost
        printMST(parent, graph, V);
    }

    // Function to print the constructed MST and its total cost
    private void printMST(int[] parent, int[][] graph, int V) {
        int totalCost = 0; // Variable to store MST cost
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            totalCost += graph[i][parent[i]]; // Summing up edge weights
        }
        System.out.println("Total Cost of MST: " + totalCost); // Print total MST cost
    }

    public static void main(String[] args) {
        MST prim = new MST();
        int[][] graph = {
            {0, 1, 0, 4, 0},
            {1, 0, 2, 6, 3},
            {0, 2, 0, 0, 5},
            {4, 6, 0, 0, 7},
            {0, 3, 5, 7, 0}
        };
        int V = graph.length;

        prim.primMST(graph, V);
    }
}
