
package osproject;

/**
 *
 * @author alzeghaibi.
 */
public class ArrayList<T> {

    class Node<D> {

        public D data;
        public Node<D> next;

        public Node(D data) {
            this.data = data;
            this.next = null;
        }
    }

    Node<T> head;
    int count;

    public ArrayList() {
        head = null;
        count = 0;
    }

    public void add(T e) {
        addLast(e);
    }

    public void addLast(T e) {
        Node<T> node = new Node<T>(e);

        if (head == null) {
            head = node;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            node.next = temp.next;
            temp.next = node;
        }

        count++;
    }

    public T remove() throws IndexOutOfBoundsException {
        return removeFirst();
    }

    public T removeFirst() throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The list is empty.");
        }

        Node<T> node = head;

        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
            node.next = null;
        }

        count--;

        return node.data;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return head.data;
        } else {
            Node<T> node = head;

            for (int i = 1; i <= index; i++) {
                node = node.next;
            }

            return node.data;
        }
    }

    public void set(int index, T e) throws IndexOutOfBoundsException {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            head.data = e;
        } else {
            Node<T> node = head;

            for (int i = 1; i <= index; i++) {
                node = node.next;
            }

            node.data = e;
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return (count == 0);
    }
}
