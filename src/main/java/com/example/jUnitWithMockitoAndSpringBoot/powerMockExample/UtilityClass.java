package com.example.jUnitWithMockitoAndSpringBoot.powerMockExample;

/**
 * @author dkorolev
 *         Date: 4/10/2019
 *         Time: 1:22 PM
 */
public class UtilityClass {
    static int staticMethod(long value) {
        // Some complex logic is done here...
        throw new RuntimeException(
                "I dont want to be executed. I will anyway be mocked out.");
    }
}