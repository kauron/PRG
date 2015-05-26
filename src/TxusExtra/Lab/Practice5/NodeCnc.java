package TxusExtra.Lab.Practice5;

import java.io.Serializable;
import linear.*;

/**
 * Class <b>NodeCnc</b>
 * 
 * @author (PRG - DSIC - ETSINF 2014-2015) 
 * @version 2015
 */

public class NodeCnc
    implements Serializable {
    public String word;
    public LinkedQueueInt numbersOfLines;
    public NodeCnc next;

    /**
     * Creates a new <b>NodeCnc</b> object with the word and connected to the next node in the list.
     *
     * @param word <b>String</b> object with the word for this node.
     * @param num  Line number where an ocurrence of this word has been found.
     * @param next Reference to the next node in the concordance.
     */
    NodeCnc(String word, int num, NodeCnc next) {
        this.word = word;
        this.numbersOfLines = new LinkedQueueInt();
        this.numbersOfLines.enqueue(num);
        this.next = next;
    }

    /**
     * Creates a new <b>NodeCnc</b> object with the word and not connected to another node.
     *
     * @param word <b>String</b> object with the word for this node.
     * @param num  Line number where an ocurrence of this word has been found.
     */
    NodeCnc(String word, int num) {
        this(word, num, null);
    }

    void setNext(NodeCnc next) {
        this.next = next;
    }

    NodeCnc getNext() {
        return next;
    }

    String getWord() {
        return word;
    }

    void addLine(int i){
        numbersOfLines.enqueue(i);
    }
}
