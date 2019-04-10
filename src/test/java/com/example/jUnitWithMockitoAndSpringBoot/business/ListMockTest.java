package com.example.jUnitWithMockitoAndSpringBoot.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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

    List<String> mockList = Mockito.mock(List.class);

    @Test
    public void test_basicSize() {
        when(mockList.size()).thenReturn(5);
        assertEquals(5, mockList.size());
    }

    @Test
    public void test_mockDifferentValues() {
        when(mockList.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mockList.size());
        assertEquals(10, mockList.size());
    }


    @Test
    public void test_withParameters() {
        when(mockList.get(0)).thenReturn("Test1");
        assertEquals("Test1", mockList.get(0));
        assertEquals(null, mockList.get(1));
    }

    @Test
    public void test_withGenericParameters() {
        when(mockList.get(anyInt())).thenReturn("Test1");
        assertEquals("Test1", mockList.get(anyInt()));
    }

    @Test
    public void verificationBasics() {
        //SUT (System Under Test - part of testing system)
        String value = mockList.get(0);
        String value2 = mockList.get(1);
        //verify
        verify(mockList).get(0);
        verify(mockList, Mockito.times(2)).get(anyInt());
        verify(mockList, Mockito.atLeast(1)).get(anyInt());
    }

    @Test
    public void capturingBacics() {
        //SUT
        mockList.add("TestForCapturing");
        //verify
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockList).add(captor.capture());
        assertEquals("TestForCapturing",captor.getValue());
    }

    @Test
    public void capturingListValues() {
        //SUT
        mockList.add("TestForCapturing");
        mockList.add("TestForCapturing2");
        //verify
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockList, times(2)).add(captor.capture());
        assertEquals("TestForCapturing",captor.getAllValues().get(0));
        assertEquals("TestForCapturing2",captor.getAllValues().get(1));
    }

    @Test
    public void beforeSpyingUseMocks() {
        List list = mock(ArrayList.class);
        System.out.println(list.get(1)); //null
        System.out.println(list.size()); //0
        list.add("Test1");
        list.add("Test2");
        System.out.println(list.size()); //0
        when(list.size()).thenReturn(5);
        System.out.println(list.size()); //5
    }

    @Test
    //spy - create object with real class behavior
    //plus we can use when().thenReturn()
    public void afterSpyingUseSpy() {
        List list = spy(ArrayList.class);
        list.add("Test0");
        System.out.println(list.get(0)); //Test0
        System.out.println(list.size()); //1
        list.add("Test1");
        list.add("Test2");
        System.out.println(list.size()); //3
        when(list.size()).thenReturn(5);
        System.out.println(list.size()); //5
        //verify
        verify(list).add("Test1");
    }
}