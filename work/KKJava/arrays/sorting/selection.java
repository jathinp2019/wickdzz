package arrays.sorting;

import java.util.*;

public class selection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a[] = new int[5];

        System.out.println("Enter array [5]: ");
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("Initial Array: ");

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        selectionSort(a);

        System.out.println("Final Array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    static void selectionSort(int arr[]) {
        int m, t;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            m = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[m])
                    m = j;

            t = arr[m];
            arr[m] = arr[i];
            arr[i] = t;

        }

    }
}
