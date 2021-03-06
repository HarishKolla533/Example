// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph
import java.util.*;
import java.lang.*;
import java.io.*;

 
class ShortestPath
{
    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    static final int V=9;
    int bz,jk;
    int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }
 
    // A utility function to print the constructed distance array
    void printSolution(int dist[], int n,int fpa[][], int src, int typ)
    {   int arr[] = new int[30]; int min=9999,minv=0;
        int z[] = new int[10];
        
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++)
            {System.out.println(i+" tt "+dist[i]);
            arr[i]=dist[i];
            
            if(dist[i]<min&&dist[i]!=0)
            	{
            		min = dist[i];
            		minv = i;
            	}
            }
        int  temp;
        Scanner s = new Scanner(System.in);
        
        for (int i = 0; i < V; i++) 
        {
            for (int j = i + 1; j < V; j++) 
            {
                if (arr[i] > arr[j]) 
                {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        
        for (int i=0;i<V;i++)
        {   fpa[i][typ]=z[i];
            System.out.println("hmm1");
            
            int yes=getArrayIndex(arr,i);
            
            if(z[yes]>0)
            System.out.println("yes");
            System.out.println(yes+""+arr[i]);
        }
        
        
}
int getArrayIndex(int[] arr,int value) {

        int k=0;
        for(int i=0;i<arr.length;i++){

            if(arr[i]==value){
                k=i;
                break;
            }
        }
    return k;
        
    }
    
 
    // Funtion that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    void dijkstra(int graph[][], int src, int fpa[][], int typ)
    {
        int dist[] = new int[V]; // The output array. dist[i] will hold
                                 // the shortest distance from src to i
 
        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];
 
        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
 
        // Distance of source vertex from itself is always 0
        dist[src] = 0;
 
        // Find shortest path for all vertices
        for (int count = 0; count < V-1; count++)
        {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);
 
            // Mark the picked vertex as processed
            sptSet[u] = true;
 
            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++)
 
                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
 
        // print the constructed distance array
        printSolution(dist, V, fpa, src, typ);
    }
 
    // Driver method
    public static void main (String[] args)
    {
        /* Let us create the example graph discussed above */
        int src,typ;
       int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                   {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                  {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                  {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0}
                                 };
        int fpa[][] = new int[][]{{2,0,1},{2,1,0},{2,1,2},{2,1,1},{2,2,2},{1,0,2},{2,1,0},{1,2,0},{1,0,1}};
        ShortestPath t = new ShortestPath();
        Scanner in = new Scanner(System.in);
        System.out.println("enter Source");
        src=in.nextInt();
        System.out.println("enter type fire:1 Police:2 Ambulance:3");
        typ=in.nextInt();
        t.dijkstra(graph, src, fpa, typ);
    }
}
