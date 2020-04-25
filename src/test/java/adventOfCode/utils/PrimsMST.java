package adventOfCode.utils;

public class PrimsMST {
    // Number of vertices in the graph
    private static final int V = 5;
    private static final int INT_MAX = 2147483647;

    // A utility function to find the vertex with
    // minimum key value, from the set of vertices
    // not yet included in MST
    private static int minKey(int[] key, boolean[] mstSet) {
        // Initialize min value
        int min = INT_MAX, min_index = -1;

        for (int v = 0; v < V; v++) {
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }

        return min_index;
    }

    // A utility function to print the
    // constructed MST stored in parent[]
    public static void printMST(int[] parent, int[][] graph) {
        int totalWeight = 0;
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + "-" +  i + "\t" + graph[i][parent[i]]);
            totalWeight += graph[i][parent[i]];
        }
        System.out.println("Total weight: " + totalWeight);
    }

    // Function to construct and print MST for
    // a graph represented using adjacency
    // matrix representation
    public static void primMST(int[][] graph) {
        // Array to store constructed MST
        int[] parent = new int[V];

        // Key values used to pick minimum weight edge in cut
        int[] key = new int[V];

        // To represent set of vertices not yet included in MST
        boolean[] mstSet = new boolean[V];

        // Initialize all keys as INFINITE
        for (int i = 0; i < V; i++) {
            key[i] = INT_MAX;
            mstSet[i] = false;
        }

        // Always include first 1st vertex in MST.
        // Make key 0 so that this vertex is picked as first vertex.
        key[0] = 0;
        parent[0] = -1;  // First node is always root of MST

        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum key vertex from the
            // set of vertices not yet included in MST
            int u = minKey(key, mstSet);

            // Add the picked vertex to the MST Set
            mstSet[u] = true;

            // Update key value and parent index of
            // the adjacent vertices of the picked vertex.
            // Consider only those vertices which are not
            // yet included in MST
            for (int v = 0; v < V; v++) {

                // graph[u][v] is non zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v] > 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // print the constructed MST
        printMST(parent, graph);
    }
}
