package arrays.easy;

import java.util.*;

//https://leetcode.com/problems/concatenation-of-array/
public class conactenationOfArray {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 5 };
        int[] ans = new int[2 * nums.length];

        int n = nums.length - 1, i = 0;
        System.out.println(n);
        System.out.println(Arrays.toString(ans));

        int t = 0;
        while (i <= (2 * n) + 1) {
            ans[i] = nums[t];
            i++;
            System.out.println(t + " " + Arrays.toString(ans));
            t++;
            if (t > n) {
                t = 0;
            }

        }

    }
}

// https://leetcode.com/problems/concatenation-of-array/submissions/