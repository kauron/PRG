package Topic5.Lab5;

import java.io.*;
import java.util.Scanner;

public class Concordance implements Serializable {
    private NodeCnc first, last;
    private int     size;
    private boolean sorted;
    private String  delimiters;
    private int     line;

    /**
     * Constructor from an object of the class Scanner
     * @param sf Object of the class Scanner from which loading the text
     *           for building the concordance.
     * @param sorted If true the word list will be sorted in ascending order.
     * @param delimiters Regular expression for performing the separation of words.
     */
    public Concordance ( Scanner sf, boolean sorted, String delimiters ) {
        this.size = 0;
        this.line = 1;
        this.sorted = sorted;
        this.delimiters = delimiters;
        this.first = this.last = null;
        this.add (sf);
    }

    /**
     * Constructor from a String
     * @param str Object of the class String with the text for building the concordance.
     * @param sorted If true the word list will be sorted in ascending order.
     * @param delimiters Regular expression for performing the separation of words.
     */
    public Concordance ( String str, boolean sorted, String delimiters ) {
        this (new Scanner(str), sorted, delimiters);
    }

    public void add (Scanner sf) {
        while (sf.hasNextLine()) {
            String[] words = sf.nextLine().trim().split(delimiters);
            for (String word : words) {
                if (sorted) insertInOrder(word, line);
                else insert(word, line);
            }
            line++;
        }
    }

    public void add (String str) {this.add(new Scanner(str));}

    /**
     * Returns the number of items into the concordance
     * @return int
     */
    public int size () {return size;}

    /** Returns if the concordance is sorted or not
     * @return boolean
     */
    public boolean isSorted () {return sorted;}

    /**
     * Returns a String representing the contents of the concordance
     * @return String the contents of the concordance
     */
    public String toString () {
        String s = "";
        NodeCnc current = first;
        while (current != null) {
            s += current.toString();
            current = current.getNext();
        }

        return s;
    }

    /**
     * Insertion into the Concordance. A new word is inserted at the end of the list
     * if it didn't exist, if it already existed, then the line number is inserted
     * into the queue associated with the word.
     * @param word String
     * @param line int
     */
    private void insert (String word, int line) {
        if (size == 0) {
            first = last = new NodeCnc(word, line);
            size++;
        } else {
            NodeCnc current = first;
            while (current != null) {
                if (current.getWord().equals(word)) {
                    current.addLine(line);
                    return;
                }
                current = current.getNext();
            }
            last.setNext(new NodeCnc(last.getLast(), word, line));
            last = last.getNext();
            size++;
        }
    }

    /**
     * Insertion into the Concordance. A new word is inserted in the list in an orderly
     * manner if it didn't exist, if it already existed, then the line number is inserted
     * into the queue associated with the word.
     * @param word String
     * @param line int
     */
    private void insertInOrder (String word, int line) {
        if (size == 0) {
            first = last = new NodeCnc(word, line);
            size++;
        } else {
            NodeCnc current = first;

            if (word.compareTo(current.getWord()) < 0) { //word comes before current.getWord()
                first.setLast(new NodeCnc(word, line, first));
                first = first.getLast();
                size++;
                return;
            } else if (current.getWord().equals(word)) {
                current.addLine(line);
                return;
            } else {
                current = current.getNext();
            }

            while (current != null) {
                if (word.compareTo(current.getWord()) < 0) { // word comes before current.getWord()
                    //insert an element before the current
                    //current.getLast() != null && current != null always
                    current.getLast().setNext(new NodeCnc(current.getLast(), word, line, current));
                    current.setLast(current.getLast().getNext());
                    size++;
                    return;
                } else if (current.getWord().equals(word)) {
                    current.addLine(line);
                    return;
                }
                current = current.getNext();
            }
            last.setNext(new NodeCnc(last, word, line));
            size++;
            last = last.getNext();
        }
    }

    public void save (String filename) throws Exception {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    new File(filename)
                            )
                    )
            );

            oos.writeObject(this);
        } catch (FileNotFoundException e) {
            if (oos != null) oos.close();
            throw new Exception("The file didn't exist!");
        } catch (IOException e) {
            if (oos != null) oos.close();
            throw new Exception("There was an error with the file");
        } finally {
            if (oos!= null) oos.close();
        }
    }

    public static Concordance load (String filename) throws Exception {
        ObjectInputStream ois = null;
        Concordance concordance = null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File(filename)
                            )
                    )
            );
            Object o = ois.readObject();
            if (o instanceof Concordance) concordance = (Concordance)o;
        } catch (FileNotFoundException e) {
            if (ois != null) ois.close();
            throw new Exception("The file didn't exist!");
        } catch (IOException e) {
            if (ois != null) ois.close();
            throw new Exception("The file didn't exist!");
        } catch (ClassNotFoundException e) {
            ois.close();
            throw new Exception("The file didn't exist!");
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return concordance;
    }
}