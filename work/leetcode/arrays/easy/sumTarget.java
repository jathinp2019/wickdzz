package arrays.easy;

import java.util.*;

public class sumTarget {
    public static void main(String[] args) {
        // int[] nums = { 2, 7, 11, 15 };
        int[] nums = { 3, 2, 4 };
        int target = 6;

        ArrayList<Integer> index = new ArrayList<>(4);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    index.add(i);
                    index.add(j);
                }

            }
        }

        System.out.println(index);

    }
}

// https://leetcode.com/problems/two-sum/submissions/