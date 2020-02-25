import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

// An immutable data type for outcast detection.
public class Outcast {
    private WordNet wordnet;
    // Construct an Outcast object given a WordNet object.
    public Outcast(WordNet wordnet) {
        this.wordnet = wordnet;
       //idk String nouns[] = ["apple" , "cat", nouns(), "phone"];
       //idk n = "apple";
    }

    // The outcast noun from nouns.
    public String outcast(String[] nouns) {
    String outcast = "";
        int longest = Integer.MIN_VALUE;
        for (String n : nouns) {
        int sum = 0;
        for (String n2 : nouns) {
        sum += wordnet.distance(n, n2);
    } // i have a problem with brackets
    if (sum > longest) {
    longest = sum;
    outcast = n;
    }
    }
    return outcast;
    }


    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int t = 2; t < args.length; t++) {
            In in = new In(args[t]);
            String[] nouns = in.readAllStrings();
            StdOut.println("outcast(" + args[t] + ") = "
                           + outcast.outcast(nouns));
        }
    }
}
