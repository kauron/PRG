package Topic5;

//circular buffer
public class QueueIntArray {
    private static final String ERROR_NOELEMENTS = "There are no elements in the queue!";
    private static int DEFAULT_SIZE = 100;

    private int[] queue;
    //first is the first occupied position, last is the last position used + 1
    private int first, last;

    public QueueIntArray() {
        this(DEFAULT_SIZE);
    }

    public QueueIntArray(int size) {
        this.first = 0;
        this.last = 0;
        this.queue = new int[size];
    }

    public void enqueue(int value) {
        if (size() == queue.length - 1) resize();
        queue[last] = value;
        last = (last + 1) % queue.length;
    }

    public int dequeue() throws Exception {
        if (!isEmpty()) {
            int value = queue[first];
            first = (first + 1) % queue.length;
            return value;
        } else {
            throw new Exception(ERROR_NOELEMENTS);
        }
    }

    public int first() throws Exception {
        if (!isEmpty()) {
            return queue[first];
        } else {
            throw new Exception(ERROR_NOELEMENTS);
        }
    }

    public int size() {
        return (last - first + queue.length /* =1 */) % queue.length;
    } // for first = 1

    public boolean isEmpty() {
        return size() == 0;
    }

    private void resize() {
        int[] t = new int[queue.length + 100];
        System.arraycopy(queue, first, t, 0, queue.length - first - 1);
        System.arraycopy(queue, 0, t, first, first);
    }
}