package arrays.easy;

//https://leetcode.com/problems/number-of-good-pairs/
public class goodPairs {
    public static void main(String[] args) {
        int n = 0;
        int[] arr = { 1, 2, 3, 1, 1, 3 };

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    n++;
                }
            }
        }

        System.out.println(n);
    }
}
// https://leetcode.com/problems/number-of-good-pairs/submissions/