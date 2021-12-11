package arrays.easy;

// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

import java.util.*;

// Given an array nums of integers, return how many of them contain an even number of digits.

public class evenDigits {

    public static void main(String[] args) {
        int[] nums = { 12, 345, 2, 6, 7896 };
        // System.out.println(digits1(nums));

        System.out.println(digits2(nums));
    }

    static int digits1(int[] nums) {
        int c = 0;

        for (int num : nums) {
            int n = 0;

            if (num < 0)
                num = num * -1;

            while (num > 0) {
                n++;
                num = num / 10;
            }
            if (n % 2 == 0) {
                c++;
            }
        }
        System.out.println(c);
        return c;
    }

    static int digits2(int[] nums) {
        int n, c = 0;
        for (int num : nums) {
            n = (int) Math.floor(Math.log10(num)) + 1;
            // log10 of a number !!

            System.out.println("n: " + n);
            if (n % 2 == 0) {
                c++;
            }
        }
        return c;
    }
}
// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/submissions/