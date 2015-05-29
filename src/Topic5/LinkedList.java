package Topic5;

import java.util.NoSuchElementException;

/**
 * Class to manage a list of integer numbers stored as NodeInt
 * Provides funtionality to add, remove, search and sort
 * The position in which most operations apply is the cursor
 * However, there are some operations that are independent, such as
 * sorting, searching, adding/deleting at the end/beginning and insertInOrder
 */
public class LinkedList {
    private int size; //number of elements stored in the list
    private NodeInt first, last; //first and last elements of the list, if null, list is empty
    private NodeInt cursor; //current position to which most operations will apply

	/**
	 * Default constructor that intializes an empty list
	 */
    public LinkedList() {
        size = 0;
        first = last = cursor = null;
    }

	/**
	 * Number of elements stored in the list
	 * @return size of the list
	 */
    public int size() {
        return size;
    }

	/**
	 * Checks if there are no elements in the list
	 * @return If size is 0
	 */
    public boolean isEmpty() {
        return size == 0;
    }

	/**
	 * Moves the cursor to the first element in the list
	 * @throws IndexOutOfBoundsException If there are no elements in the list
	 */
    public void begin() throws IndexOutOfBoundsException {
        if (isEmpty())
            throw new IndexOutOfBoundsException("There are no elements");
        else cursor = first;
    }

	/**
	 * Moves the cursor to the last element in the list
	 * @throws IndexOutOfBoundsException If there are no elements in the list
	 */
    public void end() throws IndexOutOfBoundsException {
        if (isEmpty())
            throw new IndexOutOfBoundsException("There are no elements");
        else cursor = last;
    }

	/**
	 * Moves the cursor to the next element in the list
	 * This method can go to the next element of the last element (null)
	 * @throws IndexOutOfBoundsException If the position is invalid
	 */
    public void next() throws IndexOutOfBoundsException {
        if (!isValid())
            throw new IndexOutOfBoundsException("You have reached the end");
        else cursor = cursor.getNext();
    }

	/**
	 * Moves the cursor to the previous element in the list
	 * This method can go to the previous element of the first element (null)
	 * @throws IndexOutOfBoundsException If the position is invalid
	 */
    public void previous() throws IndexOutOfBoundsException {
        if (!isValid())
            throw new IndexOutOfBoundsException("You have reached the beginning");
        else cursor = cursor.getPrevious();
    }

	/**
	 * Checks if the current position is a valid NodeInt object reference
	 * @return If the cursor is null
	 */
    public boolean isValid() {
        return cursor != null;
    }

	/**
	 * Gets the value of the cursor
	 * @throws NoSuchElementException If the position is invalid the value cannot be accessed
	 * @return The value of the current element
	 */
    public int get() throws NoSuchElementException {
        if (!isValid())
            throw new NoSuchElementException("The current position is invalid!");
        else return cursor.getValue();
    }

	/**
	 * Changes the value of the cursor
	 * @param value New value to be set
	 * @throws NoSuchElementException If the position is invalid the value cannot be updated
	 */
    public void update(int value) throws NoSuchElementException {
        if (!isValid())
            throw new NoSuchElementException("The current position is invalid!");
        else cursor.setValue(value);
    }

	/**
	 * Adds a value before the current position of the list
	 * If the position is invalid, the value will be inserted at the end
	 * @param value Number to be inserted
	 */
    public void insert(int value) { insert(new NodeInt(value)); }

