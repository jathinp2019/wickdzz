package arrays.easy;

import java.util.*;

//https://leetcode.com/problems/create-target-array-in-the-given-order/

public class targetArray {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 0 };
        int[] index = { 0, 1, 2, 3, 0 };

        int[] target = new int[index.length];

        for (int i = 0; i < index.length; i++) {
            System.out.println(Arrays.toString(target));
            System.out.println(index[i] + " " + nums[i]);

            if (target[index[i]] != 0) {
                int t = target[index[i + 1]];

                for (int j = 0; j < index.length; j++) {
                    // target[index[i]=t;
                    target[index[i] + 1] = target[index[i]];
                    t = target[index[i] + 1];
                }
                target[index[i]] = nums[i];

            } else
                target[index[i]] = nums[i];

            // target[index[i]] = nums[i];
        }

        System.out.println(Arrays.toString(target));
    }
}
