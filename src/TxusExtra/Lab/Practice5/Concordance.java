package TxusExtra.Lab.Practice5;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by baudlord on 5/19/15.
 */
public class Concordance {
    private static final String DEFAULT_DELIMITER =
            "[\\p{Space}\\p{Punct}\\p{Digit}¡¿]+";
    private NodeCnc first;
    private NodeCnc last;
    private int size;
    private boolean sorted;
//    private String delimiters;

    public Concordance(Scanner sf, boolean sorted) {
        this(sf, sorted, DEFAULT_DELIMITER);
    }

    public Concordance(Scanner sf, boolean sorted, String delimiters) {
//        this.delimiters = delimiters;
        this.first = this.last = null;
        this.sorted = sorted;
        size = 0;

        for (int i = 1; sf.hasNextLine(); i++) {
            String[] words = sf.nextLine().split(delimiters);

            for (String word : words) {
                if (sorted) insertInOrder(word, i);
                else insert(word, i);
            }
        }

    }

    /**
     * Constructor from a String.
     *
     * @param str Object of the class String with the text for building the concordance.
     */
    public Concordance(String str, boolean sorted) {
        this(str, sorted, DEFAULT_DELIMITER);
    }

    public Concordance(String str, boolean sorted, String delimiters) {
        this(new Scanner(str), sorted, delimiters);
    }

    /**
     * Returns the number of items into the concordance.
     *
     * @return int
     */
    public int size() {
        return size;
    }

    /**
     * Returns whether the concordance is sorted or not.
     *
     * @return boolean
     */
    public boolean isSorted() {
        return sorted;
    }

    /**
     * Returns a String representing the contents of the concordance.
     *
     * @return String The contents of the concordance.
     */
    //public String toString() { }

    /**
     * Insertion into the Concordance.
     * A new word is inserted at the end of the list if it didn't exist, if it
     * already existed, then the line number is inserted into the queue
     * associated with the word.
     *
     * @param pal    String to read words from.
     * @param lineNo Integer containing the line number of the pal string.
     */
    private void insert(String pal, int lineNo) {
        Scanner sp = new Scanner(pal);

        while (sp.hasNext()) {
            if (size == 0) {
                first = last = new NodeCnc(sp.next(), lineNo);
            } else {
                String w = sp.next();
                NodeCnc node = search(w);
                if (node == null) {
                    last.setNext(new NodeCnc(w, lineNo));
                    last = last.getNext();
                } else {
                    node.addLine(lineNo);
                }
            }
        }
    }


    // a.compareTo(b) == -1

    /**
     * Insertion into the Concordance.
     * A new word is inserted in the list in an orderly manner if it didn't
     * exist, if it already existed, then the line number is inserted into the
     * queue associated with the word.
     *
     * @param pal    String to read words from.
     * @param lineNo Line number of the pal string.
     */
    private void insertInOrder(String pal, int lineNo) {
        Scanner sp = new Scanner(pal);

        while (sp.hasNext()) {
            if (size == 0) {
                first = last = new NodeCnc(sp.next(), lineNo);
            } else {
                String w = sp.next();
                NodeCnc node = search(w);
                if (node == null) {
                    // look for appropriate spot

                    last.setNext(new NodeCnc(w, lineNo));
                    last = last.getNext();
                } else {
                    node.addLine(lineNo);
                }
            }
        }
    }

    private NodeCnc search(String pal)
            throws NoSuchElementException {
        if (size == 0) throw new NoSuchElementException();

        NodeCnc current = first;
        while (current != null) {
            if (current.getWord().equals(pal)) return current;
            else current = current.getNext();
        }

        throw new NoSuchElementException();
    }
}
