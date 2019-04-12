//package com.example.jUnitWithMockitoAndSpringBoot.powerMockExample;
//
//import static org.mockito.Mockito.when;
//
//import java.util.Arrays;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.powermock.modules.junit4.PowerMockRunner;
//import org.powermock.reflect.Whitebox;
//
///**
// * @author dkorolev
// *         Date: 4/10/2019
// *         Time: 5:19 PM
// */
//@RunWith(PowerMockRunner.class)
//public class SystemUnderTestTestPrivate {
//
//    @Mock
//    Dependency dependency;
//
//    @InjectMocks
//    SystemUnderTest systemUnderTest;
//
//    @Test
//    public void powerMockito_testPrivateMethod() throws Exception {
//        //mocking result
//        when(dependency.retrieveAllStats()).thenReturn(Arrays.asList(1, 2, 3));
//
//        //get private method with reflection Whitebox.invokeMethod !
//        long privateValue = Whitebox.invokeMethod(systemUnderTest, "privateMethodUnderTest");
//
//        //checking
//        Assert.assertEquals(6L, privateValue);
//
//    }
//}