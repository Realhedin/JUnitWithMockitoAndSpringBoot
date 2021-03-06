package com.example.jUnitWithMockitoAndSpringBoot.powerMockExample;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dkorolev
 *         Date: 4/10/2019
 *         Time: 1:24 PM
 */
public class SystemUnderTest {
    private Dependency dependency;

    public int methodUsingAnArrayListConstructor() {
        List list = new ArrayList();
        return list.size();
    }

    public int methodCallingAStaticMethod() {
        //privateMethodUnderTest calls static method SomeClass.staticMethod
        List<Integer> stats = dependency.retrieveAllStats();
        long sum = 0;
        for (int stat : stats)
            sum += stat;
        return UtilityClass.staticMethod(sum);
    }

    private long privateMethodUnderTest() {
        List<Integer> stats = dependency.retrieveAllStats();
        long sum = 0;
        for (int stat : stats)
            sum += stat;
        return sum;
    }
}

interface Dependency {
    List<Integer> retrieveAllStats();
}