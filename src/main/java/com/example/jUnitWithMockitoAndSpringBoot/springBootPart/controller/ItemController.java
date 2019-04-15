package com.example.jUnitWithMockitoAndSpringBoot.springBootPart.controller;

import java.util.List;

import com.example.jUnitWithMockitoAndSpringBoot.springBootPart.business.ItemBusinessService;
import com.example.jUnitWithMockitoAndSpringBoot.springBootPart.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dkorolev
 *         Date: 4/11/2019
 *         Time: 2:10 PM
 */
@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;

    @GetMapping("/dummyItem")
    public Item dummyItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/itemFromBusinessService")
    public Item itemFromBusinessService() {
        return businessService.retrieveHardcodedItem();
    }

    @GetMapping("/getAllItemsFromDB")
    public List<Item> retreiveAllItems() {
        return businessService.retrieveAllItems();
    }

}