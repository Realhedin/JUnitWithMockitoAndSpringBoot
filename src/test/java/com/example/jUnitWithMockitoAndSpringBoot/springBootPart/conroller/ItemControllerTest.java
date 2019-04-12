package com.example.jUnitWithMockitoAndSpringBoot.springBootPart.conroller;

import static org.mockito.Mockito.when;

import com.example.jUnitWithMockitoAndSpringBoot.springBootPart.business.ItemBusinessService;
import com.example.jUnitWithMockitoAndSpringBoot.springBootPart.controller.ItemController;
import com.example.jUnitWithMockitoAndSpringBoot.springBootPart.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
@WebMvcTest(value = ItemController.class)   //load only Web context => and only ItemController
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc; //main class for mocking controllers

    @MockBean
    private ItemBusinessService businessService; //mockBean for mocking spring bean

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
                //JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
                .andReturn();
    }

    @Test
    public void itemFromBusinessService_basic() throws Exception {

        when(businessService.retrieveHardcodedItem()).thenReturn(new Item(2, "Item2", 10, 10)); //common mockito mocking method

        //create builder for GET with uri: "/itemFromBusinessService" and MediaType: application/json
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/itemFromBusinessService")
                .accept(MediaType.APPLICATION_JSON);
        //call "/itemFromBusinessService" GET application/json and get result
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{id:2, name:Item2, price:10, quantity:10}"))
                //JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
                .andReturn();
    }
}