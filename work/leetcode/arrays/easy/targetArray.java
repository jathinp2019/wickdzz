package arrays.easy;

import java.util.*;

//https://leetcode.com/problems/create-target-array-in-the-given-order/

public class targetArray {
    public static void main(String[] args) {
        // int[] nums = { 1, 2, 3, 4, 0 };
        // int[] index = { 0, 1, 2, 3, 0 };
        int[] nums = { 0, 1, 2, 3, 4 };
        int[] index = { 0, 1, 2, 2, 1 };

        int[] target = new int[index.length];

        for (int i = 0; i < index.length; i++) {
            System.out.println(Arrays.toString(target));

            for (int j = index.length - 1; j > index[i]; j--) {
                target[j] = target[j - 1];
                // shifting elements till the index point to make space
            }
            target[index[i]] = nums[i];
            // adding element at the index
        }

        System.out.println("final: ");
        System.out.println(Arrays.toString(target));
    }
}

// https://leetcode.com/problems/create-target-array-in-the-given-order/submissions/