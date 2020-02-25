import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinkedStack;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;
import java.util.Comparator;

// A solver based on the A* algorithm for the 8-puzzle and its generalizations.
public class Solver {
    private MinPQ<SearchNode> pq;
    private LinkedStack<Board> solution;
    private int moves;
    
    
    // Helper search node class.
    private class SearchNode {
        private Board board;
        private int moves;
        private SearchNode previous;

        SearchNode(Board board, int moves, SearchNode previous) {
            this.board = board;
            this.moves = moves;
            this.previous = previous;
        
        }
    }
     
    // Find a solution to the initial board (using the A* algorithm).
    public Solver(Board initial) {
        solution = new LinkedStack<Board>();
        pq = new MinPQ<SearchNode>(new ManhattanOrder());
        pq.insert(new SearchNode(initial, 0, null));
        while (!pq.isEmpty()) {
       SearchNode node = pq.delMin();
       if (node.board.isGoal()) {
        moves = node.moves;
       for (SearchNode x = node; x.previous != null; x = x.previous) {
       solution.push(x.board);
       }
       break;
       } 
       for (Board x : node.board.neighbors()) {
       SearchNode add = new SearchNode(x, node.moves + 1, node);
       pq.insert(add);
    }
    this.moves++;
    }
    }
    
    

    // The minimum number of moves to solve the initial board.
    public int moves() {
        return this.moves;
    }

    // Sequence of boards in a shortest solution.
    public Iterable<Board> solution() {
        return solution;
    }

    // Helper hamming priority function comparator.
    private static class HammingOrder implements Comparator<SearchNode> {
        public int compare(SearchNode a, SearchNode b) {
       if (a.board.hamming() + a.moves > b.board.hamming() + b.moves) {
       return 1;
       }
       else if (a.board.hamming() + a.moves < b.board.hamming() + b.moves) {
       return -1;
       }
       else {
       return 0;
       }
       }
       }
       
    // Helper manhattan priority function comparator.
    private static class ManhattanOrder implements Comparator<SearchNode> {
    public int compare(SearchNode a, SearchNode b) {
        if (a.board.manhattan() + a.moves > b.board.manhattan() + b.moves) {
       return 1;
       }
       else if (a.board.manhattan() + a.moves < b.board.manhattan() + b.moves) {
       return -1;
       }
       else {
       return 0;
       }
       }
       }
       

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        In in = new In(args[0]);
        int N = in.readInt();
        int[][] tiles = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tiles[i][j] = in.readInt();
            }
        }
        Board initial = new Board(tiles);
        if (initial.isSolvable()) {
            Solver solver = new Solver(initial);
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution()) {
                StdOut.println(board);
            }
        }
        else {
            StdOut.println("Unsolvable puzzle");
        }
    }
}
