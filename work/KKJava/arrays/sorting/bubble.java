package arrays.sorting;

import java.util.*;

public class bubble {
    public static void main(String[] args) {
        System.out.println("");

        int a[] = new int[5];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size: ");
        int n = sc.nextInt();

        System.out.println("Enter array: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("Initial array: ");
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }

        bubbleSort(a, n);

        System.out.println("Final array: ");
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }

    static int bubbleSort(int arr[], int n) {
        int t;
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    t = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = t;

                }

            }
        }
        return 0;
    }
}
