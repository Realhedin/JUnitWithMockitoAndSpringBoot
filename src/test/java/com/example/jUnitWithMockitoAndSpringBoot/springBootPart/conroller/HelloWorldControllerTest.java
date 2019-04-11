package com.example.jUnitWithMockitoAndSpringBoot.springBootPart.conroller;

import com.example.jUnitWithMockitoAndSpringBoot.springBootPart.controller.HelloWorldController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author dkorolev
 *         Date: 4/11/2019
 *         Time: 2:16 PM
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = HelloWorldController.class)   //load only Web context => and only Hello
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc; //main class for mocking controllers

    @Test
    public void helloWorldTest_basic() throws Exception {
        //create builder for GET with uri: "/helloWorld" and MediaType: application/json
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/helloWorld")
                .accept(MediaType.APPLICATION_JSON);
        //call "/helloWorld" GET application/json and get result
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello, World"))
                .andReturn();
        //verify "Hello, World" response
        Assert.assertEquals("Hello, World", mvcResult.getResponse().getContentAsString());
    }

}