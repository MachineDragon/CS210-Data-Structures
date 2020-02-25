import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinkedQueue;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// An immutable data type for computing shortest common ancestors.
public class ShortestCommonAncestor {
    private Digraph G;

    // Construct a ShortestCommonAncestor object given a rooted DAG.
    public ShortestCommonAncestor(Digraph G) {
        this.G = new Digraph(G);
        //or newDiagraph(G)
    }

    // Length of the shortest ancestral path between v and w.
    public int length(int v, int w) {
    
      int ancestor = ancestor(v, w);
       return distFrom(v).get(ancestor) + distFrom(w).get(ancestor);
    }

    // Shortest common ancestor of vertices v and w.
    public int ancestor(int v, int w) {
        int minDist = Integer.MAX_VALUE;
        SeparateChainingHashST<Integer, Integer> vTree = distFrom(v);
        SeparateChainingHashST<Integer, Integer> wTree = distFrom(w);
        int ancestor = -1;
        for (int x : vTree.keys()) {
            if (wTree.contains(x)) {
                int distance = vTree.get(x) + wTree.get(x);
                if (distance < minDist) {
                    minDist = distance;
                    ancestor = x;
        }
        }
        }
        return ancestor;
    }
    

    // Length of the shortest ancestral path of vertex subsets A and B.
    public int length(Iterable<Integer> A, Iterable<Integer> B) {
      // diffrent method ancestor(A,B)
      int[] triad = triad(A, B);
      return distFrom(triad[1]).get(triad[0]) 
      + distFrom(triad[2]).get(triad[0]);

    }

    // A shortest common ancestor of vertex subsets A and B.
    public int ancestor(Iterable<Integer> A, Iterable<Integer> B) {
      int[] triad = triad(A, B);
      return triad[0];
    }
    
        
    // Helper: Return a map of vertices reachable from v and their 
    // respective shortest distances from v.
private SeparateChainingHashST<Integer, Integer> distFrom(int v) {
    
    SeparateChainingHashST<Integer, Integer> st = 
    new SeparateChainingHashST<Integer, Integer>();
    st.put(v, 0);
    //enqueue v
    LinkedQueue<Integer> q = new LinkedQueue<Integer>();
    q.enqueue(v);
    while (!(q.isEmpty())) {
        int i = q.dequeue();
        for (int w : G.adj(i)) {
            if (!(st.contains(w))) {
                st.put(w, st.get(i) + 1);
                q.enqueue(w);
    }
    }
    }
    return st;
    }

    // Helper: Return an array consisting of a shortest common ancestor a 
    // of vertex subsets A and B, and vertex v from A and vertex w from B 
    // such that the path v-a-w is the shortest ancestral path of A and B.
    private int[] triad(Iterable<Integer> A, Iterable<Integer> B) {
        int minLength = Integer.MAX_VALUE;
        int v = -1;
        int w = -1;
        for (int minA : A) {
            for (int minB : B) {
                if (length(minA, minB) < minLength) {
                    minLength =  length(minA, minB);
                    v = minA;
                    w = minB; }
        }
    }
    int[] triad = {ancestor(v, w), v, w};
    return triad;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        ShortestCommonAncestor sca = new ShortestCommonAncestor(G);
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            int length   = sca.length(v, w);
            int ancestor = sca.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }
}
