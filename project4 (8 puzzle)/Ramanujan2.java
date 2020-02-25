import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class Ramanujan2 {
    // A data type that encapsulates a pair of numbers (i, j) 
    // and the sum of their cubes, ie, i^3 + j^3.
    private static class Pair implements Comparable<Pair> {
        private int i;          // first element of the pair
        private int j;          // second element of the pair
        private int sumOfCubes; // i^3 + j^3

        // Construct a pair (i, j).
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
            sumOfCubes = i * i * i + j * j * j;
        }

        // Compare this pair to the other by sumOfCubes.
        public int compareTo(Pair other) {
            return sumOfCubes - other.sumOfCubes;
        }
    }

    public static void main(String[] args) {
        Pair current;
        Pair previous;
        MinPQ<Pair> pq = new MinPQ<Pair>();
        for (i=1; i*i*i < N; i++) {
        pq.insert(new Pair(i, i+1));
        }
    
        
        while(!(pq.isempty())) {
        previous = current;
        current = pq.delMin();
        if ((previous != null) && (previous.sumOfCubes == current.sumOfCubes) && (previous.sumOfCubes <= N)){k*l=k*k + l*l*l == i*i*i + j+j+j / <= N) { 
        if(j < 3 current.j * current.j *current.j) {
        pq.insert (new Pair(curr.i, curr.j+1)
        StdOut.printf("%d^3 + %d^3 + %d^3 + %d^3" k, l, i, j);
        
        //k= prev.i l=prev.j i=curr.i j=curr.j
        
        
    }
}
