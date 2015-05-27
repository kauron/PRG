package Topic5.GenericLinear;

public class StackArray {
    // TODO: fix docs
    private int[] data;
    /**
     * Integer that indicates the first empty element of the array (max = data.length)
     */
    private int top;

    public StackArray() {
        this(100);
    }

    public StackArray(int maxSize) {
        data = new int[maxSize];
        top = 0;
    }

    /**
     * Pops the last element of the stack, removing it.
     *
     * @return int the last element of the stack
     * @throws Exception
     */
    public int pop() throws Exception {
        if (top != 0) return data[--top];
        throw new Exception("There are no elements in the stack");
    }

    /**
     * Pushes a new element to the stack, adding it.
     * If the array is full, it's size is increased previously.
     *
     * @param value int value to add to the top of the stack.
     */
    public void push(int value) {
        if (top != data.length) data[top++] = value;
        else {
            int[] newData = new int[(data.length + 1) * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
            push(value);
        }
    }

    /**
     * Returns the element on top of the stack, without removing it.
     *
     * @return int An integer, the last pushed to the stack.
     * @throws Exception
     */
    public int top() throws Exception {
        if (top != 0) return data[top - 1];
        throw new Exception("There are no elements in the stack");
    }

    /**
     * @return boolean Whether the array has elements or not.
     */
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * @return int Number of elements in the stack.
     */
    public int size() {
        return top;
    }
}
