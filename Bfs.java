import java.util.Iterator;
import java.util.LinkedList;

class Graph
{
    private int numNodes;
    private LinkedList<Integer> adjacencyList[];

    Graph(int numNodes)
    {
        this.numNodes = numNodes;
        adjacencyList = new LinkedList[numNodes];
        for (int i = 0; i< numNodes; ++i)
            adjacencyList[i] = new LinkedList();
    }

    void BFS(int s)
    {
        boolean visited[] = new boolean[numNodes];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            s = queue.poll();
            System.out.print(s);

            Iterator<Integer> i = adjacencyList[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void addConnection(int v, int w)
    {
        adjacencyList[v].add(w);
    }
}
