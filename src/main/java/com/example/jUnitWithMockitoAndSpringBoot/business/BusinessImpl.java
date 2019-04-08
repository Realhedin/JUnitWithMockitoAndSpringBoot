package com.example.jUnitWithMockitoAndSpringBoot.business;

import java.util.Arrays;

/**
 * @author dkorolev
 *         Date: 4/8/2019
 *         Time: 4:44 PM
 */
public class BusinessImpl {

    public int calculateSum(int[] data) {
//        int sum = 0;
//        for (int i : data) {
//            sum+=i;
//        }
        int sum2 = Arrays.stream(data).reduce(0,(s1, s2) -> s1 + s2);
        return sum2;
    }
}