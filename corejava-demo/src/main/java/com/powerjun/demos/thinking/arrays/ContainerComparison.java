package com.powerjun.demos.thinking.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BerylliumSphere {
    private static long counter;
    private long id = counter++;

    @Override
    public String toString() {
        return "Sphere "+ id ;
    }
}
public class ContainerComparison {
    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[5];
        for (int i = 0; i < spheres.length; i++) {
            spheres[i] = new BerylliumSphere();
        }
        System.out.println(spheres[4]);

        List<BerylliumSphere> sphereList = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            sphereList.add(new BerylliumSphere());
        }
        System.out.println(sphereList.get(4));

        int[] integers = {1, 2, 3, 4, 5};
        System.out.println(integers[4]);

        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(integerList.get(4));
    }
}
