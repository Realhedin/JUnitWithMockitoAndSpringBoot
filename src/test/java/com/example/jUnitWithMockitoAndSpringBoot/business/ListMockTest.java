package com.example.jUnitWithMockitoAndSpringBoot.business;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

/**
 * @author dkorolev
 *         Date: 4/9/2019
 *         Time: 1:25 PM
 */
public class ListMockTest {

    List<String> mock = Mockito.mock(List.class);

    @Test
    public void test_basicSize() {
        Mockito.when(mock.size()).thenReturn(5);
        Assert.assertEquals(5, mock.size());
    }

    @Test
    public void test_mockDifferentValues() {
        Mockito.when(mock.size()).thenReturn(5).thenReturn(10);
        Assert.assertEquals(5, mock.size());
        Assert.assertEquals(10, mock.size());
    }


    @Test
    public void test_withParameters() {
        Mockito.when(mock.get(0)).thenReturn("Test1");
        Assert.assertEquals("Test1", mock.get(0));
        Assert.assertEquals(null, mock.get(1));
    }

    @Test
    public void test_withGenericParameters() {
        Mockito.when(mock.get(ArgumentMatchers.anyInt())).thenReturn("Test1");
        Assert.assertEquals("Test1", mock.get(ArgumentMatchers.anyInt()));
    }

    @Test
    public void verificationBasics() {
        String value = mock.get(0);
        String value2 = mock.get(1);
        //verify
        Mockito.verify(mock).get(0);
        Mockito.verify(mock, Mockito.times(2)).get(ArgumentMatchers.anyInt());
        Mockito.verify(mock, Mockito.atLeast(1)).get(ArgumentMatchers.anyInt());
    }
}