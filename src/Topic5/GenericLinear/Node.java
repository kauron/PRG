package Topic5.GenericLinear;

/**
 * Created by baudlord on 4/29/15.
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    Node<T> next, previous;
    T value;

    Node(T value) {
        this(null, null, value);
    }

    Node(Node<T> next, T value) {
        this(null, next, value);
    }

    Node(Node<T> previous, Node<T> next, T value) {
        this.previous = previous;
        this.next = next;
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public boolean hasPrevious() { return previous != null; }
    public boolean hasNext() { return next != null; }

    public Node<T> clone() {
        return new Node<>(previous, next, value);
    }

    public void clearLinks() {
        if (next != null) next.setPrevious(previous);
        if (previous != null) previous.setNext(next);
        next = previous = null;
    }

    @Override
    public int compareTo(Node<T> o) {
        return this.value.compareTo(o.value);
    }
}
