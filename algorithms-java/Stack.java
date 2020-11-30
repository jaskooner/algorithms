import java.util.Iterator;

/*
pushdown stack (linked-list implementation)
*/

public class Stack<Item> implements Iterable<Item> {

    private Node first; // top of stack (most recently added code)
    private int N; // number of items

    private class Node { // nested class to define nodes
        Item item;
        Node next;

    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) { // add item to top of stack
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop() { // remove item from top of stack
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            return item;
        }

    }

}