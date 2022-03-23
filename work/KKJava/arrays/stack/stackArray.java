package arrays.stack;

import java.util.*;

public class stackArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        System.out.println("Enter array[5]: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        print(arr);
    }

    static void push(int a[], int e) {

    }

    static void pop(int a[]) {
    }

    static void peek(int a[]) {

    }

    static void print(int a[]) {
        System.out.println("Array[5]: ");
        for (int i = 0; a[i] != 0; i++) {
            System.out.println(a[i]);
        }
    }

    static void isFull(int[] a) {

    }
}
