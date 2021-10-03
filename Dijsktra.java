// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph
import java.lang.*;

class Dijsktra {

    static final int numVertices = 12;

    int calcMinDist(int distance[], Boolean set[])
    {
        int min = Integer.MAX_VALUE, minIdx = -1;

        for (int v = 0; v < numVertices; v++)
            if (set[v] == false && distance[v] <= min) {
                min = distance[v];
                minIdx = v;
            }

        return minIdx;
    }

    void dijkstra(int graph[][], int source)
    {
        int distance[] = new int[numVertices];
        Boolean set[] = new Boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            distance[i] = Integer.MAX_VALUE;
            set[i] = false;
        }
        distance[source] = 0;
        for (int count = 0; count < numVertices - 1; count++) {
            int u = calcMinDist(distance, set);
            set[u] = true;
      for (int v = 0; v < numVertices; v++) {
        if (!set[v]
            && graph[u][v] != 0
            && distance[u] != Integer.MAX_VALUE
            && distance[u] + graph[u][v] < distance[v]) {
          distance[v] = distance[u] + graph[u][v];
        }
            }
        }
    }
}

