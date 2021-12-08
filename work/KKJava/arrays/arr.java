package KKjava.array;

import java.util.*;

public class arr {

    // Syntax: datatype[] var_name = new datatype[size]

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[] { 1, 2, 3 };
        int[] a1 = { 1, 2, 3 };

        String[] st = { "vai", "shakh" };

        int sum = 0;
        for (int num : a1) {
            System.out.println(num);
            sum += num;
        }
        System.out.println("sum: " + sum);
        // here num represents individual elements of array 'arr'

        System.out.println(Arrays.toString(a1));

        // String[] str = new String[5];
        // for (int i = 0; i < str.length; i++) {
        // str[i] = in.nextLine();
        // }
        // System.out.println(Arrays.toString(str));

        fun(arr);
        System.out.println(Arrays.toString(arr));

        int[][] multi_arr = new int[3][3];
        // @ adding the row is mandatory...columns isnt

        int[][] arr2d = {
                { 1, 2, 3 },
                { 4, 5 },
                { 6, 7, 8 }
        };
        // this is why column no.'s arent't necessary
        // as 2-d arrays are 'Arrays of array' ...and it has a different kind of memory
        // management in JAVA
        for (int i = 0; i < arr2d.length; i++) {
            for (int j = 0; j < arr2d[i].length; j++) {
                System.out.print(arr2d[i][j] + " ");
            }
            System.out.println();
        }
        // @ logically understand why j was limited acc to length

        System.out.println("2d array(matrix): ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                multi_arr[i][j] = in.nextInt();
            }
        }

        System.out.println("matrix: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(multi_arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("using toString(): ");
        for (int i = 0; i < multi_arr.length; i++) {
            System.out.println(Arrays.toString(multi_arr[i]));
        }

        System.out.println("using forEach: ");
        for (int[] n : multi_arr) {
            System.out.println(Arrays.toString(n));
        }
    }

    static void fun(int[] arr) {
        System.out.println("changed: ");
        arr[0] = 9;
    }

}
