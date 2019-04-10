package com.example.jUnitWithMockitoAndSpringBoot.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
    @Mock
    List<Integer> mockList;


    @Test
    public void calculateSumUsingDataService() {
        when(mockService.retrieveAllData()).thenReturn(new int[]{1,3,5});
        assertEquals(9, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(mockService.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_another() {
        when(mockService.retrieveAllData()).thenReturn(new int[]{2,4,6});
        assertEquals(12, business.calculateSumUsingDataService());
    }

    @Test
    public void complexMethodCall() {
        //SUT
        when(mockService.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
        business.complexMethodCall();
        //verify
        verify(mockList).add(1); //check that internal call of list was done
        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
        verify(mockList).add(captor.capture()); //check that parameter was as expected (below)
        assertEquals(Integer.valueOf(1),captor.getValue());

    }


}