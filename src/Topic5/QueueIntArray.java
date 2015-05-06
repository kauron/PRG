package Topic5;

//circular buffer
public class QueueIntArray {

    private int[] queue;
    //first is the first occupied position, last is the last position used
    private int   first, last;

    public QueueIntArray () {
        this( 10 );
    }

    public QueueIntArray (int size) {
        this.first = 1;
        this.last  = 0;
        this.queue = new int[size];
    }

    public void enqueue (int value) {
        if ( size() == queue.length - 1 ) resize();

        last = (last + 1) % queue.length;
        queue[last] = value;
    }

    public int dequeue () throws Exception {
        if (!isEmpty()) {
            int value = queue[first];
            first = (first + 1) % queue.length;
            return value;
        } else {
            throw new Exception ("There are no elements in the queue");
        }
    }

    public int first () throws Exception {
        if (!isEmpty()) {
            return queue[first];
        } else {
            throw new Exception ("There are no elements in the queue");
        }
    }

    public int size() {return (last - first + queue.length + 1) % queue.length;}
    public boolean isEmpty() {return size() == 0;}

    private void resize() {
        try {
            int[] aux = new int[queue.length * 2];
            int i = 0;
            while (!isEmpty()) aux[i++] = dequeue();
            first = 0;
            last = queue.length - 1;
            queue = aux;
        } catch (Exception e) {
            e.printStackTrace( System.err );
            System.exit(1000);
        }
    }
}