package com.example.jUnitWithMockitoAndSpringBoot.business;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author dkorolev
 *         Date: 4/8/2019
 *         Time: 4:49 PM
 */
@RunWith(MockitoJUnitRunner.class) //to activate injection by Mockito
public class BusinessImplMockTest {

    @InjectMocks //will inject all of the mocks
    BusinessImpl business;

    @Mock //auto-mocking service
    SomeDataService mockService;


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