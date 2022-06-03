package queues;

import java.util.*;

public class linkedListImpl {
    public static void main(String[] args) {

        System.out.println("LL impl of queues");

        Que q = new Que();

        choice(q);
    }

    static void choice(Que q) {
        System.out.println("Enter choice: 1)add 2)remove 3)print 4)Esc");
        Scanner sc = new Scanner(System.in);

        int ch = sc.nextInt();

        switch (ch) {
            case 1:
                System.out.println("Enter element to be added");
                int e = sc.nextInt();
                q.enqueue(e);
                choice(q);
                break;
            case 2:
                q.dequeue();
                choice(q);
                break;
            case 3:
                q.peek();
                choice(q);
                break;

            case 4:
                break;

            default:
                System.out.println("Wrong entry !");
                choice(q);
                break;
        }
    }
}

class Que {
    // LinkedList l1 = new LinkedList(); (Raw and unsafe type)
    LinkedList<Integer> l1 = new LinkedList<Integer>();
    int f, r;

    Que() {
        // creating the linked list
        f = r = -1;
    }

    void enqueue(int e) {
        if (f == -1 && r == -1) {
            f = r = 0;
        } else {
            r++;
        }

        l1.addLast(e);

    }

    int dequeue() {
        if (f == r) {
            f = r = -1;
        } else if (f == -1 && r == -1) {
            System.out.println("Empty");
            return 0;
        } else {
            f++;
        }

        l1.removeFirst();
        return 0;
    }

    void peek() {
        System.out.println(l1);
    }

}
