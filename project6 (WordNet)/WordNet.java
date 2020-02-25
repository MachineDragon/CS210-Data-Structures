import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdOut;

// An immutable WordNet data type.
public class WordNet {
    private RedBlackBST<String, SET<Integer>> st;
    private RedBlackBST<Integer, String> rst;
    private ShortestCommonAncestor sca;
        //rst, sca
    
    // Construct a WordNet object given the names of the input (synset and
    // hypernym) files.
    public WordNet(String synsets, String hypernyms) {
        st = new RedBlackBST<String, SET<Integer>>();
        rst = new RedBlackBST<Integer, String>();
        In synsetIN = new In(synsets);
        int ID = 0;
        while (!synsetIN.isEmpty()) {
            String[] a = synsetIN.readLine().split(",");
            String[] nouns = a[1].split("\\s");
            ID = Integer.parseInt(a[0]);
            for (String noun : nouns) {
                if (!st.contains(noun)) {
                    st.put(noun, new SET<Integer>());
                    
        }
        st.get(noun).add(ID);
        }
        rst.put(ID, a[1]);
    }
    Digraph G = new Digraph(ID + 1);
    In hypernymIN = new In(hypernyms);
    while (!hypernymIN.isEmpty()) {
        String[] a = hypernymIN.readLine().split(",");
        int x = Integer.parseInt(a[0]);
        for (int i = 1; i < a.length; i++) {
            G.addEdge(x, Integer.parseInt(a[i]));
    }
    }
    sca = new ShortestCommonAncestor(G);
    
    }

    // All WordNet nouns.
    public Iterable<String> nouns() {
        return st.keys();
        
        
    }

    // Is the word a WordNet noun?
    public boolean isNoun(String word) {
        return st.contains(word);
    }

    // A synset that is a shortest common ancestor of noun1 and noun2.
    public String sca(String noun1, String noun2) {
      
       return rst.get(sca.ancestor(st.get(noun1), st.get(noun2)));
    }

    // Distance between noun1 and noun2.
    public int distance(String noun1, String noun2) {
        return sca.length(st.get(noun1), st.get(noun2));
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        String word1 = args[2];
        String word2 = args[3];        
        int nouns = 0;
        for (String noun : wordnet.nouns()) {
            nouns++;
        }
        StdOut.println("# of nouns = " + nouns);
        StdOut.println("isNoun(" + word1 + ") = " + wordnet.isNoun(word1));
        StdOut.println("isNoun(" + word2 + ") = " + wordnet.isNoun(word2));
        StdOut.println("isNoun(" + (word1 + " " + word2) + ") = "
                       + wordnet.isNoun(word1 + " " + word2));
        StdOut.println("sca(" + word1 + ", " + word2 + ") = "
                       + wordnet.sca(word1, word2));
        StdOut.println("distance(" + word1 + ", " + word2 + ") = "
                       + wordnet.distance(word1, word2));
    }
}
