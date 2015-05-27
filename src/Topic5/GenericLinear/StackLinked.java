package Topic5.GenericLinear;

public class StackLinked<T extends Comparable<T>> {
    private Node<T> top;
    private int size;

    public StackLinked() {
        top = null;
        size = 0;
    }

    public void push ( T value ) {
        top = new Node<T> (top, value);
        size++;
    }

    public T pop () throws Exception {
        if ( top != null ) {
            T lastTop = top.getValue();
            top = top.getNext();
            size--;
            return lastTop;
        } else {
            throw new Exception("There are no elements in this stack");
        }
    }

    public T top () throws Exception {
        if ( top != null )
            return top.getValue();
        else
            throw new Exception("There are no elements in this stack");
    }

    public int size () {return size;}
    public boolean isEmpty() {return top == null;}
}