package queues;

public class circularQueueArr {
    int l = 10;
    int f, r;
    int a[] = new int[l];

    circularQueueArr() {
        f = -1;
        r = -1;
    }

    boolean isEmpty() {
        if (f == -1)
            return true;
        else
            return false;
    }

    boolean isFull() {
        if (f == 0 && r == l - 1) {
            return true;
        }
        if (f == r + 1) {
            return true;
        }
        return false;
    }

    void enqueue(int d) {
        if (isFull()) {
            System.out.println("Full");
        } else {
            if (f == -1)
                f = 0;
            r = (r + 1) % l;
            a[r] = d;
        }
    }

    // Removing an d
    int dequeue() {
        int d;
        if (isEmpty()) {
            System.out.println("Empty");
            return (-1);
        } else {
            d = a[f];
            if (f == r) {
                f = -1;
                r = -1;
            } else {
                f = (f + 1) % l;
            }
            return (d);
        }
    }

    void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Empty");
        } else {
            for (i = f; i != r; i = (i + 1) % l)
                System.out.print(a[i] + " ");
            System.out.println(" ");

        }
    }

    public static void main(String[] args) {

        circularQueueArr q = new circularQueueArr();

        q.dequeue();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);

        q.display();

        q.dequeue();
        q.dequeue();
        q.dequeue();

        q.display();

        q.enqueue(6);
        q.enqueue(10);

        q.display();
        q.enqueue(8);

        q.display();
    }

}