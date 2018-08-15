package files.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
 
public class Dijkstra {
    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    private int V; // Size of graph
    public ArrayList<Integer> nPrime = new ArrayList<Integer>();

    public Dijkstra(int v) {
    	V = v;
    }

    public int minDistance(int dist[], Boolean sptSet[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE;
        int min_index = -1;
 		
        for (int v = 0; v < V; v++) {
        	// If shortest path not set yet and distance to node v is less than the current shortest distance 
	        if (sptSet[v] == false && dist[v] <= min) {
	            min = dist[v];
	            min_index = v;
	        }
        }

        return min_index;
    }
 	
    // A utility function to print the constructed distance array
    public void printSolution(int dist[], int n, int src) {
    	System.out.println("Source " + src);
        System.out.println("Vertex   Distance from source 	nPrime");
        for (int i = 0; i < V; i++) {
        	int temp[] = new int[i];
        	for (int j = 0; j < temp.length; j++) {
        		temp[j] = nPrime.get(j);
        	}
            System.out.println(i + "  \t\t  " + dist[i] + "  \t\t 	"   + Arrays.toString(temp));
        }

        System.out.println();
    }
 
    // Funtion that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    public void process(int graph[][], int src) {
        int dist[] = new int[V]; // The output array. dist[i] will hold
                                 // the shortest distance from src to i
        int prev[] = new int[V];
 
        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];
 
        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
 
        // Distance of source vertex from itself is always 0
        dist[src] = 0;
 
        // Find shortest path for all vertices
        for (int count = 0; count < V-1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);
            nPrime.add(u);
 
            // Mark the picked vertex as processed
            sptSet[u] = true;
 
            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++) { 
	            // Update dist[v] only if is not in sptSet, there is an
	            // edge from u to v, and total weight of path from src to
	            // v through u is smaller than current value of dist[v]
	            if (!sptSet[v] && graph[u][v]!=0 && dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][v] < dist[v]) {
	            	dist[v] = dist[u] + graph[u][v];
	            	prev[v] = 0;
	            }

            } 
        }
 
        // print the constructed distance array
        printSolution(dist, V, src);
    }
}