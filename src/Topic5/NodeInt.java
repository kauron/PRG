package Topic5;

public class NodeInt {
    private int value;
    private NodeInt next;

    public NodeInt(int value) {this ( value , null );}
    public NodeInt(int value, NodeInt next) {
        this.value = value;
        this.next = next;
    }

    public NodeInt getNext() {return next;}
    public void setNext(NodeInt node) {next = node;}

    public int getValue() {return value;}
}
