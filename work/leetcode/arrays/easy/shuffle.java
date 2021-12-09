package arrays.easy;

//https://leetcode.com/problems/shuffle-the-array/

import java.util.*;

public class shuffle {
    public static void main(String[] args) {
        int[] nums = { 2, 5, 1, 3, 4, 7 };
        int n = nums.length;

        int s = n / 2;

        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length / 2; i++) {
            arr[2 * i] = nums[i];
        }

        for (int i = 1; i <= (nums.length); i = i + 2) {
            arr[i] = nums[s];
            System.out.println(i + " " + nums[i]);
            s++;
        }

        System.out.println(Arrays.toString(arr));
    }
}

// https://leetcode.com/problems/shuffle-the-array/submissions/
