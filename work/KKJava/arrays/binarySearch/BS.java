package arrays.binarySearch;

import java.util.*;

class BS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array[" + n + "]");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        sort(arr);
        print(arr);

        System.out.println("Element: ");
        int ele = sc.nextInt();

        binarysearch(arr, ele, 0, n);

    }

    static void sort(int arr[]) {
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] < arr[i]) {
                    int t = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = t;
                }
            }
        }

    }

    static int binarysearch(int arr[], int e, int a, int b) {
        if (a <= b) {

            // int m = (a + b) / 2; // this is fine for smaller values
            int m = a + (b - a) / 2;
            // this works better for large numbers as it would not exceed the range of
            // integers!

            System.out.println("m :" + m);
            System.out.println("a[m] :" + arr[m]);

            if (e == arr[m]) {
                System.out.println("Element present at : " + m);
                return 0;
            } else if (e > arr[m]) {
                System.out.println(a + " > " + b);
                binarysearch(arr, e, m + 1, b);

            } else if (e < arr[m]) {
                System.out.println(a + " < " + b);
                binarysearch(arr, e, a, m - 1);

            } else
                System.out.println("Element not present");
        }

        return 0;
    }

    static void print(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
