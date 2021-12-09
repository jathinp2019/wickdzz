package arrays.linearSearch;

import java.util.*;

public class LS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Size: ");
        int size = in.nextInt();

        System.out.println("Target: ");
        int n = in.nextInt();

        int[] arr = new int[size];

        System.out.println("Array i/p : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println("target: " + n);
        System.out.println("index: " + search(arr, n));
    }

    static int search(int[] a, int n) {
        if (a.length == 0) {
            return -1;
        }
        for (int i = 0; i < a.length; i++) {
            if (n == a[i]) {
                return i;
            }
        }
        return -1;
    }
}
