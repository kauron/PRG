package Topic5.GenericLinear;
import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 * Created by baudlord on 5/13/15.
 */

@SuppressWarnings("unchecked")

public class ListsArray<T> {
    static final String ERROR_EMPTYLIST = "List is currently empty!";
    static final String ERROR_ENDOFLIST = "Reached end of the list!";
    static final String ERROR_INVALIDPOS = "The current position is invalid!";
    static final int DEFAULT_SIZE = 100;
    T[] data;
    int current;
    int size;

    // private final Constructor<? extends T> ctor;

    public ListsArray(Class<T> c) {
        this(c, DEFAULT_SIZE);
    }

    public ListsArray(Class<T> c, int initialLength) {
        data = (T[]) Array.newInstance(c, initialLength); //
        int size = 0;
        int current = -1;
    }

    public String toString() {
        // expected output:
        // [size:current] {e1, e2, e3, ... , en}i
        return "";
    }

    public ListsArray<T> clone() {
        ListsArray<T> out = new ListsArray(data[0].getClass(), data.length);
        System.arraycopy(this.data, 0, out.data, 0, this.data.length - 1);
        out.current = this.current;
        out.size = this.size;
        return out;
    }

    public int size() {
        return size;
    }

    public boolean isValid() {
        return 0 <= current && current < size;
    }

    public boolean isEmpty() {
        return size == 0 || current == -1;
    }

    public boolean isFull() {
        return data.length == size;
    }

    public void insert(T element) {
        if (isFull()) resize();
        if (isEmpty()) {
            data[size++] = element;
            current = 0;
        } else if (!isValid()) {
            data[size++] = element;
            current = size - 1;
        } else {
            shiftToRight(current, size);
            data[current] = element;
            ++current;
        }
    }

    public void remove(T element, int position)
            throws IndexOutOfBoundsException, NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException(ERROR_EMPTYLIST);
        if (!isValid()) throw new NoSuchElementException(ERROR_INVALIDPOS);
    }

    public void push(T element) {
        push(element, current);
    }

    public void push(T element, int position) {
    }

    public void pushEnd(T element) {
    }

    public void remove(T element) {
        remove(element, current);
    }


    public void begin()
            throws IndexOutOfBoundsException {
        if (size == 0) throw new IndexOutOfBoundsException(ERROR_EMPTYLIST);
        current = 0;
    }


    public void next()
            throws IndexOutOfBoundsException {
        ++current;
        if (!isValid()) {
            --current;
            throw new IndexOutOfBoundsException(ERROR_ENDOFLIST);
        }
    }

    public void previous()
            throws IndexOutOfBoundsException {
        --current;
        if (!isValid()) {
            ++current;
            throw new IndexOutOfBoundsException(ERROR_ENDOFLIST);
        }
    }


    public T get()
            throws NoSuchElementException {
        if (!isValid()) throw new NoSuchElementException(ERROR_INVALIDPOS);

        return data[current];
    }

    public void update(T element)
            throws NoSuchElementException {
        if (!isValid()) throw new NoSuchElementException(ERROR_INVALIDPOS);

        data[current] = element;
    }

    public void resize() {
        T[] aux = (T[]) Array.newInstance(data[0].getClass(), data.length+DEFAULT_SIZE);
        System.arraycopy(data, 0, aux, 0, data.length);
        data = aux;
    }

    public void shiftToRight(int from, int to) {
        System.arraycopy(data, to, data, to+1, from-to);
    }

    public void shiftToLeft(int from, int to) {
        System.arraycopy(data, to, data, to-1, from-to);
    }
}

