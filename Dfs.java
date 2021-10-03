class Graph {
    private int numNodes;

    private LinkedList<Integer> adjacencyList[];

    public Graph(int numNodes)
    {
        this.numNodes = numNodes;
        adjacencyList = new LinkedList[numNodes];
        for (int i = 0; i < numNodes; ++i)
            adjacencyList[i] = new LinkedList();
    }

    void dfs(int node, boolean visited[])
    {
        visited[node] = true;
        System.out.print(node);

        Iterator<Integer> i = adjacencyList[node].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                dfs(n, visited);
        }
    }

    void dfsVisit(int v)
    {
        boolean visited[] = new boolean[numNodes];
        dfs(v, visited);
    }
}
