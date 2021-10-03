class BellmanFord {

    class Edge {
        int src, dest, weight;
        Edge()
        {
            src = dest = weight = 0;
        }
    };

    int numVertices, numEdges;
    Edge edge[];

    BellmanFord(int numVertices, int numEdges)
    {
        this.numVertices = numVertices;
        this.numEdges = numEdges;
        edge = new Edge[numEdges];
        for (int i = 0; i < numEdges; ++i)
            edge[i] = new Edge();
    }

    void bellmanFord(Graph graph, int source)
    {
        int V = graph.numVertices, E = graph.numEdges;
        int dist[] = new int[V];

        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[source] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].src;
            int v = graph.edge[j].dest;
            int weight = graph.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Neg wt cycle");
                return;
            }
        }
    }

}
