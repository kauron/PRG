package Topic5;

public class StackIntLinked {
    private NodeInt top;
    private int size;

    public StackIntLinked () {
        top = null;
        size = 0;
    }

    public void push ( int value ) {
        top =  new NodeInt (value, top);
        size++;
    }

    public int pop () throws StackUnderflowException {
        if ( top != null ) {
            int lastTop = top.getValue();
            top = top.getNext();
            size--;
            return lastTop;
        } else {
            throw new StackUnderflowException("There are no elements in this stack");
        }
    }

    public int top () throws StackUnderflowException {
        if ( top != null )
            return top.getValue();
        else
            throw new StackUnderflowException("There are no elements in this stack");
    }

    public int size () {return size;}
    public boolean isEmpty() {return top == null;}
}