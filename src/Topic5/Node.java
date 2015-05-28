package Topic5;

public class Node<T> {
    private T value;
    private Node next, previous;

    public Node(T value) {
        this(value, null);
    }

    public Node(T value, Node next) {
        this(null, value, next);
    }

    public Node(Node previous, T value) {
        this(previous, value, null);
    }

    public Node(Node previous, T value, Node next) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node node) {
        next = node;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node node) {
        previous = node;}

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void clearLinks() {
        this.next = null;
        this.previous = null;
    }

    @Override
    public String toString() {
        return String.format(
                "%s - %d - %s",
                this.previous == null ? "null" : this.previous.getValue(),
                this.value,
                this.next == null ? "null" : this.next.getValue()
        );
    }

    public void linkBefore(Node node) {
        node.clearLinks();

        node.setNext(this); //link the node with this
        if (previous != null) {
            node.setPrevious(previous); //link the node with the previous
            previous.setNext(node); //link the previous with the node
        }
        this.setPrevious(node); // link this with the node
    }

    public void linkAfter(Node node) {
        node.clearLinks();

        node.setPrevious(this); //link the node with this
        if (next != null) {
            node.setNext(next); //link the node with the next
            next.setPrevious(node); //link the next with the node
        }
        this.setNext(node); // link this with the node
    }

    public void breakPreviousLink() {
        if (this.previous != null) {
            previous.setPrevious(null);
            this.previous = null;
        }
    }
}
