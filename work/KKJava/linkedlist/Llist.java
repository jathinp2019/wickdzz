package linkedlist;

public class Llist {

    public static void main(String[] args) {
        LL l = new LL();
        l.addNode(5);
        l.addNode(6);
        l.addNode(7);

        l.peek();
    }
}

class Node {
    // a Node consists of a data element and a next pointer
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }

}

class LL {
    // head and tail of LL
    Node t = null;
    Node h = null;

    // adding nodes to LL
    void addNode(int data) {
        Node newNode = new Node(data);

        if (h == null && t == null) {
            h = newNode;
            t = newNode;
        } else {
            t.next = newNode;// new node added to the existing tail

            t = newNode; // tail updated to be in the end
        }
    }

    void peek() {
        Node current = h;

        System.out.println("Linked Lists");

        if (h == null) {
            System.out.println("empty");
        } else {
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
    }
}
