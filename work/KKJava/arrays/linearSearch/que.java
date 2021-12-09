package arrays.linearSearch;

import java.util.*;

public class que {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // System.out.println("Srting i/p: ");
        // String st = in.nextLine();

        // System.out.println("Target: ");
        // char s = in.nextLine().charAt(0);

        // System.out.println(charSearch(st, s));

        // int[] arr = { -1, 7, 6, 48, 21 };

        // System.out.println(inRange(arr, 48, 1, 4));

        int[][] arr = {
                { 21, 14, 5 }, { 18, 12, 16, 9 }, { 47, 81, 2 }
        };
        int[] ans = search2d(arr, 16);
        System.out.println(Arrays.toString(ans));

    }

    static boolean charSearch(String st, char s) {

        // @ length():for Strings
        // @ length:for Arrays

        if (st.length() == 0) {
            return false;
        }

        for (int i = 0; i < st.length(); i++) {
            if (s == st.charAt(i)) {
                return true;
            }
        }

        return false;
    }

    static String inRange(int[] arr, int t, int a, int b) {
        for (int i = a; i < b; i++) {
            if (t == arr[i]) {
                return ("In Range: " + i);
            }
        }
        return "Not in range";
    }

    static int[] search2d(int[][] a, int n) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (n == a[i][j]) {
                    return new int[] { i, j };
                    // creating a new array object
                }
            }
        }

        return new int[] {};
    }
}
