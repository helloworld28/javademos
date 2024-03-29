package com.powerjun.demos.thinking.arrays;

import java.util.Arrays;
import java.util.Random;

public class IceCream {
    private static Random rand = new Random(47);
    static final String[] FLAVORS = {"Chocolate", "Strawberry", "Vanilla Fudge Swirl", "Mint Chip",
            "Mocha Almond Fudge", "Rum Raisin", "Praline Cream", "Mud Pie"};

    public static String[] flavorSet(int n) {
        if (n > FLAVORS.length) {
            throw new IllegalArgumentException("must be less than " + FLAVORS.length);
        }

        String[] result = new String[n];

        boolean[] picked = new boolean[FLAVORS.length];
        for (int i = 0; i < n; i++) {
            int t;
            do {
                t = rand.nextInt(FLAVORS.length);
            }while (picked[t]);
            result[i] = FLAVORS[t];
            picked[t] = true;
        }
        return result;


    }


    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.asList(flavorSet(3)));
        }
    }
}
