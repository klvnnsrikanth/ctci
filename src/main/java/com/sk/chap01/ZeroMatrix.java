package com.sk.chap01;

import java.util.Arrays;

/**
 * 1.8 Write an algorithm such that if an element in a MxN matrix is 0, its entire row and column are set to 0.
 */
public class ZeroMatrix {
    private static void zerofyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private static void zerofyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix[column].length; i++) {
            matrix[i][column] = 0;
        }
    }

    private static void zerofyRowsAndColumns(int[][] matrix) {
        boolean[] rowIndexes = new boolean[matrix.length];
        boolean[] columnIndexes = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowIndexes[i] = true;
                    columnIndexes[j] = true;
                }
            }
        }

        for (int i = 0; i < rowIndexes.length; i++) {
            if (rowIndexes[i]) {
                zerofyRow(matrix, i);
            }
        }

        for (int i = 0; i < columnIndexes.length; i++) {
            if (columnIndexes[i]) {
                zerofyColumn(matrix, i);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix  = {{1, 2, 3}, {4, 0, 6}, {7, 9, 0}};

        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println("==============");
        zerofyRowsAndColumns(matrix);

        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
