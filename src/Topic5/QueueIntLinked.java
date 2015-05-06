package Topic5;

public class QueueIntLinked {
    private NodeInt first, last;
    private int size;

    public QueueIntLinked() {
        first = null;
        last  = null;
        size  = 0;
    }

    public void enqueue (int value) {
        if (last != null) {
            last.setNext(new NodeInt(value));
            last = last.getNext();
        } else {
            first = last = new NodeInt(value);
        }
        size++;
    }

    public int dequeue () throws Exception {
        if (first != null) {
            int aux = first.getValue();
            first = first.getNext();
            size--;
            if (size == 0) last = null;
            return aux;
        } else {
            throw new Exception("There are no elements in the queue");
        }
    }

    public int first() throws Exception {
        if (first != null) return first.getValue();
        else throw new Exception ("There are no elements in the queue");
    }

    public int size() {return size;}
    public boolean isEmpty() {return 0 == size;}
}
