import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Spell {
    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] lines = in.readAllLines();
        in.close();

        // Create an ArrayST<String, String> object called st. 
        ArrayST<String, String> st = new ArrayST<String, String>();

        // For each line in lines, split it into two tokens using
        // "," as delimiter; insert into st the key-value pair
        // (token 1, token 2).
        for (int i = 0; i < lines.length; i++) {
            String []toke = lines[i].split(",");
            st.put(toke[0], toke[1]);
            }
            
        // Read from standard input one line at a time; increment
        // a line number counter; split the line into words using
        // "\\b" as the delimiter; for each word in words, if it
        // exists in st, write the (misspelled) word, its line number, and
        // corresponding value (correct spelling) from st.
        int line = 0;
        while (StdIn.hasNextLine()) {
        line++;
        String q = StdIn.readLine();
        String []seperate = q.split("\\b");
        for (int i = 0; i < seperate.length; i++) {
        if (st.contains(seperate[i])) {
        StdOut.printf("%s:%d -> %s", seperate[i], line, st.get(seperate[i]));
        StdOut.println();
    }
}
}
}
}
