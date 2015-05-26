package TxusExtra.Lab.Practice5;
// TODO: move to linear

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * LinkedQueueInt: Linked queue for storing integer values.
 * 
 * @author (PRG - DSIC - ETSINF, curs 2014-15) 
 * @version (curs 2014 - 2015)
 */

public class LinkedQueueInt
    implements Serializable
{
    /** Reference to an object of the {@link NodeInt} class which represents the first item of the queue. */
    private NodeInt first;
    /** Reference to an object of the {@link NodeInt} class which represents the last item of the queue. */
    private NodeInt last;
    /** Integer with the number of items in the queue. */
    private int     size;

    /** Constructor */
    public LinkedQueueInt()
    {
        first = null;
        last  = null;
        size  = 0;
    }

    /** Tell us if the queue is empty.
      *
      * @return  {@code true} if the queue is empty, and {@code false} if the queue contains at least one item.
      */
    public boolean empty()
    {
        return ( first==null && last==null );
    }
    
    /** Enqueues a new integer value.
      *
      * @param value An int value to be added into the queue.
      */    
    public void enqueue( int value )
    {
        if ( this.empty() ) {

            first = last = new NodeInt( value );

        } else {

            NodeInt newNode = new NodeInt( value );
            last.setNext( newNode );
            last = newNode;
        }
        ++size;
    }

    /** 
      * Returns the value of the oldest item.
      * Precondition: !empty()
      *
      * @return The integer value stored at the first position in the queue.
      */
    public int first()
    {
        if ( empty() ) throw new NoSuchElementException( "Queue is empty!" );

        return first.getValue();
    }    
    
    /** 
      * Removes the oldest item and returns its integer value.
      * Precondition: !empty()
      *
      * @return The integer value stored in the removed item.
      */
    public int dequeue()
    {
        if ( empty() ) throw new NoSuchElementException( "Queue is empty!" );

        int value = first.getValue();

        if ( first == last )
            first = last = null;
        else
            first = first.getNext();
        
        --size;
        return value;
    }
        
    /** 
      * Returns the number of items in the queue.
      *
      * @return The number of items in the queue.
      */    
    public int size() { return size; }

    /**
     * Returns a String representing the contents of the queue.
     *
     * @return A reference to an object of the String class.
     */
    public String toString()
    {
        if ( size == 0 ) return " {} ";

        String str=" { " + first.getValue();
        for( NodeInt aux = first.getNext(); aux != null; aux = aux.getNext() ) {
            str += ", " + aux.getValue();
        }
        str += " } ";

        return str;
    }
}
