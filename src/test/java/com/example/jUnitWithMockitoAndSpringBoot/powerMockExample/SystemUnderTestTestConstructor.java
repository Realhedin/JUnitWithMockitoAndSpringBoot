package com.example.jUnitWithMockitoAndSpringBoot.powerMockExample;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author dkorolev
 *         Date: 4/10/2019
 *         Time: 5:35 PM
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({SystemUnderTest.class})  /*To be able to mock the Constructor, we need to add in the Class that creates the new object*/
public class SystemUnderTestTestConstructor {
    @Mock
    Dependency dependency;

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public void powerMockito_constuctor() throws Exception {
        //mock ArrayList for further usage
        ArrayList mockList = mock(ArrayList.class);
        when(mockList.size()).thenReturn(100);

        //handle constructor mocking inside method to return mocked object !
        PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);

        //actual call to method
        int size = systemUnderTest.methodUsingAnArrayListConstructor();
        //checking
        Assert.assertEquals(100, size);


    }
}