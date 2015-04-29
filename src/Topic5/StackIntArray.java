package Topic5;

public class StackIntArray {
    private int[] data;
    /**
     * Integer that indicates the first empty element of the array (max = data.length)
     */
    private int top;

    public StackIntArray () {
        this ( 100 );
    }

    public StackIntArray ( int maxSize ) {
        data = new int[maxSize];
        top = 0;
    }

    /**
     * Takes away the last element of the stack (removes it from memory)
     * @return int the last element of the stack
     * @throws StackUnderflowException
     */
    public int pop () throws StackUnderflowException {
        if ( top != 0 ) return data[--top];
        else throw new StackUnderflowException("There are no elements in the stack");
    }

    /**
     * Add a new int to the array if there is space, if not the array is resized
     * @param value int value to add
     */
    public void push ( int value ) {
        if ( top != data.length ) data[top++] = value;
        else {
            int [] newData = new int[ (data.length + 1) * 2 ];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
            push ( value );
        }
    }

    /**
     * Get the element located at the top of the array
     * @return The top element of the array (without eliminating it)
     * @throws StackUnderflowException
     */
    public int top () throws StackUnderflowException {
        if ( top != 0 ) return data[top - 1];
        else throw new StackUnderflowException("There are no elements in the stack");
    }

    /**
     * @return boolean Whether the array has elements or not
     */
    public boolean isEmpty() {return top == 0;}

    /**
     * @return int Number of elements occupied in the array
     */
    public int size() {return top;}
}
