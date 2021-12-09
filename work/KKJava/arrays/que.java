package arrays;

import java.util.*;

public class que {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(arr));
        // swap(arr, 1, 3);
        max(arr);
        reverse(arr);

    }

    static void swap(int[] a, int i1, int i2) {
        int t = a[i1];
        a[i1] = a[i2];
        a[i2] = t;

        System.out.println("After swap at " + i1 + " ," + i2 + " : " + Arrays.toString(a));

    }

    static void max(int[] a) {
        int max = a[0];
        int index = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                index = i;
            }
        }
        System.out.println("Max: " + max + " at: " + index);
    }

    static void reverse(int[] a) {
        int t, s = a.length - 1;

        for (int i = 0; i < s; i++) {
            t = a[i];
            a[i] = a[s];
            a[s] = t;
            s--;
        }

        System.out.println("\n After reverse: " + Arrays.toString(a));
    }
}
