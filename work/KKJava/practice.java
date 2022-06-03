import java.util.*;

public class practice {

    public static void main(String[] args) {
        // System.out.println("Ll: ");
        // LL l = new LL();
        // l.addNode(4);
        // l.addNode(5);
        // l.addNode(6);
        // l.addNode(7);
        // l.addNode(1);

        // l.peek();

        System.out.println("Queues");

        Queues_impl q = new Queues_impl();
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(8);

        q.peek();

        q.dequeue();
        q.dequeue();

        q.peek();

        System.out.println("Stack");

    }
}

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LL {

    Node head = null;
    Node tail = null;

    void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null && tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    void peek() {
        Node current = head;

        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
    }
}

class Queues_impl {
    Node front = null;
    Node rear = null;

    boolean isEmpty() {
        if (front == null && rear == null) {
            return true;
        }
        return false;
    }

    void enqueue(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
        }

        rear = newNode;
    }

    void dequeue() {
        System.out.println(" ");
        if (isEmpty()) {
            System.out.println("not possible");
        } else {
            front = front.next;
        }
    }

    void peek() {
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(" ");

    }
}
