package com.example.jUnitWithMockitoAndSpringBoot.springBootPart.business;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.example.jUnitWithMockitoAndSpringBoot.springBootPart.data.ItemRepository;
import com.example.jUnitWithMockitoAndSpringBoot.springBootPart.model.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author dkorolev
 *         Date: 4/15/2019
 *         Time: 2:57 PM
 */
@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService itemBusinessService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void retrieveAllItemsTest() {
        List<Item> listOfItems = Arrays.asList(new Item(2, "Item2", 10, 10),
                new Item(3, "Item3", 20, 20));
        when(itemRepository.findAll()).thenReturn(listOfItems);

        List<Item> actualItems = itemBusinessService.retrieveAllItems();

        Assert.assertEquals(100, actualItems.get(0).getValue());
        Assert.assertEquals(400, actualItems.get(1).getValue());



    }
}