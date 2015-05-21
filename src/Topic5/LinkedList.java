package Topic5;

import java.util.NoSuchElementException;

public class LinkedList {
    private int size;
    private NodeInt first, last;
    private NodeInt cursor;

    public LinkedList() {
        size = 0;
        first = last = cursor = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void begin() throws IndexOutOfBoundsException {
        if (isEmpty()) throw new IndexOutOfBoundsException("There are no elements");
        else cursor = first;
    }

    public void end() throws IndexOutOfBoundsException {
        if (isEmpty()) throw new IndexOutOfBoundsException("There are no elements");
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
        if (!isValid()) throw new NoSuchElementException("The current position is invalid!");
        else return cursor.getValue();
    }

    public void update(int value) throws NoSuchElementException {
        if (!isValid()) throw new NoSuchElementException("The current position is invalid!");
        else cursor.setValue(value);
    }

    public void insert(int value) throws NoSuchElementException {
        insert(new NodeInt(value));
    }

    public void insert(NodeInt node) throws NoSuchElementException {
        node.clearLinks();

        if (isEmpty()) {
            //insert when no elements are present
            first = last = cursor = node;
        } else if (!isValid()) {
            //insert when the cursor is not valid, the elements goes at the end
            node.setPrevious(last);
            last.setNext(node);
            last = cursor = node;
        } else if (cursor == first) {
            //if we are at the first position insert is as first
            node.setNext(first);
            first.setPrevious(node);
            first = cursor = node;
        } else {
            //else insert the element before the current one
            node.setPrevious(cursor.getPrevious());
            node.setNext(cursor);
            cursor.getPrevious().setNext(node);
            cursor.setPrevious(node);
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
        insertInOrder(new NodeInt(value));
    }

    public void insertInOrder(NodeInt node) {
        if (!isEmpty()) {
            begin();
            while (isValid() && cursor.getValue() < node.getValue()) next();
        }
        insert(node);
    }

    public NodeInt search (int value) {
        for (NodeInt temp = first; temp != null; temp = temp.getNext())
            if (temp.getValue() == value) return temp;
        return null;
    }

    @Override
    public String toString() {
        String s = String.format("[%d:%s] { ", size, cursor == null ? "null" : cursor.getValue());
        for (NodeInt temp = first; temp != null; temp = temp.getNext())
            s += String.format("%d%s ", temp.getValue(), temp.getNext() != null ? "," :"");
        s += "}";

        return s;
    }

    @Override
    public LinkedList clone() {
        LinkedList aux = new LinkedList();
        for (NodeInt temp = first; temp != null; temp = temp.getNext())
            aux.addEnd(temp.getValue());
        aux.begin();
        return aux;
    }

    public void insertionSort() {
        if (size < 2) return;

        NodeInt current = first.getNext();

        while (current != null) {
            NodeInt nextNode = current.getNext();
            if (current.getValue() < current.getPrevious().getValue()) {
                cursor = current;
                remove();
                while (cursor != first && current.getValue() < cursor.getPrevious().getValue())
                    cursor = cursor.getPrevious();
                insert(current);
            }
            System.out.println(this);
            current = nextNode;
        }
        System.out.println();
    }
}