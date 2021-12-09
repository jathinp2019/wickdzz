package arrays.easy;

import java.util.*;

//https://leetcode.com/problems/running-sum-of-1d-array/
public class runningSum {
    public static void main(String[] args) {
        // int[] nums = { 1, 2, 3, 4 };
        int[] nums = { 1, 1, 1, 1, 1 };
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
            System.out.println(sum + " " + Arrays.toString(nums));
        }
    }
    // https://leetcode.com/problems/running-sum-of-1d-array/submissions/
}
