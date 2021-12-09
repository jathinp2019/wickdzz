package arrays.easy;

//https://leetcode.com/problems/richest-customer-wealth/

public class richest {
    public static void main(String[] args) {
        int[][] account = { { 1, 5 }, { 5, 7 }, { 3, 5 } };

        int t = 0, index = 0;

        for (int i = 0; i < account.length; i++) {
            int sum = 0;
            for (int j = 0; j < account[i].length; j++) {
                sum += account[i][j];
            }
            if (t < sum) {
                t = sum;
                index = i;
            }
        }

        System.out.println(t + " " + index);
    }
}
// https://leetcode.com/problems/richest-customer-wealth/submissions/