package com.example.jUnitWithMockitoAndSpringBoot.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dkorolev
 *         Date: 4/8/2019
 *         Time: 4:49 PM
 */
public class BusinessImplTest {

    BusinessImpl business;

    @Before
    public void init() {
        business = new BusinessImpl();
    }

    @Test
    public void calculateSum_basic() {
        int actualValue = business.calculateSum(new int[]{1, 2, 3});
        Assert.assertEquals(6,actualValue);
    }

    @Test
    public void empty_array() {
        int actualValue = business.calculateSum(new int[]{});
        Assert.assertEquals(0,actualValue);
    }

    @Test
    public void calculateSum_one() {
        int actualValue = business.calculateSum(new int[]{2});
        Assert.assertEquals(2,actualValue);
    }
}