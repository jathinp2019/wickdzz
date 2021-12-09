package arrays.easy;

import java.util.*;

public class smallerNo {
    public static void main(String[] args) {

        int[] arr = { 8, 1, 2, 2, 3 };
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int max, n = 0;
            max = arr[i];
            for (int j = 0; j < result.length; j++) {
                if (arr[j] < max) {
                    n++;
                }
                result[i] = n;
            }

        }

        System.out.println(Arrays.toString(result));
    }

}

// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/submissions/