	/**
	 * Adds a node before the current position of the list
	 * If the position is invalid, the value will be inserted at the end
	 * @param node NodeInt to be inserted
	 */
    public void insert(NodeInt node) {
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

	/**
	 * Adds a value at the beginning of the list
	 * Cost \Theta (1)
	 * @param value Number to be inserted
	 */
    public void addBeginning(int value) {
		addBeginning(new NodeInt(value));
	}

	/**
	 * Adds a node at the beginning of the list
	 * Cost \Theta (1)
	 * @param node NodeInt to be inserted
	 */
    public void addBeginning(NodeInt node) {
    	if(!isEmpty()) begin();
		insert(node);
	}

	/**
	 * Adds a value at the end of the list
	 * Cost \Theta (1)
	 * @param value Number to be inserted
	 */
    public void addEnd(int value) {
        addEnd(new NodeInt(value));
    }

	/**
	 * Adds a node at the end of the list
	 * Cost \Theta (1)
	 * @param node NodeInt to be inserted
	 */
    public void addEnd(NodeInt node) {
        cursor = null;
        insert(node);
    }

	/**
	 * Removes the first appearance of the value passed as parameter from the list
	 * Cost \Theta (n)
	 * @param value Number to be searched and removed
	 * @throws NoSuchElementException If the element is not found it can't be eliminated
	 */
    public void remove(int value) throws NoSuchElementException {
        cursor = search(value);
        if (isValid())
            remove();
        else
            throw new NoSuchElementException("The element " + value + " doesn't exist");
    }


	/**
	 * Removes the value the cursor is pointing at right now,
	 * if the cursor is null the last element will be removed
	 * Cost \Theta (1)
	 * @throws IndexOutOfBoundsException If the list is empty no value can be elminated
	 */
    public void remove() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException("The list is empty!");
        if (!isValid())
            throw new NoSuchElementException("You are in an invalid position!");

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

	/**
	 * Removes the first value of the list
	 * Cost \Theta (1)
	 * @throws IndexOutOfBoundsException If the list is empty there is no first value to eliminate
	 */
    public void removeBeginning() throws IndexOutOfBoundsException {
        begin();
        remove();
    }

	/**
	 * Removes the last value of the list
	 * Cost \Theta (1)
	 * @throws IndexOutOfBoundsException If the list is empty there is no last value to eliminate
	 */
    public void removeEnd() throws IndexOutOfBoundsException {
        end();
        remove();
    }

	/**
	 * Inserts a new value passed as parameter in order
	 * Cost \Theta (n)
	 * @param value The number to be inserted. 
	 */
    public void insertInOrder(int value) {
        insertInOrder(new NodeInt(value));
    }

	/**
	 * Inserts a new NodeInt passed as parameter in order
	 * Cost \Theta (n)
	 * @param node The node to be inserted. 
	 * It doesn't matter if it is linked with others, they will be ignored
	 */
    public void insertInOrder(NodeInt node) {
        if (!isEmpty()) {
            begin();
            while (isValid() && cursor.getValue() < node.getValue()) next();
        }
        insert(node);
    }

	/**
	 * Looks for an element in the list
	 * This method is not affected by the position of the cursor
	 * Cost \Theta (n)
	 * @param value Integer to search for
	 * @return The NodeInt containing the first occurrence of the value inside the list
	 */
    public NodeInt search(int value) {
        for (NodeInt temp = first; temp != null; temp = temp.getNext())
            if (temp.getValue() == value) return temp;
        return null;
    }

	/**
	 * Builds a String representing the LinkedList using the following format
	 * [size:current] { element1, element2, element3, element4, element5 }
	 * Cost \Theta (n)
	 * @return String representing the list
	 */
    @Override
    public String toString() {
        String s = String.format("[%d:%s] { ", size, cursor == null ? "null" : cursor.getValue());
        for (NodeInt temp = first; temp != null; temp = temp.getNext())
            s += String.format("%d%s ", temp.getValue(), temp.getNext() != null ? "," : "");
        s += "}";

        return s;
    }

	/**
	 * Generates a new LinkedList exactly equal to this one
	 * The cursor in this list will remain unchanged
	 * The cursor in the cloned list will be the first element
	 * Cost \Theta (n)
	 * @return Cloned list with the same elements
	 */
    @Override
    public LinkedList clone() {
        LinkedList aux = new LinkedList();
        for (NodeInt temp = first; temp != null; temp = temp.getNext())
            aux.addEnd(temp.getValue());
        aux.begin();
        return aux;
    }

	/**
	 * Sorts the list using the insertionSort algorithm
	 * Cost \Theta (n^2)
	 */
    public void insertionSort() {
        if (size < 2) return; //a list with size 1 or 0 is always sorted

        NodeInt current = first.getNext();
		//beginning with the second element, move it back to the proper place
		//Then get the next unsorted element and do the same until the end is reached
        while (current != null) {
            NodeInt nextNode = current.getNext(); //this keeps the next UNSORTED element
            if (current.getValue() < current.getPrevious().getValue()) {
                cursor = current;
                remove();
                while (cursor != first && current.getValue() < cursor.getPrevious().getValue())
                    cursor = cursor.getPrevious();
                insert(current);
            }
//            System.out.println(this); for testing
            current = nextNode;
        }
//        System.out.println(); for testing
    }

	/**
	 * Sorts a the list using the mergeSort algorithm
	 * Cost \Theta (nlog(n))
	 */
    public void mergeSort() {
        if (size < 2) return; //a list with size 1 or 0 is always sorted
        begin();
        cursor = first = mergeSort(cursor, size); //call the private sorting method
		//once the list is sorted it must be set back to its place
        NodeInt aux = first;
		//this is necesary to place properly 'last'
        while (aux.getNext() != null) aux = aux.getNext();
        last = aux;

    }

	/**
	 * Sorts a list given its first element and its size
	 * Recursive method, cost \Theta (nlog(n))
	 * Note that the nodes are not destroyed and regenerated to avoid
	 * overloading the garbage collector
	 * @param begin NodeInt, first node of the list to be sorted
	 * @param s Size of the list, in order to compute the middle element
	 * @return NodeInt, The first element of the sorted list
	 */
    private static NodeInt mergeSort(NodeInt begin, int s) {
        if (s < 2) { //trivial case, a list with size 1 or 0 is sorted
            return begin;
        }
        NodeInt half = begin; //find the middle element
        for (int i = 0; i < s / 2; i++) {
            half = half.getNext();
        }
		//cut the links between the middle element (that becomes the head of a new list)
		//and the previous one (the last element of the other list)
        half.getPrevious().setNext(null);
        half.setPrevious(null);
		//merge the result of sorting both sublists
        return naturalMerge(mergeSort(begin, s / 2), mergeSort(half, s - s / 2));
    }

    /**
     * Merges two lists given their first elements (liked to the rest)
	 * Cost \Theta (n)
	 * @param h1 Head of the first list to merge
	 * @param h2 Head of the second list to merge
	 * @return Head of the new list merged from the other two
     */
    private static NodeInt naturalMerge(NodeInt h1, NodeInt h2) {
        NodeInt head = h1; //this keeps the head of the list
		//first merge until the end of the first list is reached
        while (h1.getNext() != null && h2 != null) {
            if (h1.getValue() < h2.getValue()) {
                h1 = h1.getNext();
            } else {
                if (h1 == head) head = h2;
                NodeInt aux = h2;
                h2 = h2.getNext();
                h1.linkBefore(aux);
            }
        }
		
		//then add the elements from list2 to the list1 (after or before the end
        while (h2 != null) {
            NodeInt aux = h2;
            h2 = h2.getNext();
            if (h1.getValue() < aux.getValue()) {
                h1.linkAfter(aux);
                h1 = aux;
            } else {
                if (head == h1) head = aux;
                h1.linkBefore(aux);
            }
        }

        return head;
    }
}
