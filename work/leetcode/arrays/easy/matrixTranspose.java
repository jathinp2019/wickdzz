package arrays.easy;

import java.util.*;

//https://leetcode.com/problems/transpose-matrix/ 

public class matrixTranspose {
    public static void main(String[] args) {
        // int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };
        int l = matrix[0].length;
        int[][] transpose = new int[l][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < l; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        System.out.println("Matrix: ");
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println(" ");
        }

    }
}

// https://leetcode.com/problems/transpose-matrix/submissions/