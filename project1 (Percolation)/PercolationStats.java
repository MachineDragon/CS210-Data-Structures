import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

// Estimates percolation threshold for an N-by-N percolation system.
public class PercolationStats {
    private long []thresh;
    private int N;
    private int T;

    // Perform T independent experiments (Monte Carlo simulations) on an 
    // N-by-N grid.
    public PercolationStats(int N, int T) {
    if (N <= 0 || T <= 0)

    
        
    
    // Sample mean of percolation threshold.
    public double mean() {
        double u;
		long sum = 0;
		for (int i = 0; i < T; i++)
	}

    // Sample standard deviation of percolation threshold.
    public double stddev() {
        double u = mean();
		double sum = 0;
		for (int i = 0; i < T; i++)
	}

    // Low endpoint of the 95% confidence interval.
    public double confidenceLow() {
	}
    // High endpoint of the 95% confidence interval.
    public double confidenceHigh() {

	}

        
    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(N, T);
        StdOut.printf("mean           = %f\n", stats.mean());
        StdOut.printf("stddev         = %f\n", stats.stddev());
        StdOut.printf("confidenceLow  = %f\n", stats.confidenceLow());
        StdOut.printf("confidenceHigh = %f\n", stats.confidenceHigh());
    }
}
