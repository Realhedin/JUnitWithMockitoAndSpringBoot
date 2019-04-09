package com.example.jUnitWithMockitoAndSpringBoot.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dkorolev
 *         Date: 4/8/2019
 *         Time: 4:44 PM
 */
public class BusinessImpl {

    private SomeDataService someDataService;
    private List<Integer> list = new ArrayList<>();

    public int calculateSum(int data[]) {
//        int sum = 0;
//        for (int i : data) {
//            sum+=i;
//        }
        int sum2 = Arrays.stream(data).reduce(0,(s1, s2) -> s1 + s2);
        return sum2;
    }


    public int calculateSumUsingDataService() {
        int[] data = someDataService.retrieveAllData();
        int sum2 = Arrays.stream(data).reduce(0,(s1, s2) -> s1 + s2);
        return sum2;
    }


    public int complexMethodCall() {
        int[] ints = someDataService.retrieveAllData();
        list.add(ints[0]);
        return list.size();
    }



    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }
}