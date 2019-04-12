package com.example.jUnitWithMockitoAndSpringBoot.springBootPart.conroller;

import com.example.jUnitWithMockitoAndSpringBoot.springBootPart.controller.ItemController;
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
@WebMvcTest(value = ItemController.class)   //load only Web context => and only Hello
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc; //main class for mocking controllers

    @Test
    public void dummyItemTest_basic() throws Exception {
        //create builder for GET with uri: "/dummyItem" and MediaType: application/json
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/dummyItem")
                .accept(MediaType.APPLICATION_JSON);
        //call "/dummyItem" GET application/json and get result
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();
        //verify response
        Assert.assertEquals("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}", mvcResult.getResponse().getContentAsString());
    }

}