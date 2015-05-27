package Topic5.GenericLinear;

import Topic5.NodeInt;

public class QueueLinked<T extends Comparable<T>> {

    private Node<T> first, last;
    private int size;

    public QueueLinked() {
        first = null;
        last  = null;
        size  = 0;
    }

    public void enqueue (T value) {
        if (last != null) {
            last.setNext(new Node<T>(value));
            last = last.getNext();
        } else {
            first = last = new Node<T>(value);
        }
        size++;
    }

    public T dequeue () throws Exception {
        if (first != null) {
            T aux = first.getValue();
            first = first.getNext();
            size--;
            if (size == 0) last = null;
            return aux;
        } else {
            throw new Exception("There are no elements in the queue");
        }
    }

    public T first() throws Exception {
        if (first != null) return first.getValue();
        else throw new Exception ("There are no elements in the queue");
    }

    public int size() {return size;}
    public boolean isEmpty() {return 0 == size;}
}
