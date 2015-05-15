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
    public NodeInt getPrevious() {return previous;}
    public void setNext(NodeInt node) {next = node;}
    public void setPrevious(NodeInt node) {
        previous = node;}

    public int getValue() {return value;}
    public void setValue(int value) {this.value = value;}
}
