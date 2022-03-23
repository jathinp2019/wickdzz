package arrays.sorting;

import java.util.*;

class quick {

    static int partition(int array[], int low, int high) {

        int pivot = array[high];

        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {

                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return (i + 1);
    }

    static void quickSort(int array[], int low, int high) {
        if (low < high) {

            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);

            quickSort(array, pi + 1, high);
        }
    }

    static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter limit: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter array[" + n + "]: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Initial Array");
        print(arr);

        int size = arr.length;
        quickSort(arr, 0, size - 1);

        System.out.println("\n Sorted Array: ");
        print(arr);
    }
}
