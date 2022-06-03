package queues;

public class raw_LL_Impl {
    public static void main(String[] args) {
        Queues q = new Queues();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        q.peek();

        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();

        q.peek();
    }
}

class Node {

    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
    // creating a node with (data,next)
}

class Queues {
    Node f = null, r = null;

    int enqueue(int d) {
        Node newNode = new Node(d);

        if (f == null && r == null) {
            f = newNode;
            r = newNode;
            // pointing to the first added node
        } else {
            r.next = newNode; // adding the newNode to existing rear
            r = newNode; // updating rear to be in the end
        }
        return 0;
    }

    int dequeue() {
        if (f == null) {
            System.out.println("\nEmpty");
            return 0;
        } else {
            Node t = f; // storing front value to temp variable
            f = f.next; // incrementing front to next value
        }

        if (f == null) {
            r = null;
        }
        return 0;
    }

    void peek() {
        Node current = f;

        System.out.println(" ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

}