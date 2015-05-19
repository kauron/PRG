package Topic5.Lab5;

import java.io.Serializable;

/**
 * Class <b>NodeCnc</b>
 * 
 * @author (PRG - DSIC - ETSINF 2014-2015) 
 * @version 2015
 */

public class NodeCnc
    implements Serializable
{
    public String          word;
    public LinkedQueueInt  numbersOfLines;
    public NodeCnc         next, last;
    
    /** Creates a new <b>NodeCnc</b> object with the word and connected to the next node in the list.
      *
      * @param word  <b>String</b> object with the word for this node.
      * @param num   Line number where an ocurrence of this word has been found.
      * @param next  Reference to the next node in the concordance.
      */
    NodeCnc( NodeCnc last, String word, int num, NodeCnc next )
    {
        this.word = word;
        this.numbersOfLines = new LinkedQueueInt();
        this.numbersOfLines.enqueue( num );
        this.next = next;
        this.last = last;
    }

    NodeCnc( String word, int num, NodeCnc next) {this (null, word, num, next);}
    NodeCnc( NodeCnc last, String word, int num) {this (last, word, num, null);}
    
    /** Creates a new <b>NodeCnc</b> object with the word and not connected to another node.
      *
      * @param word  <b>String</b> object with the word for this node.
      * @param num   Line number where an ocurrence of this word has been found.
      */
    NodeCnc( String word, int num )
    {
        this( word, num, null );
    }

    public String toString () {
        return String.format("%30s %s\n", word, numbersOfLines.toString());
    }

    NodeCnc getNext() {return next;}
    NodeCnc getLast() {return last;}
    String getWord() {return word;}

    void addLine(int line) {numbersOfLines.enqueue(line);}
    void setNext(NodeCnc node) {this.next = node;}
    void setLast(NodeCnc node) {this.last = node;}
}
