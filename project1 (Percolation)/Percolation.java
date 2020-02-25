import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

// Models an N-by-N percolation system.
public class Percolation {
    private int N;
    private int start = 0;
    private int drop;
    private boolean[][]cells;
    private int count = 0;
    private int length;
     private WeightedQuickUnionUF check;
    private WeightedQuickUnionUF response;
   
    // Create an N-by-N grid, with all sites lengthed.
    public Percolation(int N) {
    this.length = N;
    this.cells = new boolean[length][length];
  
    this.drop = (length * length) + 1;
    check = new WeightedQuickUnionUF(length * length + 2);
    response = new WeightedQuickUnionUF(length * length + 2);
    
    for (int i = 0; i < length; i++) {
    check.union(encode(0, i), start);
    response.union(encode(0, i), start);
    }
    
     for (int j = 0; j < length; j++) {
            check.union(encode(N-1, j), drop);
        }
    }


    // Open site (i, j) if it is not open already.
    public void open(int i, int j) {
        
     cells[i][j] = true;
        count += 1;
        if ((i-1) >= 0 && isOpen(i-1, j)) {
            check.union(encode(i, j), encode(i-1, j)); 
            response.union(encode(i, j), encode(i-1, j));
        }
        if ((i+1) < length && isOpen(i+1, j)) {
            check.union(encode(i, j), encode(i+1, j));
            response.union(encode(i, j), encode(i+1, j));
        }
        if ((j-1) >= 0 && isOpen(i, j-1)) {
            check.union(encode(i, j), encode(i, j-1));
            response.union(encode(i, j), encode(i, j-1));
        }
        if ((j+1) < length && isOpen(i, j+1)) {
            check.union(encode(i, j), encode(i, j+1));
            response.union(encode(i, j), encode(i, j+1));
        }

    }

    public boolean isOpen(int i, int j) {
        return cells[i][j];
    }


    public boolean isFull(int i, int j) {
        return response.connected(start, encode(i, j));
    }

    public int numberOfOpenSites() {
        return count;
    }

    
    public boolean percolates() {
        return check.connected(0, drop);
    }

    private int encode(int i, int j) {
         int number = length * i + 1 + j;
        return number;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Percolation perc = new Percolation(N);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        StdOut.println(perc.numberOfOpenSites() + " open sites");
        if (perc.percolates()) {
            StdOut.println("percolates");
        }
        else {
            StdOut.println("does not percolate");
        }
        
        // Check if site (i, j) optionally specified on the command line
        // is full.
        if (args.length == 3) {
            int i = Integer.parseInt(args[1]);
            int j = Integer.parseInt(args[2]);
            StdOut.println(perc.isFull(i, j));
        }
    }
}
