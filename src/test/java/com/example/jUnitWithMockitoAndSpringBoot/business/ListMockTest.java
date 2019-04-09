package com.example.jUnitWithMockitoAndSpringBoot.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
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
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void test_mockDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }


    @Test
    public void test_withParameters() {
        when(mock.get(0)).thenReturn("Test1");
        assertEquals("Test1", mock.get(0));
        assertEquals(null, mock.get(1));
    }

    @Test
    public void test_withGenericParameters() {
        when(mock.get(anyInt())).thenReturn("Test1");
        assertEquals("Test1", mock.get(anyInt()));
    }

    @Test
    public void verificationBasics() {
        //SUT (System Under Test - part of testing system)
        String value = mock.get(0);
        String value2 = mock.get(1);
        //verify
        verify(mock).get(0);
        verify(mock, Mockito.times(2)).get(anyInt());
        verify(mock, Mockito.atLeast(1)).get(anyInt());
    }

    @Test
    public void capturingBacics() {
        //SUT
        mock.add("TestForCapturing");
        //verify
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        assertEquals("TestForCapturing",captor.getValue());
    }

    @Test
    public void capturingListValues() {
        //SUT
        mock.add("TestForCapturing");
        mock.add("TestForCapturing2");
        //verify
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());
        assertEquals("TestForCapturing",captor.getAllValues().get(0));
        assertEquals("TestForCapturing2",captor.getAllValues().get(1));
    }
}