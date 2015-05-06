package Topic5;

//circular buffer
public class QueueIntArray2 {

    private int[] queue;
    //first is the first occupied position, last is the last position used + 1
    private int   first, last;

    public QueueIntArray2() {
        this( 10 );
    }

    public QueueIntArray2(int size) {
        this.first = 0;
        this.last  = 0;
        this.queue = new int[size];
    }

    public void enqueue (int value) {
        if ( size() == queue.length - 1 ) resize();
        queue[last] = value;
        last = (last + 1) % queue.length;
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

    public int size() {return (last - first + queue.length) % queue.length;}
    public boolean isEmpty() {return size() == 0;}

    private void resize() {
        try {
            int[] aux = new int[queue.length * 2];
            for (int i = 0; !isEmpty(); i++) aux[i] = dequeue();
            first = 0;
            last = queue.length;
            queue = aux;
        } catch (Exception e) {
            e.printStackTrace( System.err );
            System.exit(1000);
        }
    }
}