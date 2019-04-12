//package com.example.jUnitWithMockitoAndSpringBoot.powerMockExample;
//
//import static org.mockito.Matchers.anyLong;
//import static org.mockito.Mockito.when;
//
//import java.util.Arrays;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//
///**
// * @author dkorolev
// *         Date: 4/10/2019
// *         Time: 2:47 PM
// */
//@RunWith(PowerMockRunner.class)
//@PrepareForTest({ UtilityClass.class})
//public class SystemUnderTestTestStatic {
//
//    @Mock
//    Dependency dependency;
//
//    @InjectMocks
//    SystemUnderTest systemUnderTest;
//
//
//
//    @Test
//    public void powerMockito_MockingAStaticCall() {
//        //usual mock behavior. mocking method returns what we want
//        when(dependency.retrieveAllStats()).thenReturn(Arrays.asList(1, 2, 3));
//
//        //Power mock usage to mock Class with static method !
//        PowerMockito.mockStatic(UtilityClass.class);
//        //mockito approach to return what do we want
//        when(UtilityClass.staticMethod(anyLong())).thenReturn(150);
//
//        //checking result
//        Assert.assertEquals(150, systemUnderTest.methodCallingAStaticMethod());
//
//        //verification part
//        //First : Call PowerMockito.verifyStatic()
//        //Second : Call the method to be verified
//        PowerMockito.verifyStatic();
//        UtilityClass.staticMethod(1 + 2 + 3);
//
//        //verify number of calls
////        PowerMockito.verifyStatic(times(1));
//
//
//    }
//}