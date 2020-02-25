import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinkedQueue;
import edu.princeton.cs.algs4.StdOut;

// Models a board in the 8-puzzle game or its generalization.
public class Board {
    private int N;
    private final int[][] tiles;
    private int hamming;
    private int manhattan;
    
    // Construct a board from an N-by-N array of tiles, where 
    // tiles[i][j] = tile at row i and column j, and 0 represents the blank 
    // square.
    public Board(int[][] tiles) {
    hamming = 0;
    manhattan = 0;
    N = tiles.length;
    this.tiles = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
            this.tiles[i][j] = tiles[i][j];
    if ((this.tiles[i][j] != 0) && (this.tiles[i][j] != N * i + j + 1)) {
    int colj = ((this.tiles[i][j] - 1) % N);
    int coli = ((this.tiles[i][j] - 1) / N);
        manhattan += (Math.abs(coli - i) + Math.abs(colj - j));      
        hamming++;  
    }
    }
    }
}
    // Tile at row i and column j.
    public int tileAt(int i, int j) {
        return tiles[i][j];
    }
    
    // Size of this board.
    public int size() {
        return N;
    }

    // Number of tiles out of place.
    public int hamming() {
        return hamming;
    }
    

    // Sum of Manhattan distances between tiles and goal.
    public int manhattan() {
    return manhattan;
    }

    // Is this board the goal board?
    public boolean isGoal() {
        return (hamming == 0);
}
    // Is this board solvable?
    public boolean isSolvable() {
        if (N % 2 != 0) {
        if ((inversions()) % 2 != 0) {
        return false; 
        }
        return true;
        }
        if (((inversions() + ((blankPos() - 1) / N) * ((blankPos() - 1) 
        / N) * ((blankPos() - 1) / N)) % 2) == 0) {
        return true;
        }
        return false;
    }
    
    

    // Does this board equal that?
    public boolean equals(Board that) {
        if (this.tiles == that.tiles) {
        return true;
        }
        return false;
        }
        

    // All neighboring boards.
    public Iterable<Board> neighbors() {
    LinkedQueue<Board> q = new LinkedQueue<Board>();
    int blankPos = blankPos();
    int i = (blankPos - 1) / N;
    int j = (blankPos - 1) % N;
    if (i - 1 >= 0) {
    int [][] c = cloneTiles();
    int temp = c[i][j];
    c[i][j] = c[i - 1][j];
    c[i - 1][j] = temp;
    q.enqueue(new Board(c));
    }
    if (j + 1 < N) {
    int [][] c = cloneTiles();
    int temp = c[i][j];
    c[i][j] = c[i][j + 1];
    c[i][j + 1] = temp;
    q.enqueue(new Board(c));
    }
    if (i + 1 < N) {
    int [][] c = cloneTiles();
    int temp = c[i][j];
    c[i][j] = c[i + 1][j];
    c[i + 1][j] = temp;
    q.enqueue(new Board(c));
    }
    if (j - 1 >= 0) {
    int [][] c = cloneTiles();
    int temp = c[i][j];
    c[i][j] = c[i][j - 1];
    c[i][j - 1] = temp;
    q.enqueue(new Board(c));
    }
    return q;
    }

    // String representation of this board.
    public String toString() {
        String s = N + "\n";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s += String.format("%2d", tiles[i][j]);
                if (j < N - 1) {
                    s += " ";
                }
            }
            if (i < N - 1) {
                s += "\n";
            }
        }
        return s;
    }

    // Helper method that returns the position (in row-major order) of the 
    // blank (zero) tile.
    private int blankPos() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
            if (tiles[i][j] == 0) {
            return (N * i + j + 1);
    }
    }
    }
    return -1;
    }

    // Helper method that returns the number of inversions.
    private int inversions() {
    int inversions = 0;
        int[] temp = new int[N*N];
        int x = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
            if (tiles[i][j] != 0) {
            temp[x++] = tiles[i][j];
    }
    }
    }
    
    for (int i = 0; i < temp.length; i++) {
        for (int j = i + 1; j < temp.length; j++) {
        if (temp[i] > temp[j]) {
        inversions++;
        }
        }
        }
        return inversions;
        }

    // Helper method that clones the tiles[][] array in this board and 
    // returns it.
    private int[][] cloneTiles() {
        int[][] clone = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
            clone[i][j] = tiles[i][j];
        }
        }
        return clone;
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
        Board board = new Board(tiles);
        StdOut.println(board.hamming());
        StdOut.println(board.manhattan());
        StdOut.println(board.isGoal());
        StdOut.println(board.isSolvable());
        for (Board neighbor : board.neighbors()) {
            StdOut.println(neighbor);
        }
    }
}
