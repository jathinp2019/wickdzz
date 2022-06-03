package queues;

import java.util.*;

public class arrayImpl {
    public static void main(String[] args) {

        System.out.println("Arr impl of queues");

        ArrQue q = new ArrQue();

        choice(q);
    }

    static void choice(ArrQue q) {
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

class ArrQue {

    int f, r, size = 5;
    int[] arr = new int[size];

    ArrQue() {
        f = r = -1;
    }

    int enqueue(int e) {
        if (f == -1 && r == -1) {
            f = r = 0;
        } else if (r >= size - 1) {
            System.out.println("Full");
            return 0;
        } else {
            r++;
        }

        arr[r] = e;
        return 0;
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

        return 0;
    }

    void peek() {
        for (int i = f; i <= r; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
    }
}
