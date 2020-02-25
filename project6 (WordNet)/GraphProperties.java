import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.CC;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinkedQueue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;

public class GraphProperties {
    private int[] eccentricities;
    private int diameter;
    private int radius;
    private LinkedQueue<Integer> centers;

    // Calculate graph properties for the graph G.
    public GraphProperties(Graph G) {
        CC cc = new CC(G);
        if (cc.count() > 1) {
            throw new IllegalArgumentException("G is not connected");
        }
        eccentricities = new int[G.V()];
        
        for (int v = 0; v < G.V(); v++) {
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, v);
        int longest = Integer.MIN_VALUE;
        for (int w = 0; w < G.V(); w++) {
        if (bfs.distTo(w) > longest) {
        longest = bfs.distTo(w);
        }
        }
        eccentricities[v] = longest;
        }
        centers = new LinkedQueue<Integer>();
        for (int i = 0; i < G.V(); i++) {
        if (eccentricities[i] == radius()) {
        centers.enqueue(i);
        }
        
    }
    }
    
    // Eccentricity of v.
    public int eccentricity(int v) {
        // eccentricity of v = 4 id
        return eccentricities[v];
    }

    // Diameter of G.
    public int diameter() {
        return StdStats.max(eccentricities);
        
    }

    // Radius of G.
    public int radius() {
        return StdStats.min(eccentricities);
    }

    // Centers of G.
    public Iterable<Integer> centers() {
        return centers;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        GraphProperties gp = new GraphProperties(G);
        StdOut.println("Diameter = " + gp.diameter());
        StdOut.println("Radius   = " + gp.radius());
        StdOut.println("Centers  = " + gp.centers());
    }
}
