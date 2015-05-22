package Topic5;

public class NodeInt {
    private int value;
    private NodeInt next, previous;

    public NodeInt(int value) {this ( value , null );}
    public NodeInt(int value, NodeInt next) {this (null, value, next);}
    public NodeInt(NodeInt previous, int value) {this (previous, value, null);}

    public NodeInt(NodeInt previous, int value, NodeInt next) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public NodeInt getNext() {return next;}

    public void setNext(NodeInt node) {next = node;}

    public NodeInt getPrevious() {
        return previous;
    }

    public void setPrevious(NodeInt node) {
        previous = node;}

    public int getValue() {return value;}
    public void setValue(int value) {this.value = value;}

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

    public void linkBefore(NodeInt node) {
        node.clearLinks();

        node.setNext(this); //link the node with this
        if (previous != null) {
            node.setPrevious(previous); //link the node with the previous
            previous.setNext(node); //link the previous with the node
        }
        this.setPrevious(node); // link this with the node
    }

    public void linkAfter(NodeInt node) {
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
