package arrays.easy;

import java.util.*;

// https://leetcode.com/problems/build-array-from-permutation/
public class ArrayFromPermutation {
    public static void main(String[] args) {
        // int[] arr = { 0, 2, 1, 5, 3, 4 };
        int[] arr = { 5, 0, 1, 2, 3, 4 };
        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[arr[i]];
        }
        System.out.println("ans: ");
        System.out.println(Arrays.toString(ans));
    }
}
// https://leetcode.com/problems/build-array-from-permutation/submissions/