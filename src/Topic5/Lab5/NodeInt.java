
package Topic5.Lab5;

import java.io.Serializable;

/**
 * Class <b>NodeInt</b>.
 * 
 * @author (PRG - DSIC - ETSINF, curs 2014-15) 
 * @version (curs 2014 - 2015)
 */

public class NodeInt
    implements Serializable
{
    /** Attribute for storing an integer number. Not declared as private in order to allow direct access in other classes of the same package. */
    private int     value;
    /** Reference to the next node in the list. Not declared as private in order to allow direct access in other classes of the same package. */
    private NodeInt next;
    
    /**  Constructor for creating a <b>NodeInt</b> object with an integer value and connected to another
      *  object which will be the next of this one.
      *
      *  @param value   Integer value to be stored in this node.
      *  @param next    Reference to the next node in the list.
      */
    NodeInt( int value, NodeInt next )
    {
        this.value = value;
        this.next  = next;
    }
    
    /**  Constructor for creating a <b>NodeInt</b> object with an integer value and not connected to a next node.
      *
      *  @param value   Integer value to be stored in this node.
      */
    NodeInt( int value )
    {
        this( value, null );
    }

    /** Getter method for attribute <code>value</code>
      *
      * @return An integer.
      */
    public int getValue() { return value; }

    /** Getter method for attribute <code>next</code>
      *
      * @return A reference to the next node in the linked sequence.
      */
    public NodeInt getNext() { return next; }

    /** Setter method for attribute <code>next</code>
      *
      * @param next A new reference for updating the next node in the linked sequence.
      */
    public void setNext( NodeInt next ) { this.next = next; }
}
