package arrays.binarySearch;

import java.util.*;

// class BS {

//     public static void main(String[] args) {
//         // int a[] = new int[5];
//         int arr[] = { 20, 10, 40, 30, 60, 50 };

//         int ele = 50;
//         int a = 0;
//         int b = arr.length;

//         binarysearch(arr, ele, a, b);
//         System.out.println();
//     }

//     static void sort(int arr[]) {

//         for (int i = 0; i < arr.length; i++) {
//             for (int j = 0; j < arr.length - 1; j++) {
//                 if (arr[j] > arr[j + 1]) {
//                     int t = arr[j];
//                     arr[j] = arr[j + 1];
//                     arr[j + 1] = t;
//                 }
//             }

//             System.out.println(arr[i]);
//         }

//         System.out.println("---------");
//     }

//     static int binarysearch(int arr[], int e, int a, int b) {
//         sort(arr);
//         System.out.println("ele: " + e);

//         int m = a + ((b - a) / 2);
//         System.out.println("m: " + m);

//         if (arr[m] < e) {
//             a = m;
//             System.out.println("a=m : " + a + "b: " + b);
//             // binarysearch(arr, e, a, b);

//         } else if (arr[m] > e) {
//             b = m;
//             System.out.println("b=m : " + b + "a: " + a);
//             // binarysearch(arr, e, a, b);

//         } else if (arr[m] == e) {
//             System.out.println("ele found at " + m);
//             return 0;
//         }

//         System.out.println("------------------");
//         return 0;
//     }

// }

// class BinarySearch {
class BS {
    static int binarySearch(int a[], int beg, int end, int val) {
        int mid;
        if (end >= beg) {
            mid = (beg + end) / 2;
            if (a[mid] == val) {
                return mid + 1;
            } else if (a[mid] < val) {
                return binarySearch(a, mid + 1, end, val);
            } else {
                return binarySearch(a, beg, mid - 1, val);
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int a[] = { 8, 10, 22, 27, 37, 44, 49, 55, 69 }; // given array
        int val = 37; // value to be searched
        int n = a.length; // size of array
        int res = binarySearch(a, 0, n - 1, val); // Store result
        System.out.print("The elements of the array are: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("Element to be searched is: " + val);
        if (res == -1)
            System.out.println("Element is not present in the array");
        else
            System.out.println("Element is present at " + res + " position of array");
    }
}