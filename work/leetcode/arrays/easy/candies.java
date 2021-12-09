package arrays.easy;

//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

import java.util.*;

public class candies {
    public static void main(String[] args) {
        // int[] candies = { 2, 3, 5, 1, 3 };
        int[] candies = { 2, 8, 7 };
        int extraCandies = 1;

        int max = 0;

        ArrayList<Boolean> result = new ArrayList<>();

        for (int n : candies) {
            if (max < n) {
                max = n;
            }
        }
        System.out.println("Max: " + max);

        for (int n : candies) {

            System.out.println("sum: " + (n + extraCandies));
            if ((n + extraCandies) >= max) {
                result.add(true);
            } else
                result.add(false);

        }

        System.out.println(Arrays.toString(candies));
        System.out.println(result);
    }
}

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/submissions/