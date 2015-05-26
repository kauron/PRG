package Topic5.GenericLinear;
import java.util.NoSuchElementException;

/**
 * Created by baudlord on 5/15/15.
 */

public class ListsLinked<T extends Comparable<T>> {
    static final String ERROR_EMPTYLIST = "List is currently empty!";
    static final String ERROR_ENDOFLIST = "Reached end of the list!";
    static final String ERROR_INVALIDPOS = "The cursor position is invalid!";

    private int size;
    private Node<T> first, last, cursor;

    public ListsLinked() {
        size = 0;
        first = last = cursor = null;
    }

    public String toString() {
        // [size:cursor] { e1, e2, ... , eN }
        if (isEmpty()) return String.format("[%s: ] { }", size);
        Node<T> c = cursor;
        // get cursor.index
        int currentIndex = 0;
        if (cursor == last) {
            currentIndex = size() - 1;
        } else if (!(cursor == first)) {
            while (hasPrevious()) {
                try {
                    previous();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    return null;
                }
                currentIndex++;
            }
        }

        String o = String.format("[%s:%s] { ", size, currentIndex);
        try {
            begin();
        } catch (Exception e) {
            System.err.print(e.getMessage());
            return null;
        }

        while (hasNext()) {
            o += String.format("%s ,", cursor.getValue());
        }

        cursor = c;
        return o.substring(0, o.length() - 2) + " }";
    }
    public ListsLinked<T> clone() {
        Node<T> c = cursor;
        if (isEmpty()) return new ListsLinked<T>();

        try {
            begin();
        } catch (Exception e) {
            System.err.print(e.getMessage());
            return null;
        }

        ListsLinked<T> clone = new ListsLinked<>();
        do {
            clone.insert(get());
            try {
                this.next();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (this.hasNext());

        cursor = c;
        return clone;
    }


    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return 0 == size;
    }
    public boolean isValid() {
        return cursor != null;
    }

    public void begin()
            throws Exception {
        if (isEmpty()) throw new Exception(ERROR_EMPTYLIST);
        cursor = first;
    }
    public void end()
            throws Exception {
        if (isEmpty()) throw new Exception(ERROR_EMPTYLIST);
        cursor = last;
    }
   public void previous()
            throws Exception {
        if (!isValid()) throw new Exception(ERROR_INVALIDPOS);
        if (!hasPrevious()) throw new Exception(ERROR_ENDOFLIST);
        cursor = cursor.getNext();
    }
    public void next()
            throws Exception {
        if (!isValid()) throw new Exception(ERROR_INVALIDPOS);
        if (!hasNext()) throw new Exception(ERROR_ENDOFLIST);
        cursor = cursor.getNext();
    }
    public boolean hasPrevious() {
        return cursor.hasPrevious();
    }
    public boolean hasNext() {
        return cursor.hasNext();
    }

    public T get()
            throws NoSuchElementException {
        if (!isValid()) throw new NoSuchElementException(ERROR_INVALIDPOS);
        return cursor.getValue();
    }
    public void update(T value)
            throws NoSuchElementException {
        if (!isValid()) throw new NoSuchElementException(ERROR_INVALIDPOS);
        cursor.setValue(value);
    }

    public void insert(T value){
        insert(new Node<T>(value));
    }
    public void insert(Node<T> node) {
        node.clearLinks();

        if (isEmpty()) {
            first = last = cursor = node;
        } else if (!isValid() || cursor == last) {
            node.setPrevious(last);
            last.setNext(node);
            last = node;
        } else if (cursor == first) {
            node.setNext(first);
            first.setPrevious(node);
            first = node;
        } else {
            cursor.getPrevious().setNext(node);
            cursor.setPrevious(node);
            cursor = node;
        }
        ++size;
    }

    public void insertBeginning(T value)
            throws Exception {
        insertBeginning(new Node<T>(value));
    }
    public void insertBeginning(Node<T> node)
            throws Exception {
        Node<T> c = null;
        if (isValid()) {
            c = cursor;
        }
        if (!isEmpty()) begin();
        insert(node);
        if (c != null) cursor = c;
    }

    public void insertEnd(T value)
            throws Exception{
        insertEnd(new Node<T>(value));
    }
    public void insertEnd(Node<T> node)
            throws Exception {
        Node<T> c = null;
        if (isValid()) {
            c = cursor;
        }
        if (!isEmpty()) end();
        insert(node);
        if (c != null) cursor = c;
    }

    public void remove()
            throws Exception {
        if (isEmpty()) throw new Exception(ERROR_EMPTYLIST);
        if (!isValid()) throw new Exception(ERROR_INVALIDPOS);

        if (1 == size) {
            first = last = cursor = null;
        } else if (cursor == last) {
            cursor = last = last.getPrevious();
            last.setNext(null);
        } else if (cursor == first) {
            cursor = first = first.getNext();
            first.setPrevious(null);
        } else {
            cursor.getNext().setPrevious(cursor.getPrevious());
            cursor = cursor.getPrevious();
            cursor.setNext(cursor.getNext());
        }
        --size;
    }

    public void removeBeginning()
            throws Exception {
        begin();
        remove();
    }
    public void removeEnd()
            throws Exception {
        end();
        remove();
    }

    public Node<T> search(T value) {
        for (Node<T> n = first; n != null; n = n.getNext())
            if (n.getValue().equals(value)) return n;
        return null;
    }

    public void insertInOrder(T value)
            throws Exception {
        if (!isEmpty()) {
            cursor = first;
            while (hasNext() && cursor.getValue().compareTo(value) < 0) next();
        }
        insert(value);
    }

    /* in-place insertionSort() */

    public void insertionSort()
            throws Exception {
        for (Node<T> current = first.getNext();
             current != null;
             current = current.getNext()) {
            for (Node<T> target = current.getNext();
                 target != null;
                 target = target.getPrevious()) {
                if (current.compareTo(first) > 0) {
                    insertBeginning(current);
                    break;
                } else if (current.compareTo(target) > 0) {
                    cursor = target; insert(current);
                    cursor = current; remove();
                    break;
               }
            }
        }
    }

    public void mergeSort()
            throws Exception {

        //sublist 1
        // naturalsplit


        //sublist 2
    }
}