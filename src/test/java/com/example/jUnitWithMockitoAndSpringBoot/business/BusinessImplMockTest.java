package com.example.jUnitWithMockitoAndSpringBoot.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author dkorolev
 *         Date: 4/8/2019
 *         Time: 4:49 PM
 */
public class BusinessImplMockTest {

    BusinessImpl business;
    SomeDataService mockService;


    @Before
    public void init() {
        business = new BusinessImpl();
        mockService = Mockito.mock(SomeDataService.class);
        business.setSomeDataService(mockService);
    }

    @Test
    public void calculateSumUsingDataService() {
        Mockito.when(mockService.retrieveAllData()).thenReturn(new int[]{1,3,5});
        Assert.assertEquals(9, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        Mockito.when(mockService.retrieveAllData()).thenReturn(new int[]{});
        Assert.assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_another() {
        Mockito.when(mockService.retrieveAllData()).thenReturn(new int[]{2,4,6});
        Assert.assertEquals(12, business.calculateSumUsingDataService());
    }


}