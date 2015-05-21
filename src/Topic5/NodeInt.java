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
}
