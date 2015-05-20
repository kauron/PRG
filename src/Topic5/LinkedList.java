package Topic5;

import java.util.NoSuchElementException;

public class LinkedList {
    private int size;
    private NodeInt first, last;
    private NodeInt cursor;

    public LinkedList () {
        size = 0;
        first = last = cursor = null;
    }

    public int size() {return size;}
    public boolean isEmpty() {return size == 0;}

    public void begin() throws IndexOutOfBoundsException {
        if ( isEmpty() ) throw new IndexOutOfBoundsException("There are no elements");
        else cursor = first;
    }

    public void end() throws IndexOutOfBoundsException {
        if ( isEmpty() ) throw new IndexOutOfBoundsException("There are no elements");
        else cursor = last;
    }

    public void next() throws IndexOutOfBoundsException {
        if (!isValid()) throw new IndexOutOfBoundsException("You have reached the end");
        else cursor = cursor.getNext();
    }

    public void previous() throws IndexOutOfBoundsException {
        if (!isValid()) throw new IndexOutOfBoundsException("You have reached the beginning");
        else cursor = cursor.getPrevious();
    }

    public boolean isValid() {
        return cursor != null;
    }

    public int get() throws NoSuchElementException {
        if ( ! isValid() ) throw new NoSuchElementException("The current position is invalid!");
        else return cursor.getValue();
    }

    public void update (int value) throws NoSuchElementException {
        if ( ! isValid() ) throw new NoSuchElementException("The current position is invalid!");
        else cursor.setValue(value);
    }

    public void insert (int value) throws NoSuchElementException {
        if ( isEmpty() ) {
            //insert when no elements are present
            first = last = cursor = new NodeInt(value);
        } else if ( !isValid() ) {
            //insert when the cursor is not valid, the elements goes at the end
            NodeInt aux = new NodeInt(last, value);
            last.setNext(aux);
            last = cursor = aux;
        } else if ( cursor == first ) {
            //if we are at the first position insert is as first
            NodeInt aux = new NodeInt(value, first);
            first.setPrevious(aux);
            first = cursor = aux;
        } else {
            //else insert the element before the current one
            NodeInt aux = new NodeInt(cursor.getPrevious(), value, cursor);
            cursor.getPrevious().setNext(aux);
            cursor.setPrevious(aux);
        }
        size++;
    }

    public void addBeginning(int value) {
        if (!isEmpty()) begin();
        insert(value);
    }

    public void addEnd(int value) {
        cursor = null;
        insert(value);
    }

    public void remove(int value) throws NoSuchElementException {
        cursor = search(value);
        if (isValid())
            remove();
        else
            throw new NoSuchElementException("The element " + value + " doesn't exist");
    }

    public void remove() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException("The list is empty!");
        if (!isValid()) throw new NoSuchElementException("You are in an invalid position!");

        if (size == 1) {
            cursor = first = last = null;
        } else if (cursor == first) {
            first = cursor = cursor.getNext();
            cursor.setPrevious(null);
        } else if (cursor == last) {
            last = cursor = cursor.getPrevious();
            cursor.setNext(null);
        } else {
            cursor.getPrevious().setNext(cursor.getNext());
            cursor.getNext().setPrevious(cursor.getPrevious());
            next();
        }
        size--;
    }

    public void removeBeginning() throws IndexOutOfBoundsException {
        begin();
        remove();
    }

    public void removeEnd() throws IndexOutOfBoundsException {
        end();
        remove();
    }

    public void insertInOrder(int value) {
        if (!isEmpty()) {
            begin();
            while (isValid() && cursor.getValue() < value) next();
        }
        insert(value);
    }

    public NodeInt search (int value) {
        for (NodeInt temp = first; temp != null; temp = temp.getNext())
            if (temp.getValue() == value) return temp;
        return null;
    }

    public String toString() {
        String s = String.format("[%d:%s] { ", size, cursor == null ? "null" : cursor.getValue());
        for (NodeInt temp = first; temp != null; temp = temp.getNext())
            s += String.format("%d%s ", temp.getValue(), temp.getNext() != null ? "," :"");
        s += "}";

        return s;
    }

    public LinkedList clone() {
        LinkedList aux = new LinkedList();
        for (NodeInt temp = first; temp != null; temp = temp.getNext())
            aux.addEnd(temp.getValue());
        aux.begin();
        return aux;
    }
}
