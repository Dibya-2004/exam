import java.util.Arrays;

public class Dikshtra {
	public int minDist(int dist[], boolean[] visited) {
		int minVertex = -1;
		for (int i = 0; i < dist.length; i++) {
			if (!visited[i] && (minVertex == -1 || dist[i] < dist[minVertex])) {
				minVertex = i;
			}
		}
		return minVertex;
	}

	public void shortestPath(int graph[][]) {
		int dist[] = new int[5];// 5=no of vertices
		boolean[] visited = new boolean[5];
		int parent[] = new int[5];
		Arrays.fill(parent, -1);
		dist[0] = 0;
		for (int i = 1; i < 4; i++) {
			dist[i] = Integer.MAX_VALUE;// assigning infinity of each
		}
		for (int i = 0; i < 5; i++) {
			int minVertex = minDist(dist, visited);// vertex with min dist
			if (minVertex == -1)
				break;
			// Exploring Neighbours
			visited[minVertex] = true;
			for (int j = 0; j < 5; j++) {
				if (graph[minVertex][j] != 0 && !visited[j] && dist[minVertex] != Integer.MAX_VALUE) {
					int newDist = dist[minVertex] + graph[minVertex][j];
					if (newDist < dist[j]) {
						dist[j] = newDist;
						parent[j] = minVertex;
					}
				}
			}
		}
		// print
		System.out.println("Vertex \t Distance \t Path");
		for (int i = 0; i < 5; i++) {
			System.out.print(i + "\t " + dist[i] + "\t\t ");
			printPath(parent, i);
			System.out.println();
		}

	}

	public void printPath(int parent[], int vertex) {
		if (vertex == -1) {
			return;
		}
		printPath(parent, parent[vertex]);
		if (parent[vertex] != -1) { // Avoid printing -1
			System.out.print(" --> ");
		}
		System.out.print(vertex);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph = new int[][] {
				{ 0, 10, 0, 5, 0 },
				{ 0, 0, 2, 3, 0 },
				{ 0, 0, 0, 0, 4 },
				{ 0, 1, 0, 0, 4 },
				{ 0, 6, 12, 0, 0 }
		};
		Dikshtra d = new Dikshtra();
		d.shortestPath(graph);
	}
}
