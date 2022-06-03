package queues;

import java.util.*;

class Solution {

    static class Node {
        int data;
        Node link;
    }

    static class queue {
        Node f, r;
    }

    // Function to create Circular queue
    static void enqueue(queue q, int value) {
        Node temp = new Node();
        temp.data = value;
        if (q.f == null)
            q.f = temp;
        else
            q.r.link = temp;

        q.r = temp;
        q.r.link = q.f;
    }

    static int deQueue(queue q) {
        if (q.f == null) {
            System.out.printf("Queue is empty");
            return Integer.MIN_VALUE;
        }

        int value;
        if (q.f == q.r) {
            value = q.f.data;
            q.f = null;
            q.r = null;
        } else {
            Node temp = q.f;
            value = temp.data;
            q.f = q.f.link;
            q.r.link = q.f;
        }

        return value;
    }

    static void displayQueue(queue q) {
        Node temp = q.f;
        System.out.println("\nElements in Circular Queue are: ");
        while (temp.link != q.f) {
            System.out.println(temp.data);
            temp = temp.link;
        }
        System.out.println(temp.data);
    }

    public static void main(String args[]) {
        queue q = new queue();
        q.f = q.r = null;

        enqueue(q, 14);
        enqueue(q, 22);
        enqueue(q, 6);

        displayQueue(q);

        System.out.println("\nDeleted value = " + deQueue(q));
        System.out.println("\nDeleted value = " + deQueue(q));

        displayQueue(q);

        enqueue(q, 9);
        enqueue(q, 20);
        displayQueue(q);
    }
}