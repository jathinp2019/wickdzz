package arrays.sorting;

import java.util.*;

public class enhancedBubble {

    static void bubbleSort(int arr[], int n) {
        int i, j, t;
        int swap;

        for (i = 0; i < n - 1; i++) {
            swap = 0;
            for (j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    swap = 1;
                }

            }

            if (swap == 0) {
                break;
            }
        }
    }

    public static void main(String args[]) {
        int a[] = new int[5];
        int n = a.length;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array[5]: ");
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        bubbleSort(a, n);
        System.out.println("Final array: ");

        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
