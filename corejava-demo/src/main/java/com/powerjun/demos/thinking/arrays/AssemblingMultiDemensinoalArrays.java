package com.powerjun.demos.thinking.arrays;

import java.util.Arrays;

public class AssemblingMultiDemensinoalArrays {

    public static void main(String[] args) {
        int[][] a = new int[3][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new int[3];
            for (int j = 0; j < a[i].length; j++) {

                a[i][j] = i * j;
            }
        }
        System.out.println(Arrays.deepToString(a));
    }
}
