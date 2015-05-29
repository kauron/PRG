package Topic5.GenericLinear;

import java.lang.reflect.Array;

public class Heap<T extends Comparable<T>> {
    private T[] A;
    private int size;
    private boolean maxHeap;

    /**
     * Default constructor, returns a maxHeap of size 100
     */
    public Heap (Class<T> c) {this(c, true);}

    /**
     * Constructor that lets you choose if the heap is a maxHeap or a minHeap
     * @param maxHeap
     */
    public Heap (Class<T> c, boolean maxHeap) {this(c, 100, maxHeap);}

    /**
     * Constructor specifying the maximum size of the Heap
     * @param maxSize
     * @param maxHeap
     */
    public Heap(Class<T> c, int maxSize, boolean maxHeap) {
        this.size = 1;
        this.maxHeap = maxHeap;
        this.A = (T[]) Array.newInstance(c, maxSize);
    }

    public void enqueue (T value) {
        if (size == A.length) {
            T[] aux = (T[]) Array.newInstance(value.getClass(), size + 20);
            System.arraycopy(A, 0, aux, 0, size);
            A = aux;
        }

        A[size] = value;
        int index = size++;
        if (maxHeap) {
            while (index != 1 || A[index].compareTo(A[index/2]) > 0 ) {
                A[index] = A[index/2];
                A[index/2] = value;
                index /= 2;
            }
        } else {
            while (index != 1 || A[index].compareTo(A[index/2]) < 0 ) {
                A[index] = A[index/2];
                A[index/2] = value;
                index /= 2;
            }
        }
    }

    public T dequeue () {
        T value = A[1];
        int index = 1;
        if (maxHeap) {
            while (A[index*2] != null && A[index*2+1] != null) {
                if (A[index*2] == null) {
                    A[index] = A[index*2];
                } else if (A[index*2+1] == null) {
                    A[index] = A[index*2+1];
                } else if (A[index*2].compareTo(A[index*2+1]) > 0) {
                    A[index] = A[index*2];
                    index *= 2;
                } else {
                    A[index] = A[index*2+1];
                    index = index * 2 + 1;
                }
            }
        } else {
            while (A[index*2] != null && A[index*2+1] != null) {
                if (A[index*2] == null) {
                    A[index] = A[index*2];
                } else if (A[index*2+1] == null) {
                    A[index] = A[index*2+1];
                } else if (A[index*2].compareTo(A[index*2+1]) < 0) {
                    A[index] = A[index*2];
                    index *= 2;
                } else {
                    A[index] = A[index*2+1];
                    index = index * 2 + 1;
                }
            }
        }
        A[index] = null;

        return value;
    }
}
