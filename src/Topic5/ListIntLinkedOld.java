package Topic5;

public class ListIntLinkedOld {
    private NodeInt first;

    public ListIntLinkedOld() {
        first = null;
    }

    public void insert(int value) {
        NodeInt aux = first, last = null;
        while (aux != null && aux.getValue() < value) {
            last = aux;
            aux = aux.getNext();
        }
        if (last == null) first = new NodeInt(value);
        else last.setNext(new NodeInt(value, aux));
    }

    public NodeInt search (int value) {
        NodeInt aux = first;
        while (aux != null) {
            if (aux.getValue() == value) return aux;
            else aux = aux.getNext();
        }
        return null;

    }

    public void delete (int value) {
        NodeInt aux = first, last = first;
        while (aux != null && aux.getValue() != value){
            last = aux;
            aux = aux.getNext();
        }
        if (aux != null)
            last.setNext(aux.getNext());
    }
}
