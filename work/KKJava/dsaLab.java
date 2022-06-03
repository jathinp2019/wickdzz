//People are standing in a queue to deposit an amount in a bank.If the amount they deposit is greater than 2 lakh add them to Queue_ privilege else if the amount they deposit is less than sixty thousand add them to Queue_normal. Find the total amount deposited by privileged customers and normal customers separately

import java.util.*;

public class dsaLab {

    public static void main(String[] args) {
        System.out.println("Queues");

        Queues_impl Queue_privilege = new Queues_impl();
        Queues_impl Queue_normal = new Queues_impl();
        Queues_impl Queue_unaccepted = new Queues_impl();

        Scanner sc = new Scanner(System.in);

        System.out.println("No. of inputs: ");
        int n = sc.nextInt();

        System.out.println("Enter amount (in 10K's): ");
        int amt;

        for (int i = 0; i < n; i++) {

            amt = sc.nextInt();
            if (amt > 20) {
                Queue_privilege.enqueue(amt);

            } else if (amt < 6) {
                Queue_normal.enqueue(amt);
            } else {
                Queue_unaccepted.enqueue(amt);
            }
        }

        System.out.println("normal: ");
        Queue_normal.show();

        System.out.println(" ");

        System.out.println("privilege: ");
        Queue_privilege.show();

        System.out.println(" ");

        System.out.println("unnaccepted: ");
        Queue_unaccepted.show();

        System.out.println(" ");

        System.out.println("Sum privilege: ");
        System.out.println(Queue_privilege.sum() + "0000");

        System.out.println("Sum normal: ");
        System.out.println(Queue_normal.sum() + "0000");

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

class Queues_impl {
    Node f = null;
    Node r = null;

    boolean isEmpty() {
        if (f == null && r == null) {
            return true;
        }
        return false;
    }

    void enqueue(int data) {
        Node tempNode = new Node(data);

        if (isEmpty()) {
            f = r = tempNode;
        } else {
            r.next = tempNode;
        }

        r = tempNode;
    }

    void dequeue() {
        System.out.println(" ");
        if (isEmpty()) {
            System.out.println("Not possible");
        } else {
            f = f.next;
        }
    }

    int sum() {
        int sum = 0;
        Node current = f;

        while (current != null) {
            sum += current.data;
            current = current.next;
        }

        return sum;
    }

    void show() {
        Node current = f;

        while (current != null) {
            System.out.print(current.data + "0000 ");
            current = current.next;
        }
    }
}